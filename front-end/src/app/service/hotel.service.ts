import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../model/hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http:HttpClient) { }

  getAllHotelDesactive():Observable<Hotel>{
    return this.http.get("hotel/hotelDesactive")
  }

  getAllHotel():Observable<Hotel>{
    return this.http.get("hotel/all")
  }

  addHotel(hotel:Hotel):Observable<Hotel>{
    return this.http.post("hotel/add",hotel)
  }

  getOneHotel(id:number):Observable<Hotel>{
    return this.http.get("hotel/one/"+id);
  }

  updateHotel(hotel:Hotel,id:number):Observable<Hotel>{
    return this.http.put("hotel/update/"+id,hotel);
  }
  
  deleteHotel(id:number):Observable<any>{
    return this.http.delete("hotel/delete/"+id)
  }
}
