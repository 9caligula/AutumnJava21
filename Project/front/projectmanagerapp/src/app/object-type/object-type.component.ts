import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ObjectType } from './objectType';
import { MatDialog } from '@angular/material/dialog';
import { ObjecttypeService } from './objecttype.service';
import { Router } from '@angular/router';
import { DialogAttributeComponent } from '../dialog-attribute/dialog-attribute.component';
import { DialogObjectTypeComponent } from '../dialog-object-type/dialog-object-type.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-object-type',
  templateUrl: './object-type.component.html',
  styleUrls: ['./object-type.component.css']
})
export class ObjectTypeComponent implements OnInit {

  public objectTypes!: ObjectType[];

  constructor(public dialog: MatDialog, private objectTypeService: ObjecttypeService, public router: Router,
    private activateRoute: ActivatedRoute) {  }

  ngOnInit(): void {
      this.getObjectType();
  }

  public getObjectType(): void {
    this.objectTypeService.getObjectType().subscribe(
      (response: ObjectType[]) => {
        this.objectTypes = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }     
    )
  }

  openDialog(): void {
    this.dialog.open(DialogAttributeComponent);
  }

  openDialogObjectType(): void {
    this.dialog.open(DialogAttributeComponent);
  }
}