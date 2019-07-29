import { LoaderService } from './../loader.service';
import { Fipe } from './fipe';
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
  fipeList: Array<Fipe> = new Array<Fipe>();

  marcaSelecionada: Marca;
  veiculoSelecionado: Veiculo;
  spinner: boolean;
  
  constructor(
    private veiculoService: VeiculoService,
    private marcaService: MarcaService,
    private loader: LoaderService
  ) { }

  ngOnInit() {
    this.carregarMarcas();
  }

  carregarMarcas() {
    this.marcaService.listarMarcas().subscribe(res => {
      this.marcas = res
    })

  }

  carregarVeiculos(id) {    
    this.veiculoService.listarVeiculos(id).subscribe( res => {
      this.veiculos = res
    });
  }

  pesquisarFipe() {
    this.spinner = true;
    this.loader.display(true);
    this.veiculoService.pesquisarFipe(this.marcaSelecionada.id, this.veiculoSelecionado.id).subscribe( res => {
      this.fipeList = res;
      this.loader.display(false);
      this.spinner = false;
    });
  }

}
