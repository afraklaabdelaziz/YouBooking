import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../model/hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http:HttpClient) { }

  getAllHotelDesactive():Observable<any>{
    return this.http.get("http://localhost:8080/hotel/hotelDesactive")
  }

  getAllHotel():Observable<any>{
    return this.http.get("http://localhost:8080/hotel/all")
  }

  getAllHotelOfOwner(email:string):Observable<any>{
    return this.http.get("http://localhost:8080/hotel/proprietair/"+email)
  }

  addHotel(hotel:FormData ,email:string):Observable<any>{
    return this.http.post<any>("http://localhost:8080/hotel/add/"+email,hotel)
  }

  getOneHotel(id:number):Observable<any>{
    return this.http.get("http://localhost:8080/hotel/one/"+id);
  }

  updateHotel(hotel:Hotel,id:number):Observable<any>{
    return this.http.put("http://localhost:8080/hotel/update/"+id,hotel);
  }

  deleteHotel(id:number):Observable<any>{
    return this.http.delete("http://localhost:8080/hotel/delete/"+id)
  }

  updateStatusHotel(id:number):Observable<any>{
    return this.http.put("http://localhost:8080/hotel/updateStatusHotel/"+id,null)
  }
}
