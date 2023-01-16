import { Component } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent {
  user: any;
  email: string;
  userFound: any;
  url: string;
  image: any;

  constructor(private userService:UserService,private sanitizer: DomSanitizer) {
  }
  collapseShow = "hidden";
  token: any;
  toggleCollapseShow(classes: string) {
    this.collapseShow = classes;
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
