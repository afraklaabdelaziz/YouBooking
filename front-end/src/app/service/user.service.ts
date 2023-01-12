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

  getAllUsers():Observable<any>{
    return this.http.get("http://localhost:8080/user/all")
  }

  register(user:User):Observable<any>{
    return this.http.post<any>(`http://localhost:8080/user/add`,user)
  }


  bannUser(id:number):Observable<any>{
    return this.http.put("http://localhost:8080/user/bannUser/"+id,null)
  }

  deleteUser(id:number):Observable<any>{
    return this.http.delete("http://localhost:8080/user/delete/"+id)
  }

  updateUser(id:number,user:User):Observable<any>{
    return this.http.put("http://localhost:8080/user/update/"+id,user);
  }

  findUser(tele:string):Observable<any>{
    return this.http.get("http://localhost:8080/user/oneUser/"+tele)
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

