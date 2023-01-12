import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddChamberComponent } from './component/chamber/add-chamber/add-chamber.component';
import { AddHotelComponent } from './component/hotel/add-hotel/add-hotel.component';
import { AllHotelComponent } from './component/hotel/all-hotel/all-hotel.component';
import { OneHotelComponent } from './component/hotel/one-hotel/one-hotel.component';
import { LoginComponent } from './component/login/login.component';
import { RegisterComponent } from './component/register/register.component';
import { AuthGuard } from './interceptor/auth.guard';
import { RoleGuard } from './interceptor/role.guard';
import { AuthComponent } from './layout/auth/auth.component';
import { SideBarComponent } from './layout/side-bar/side-bar.component';
import { LandingComponent } from './views/landing/landing.component';
import * as path from "path";
import { AdminComponent } from './layout/admin/admin.component';
import { AllUsersComponent } from './views/all-users/all-users.component';
import { OneRoomComponent } from './views/one-room/one-room.component';
import { HotelsOwnerComponent } from './views/hotels-owner/hotels-owner.component';

const routes: Routes = [
  {path: 'chamber',component: OneRoomComponent},
  {path: 'add_hotel',component: AddHotelComponent},
  {path: 'all_hotel',component: AllHotelComponent,canActivate: [AuthGuard,RoleGuard],data:{role:'propritaire'}},
  {path: 'one_hotel/:id',component: OneHotelComponent},
  {path: 'add_chamber/:id',component: AddChamberComponent},
  {path: '',component: LandingComponent},
  {
    path: "admin",
    component: AdminComponent,
    children: [
      {path: 'hotel_list', component: AllHotelComponent },
      {path: 'one_hotel/:id', component: OneHotelComponent },
      {path: 'user_list',component: AllUsersComponent}
    ]
  },
  {
    path: "owner",
    component: AdminComponent,
    children: [
      {path: 'one_hotel/:id', component: OneHotelComponent },
      {path: 'hotel_list',component: HotelsOwnerComponent}
    ]
  },
  {
    path: "auth",
    component: AuthComponent,
    children: [
      { path: "login", component: LoginComponent },
      { path: "register", component: RegisterComponent },
      { path: "", redirectTo: "login", pathMatch: "full" },

    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
