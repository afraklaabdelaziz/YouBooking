import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';
import { Image } from 'src/app/model/image'
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  ngOnInit(): void {
  }
  public user:User;
  constructor(private userService: UserService,private sanitizare:DomSanitizer) {
    this.user =  new User();
  }

  register(form:NgForm){
    const userForm = this.prepareFormData(this.user)
    this.userService.register(userForm).subscribe((res)=>{
      if (res.status === 'success'){
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: res.message,
          showConfirmButton: false,
          timer: 1500
        })
      }
      this.refresh()
    })
  }

  refresh(): void {
    window.location.reload();
  }


  imageSelected(event:any) {
    if (event.target.files){
      const file:File = event.target.files[0];

      const image:Image = new Image (file,this.sanitizare.bypassSecurityTrustUrl(
        window.URL.createObjectURL(file)
      ))
      this.user.image.push(image)
    }
  }


  prepareFormData(user: User) : FormData{
    const formData = new FormData();
    formData.append(
      'user',
      new Blob([JSON.stringify(user)],{type: 'application/json'})
    );
    for (let i = 0; i < user.image.length; i++) {
      formData.append(
        'imageFile',
        user.image[i].file,
        user.image[i].file.name
      )
    }
    return formData
  }

}
