import { Component, OnInit } from '@angular/core';
import {Fornecedor} from "../fornecedor.model";
import {FornecedorService} from "../../servicos/fornecedor.service";
import {Empresa} from "../../empresa/empresa.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'dff-fornecedor-cadastro',
  templateUrl: './fornecedor-cadastro.component.html'
})
export class FornecedorCadastroComponent implements OnInit {

  fornecedor: Fornecedor = new Fornecedor();

  constructor(private fornecedorService: FornecedorService, private router: Router, private routeActive: ActivatedRoute) { }

  ngOnInit() {
    const id = this.routeActive.snapshot.paramMap.get('id');
    if (id != null){
      this.fornecedorService.obterPorId(id).subscribe(retorno => {
        this.fornecedor = retorno;
      });
    }
  }

  salvar(){
    this.fornecedorService.salvar(this.fornecedor).subscribe(retorno => {
      if(this.fornecedor.id == null){
        alert("Fornecedor cadastrado com sucesso!");
      }else {
        alert("Forncedor atualizado com sucesso!");
      }
      this.router.navigate(['fornecedor']);
    });
    this.fornecedor = new Fornecedor();
  }

}
