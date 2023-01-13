import { Component } from '@angular/core';
import { ReservationService } from 'src/app/service/reservation.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reservation-list-oncours',
  templateUrl: './reservation-list-oncours.component.html',
  styleUrls: ['./reservation-list-oncours.component.css']
})
export class ReservationListOncoursComponent {
  reservations:any;
  status:any = "EnCours"

  constructor(private reservationService: ReservationService) {

  }

  ngOnInit(): void {
    this.reservationService.getAllReservationEncours().subscribe((res)=>{
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
