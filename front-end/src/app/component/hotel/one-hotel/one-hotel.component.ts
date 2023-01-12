import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Chamber } from 'src/app/model/chamber';
import { Hotel } from 'src/app/model/hotel';
import { ChamberService } from 'src/app/service/chamber.service';
import { HotelService } from 'src/app/service/hotel.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-one-hotel',
  templateUrl: './one-hotel.component.html',
  styleUrls: ['./one-hotel.component.css']
})
export class OneHotelComponent implements OnInit{

  idHotel:number;
  hotel:any;
  chamberFound: Chamber
  idRoom:number;
  chambers:any;
  showModalAdd = false;
  showModal = false;
  constructor(private hotelService:HotelService,private routeActive: ActivatedRoute,private chamberService: ChamberService) {
  this.chamberFound = new Chamber()
  }

ngOnInit():void{
    this.idHotel = this.routeActive.snapshot.params['id'];
    this.hotelService.getOneHotel(this.idHotel).subscribe((res)=>{
      this.hotel = res.data;
      this.chambers = res.data.chambers;
    })
}

  toggleModalAdd() {
   this.showModalAdd = !this.showModalAdd
  }

  toggleModal() {
  this.showModal = !this.showModal
  }

  update(id: number) {
    this.chamberService.getOneRoom(id).subscribe((res)=>{
      this.chamberFound = res.data;
      this.idRoom = res.data.id
    })
  }

  updateRoom(ngForm: NgForm) {
   this.chamberService.updateRoom(this.idRoom,this.chamberFound,this.idHotel).subscribe((res)=>{
     if (res.status === 'success'){
       Swal.fire({
         position: 'top-end',
         icon: 'success',
         title: res.message,
         showConfirmButton: false,
         timer: 1500
       })
   this.refresh()
     }
   })
  }

  deleteRoom(id: number) {
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.chamberService.deleteRoom(id).subscribe((res:any)=>{
          console.log(res)
          if (res.status == 'success'){
            Swal.fire(
              'Deleted!',
              res.message,
              'success'
            )
            this.refresh()
          }
        })

      }
    })
  }

  refresh(): void {
    window.location.reload();
  }


}
