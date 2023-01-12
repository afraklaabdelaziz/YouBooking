import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Chamber } from 'src/app/model/chamber';
import { Hotel } from 'src/app/model/hotel';
import { ChamberService } from 'src/app/service/chamber.service';
import { HotelService } from 'src/app/service/hotel.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-chamber',
  templateUrl: './add-chamber.component.html',
  styleUrls: ['./add-chamber.component.css']
})
export class AddChamberComponent implements OnInit{

  chamber:Chamber;
  idHotel:number;
  hotels:any;
  constructor(private chamberService:ChamberService,private hotelService:HotelService,private routerActive: ActivatedRoute ) {
    this.chamber = new Chamber();
  }

  ngOnInit(): void {
    }



  addChamber(form: NgForm) {
    this.chamber.hotel.id = this.routerActive.snapshot.params['id'];
    this.chamberService.addRoom(this.chamber).subscribe((res)=>{
      if (res.status === 'success'){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: false,
          timer: 1500
        })
      }
      this.refresh()
    })
  }

  refresh(): void {
    window.location.reload();
  }

}
