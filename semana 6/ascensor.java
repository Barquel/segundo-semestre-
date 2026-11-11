import java.util.ArrayList;
import java.util.List;

public class Ascensor {
    private int pisoActual;
    private String direccion; // "SUBIENDO", "BAJANDO", "DETENIDO"
    private Puerta puerta;
    private List<Boton> botonesDestino;

    public Ascensor(int totalPisos) {
        this.pisoActual = 1; // Empieza en el primer piso
        this.direccion = "DETENIDO";
        this.puerta = new Puerta();
        this.botonesDestino = new ArrayList<>();

        // Crear un botón de destino por cada piso del edificio[span_16](start_span)[span_16](end_span)
        for (int i = 1; i <= totalPisos; i++) {
            botonesDestino.add(new Boton("DESTINO", i));
        }
    }

    public void moverAPiso(int pisoObjetivo) {
        if (pisoObjetivo > pisoActual) {
            direccion = "SUBIENDO";
        } else if (pisoObjetivo < pisoActual) {
            direccion = "BAJANDO";
        }

        System.out.println("\n[ASCENSOR] Moviéndose desde el Piso " + pisoActual + " hacia el Piso " + pisoObjetivo + " (" + direccion + ")...");
        this.pisoActual = pisoObjetivo;
        System.out.println("[ASCENSOR] Llegó al Piso " + pisoActual + ".");
        
        // Al llegar, abre puertas y apaga el botón[span_17](start_span)[span_17](end_span)[span_18](start_span)[span_18](end_span)[span_19](start_span)[span_19](end_span)
        puerta.abrir();
        apagarBotonDestino(pisoObjetivo);
    }

    public void apagarBotonDestino(int piso) {
        for (Boton b : botonesDestino) {
            if (b.getPisoDestino() == piso) {
                b.apagar();
            }
        }
    }

    // Getters y Setters
    public int getPisoActual() { return pisoActual; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Puerta getPuerta() { return puerta; }
    public List<Boton> getBotonesDestino() { return botonesDestino; }
}