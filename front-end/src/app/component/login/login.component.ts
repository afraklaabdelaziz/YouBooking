import { Component, EventEmitter, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/login';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

 public login: Login;
 
  constructor(private userService:UserService,public router:Router) {
   this.login = new Login();
  }

  authenticate(){
    this.userService.login(this.login).subscribe((res:any)=>{
      localStorage.setItem("token",res.data)
      this.router.navigate(["/home"])
    })
  }
}
