import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, map } from 'rxjs/operators';
import { Veiculo } from './veiculo';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  private URL = 'http://localhost:8080/fipe/api/veiculo';

  constructor(
    private http: HttpClient
  ) { }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': 'true',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE',
    })
  }

  public listarVeiculos(id) : Observable<any> {
    return this.http.get(`${this.URL}/${id}`).pipe(
      map(response => response),
      catchError(this.handleError)
    );
  }

  public pesquisarFipe(id, marca): Observable<any>{
    return this.http.get(`${this.URL}/${id}/${marca}`).pipe(
      map(response => response),
      catchError(this.handleError)
    );
  }

  // Error handling 
  handleError(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    //window.alert(errorMessage);
    return throwError(errorMessage);
 }
}
