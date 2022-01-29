import { HttpErrorResponse } from '@angular/common/http';
import { Component} from '@angular/core';
import { ActivatedRoute, Router, RouterLink} from '@angular/router';
import { Attribute } from './attribute';
import { AttributeService } from './attribute.service';
import { MatDialogRef } from '@angular/material/dialog';
import { NgForm} from '@angular/forms';

@Component({
  selector: 'attribute-root',
  templateUrl: './attribute.html'
})

export class AttributeComponent {

  public attribute!: Attribute[];
  public id: number;
  

  constructor(public dialogRef: MatDialogRef<AttributeComponent>, 
    private activateRoute: ActivatedRoute, 
    private attributeService: AttributeService,
    private router: Router) {
    
    this.id = activateRoute.snapshot.params['id'];
    this.dialogRef.updateSize('30%', '60%');
  }

  ngOnInit(): void {
    this.getAttributeByID(this.id);
  }

  public getAttributeByID(id: number): void {
    this.attributeService.getAttributeByID(id).subscribe(
      (value: Attribute[]) => {
        this.attribute = value;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }     
    )
  }

  public onAddAttr(form: NgForm): void {
    this.attributeService.createAttribute(form.value.nameAttr, this.id, form.value).subscribe(
      (response: Attribute) => {
        console.log(response);
        this.getAttributeByID(this.id);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  } 

  public deleteAttribute(id: number) {
    this.attributeService.deleteAttribute(id).subscribe(
      (response: void) => {
        console.log(response);
        this.getAttributeByID(this.id);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  close() {
    this.dialogRef.close();
  }

}