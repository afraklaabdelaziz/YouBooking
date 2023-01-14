import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/model/hotel';
import { Reservation } from 'src/app/model/reservation';
import { ChamberService } from 'src/app/service/chamber.service';
import { DataService } from 'src/app/service/data.service';
import { HotelService } from 'src/app/service/hotel.service';

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
      this.dataService.putDataToStream(res);
      this.dataService.setDataToStream(this.reservation)
      this.router.navigate(['/chamber_Despo'])
    })
  }

  ngOnInit(): void {
        this.hotelService.getAllHotel().subscribe((res)=>{
          this.hotels = res;
        })
    }



}
