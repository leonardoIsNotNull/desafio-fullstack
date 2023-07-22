import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpresaComponent } from './empresa/empresa.component';
import {HttpClientModule} from "@angular/common/http";
import { EmpresaCadastroComponent } from './empresa/empresa-cadastro/empresa-cadastro.component';
import {FormsModule} from "@angular/forms";
import { FornecedorComponent } from './fornecedor/fornecedor.component';
import { FornecedorCadastroComponent } from './fornecedor/fornecedor-cadastro/fornecedor-cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpresaComponent,
    EmpresaCadastroComponent,
    FornecedorComponent,
    FornecedorCadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
