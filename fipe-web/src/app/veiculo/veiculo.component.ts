import { Component, OnInit } from '@angular/core';
import { VeiculoService } from './veiculo.service';
import { Veiculo } from './veiculo';
import { MarcaService } from '../marca/marca.service';
import { Marca } from '../marca/marca';

@Component({
  selector: 'app-veiculo',
  templateUrl: './veiculo.component.html',
  styleUrls: ['./veiculo.component.css']
})
export class VeiculoComponent implements OnInit {

  veiculos: Array<Veiculo> = new Array<Veiculo>();
  marcas: Array<Marca> = new Array<Marca>();
  
  constructor(
    private veiculoService: VeiculoService,
    private marcaService: MarcaService
  ) { }

  ngOnInit() {
    this.veiculoService.listarVeiculos('21').subscribe( res => {
      this.veiculos = res
    });

    this.carregarMarcas();
  }

  carregarMarcas() {
    this.marcaService.listarMarcas().subscribe(res => {
      this.marcas = res
    })

  }

}
