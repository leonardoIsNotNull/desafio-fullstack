export class AppConstants {

  public static get baseServidor(): string {
    return 'http://localhost:8080/';
  }

  public static get baseEmpresa(): string {
    return this.baseServidor + 'empresa';
  }

  public static get baseUrl(): string {
    return this.baseServidor + 'cursospringrestapi/usuario/';
  }

  public static get baseUrlPath(): string {
    return this.baseServidor + 'cursospringrestapi/';
  }
}
