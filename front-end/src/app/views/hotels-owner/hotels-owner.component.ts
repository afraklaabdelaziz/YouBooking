import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-hotels-owner',
  templateUrl: './hotels-owner.component.html',
  styleUrls: ['./hotels-owner.component.css']
})
export class HotelsOwnerComponent implements OnInit{
  ownerHotels:any
constructor(private hotelService:HotelService) {}

  ngOnInit(): void {
        this.hotelService.getAllHotelOfOwner(31).subscribe((res)=>{
          console.log(res)
          this.ownerHotels = res.data;
        })
    }

}
