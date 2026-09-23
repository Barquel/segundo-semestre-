
public class EjecutarEstudiante {
    public static void main(String[] args) {

        // Creación del objeto
        Estudiantes objEst1 = new Estudiantes(2627, "Jose", "Fisica", 3.0, 4.0, 5.0);

        System.out.println(objEst1.toString());

        System.out.println(objEst1.calcularPromedio());
    }
}
