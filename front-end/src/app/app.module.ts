import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './component/register/register.component';
import { LoginComponent } from './component/login/login.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from "@angular/common/http";
import { FormsModule} from '@angular/forms';
import { AddHotelComponent } from './component/hotel/add-hotel/add-hotel.component';
import { AllHotelComponent } from './component/hotel/all-hotel/all-hotel.component';
import { AddChamberComponent } from './component/chamber/add-chamber/add-chamber.component';
import { OneHotelComponent } from './component/hotel/one-hotel/one-hotel.component';
import { LandingComponent } from './views/landing/landing.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { DropDownComponent } from './component/drop-down/drop-down.component';
import { AuthComponent } from './layout/auth/auth.component';
import { CalendarComponent } from './component/calendar/calendar.component';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { SideBarComponent } from './layout/side-bar/side-bar.component';
import { StatistiqueComponent } from './views/statistique/statistique.component';
import { AdminComponent } from './layout/admin/admin.component';
import { SatatisticComponent } from './component/card/satatistic/satatistic.component';
import { AllUsersComponent } from './views/all-users/all-users.component';
import { ChamberDesponibleComponent } from './views/chamber-desponible/chamber-desponible.component';
import { OneRoomComponent } from './views/one-room/one-room.component';
import { OwnerComponent } from './layout/owner/owner.component';
import { StatisticOwnerComponent } from './views/statistic-owner/statistic-owner.component';
import { HotelsOwnerComponent } from './views/hotels-owner/hotels-owner.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    AddHotelComponent,
    AllHotelComponent,
    AddChamberComponent,
    OneHotelComponent,
    LandingComponent,
    FooterComponent,
    HeaderComponent,
    DropDownComponent,
    AuthComponent,
    CalendarComponent,
    SideBarComponent,
    StatistiqueComponent,
    AdminComponent,
    SatatisticComponent,
    AllUsersComponent,
    ChamberDesponibleComponent,
    OneRoomComponent,
    OwnerComponent,
    StatisticOwnerComponent,
    HotelsOwnerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
