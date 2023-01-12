import { Adresse } from "./adresse";
import { Role } from "./role";

export class User {
    id?: number;
    nom:string;
    email: string;
    telephone:string;
    password:string;
    public photo:string;
    role:Role;
    adresse:Adresse;


    constructor() {
    this.nom = "";
    this.email = "";
    this.telephone = "";
    this.password = "";
    this.photo = "";
    this.adresse = new Adresse();
    this.role = new Role();
  }

}
