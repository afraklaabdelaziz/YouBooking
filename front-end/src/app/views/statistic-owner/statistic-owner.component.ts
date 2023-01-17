import { Component } from '@angular/core';
import { ChamberService } from 'src/app/service/chamber.service';
import { HotelService } from 'src/app/service/hotel.service';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-statistic-owner',
  templateUrl: './statistic-owner.component.html',
  styleUrls: ['./statistic-owner.component.css']
})
export class StatisticOwnerComponent {


  numberOfRoom:number;
  numberOfHotel:number;
  numberOfReservation:number;
  token: any;
  user: any;
  email: string;
  constructor(private hotelService:HotelService,private userService:UserService,private chamberService:ChamberService,private reservationService:ReservationService) {
  }

  ngOnInit(){
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
    this.numberRooms();
    this.numberHotels();
    this.numberReservations()
  }
  numberHotels(){
    this.hotelService.getAllHotelOfOwner(this.email).subscribe((res)=>{
      this.numberOfHotel = res.data.length
    })
  }


  numberRooms(){
    this.chamberService.getCountProprietaireRooms(this.email).subscribe((res)=>{
      this.numberOfRoom = res;
    })
  }

  numberReservations(){
    this.reservationService.findAllReservationOfHotelOwner(this.email).subscribe((res)=>{
      this.numberOfReservation = res.length
    })
  }
}
