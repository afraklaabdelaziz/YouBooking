import { Component } from '@angular/core';
import { Reservation } from 'src/app/model/reservation';
import { ChamberService } from 'src/app/service/chamber.service';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-chamber-desponible',
  templateUrl: './chamber-desponible.component.html',
  styleUrls: ['./chamber-desponible.component.css']
})
export class ChamberDesponibleComponent {
  rooms:any

  constructor(private dataService:DataService) {
  }

  ngOnInit(){
    this.dataService.getData().subscribe((res: { data: any; })=>{
      this.rooms = res.data
    })
  }
}
