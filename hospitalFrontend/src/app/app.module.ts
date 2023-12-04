import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingModule } from './main/landing/landing.module';
import { SharedModule } from './shared/shared.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { IndexModule } from './main/index.module';
import { PagesModule } from './main/inicio/pages/pages.module';
import { AuthModule } from './seguridad/auth/auth.module';
import { interceptorProvider } from './seguridad/interceptors/emp-interceptor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,    
    FormsModule,
    LandingModule,
    AuthModule,    
    SharedModule,
    FontAwesomeModule,
    IndexModule,
    PagesModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatToolbarModule,
    MatCardModule
    
     
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
