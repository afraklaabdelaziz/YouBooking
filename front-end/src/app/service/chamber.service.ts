import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Chamber } from '../model/chamber';
import { Reservation } from '../model/reservation';

@Injectable({
  providedIn: 'root'
})
export class ChamberService {

  constructor(private http:HttpClient) { }

  getAllRooms():Observable<any>{
    return this.http.get("chamber")
  }

  addRoom(chamber:Chamber):Observable<any>{
    return this.http.post("chamber/add",chamber);
  }

  getOneRoom(id:number):Observable<any>{
    return this.http.get("chamber/one/"+id)
  }

  updateRoom(id:number,chamber:Chamber):Observable<any>{
    return this.http.put("chamber/update/"+id,chamber);
  }

  deleteRoom(id:number):Observable<any>{
    return this.http.delete("chamber/delete/"+id);
  }

  reserverRoom(reservation:Reservation):Observable<any>{
    return this.http.post("chamber/reserver",reservation)
  }
}
