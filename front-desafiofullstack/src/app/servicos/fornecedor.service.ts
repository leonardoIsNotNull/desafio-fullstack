import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConstants} from "../AppConstants";
import {Fornecedor} from "../fornecedor/fornecedor.model";

@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  constructor(private http: HttpClient) { }

  obterFornecedores(): Observable<any> {
    return this.http.get<any>(AppConstants.baseFornecedor);
  }

  salvar(fornecedor: Fornecedor): Observable<any>{
    return this.http.post<any>(AppConstants.baseFornecedor, fornecedor);
  }

  obterPorId(id): Observable<any>{
    return this.http.get<any>(`${AppConstants.baseFornecedor}/${id}`);
  }

  deletar(id): Observable<any>{
    return this.http.delete(`${AppConstants.baseFornecedor}/${id}`);
  }

}
