import { Component, OnInit } from '@angular/core';
import { ObjecttypeService } from '../object-type/objecttype.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router} from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';
import { ObjectType } from '../object-type/objectType';

@Component({
  selector: 'app-dialog-object-type',
  templateUrl: './dialog-object-type.component.html',
  styles: [
  ]
})
export class DialogObjectTypeComponent implements OnInit {

  public objectTypes!: ObjectType[];
  public id: number;

  constructor(public dialogRef: MatDialogRef<DialogObjectTypeComponent>, 
    private activateRoute: ActivatedRoute, 
    private objectTypeService: ObjecttypeService,
    private router: Router) {
    
    this.id = activateRoute.snapshot.params['id'];
    this.dialogRef.updateSize('30%', '60%');
  }

  ngOnInit(): void {
      this.getChildObjectType();
  }

  public getChildObjectType(): void {
    this.objectTypeService.getChildObjectType(this.id).subscribe(
      (response: ObjectType[]) => {
        this.objectTypes = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }     
    )
  }

}
