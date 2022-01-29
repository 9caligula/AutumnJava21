import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Attribute } from './attribute';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AttributeService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAttributeByID(id: number): Observable<Attribute[]> {
    return this.http.get<Attribute[]>(`${this.apiServerUrl}/attribute/${id}`)
  }

  public deleteAttribute(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/attribute/delete/${id}`)
  }

  public createAttribute(value: string, idType: number, attr: Attribute): Observable<Attribute> {
    return this.http.post<Attribute>(`${this.apiServerUrl}/type/attribute/${idType}/${value}`, attr);
  }
}