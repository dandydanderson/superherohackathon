import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Superhuman } from 'src/models/superhumans';

@Injectable({
  providedIn: 'root'
})
export class SuperServiceService {

  allSuperhumansUrl: string = 'http://localhost:8080/superhumans/superhuman';

  constructor(private http: HttpClient) { }

  getAllSuperhumans(): Observable<Superhuman[]> {
    return this.http.get<Superhuman[]>(this.allSuperhumansUrl);
  }



}
