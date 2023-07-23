import {Empresa} from "../empresa/empresa.model";

export class Fornecedor{
  id!: number;
  cnpj!: string;
  cpf!: string;
  rg!: string;
  dataNascimento!: Date;
  nome!: string;
  cep!: string;
  empresas: Empresa[] = [];
}