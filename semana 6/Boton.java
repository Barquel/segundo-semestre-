public class Boton {
    private String tipo;          // "SUBIDA", "BAJADA" o "DESTINO"
    private boolean iluminado;    // Estado visual del botón
    private int pisoDestino;      // Si es un botón de ascensor, indica a qué piso va

    // Constructor para botones de piso
    public Boton(String tipo) {
        this.tipo = tipo;
        this.iluminado = false;
        this.pisoDestino = -1;
    }

    // Constructor para botones dentro del ascensor
    public Boton(String tipo, int pisoDestino) {
        this.tipo = tipo;
        this.iluminado = false;
        this.pisoDestino = pisoDestino;
    }

    // Al presionar se enciende y emite un sonido[span_4](start_span)[span_4](end_span)
    public void presionar() {
        this.iluminado = true;
        emitirSonido();
        System.out.println("   [BOTÓN] Botón (" + tipo + (pisoDestino != -1 ? " -> Piso " + pisoDestino : "") + ") ENCENDIDO.");
    }

    private void emitirSonido() {
        System.out.println("   [SONIDO] ♪ Beep suave ♪");
    }

    public void apagar() {
        this.iluminado = false;
    }

    public boolean isIluminado() { return iluminado; }
    public String getTipo() { return tipo; }
    public int getPisoDestino() { return pisoDestino; }
}