import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './component/register/register.component';
import { LoginComponent } from './component/login/login.component';
import {HttpClientModule} from "@angular/common/http";
import { FormsModule} from '@angular/forms';
import { HomeComponent } from './component/home/home.component';
import { AddHotelComponent } from './component/hotel/add-hotel/add-hotel.component';
import { AllHotelComponent } from './component/hotel/all-hotel/all-hotel.component';
import { AddChamberComponent } from './component/chamber/add-chamber/add-chamber.component';
import { AllChamberComponent } from './component/chamber/all-chamber/all-chamber.component';
import { OneHotelComponent } from './component/hotel/one-hotel/one-hotel.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    AddHotelComponent,
    AllHotelComponent,
    AddChamberComponent,
    AllChamberComponent,
    OneHotelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
