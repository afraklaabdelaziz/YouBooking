import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-all-hotel',
  templateUrl: './all-hotel.component.html',
  styleUrls: ['./all-hotel.component.css']
})
export class AllHotelComponent implements OnInit{
  hotels:any;
constructor(private hotelService:HotelService) {
}

  ngOnInit(): void {
    this.hotelService.getAllHotel().subscribe((res)=>{
      this.hotels = res;
    })
    }
}
