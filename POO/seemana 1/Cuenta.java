public class Cuenta {
  
  //Atributos
  private int cedula;
  private String nombre;
  private String numeroCuenta;                     
  private String tipoCuenta;
  private double saldo;
  
  //El constructor de la clase permite inicializar la clase
  //El constructor de la clase se reconoce porque tiene el mismo nombre de la clase
  public Cuenta(int cedula, String nombre, String numeroCuenta, String tipoCuenta, double saldo){
    this.cedula = cedula;
    this.nombre= nombre;
    this.numeroCuenta = numeroCuenta;
    this.tipoCuenta = tipoCuenta;
    this.saldo = saldo;
  }
  
  public String toString(){
    return "Cuenta [ cedula:" + cedula + " nombre: " + nombre + " numerocuenta: " + numeroCuenta + 
                     " tipoCuenta: " + tipoCuenta + " saldo: " + saldo + "]";
  }
}  

//*********************************************************