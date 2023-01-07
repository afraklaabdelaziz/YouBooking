import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Hotel } from 'src/app/model/hotel';
import { HotelService } from 'src/app/service/hotel.service';

@Component({
  selector: 'app-add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrls: ['./add-hotel.component.css']
})
export class AddHotelComponent {
  hotel:Hotel;
  constructor(private hotelService:HotelService,public router:Router) {
    this.hotel = new Hotel();
  }

  addHotel(form: NgForm) {
    this.hotelService.addHotel(this.hotel).subscribe((res)=>{
      this.router.navigate(["/all_hotel"])
    })
  }
}
