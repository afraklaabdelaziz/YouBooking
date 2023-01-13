import { Adresse } from "./adresse";
import { Image } from "./image"

export class Hotel {
  public id?:number;
  public nom:string;
  public telephone:string;
  public photo:any;
  public adresse:Adresse;
  public image:Image[]


  constructor() {
    this.nom = "";
    this.telephone = "";
    this.photo = "";
    this.adresse = new Adresse();
    this.image = new Array() 
  }
}
