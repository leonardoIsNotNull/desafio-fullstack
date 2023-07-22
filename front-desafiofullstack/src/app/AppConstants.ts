export class AppConstants {

  public static get baseServidor(): string {
    return 'http://localhost:8080/';
  }

  public static get baseEmpresa(): string {
    return this.baseServidor + 'empresa';
  }

  public static get baseFornecedor(): string {
    return this.baseServidor + 'fornecedor';
  }

}
