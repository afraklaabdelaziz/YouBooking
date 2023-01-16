import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/service/hotel.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-hotels-owner',
  templateUrl: './hotels-owner.component.html',
  styleUrls: ['./hotels-owner.component.css']
})
export class HotelsOwnerComponent implements OnInit{
  ownerHotels:any
  token: any;
  user: any;
  email: any;
constructor(private hotelService:HotelService,private userService:UserService) {}



  ngOnInit(): void {
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
        this.hotelService.getAllHotelOfOwner(this.email).subscribe((res)=>{
          this.ownerHotels = res.data;
        })
    }

  showModal = false;
  showModalAdd = false;

  toggleModalAdd() {
    this.showModalAdd = !this.showModalAdd;
  }

}
