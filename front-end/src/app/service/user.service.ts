import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../model/login';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  register(user:User):Observable<User>{
    return this.http.post<any>(`http://localhost:8080/user/add`,user)
  }

  login(login:any):Observable<any> {
    return this.http.post<any>(`http://localhost:8080/user/login`,login)
  }
  }

