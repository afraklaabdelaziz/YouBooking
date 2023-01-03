import { Adresse } from "./adresse";
import { Role } from "./role";

export class User {
    id?: number;
    nom!:string;
    email!: string;
    telephone!:string;
    password!:string;
    role!:Role;
    adresse!:Adresse;


}
