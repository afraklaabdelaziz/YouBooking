import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Hotel } from 'src/app/model/hotel';
import { HotelService } from 'src/app/service/hotel.service';
import { UserService } from 'src/app/service/user.service';
import { Image } from 'src/app/model/image'
import Swal from 'sweetalert2';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrls: ['./add-hotel.component.css']
})
export class AddHotelComponent {
  hotel:Hotel;
  token: any;
  user: any;
  email: string;
  constructor(private hotelService:HotelService,public router:Router,private userService:UserService,private sanitizare:DomSanitizer) {
    this.hotel = new Hotel();
  }

  addHotel(form: NgForm) {
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
    const hotelForm = this.prepareFormData(this.hotel)
    this.hotelService.addHotel(hotelForm,this.email).subscribe((res)=>{
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
       this.hotel.image.push(image)
    }
  }

  prepareFormData(hotel: Hotel) : FormData{
    const formData = new FormData();
    formData.append(
      'hotel',
      new Blob([JSON.stringify(hotel)],{type: 'application/json'})
    );
    for (let i = 0; i < hotel.image.length; i++) {
      formData.append(
        'imageFile',
        hotel.image[i].file,
        hotel.image[i].file.name
      )
    }
    return formData
  }
}
