import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reservation } from 'src/app/model/reservation';
import { ChamberService } from 'src/app/service/chamber.service';
import { DataService } from 'src/app/service/data.service';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-one-room',
  templateUrl: './one-room.component.html',
  styleUrls: ['./one-room.component.css']
})
export class OneRoomComponent {
  idRoom:number
  room:any
  reservation:Reservation
  userFound: any;
  idUser: any;
  email:string
  token: any;
  user: any;
  constructor(private chamberService:ChamberService, private routeActive: ActivatedRoute,private dataService:DataService,private userService:UserService,private router:Router) {}

  ngOnInit(){
    this.idRoom = this.routeActive.snapshot.params['id'];
    this.chamberService.getOneRoom(this.idRoom).subscribe((res)=>{
      this.room = res.data;

      this.token = this.userService.getToken()
      this.user = this.userService.getUser(this.token);
      this.email = this.user.sub;
      this.userService.findUser(this.email).subscribe((res)=>{
        this.userFound = res.data
        this.idUser = res.data.id
      })
    })
  }

  reserver(id: number) {
    this.dataService.getDataRes().subscribe((res: Reservation)=>{
      this.reservation = res;
    })
    this.chamberService.reserverRoom(this.reservation,id,this.idUser).subscribe((res)=>{
      if(res.status == 'success'){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: false,
          timer: 1500
        })
     this.router.navigate([''])
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
