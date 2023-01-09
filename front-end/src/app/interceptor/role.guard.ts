import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../service/user.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

 token!: any
  constructor(private userService: UserService,private router:Router) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    this.token = this.userService.getToken();
   const authorized =  this.userService.getUser(this.token).authorities[0].authority.includes(route.data['role'])
    if (!authorized){
      this.router.navigate(['auth/login'])
    }
  return authorized;
  }

}
