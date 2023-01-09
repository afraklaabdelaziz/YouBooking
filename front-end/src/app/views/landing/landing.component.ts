import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/model/hotel';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit{

  hotels:any

  constructor(private hotelService:HotelService) {
  }

  ngOnInit(): void {
        this.hotelService.getAllHotel().subscribe((res)=>{
          this.hotels = res;
        })
    }



}
