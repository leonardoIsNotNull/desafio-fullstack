import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EmpresaComponent} from "./empresa/empresa.component";
import {EmpresaCadastroComponent} from "./empresa/empresa-cadastro/empresa-cadastro.component";

const routes: Routes = [
  {path: 'empresa', component: EmpresaComponent},
  {path: 'empresa/empresa-cadastro', component: EmpresaCadastroComponent},
  {path: 'empresa/empresa-cadastro/:id', component: EmpresaCadastroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
