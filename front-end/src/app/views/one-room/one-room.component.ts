import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from 'src/app/model/reservation';
import { ChamberService } from 'src/app/service/chamber.service';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-one-room',
  templateUrl: './one-room.component.html',
  styleUrls: ['./one-room.component.css']
})
export class OneRoomComponent {
  idRoom:number
  room:any
  reservation:Reservation
  constructor(private chamberService:ChamberService, private routeActive: ActivatedRoute,private dataService:DataService) {}

  ngOnInit(){
    this.idRoom = this.routeActive.snapshot.params['id'];
    this.chamberService.getOneRoom(this.idRoom).subscribe((res)=>{
      this.room = res.data;
    })
  }

  reserver(id: number) {
    this.dataService.getDataRes().subscribe((res: Reservation)=>{
      this.reservation = res;
    })
    this.chamberService.reserverRoom(this.reservation,id,40).subscribe((res)=>{
      console.log(res)
    })

  }
}
