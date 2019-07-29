import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {

  private URL = 'http://localhost:8080/fipe/api/veiculo';

  constructor(
    private http: HttpClient
  ) { }

  public listarMarcas() : Observable<any> {
    return this.http.get(`${this.URL}/marcas`).pipe(
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
