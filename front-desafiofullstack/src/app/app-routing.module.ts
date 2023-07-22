import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EmpresaComponent} from "./empresa/empresa.component";
import {EmpresaCadastroComponent} from "./empresa/empresa-cadastro/empresa-cadastro.component";
import {FornecedorComponent} from "./fornecedor/fornecedor.component";
import {FornecedorCadastroComponent} from "./fornecedor/fornecedor-cadastro/fornecedor-cadastro.component";

const routes: Routes = [
  {path: 'empresa', component: EmpresaComponent},
  {path: 'empresa/empresa-cadastro', component: EmpresaCadastroComponent},
  {path: 'empresa/empresa-cadastro/:id', component: EmpresaCadastroComponent},
  {path: 'fornecedor', component: FornecedorComponent},
  {path: 'fornecedor/fornecedor-cadastro', component: FornecedorCadastroComponent},
  {path: 'fornecedor/fornecedor-cadastro/:id', component: FornecedorCadastroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
