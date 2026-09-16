public class EjecutarBanco {
  public static void main(String[] args) {

    // Creación del objeto
    Cuenta objCuenta1 = new Cuenta(1010, "Juan", "587-3", "Ahorros", 0.0);

    System.out.println(objCuenta1.toString());

    objCuenta1.recargarCuenta(10000.0);

    System.out.println(objCuenta1.toString());   


     System.out.println(objCuenta1.toString());

    objCuenta1.retirarCuenta(10000.0);

    System.out.println(objCuenta1.toString());
  }
  }
