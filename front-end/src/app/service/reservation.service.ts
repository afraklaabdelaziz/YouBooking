import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClient) { }

  findAllReservationOfHotelOwner(email:string):Observable<any>{
    return this.http.get("http://localhost:8080/reservation/allreservation/"+email)
  }

  getAllReservationEncours(email:string):Observable<any>{
    return this.http.get("http://localhost:8080/reservation/reservatinEncours/"+email)
  }

  updateStatusReservation(id:number,status:any):Observable<any>{
    return this.http.put("http://localhost:8080/reservation/updateStatusReservation/"+id+"/"+status,null)
  }
}
