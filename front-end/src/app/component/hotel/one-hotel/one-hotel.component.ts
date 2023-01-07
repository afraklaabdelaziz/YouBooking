import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from 'src/app/model/hotel';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-one-hotel',
  templateUrl: './one-hotel.component.html',
  styleUrls: ['./one-hotel.component.css']
})
export class OneHotelComponent implements OnInit{

  idHotel:number;
  hotel:any;
  chambers:any;

  constructor(private hotelService:HotelService,private routeActive: ActivatedRoute) {
}

ngOnInit():void{
    this.idHotel = this.routeActive.snapshot.params['id'];
    this.hotelService.getOneHotel(this.idHotel).subscribe((res)=>{
      this.hotel = res.data;
      this.chambers = res.data.chambers;
    })
}
}
