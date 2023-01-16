import { Component } from '@angular/core';
import { ReservationService } from 'src/app/service/reservation.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reservation-list-oncours',
  templateUrl: './reservation-list-oncours.component.html',
  styleUrls: ['./reservation-list-oncours.component.css']
})
export class ReservationListOncoursComponent {
  reservations:any;
  status:any = "EnCours"
  token: any;
  user: any;
  email: any;

  constructor(private reservationService: ReservationService,private userService:UserService) {

  }

  ngOnInit(): void {
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
    this.reservationService.getAllReservationEncours(this.email).subscribe((res)=>{
      this.reservations = res;
    })
  }

  updateStatus(id:number,status: any) {
    this.reservationService.updateStatusReservation(id,status).subscribe((res)=> {
      if (res.status == "success"){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: false,
          timer: 1500
        })
        this.refresh()
      }
    })
  }

  refresh(): void {
    window.location.reload();
  }
}
