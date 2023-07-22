import { Component, OnInit } from '@angular/core';
import {Empresa} from "./empresa.model";
import {EmpresaService} from "../servicos/empresa.service";
import {Router} from "@angular/router";

@Component({
  selector: 'dff-empresa',
  templateUrl: './empresa.component.html'
})
export class EmpresaComponent implements OnInit {

  constructor(private empresaService: EmpresaService, private router: Router) { }

  empresas: Array<Empresa>;

  cabecalho: Array<String> = ['Nome Fantasia', 'CNPJ', 'CEP'];

  ngOnInit() {
    this.empresaService.getEmpresas().subscribe(retorno => {
      this.empresas = retorno;
    });
  }

  editar(id) {
    this.router.navigate(['empresa/empresa-cadastro', id]);
  }

  deletar(id) {
    this.empresaService.deletar(id).subscribe(retorno =>{
      alert(`Empresa de id ${id} excluída com sucesso.`);
      window.location.reload();
    })
  }

}
