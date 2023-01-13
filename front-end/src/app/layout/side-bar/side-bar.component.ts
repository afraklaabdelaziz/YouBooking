import { Component, Input } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {

  token:any;
  user:any;
  email:string
  userFound: any;
  constructor(private userService:UserService) {
  }
  ngOnInit(){
    this.token = this.userService.getToken();
    this.user = this.userService.getUser(this.token)
    this.email = this.user.sub
    this.userService.findUser(this.email).subscribe((res)=>{
      this.userFound = res.data
    })
  }
  collapseShow = "hidden";
  toggleCollapseShow(classes: string) {
    this.collapseShow = classes;
  }
}
