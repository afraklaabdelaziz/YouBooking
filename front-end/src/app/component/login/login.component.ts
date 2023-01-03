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

  login! : Login;
  constructor(private userService:UserService) {

  }

  authenticate(form:NgForm){
    this.userService.login(this.login).subscribe(

    );
  }

}
