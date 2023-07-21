import { Component, OnInit } from '@angular/core';
import {EmpresaService} from "../../servicos/empresa.service";
import {Empresa} from "../empresa.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'dff-empresa-cadastro',
  templateUrl: './empresa-cadastro.component.html'
})
export class EmpresaCadastroComponent implements OnInit {

  empresa: Empresa = new Empresa();

  constructor(private empresaService: EmpresaService, private router: Router, private routeActive: ActivatedRoute) { }

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
    console.log("Passou no init" + id);
    if (id != null){
      this.empresaService.obterPorId(id).subscribe(retorno => {
        console.log("Passou dentro do subscribe" + id);
        this.empresa = retorno;
      });
    }
  }

}
