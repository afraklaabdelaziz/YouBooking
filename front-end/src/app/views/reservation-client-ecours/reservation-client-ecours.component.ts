import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reservation-client-ecours',
  templateUrl: './reservation-client-ecours.component.html',
  styleUrls: ['./reservation-client-ecours.component.css']
})
export class ReservationClientEcoursComponent implements OnInit{
  token: any;
  user: any;
  email: string;

  reservations:any

  constructor(private reservationService:ReservationService,private userService:UserService) {}

  ngOnInit(): void {
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
        this.reservationService.getListReservationOfClientEncours(this.email).subscribe((res)=>{
          this.reservations = res
        })
    }

    anulerReservation(id:number){
    this.reservationService.annulerReservation(id).subscribe((res)=>{
      if (res.status == "success"){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: true,
          timer: 1500
        })
      }else {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: res.message,
          showConfirmButton: true,
          timer: 1500
        })
      }
    })
    }


}
