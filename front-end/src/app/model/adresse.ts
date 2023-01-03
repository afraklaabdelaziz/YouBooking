export class Adresse {
  id?:number;
  pays:string;
  ville:string;
  adresse:string;
  codePostal:string;


  constructor() {
    this.pays = "";
    this.ville = ""
    this.adresse = "";
    this.codePostal = "";
  }
}
