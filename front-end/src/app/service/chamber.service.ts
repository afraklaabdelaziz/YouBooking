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
    return this.http.get("http://localhost:8080/chamber")
  }

  addRoom(chamber:Chamber):Observable<any>{
    return this.http.post("http://localhost:8080/chamber/add",chamber);
  }

  getOneRoom(id:number):Observable<any>{
    return this.http.get("http://localhost:8080/chamber/one/"+id)
  }

  updateRoom(id:number,chamber:Chamber,idHotel:number):Observable<any>{
    return this.http.put("http://localhost:8080/chamber/update/"+id+"/"+idHotel,chamber);
  }

  deleteRoom(id:number):Observable<any>{
    return this.http.delete("http://localhost:8080/chamber/delete/"+id);
  }

  reserverRoom(reservation:Reservation):Observable<any>{
    return this.http.post("http://localhost:8080/chamber/reserver",reservation)
  }
}
