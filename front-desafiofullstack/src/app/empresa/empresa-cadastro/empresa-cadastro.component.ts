import { Component, OnInit } from '@angular/core';
import {EmpresaService} from "../../servicos/empresa.service";
import {Empresa} from "../empresa.model";
import {ActivatedRoute, Router} from "@angular/router";
import {Fornecedor} from "../../fornecedor/fornecedor.model";
import {FornecedorService} from "../../servicos/fornecedor.service";

@Component({
  selector: 'dff-empresa-cadastro',
  templateUrl: './empresa-cadastro.component.html'
})
export class EmpresaCadastroComponent implements OnInit {

  empresa: Empresa = new Empresa();
  fornecedores: Fornecedor[] = [];

  constructor(private empresaService: EmpresaService,
              private router: Router,
              private routeActive: ActivatedRoute,
              private fornecedorService: FornecedorService) { }

  salvar(){
    this.empresaService.salvar(this.empresa).subscribe(retorno => {
      if(this.empresa.id == null){
        alert("Empresa cadastrada com sucesso!");
      }else {
        alert("Empresa atualizada com sucesso!");
      }
      this.router.navigate(['empresa']);
    });
    this.empresa = new Empresa();
  }

  ngOnInit() {
    const id = this.routeActive.snapshot.paramMap.get('id');
    if (id != null){
      this.empresaService.obterPorId(id).subscribe(retorno => {
        this.empresa = retorno;
      });
    }

    this.fornecedorService.obterFornecedores().subscribe(retorno => {
      this.fornecedores = retorno;
    });

  }

  adicionarFornecedor(fornecedor: Fornecedor){
    this.empresa.fornecedores.push(fornecedor);
  }

  removerFornecedor(fornecedor: Fornecedor){
    this.empresa.fornecedores.splice(this.empresa.fornecedores.indexOf(fornecedor), 1);
  }

  desabilitarSelecionar(id: number) : boolean{
    return !!this.empresa.fornecedores.find(fornecedor => fornecedor.id == id);
  }
}
