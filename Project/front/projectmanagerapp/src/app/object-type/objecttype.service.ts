import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ObjectType } from './objectType';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ObjecttypeService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getObjectType(): Observable<ObjectType[]> {
    return this.http.get<ObjectType[]>(`${this.apiServerUrl}/type`)
  }
  
  public getChildObjectType(id: number): Observable<ObjectType[]> {
    return this.http.get<ObjectType[]>(`${this.apiServerUrl}/type/child/${id}`)
  }
  
}