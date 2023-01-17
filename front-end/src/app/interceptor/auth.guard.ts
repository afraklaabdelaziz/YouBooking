import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../service/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  token!:any
  constructor(private userService: UserService,
              private router: Router) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    this.token = this.userService.getToken();
    let user = this.userService.getUser(this.token);
    if (this.userService.getToken() && user.exp*1000 >= new Date().getTime()){
      return true;
    }
    localStorage.clear()
    this.router.navigate(['auth/login'])
    return false;
  }

}
