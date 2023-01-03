import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  ngOnInit(): void {
  }
  public user:User;
  constructor(private userService: UserService) {
    this.user =  new User();
  }

  register(form:NgForm){
    this.userService.register(this.user).subscribe()
  }


}
