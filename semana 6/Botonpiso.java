public class BotonPiso extends Boton {
    private String direccionSolicitud; // "SUBIDA" o "BAJADA"

    public BotonPiso(String direccionSolicitud) {
        super("PISO - " + direccionSolicitud);
        this.direccionSolicitud = direccionSolicitud;
    }

    @Override
    public void presionar() {
        super.presionar(); // Ejecuta la lógica del padre (luz y sonido)
        System.out.println("   -> Solicitud enviada para que el ascensor se mueva en dirección: " + direccionSolicitud);
    }

    public String getDireccionSolicitud() {
        return direccionSolicitud; 
    }
}