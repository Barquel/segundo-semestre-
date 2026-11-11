public class Puerta {
    private boolean abierta;
    private boolean obstaculoDetectado;

    public Puerta() {
        this.abierta = false;
        this.obstaculoDetectado = false;
    }

    public void abrir() {
        this.abierta = true;
        System.out.println("   [PUERTA] Puertas ABIERTAS.");
    }

    public void cerrar() {
        // Validación del sensor de seguridad[span_8](start_span)[span_8](end_span)[span_9](start_span)[span_9](end_span)
        if (obstaculoDetectado) {
            System.out.println("   [ALERTA PUERTA] ¡Obstáculo detectado! Reabriendo puertas por seguridad.");
            abrir();
        } else {
            this.abierta = false;
            System.out.println("   [PUERTA] Puertas CERRADAS.");
        }
    }

    // Simula presionar el botón "Mantener puertas abiertas[span_10](start_span)[span_11](start_span)"[span_10](end_span)[span_11](end_span)
    public void mantenerAbierta() {
        System.out.println("   [PUERTA] Botón 'Mantener Abierta' activado. Las puertas seguirán abiertas.");
        this.abierta = true;
    }

    public void setObstaculoDetectado(boolean estado) {
        this.obstaculoDetectado = estado;
    }

    public boolean isAbierta() { return abierta; }
}