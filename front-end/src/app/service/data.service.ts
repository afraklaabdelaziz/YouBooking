import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private _dataSream = new BehaviorSubject("")
  private _dataSreamRes = new BehaviorSubject("")
  constructor() { }

  getData():any{
    return this._dataSream.asObservable();
  }

  putDataToStream(data:any){
    this._dataSream.next(data)
  }

  getDataRes():any{
    return this._dataSreamRes.asObservable();
  }

  setDataToStream(data:any){
    this._dataSreamRes.next(data)
  }
}
