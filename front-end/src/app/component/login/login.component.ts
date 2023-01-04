import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Login } from 'src/app/model/login';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

 public login: Login;

  constructor(private userService:UserService) {
   this.login = new Login();
  }

  authenticate(){
    this.userService.login(this.login).subscribe((res:any)=>{
      console.log(res.data);
    })
  }

}
