import { Component, OnInit } from '@angular/core';
import {Empresa} from "./empresa.model";
import {EmpresaService} from "../servicos/empresa.service";

@Component({
  selector: 'dff-empresa',
  templateUrl: './empresa.component.html'
})
export class EmpresaComponent implements OnInit {

  constructor(private empresaService: EmpresaService) { }

  empresas: Array<Empresa>;

  cabecalho: Array<String> = ['Nome Fantasia', 'CNPJ', 'CEP'];

  ngOnInit() {
    this.empresaService.getEmpresas().subscribe(retorno => {
      this.empresas = retorno;
      alert("Passou")
    });
  }

}
