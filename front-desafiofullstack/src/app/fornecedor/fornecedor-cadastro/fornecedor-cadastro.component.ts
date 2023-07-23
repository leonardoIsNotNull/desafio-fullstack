import { Component, OnInit } from '@angular/core';
import {Fornecedor} from "../fornecedor.model";
import {FornecedorService} from "../../servicos/fornecedor.service";
import {Empresa} from "../../empresa/empresa.model";
import {ActivatedRoute, Router} from "@angular/router";
import {EmpresaService} from "../../servicos/empresa.service";

@Component({
  selector: 'dff-fornecedor-cadastro',
  templateUrl: './fornecedor-cadastro.component.html'
})
export class FornecedorCadastroComponent implements OnInit {

  fornecedor: Fornecedor = new Fornecedor();
  empresas: Empresa[] = [];
  name = 'radio';
  model = false;
  radios = [
    {
      label: 'Pessoa Jurídica',
      value: true,
      name: 'pessoaJuridica'
    },
    {
      label: 'Pessoa Física',
      value: false,
      name: 'pessoaFisicia'
    }
  ];

  constructor(private fornecedorService: FornecedorService,
              private router: Router,
              private routeActive: ActivatedRoute,
              private empresaService: EmpresaService) { }

  ngOnInit() {
    const id = this.routeActive.snapshot.paramMap.get('id');
    if (id != null){
      this.fornecedorService.obterPorId(id).subscribe(retorno => {
        this.fornecedor = retorno;
      });
    }

    this.empresaService.obterEmpresas().subscribe(retorno => {
      this.empresas = retorno;
    });

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

  adicionarEmpresa(empresa: Empresa){
    this.fornecedor.empresas.push(empresa);
  }

  removerFornecedor(empresa: Empresa){
    this.fornecedor.empresas.splice(this.fornecedor.empresas.indexOf(empresa), 1);
  }

  desabilitarSelecionar(id: number): boolean{
    return !!this.fornecedor.empresas.find(empresa => empresa.id == id);
  }

}
