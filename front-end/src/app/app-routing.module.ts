import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddChamberComponent } from './component/chamber/add-chamber/add-chamber.component';
import { HomeComponent } from './component/home/home.component';
import { AddHotelComponent } from './component/hotel/add-hotel/add-hotel.component';
import { AllHotelComponent } from './component/hotel/all-hotel/all-hotel.component';
import { OneHotelComponent } from './component/hotel/one-hotel/one-hotel.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';

const routes: Routes = [
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home',component: HomeComponent},
  {path: 'add_hotel',component: AddHotelComponent},
  {path: 'all_hotel',component: AllHotelComponent},
  {path: 'one_hotel/:id',component: OneHotelComponent},
  {path: 'add_chamber/:id',component: AddChamberComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
