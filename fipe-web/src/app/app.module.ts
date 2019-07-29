import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VeiculoComponent } from './veiculo/veiculo.component';
import { MarcaComponent } from './marca/marca.component';
import { VeiculoService } from './veiculo/veiculo.service';
import { HttpClientModule } from '@angular/common/http';
import { MarcaService } from './marca/marca.service';

@NgModule({
  declarations: [
    AppComponent,
    VeiculoComponent,
    MarcaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    VeiculoService,
    MarcaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
