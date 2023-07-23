import { Component, OnInit } from '@angular/core';
import {Fornecedor} from "./fornecedor.model";
import {FornecedorService} from "../servicos/fornecedor.service";
import {Router} from "@angular/router";

@Component({
  selector: 'dff-fornecedor',
  templateUrl: './fornecedor.component.html'
})
export class FornecedorComponent implements OnInit {

  fornecedores: Array<Fornecedor>;

  cabecalho: Array<String> = ['Nome', 'Tipo', 'CNPJ', 'CPF', 'E-mail', 'CEP', 'AÇÕES'];

  constructor(private fornecedorService: FornecedorService, private router: Router) { }

  ngOnInit() {
    this.fornecedorService.obterFornecedores().subscribe(retorno => {
      this.fornecedores = retorno;
    });
  }

  editar(id) {
    this.router.navigate(['fornecedor/fornecedor-cadastro', id]);
  }

  deletar(id) {
    this.fornecedorService.deletar(id).subscribe(retorno =>{
      alert(`Fornecedor de id ${id} excluído com sucesso.`);
      window.location.reload();
    })
  }

}
