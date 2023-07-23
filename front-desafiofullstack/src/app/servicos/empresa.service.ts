import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConstants} from "../AppConstants";
import {Empresa} from "../empresa/empresa.model";

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  constructor(private http: HttpClient) { }

  obterEmpresas(): Observable<any> {
    return this.http.get<any>(AppConstants.baseEmpresa);
  }

  salvar(empresa: Empresa): Observable<any>{
    return this.http.post<any>(AppConstants.baseEmpresa, empresa);
  }

  obterPorId(id): Observable<any>{
    return this.http.get<any>(`${AppConstants.baseEmpresa}/${id}`);
  }

  deletar(id): Observable<any>{
    return this.http.delete(`${AppConstants.baseEmpresa}/${id}`);
  }

}
