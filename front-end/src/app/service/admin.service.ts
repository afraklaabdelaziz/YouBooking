import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../model/hotel';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  addUser(user:User):Observable<any>{
    return this.http.post("api/v1/admin/add",user);
  }

  updateStausHotel(id:number,hotel:Hotel):Observable<any>{
    return this.http.put("api/v1/admin/updateStatusHotel/"+id,hotel)
  }

  updateStatuspropritaire(id:number,user:User):Observable<any>{
    return this.http.put("api/v1/admin/updateStatuspropritaire/"+id,user)
  }
}
