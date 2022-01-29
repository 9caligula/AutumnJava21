import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ObjectType } from './object-type/objectType';
import { ObjecttypeService } from './object-type/objecttype.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DialogAttributeComponent } from './dialog-attribute/dialog-attribute.component';
import { DialogObjectTypeComponent } from './dialog-object-type/dialog-object-type.component';
import { TokenStorageService } from './auth/token-storage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  // public objectTypes!: ObjectType[];

  // constructor(public dialog: MatDialog, private objectTypeService: ObjecttypeService, public router: Router) {  }

  // ngOnInit(): void {
  //     this.getObjectType();
  // }

  // public getObjectType(): void {
  //   this.objectTypeService.getObjectType().subscribe(
  //     (response: ObjectType[]) => {
  //       this.objectTypes = response;
  //     },
  //     (error: HttpErrorResponse) => {
  //       alert(error.message);
  //     }     
  //   )
  // }

  // openDialog(): void {
  //   this.dialog.open(DialogAttributeComponent);
  // }

  // openDialogObjectType(): void {
  //   this.dialog.open(DialogAttributeComponent);
  // }


  roles!: string[];
  authority!: string;

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'admin';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'pm';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }

  logout() {
    this.tokenStorage.signOut();
    window.location.reload();
  }
  
}