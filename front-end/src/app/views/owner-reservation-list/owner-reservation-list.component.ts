import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-owner-reservation-list',
  templateUrl: './owner-reservation-list.component.html',
  styleUrls: ['./owner-reservation-list.component.css']
})
export class OwnerReservationListComponent implements OnInit{

  reservations:any;
  email: string;
  user: any;
  token: any;

  constructor(private reservationService: ReservationService,private userService:UserService) {

  }

  ngOnInit(): void {
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
        this.reservationService.findAllReservationOfHotelOwner(this.email).subscribe((res)=>{
          this.reservations = res;
        })
    }
}
