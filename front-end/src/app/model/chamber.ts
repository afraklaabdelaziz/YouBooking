import { Hotel } from "./hotel";

export class Chamber {
  public id?:number;
  public prix:number;
  public nomberLits:number;
  public photo:string;
  public hotel:Hotel;


  constructor() {
    this.prix = 0;
    this.nomberLits = 0;
    this.photo = "";
    this.hotel = new Hotel();
  }
}
