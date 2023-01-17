import { Component } from '@angular/core';
import { ChamberService } from 'src/app/service/chamber.service';
import { HotelService } from 'src/app/service/hotel.service';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';
@Component({
  selector: 'app-statistique',
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.css']
})
export class StatistiqueComponent {
  numberOfRoom:number;
  numberOfHotel:number;
  numberOfUser:number;
  numberOfReservation:number;
constructor(private hotelService:HotelService,private userService:UserService,private chamberService:ChamberService,private reservationService:ReservationService) {
}

ngOnInit(){
  this.numberRooms();
  this.numberUsers();
  this.numberHotels();
}
  numberHotels(){
    this.hotelService.getAllHotel().subscribe((res)=>{
      this.numberOfHotel = res.length
    })
  }

  numberUsers(){
    this.userService.getAllUsers().subscribe((res)=>{
      this.numberOfUser = res.data.length
    })
  }

  numberRooms(){
    this.chamberService.getAllRooms().subscribe((res)=>{
      this.numberOfRoom = res.data.length
    })
  }

  numberReservations(){

  }
}
