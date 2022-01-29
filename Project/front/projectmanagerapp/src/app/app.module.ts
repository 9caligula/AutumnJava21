import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AttributeComponent } from './attribute/attribute.component';
import { ObjecttypeService } from './object-type/objecttype.service';

import { Routes, RouterModule } from '@angular/router';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DialogAttributeComponent } from './dialog-attribute/dialog-attribute.component';
import { AttributeService } from './attribute/attribute.service';
import { DialogObjectTypeComponent } from './dialog-object-type/dialog-object-type.component';
import { LoginComponent } from './login/login.component';
import { ObjectTypeComponent } from './object-type/object-type.component';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';

const appRoutes: Routes =[
  { path: 'attribute/:id', component: AttributeComponent },
  { path: 'type/child/:id', component: DialogObjectTypeComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'object', component: ObjectTypeComponent },
  { path: 'signup', component: RegisterComponent },
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent, 
    AttributeComponent, 
    DialogAttributeComponent, 
    DialogObjectTypeComponent,
    LoginComponent, 
    ObjectTypeComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [httpInterceptorProviders, ObjecttypeService, AttributeService],
  bootstrap: [AppComponent],
  entryComponents: [AttributeComponent]
})
export class AppModule { }