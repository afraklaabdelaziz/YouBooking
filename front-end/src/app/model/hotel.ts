import { Adresse } from "./adresse";

export class Hotel {
  public id?:number;
  public nom:string;
  public telephone:string;
  public photo:string;
  public adresse:Adresse;


  constructor() {
    this.nom = "";
    this.telephone = "";
    this.photo = "";
    this.adresse = new Adresse();
  }
}
