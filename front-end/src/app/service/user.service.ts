import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router} from '@angular/router';
import {map, Observable } from 'rxjs';
import { Login } from '../model/login';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient,private router:Router) { }

  register(user:User):Observable<User>{
    return this.http.post<any>(`http://localhost:8080/user/add`,user)
  }

  login(login:any) {
    return this.http.post(`http://localhost:8080/user/login`,login ,{
      observe: 'response'
    }).pipe(map((response:HttpResponse<any>) =>{
      const body = response.body;
      const headers = response.headers;

      const bearerToken = headers.get('Authorization')!;
      this.getUser(body.data)
      return body.data;
    }))
  }


  getUser(token:string):any{
    return JSON.parse(atob(token.split('.')[1]))
  }

  getToken(){
    return  localStorage.getItem("token")
  }
  }

