import { Component, EventEmitter, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthInterceptor } from 'src/app/interceptor/auth.interceptor';
import { Login } from 'src/app/model/login';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

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
    this.userService.login(this.login).subscribe((res:any)=> {
        if (res.status != "success"){
          Swal.fire({
            position: 'center',
            icon: 'error',
            title: res.message,
            showConfirmButton: true,
            timer: 2000
          })

        }else {
          Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: "welcome to our account",
            showConfirmButton: false,
            timer: 2000
          })
          localStorage.setItem("token", res.data)
          let role = this.userService.getUser(res.data).authorities[0].authority
          switch (role) {
            case "client" :
              this.router.navigate([""]);
              break;
            case "admin" :
              this.router.navigate(["/admin"]);
              break;
            case "proprietaire" :
              this.router.navigate(["/owner"]);
              break;
          }
        }

      }

    )
  }
}
