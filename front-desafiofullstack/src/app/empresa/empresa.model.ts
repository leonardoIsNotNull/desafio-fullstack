import {Fornecedor} from "../fornecedor/fornecedor.model";

export class Empresa {
  id!: number;
  cnpj!: string;
  nomeFantasia!: string;
  cep!: string;
  fornecedores: Fornecedor[] = [];
}
