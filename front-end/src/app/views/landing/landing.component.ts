import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/model/hotel';
import { Reservation } from 'src/app/model/reservation';
import { ChamberService } from 'src/app/service/chamber.service';
import { DataService } from 'src/app/service/data.service';
import { HotelService } from 'src/app/service/hotel.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit{

  hotels:any
  reservation:Reservation
  ville:string
    constructor(private hotelService:HotelService,private chamberService:ChamberService,private dataService:DataService,private router:Router) {
    this.reservation = new Reservation()
  }

  roomsDesponible(form: NgForm){
    this.chamberService.allRoomNoReserved(this.reservation,this.ville).subscribe((res)=>{
      console.log(res)
     if (res.status != 'success'){
       Swal.fire({
         position: 'top-end',
         icon: 'error',
         title: res.message,
         showConfirmButton: false,
         timer: 1500
       })
     }else if(res.data <=0){
       Swal.fire({
         position: 'top-end',
         icon: 'warning',
         title: "no room desponible in this date and this ville",
         showConfirmButton: false,
         timer: 2500
       })
     }else {
      this.dataService.putDataToStream(res);
      this.dataService.setDataToStream(this.reservation)
      this.router.navigate(['/chamber_Despo'])
    }})
  }

  ngOnInit(): void {
        this.hotelService.getAllHotel().subscribe((res)=>{
          this.hotels = res;
        })
    }



}
