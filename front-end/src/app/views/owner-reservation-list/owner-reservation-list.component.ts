import { Component, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/service/reservation.service';

@Component({
  selector: 'app-owner-reservation-list',
  templateUrl: './owner-reservation-list.component.html',
  styleUrls: ['./owner-reservation-list.component.css']
})
export class OwnerReservationListComponent implements OnInit{

  reservations:any;

  constructor(private reservationService: ReservationService) {

  }

  ngOnInit(): void {
        this.reservationService.getAllReservation().subscribe((res)=>{
          this.reservations = res;
        })
    }
}
