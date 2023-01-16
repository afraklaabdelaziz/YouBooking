import { Component } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  navbarOpen = false;
  token: any;
  user: any;
  email: any;
  userFound: any;
  url: string;
  image: any;

  constructor(private userService:UserService,private sanitizer: DomSanitizer) {}

  setNavbarOpen() {
    this.navbarOpen = !this.navbarOpen;
  }

  ngOnInit(): void {
    this.token = this.userService.getToken()
    this.user = this.userService.getUser(this.token);
    this.email = this.user.sub;
    this.userService.findUser(this.email).subscribe((res)=>{
      this.userFound = res.data
      this.url ='data:image/png;base64,' + this.userFound.image.picByte;
      this.image = this.sanitizer.bypassSecurityTrustUrl(this.url)
    })
  }

}
