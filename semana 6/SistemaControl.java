import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaControl {
    private Ascensor ascensor;
    private List<Piso> pisos;
    private List<Integer> solicitudesPendientes;
    private long tiempoInicioFuncionamiento;

    public SistemaControl(int numPisos) {
        this.ascensor = new Ascensor(numPisos);
        this.pisos = new ArrayList<>();
        this.solicitudesPendientes = new ArrayList<>();
        this.tiempoInicioFuncionamiento = System.currentTimeMillis();

        for (int i = 1; i <= numPisos; i++) {
            pisos.add(new Piso(i));
        }
    }

    // Agrega solicitudes al sistema de manera optimizada[span_24](start_span)[span_24](end_span)[span_25](start_span)[span_25](end_span)
    public void solicitarAscensor(int pisoOrigen, String direccionDeseada) {
        System.out.println("\n--- NUEVA SOLICITUD ---");
        System.out.println("Solicitud en Piso " + pisoOrigen + " para " + direccionDeseada);

        Piso piso = pisos.get(pisoOrigen - 1);
        if (direccionDeseada.equalsIgnoreCase("SUBIDA")) {
            piso.getBotonSubir().presionar();
        } else {
            piso.getBotonBajar().presionar();
        }

        if (!solicitudesPendientes.contains(pisoOrigen)) {
            solicitudesPendientes.add(pisoOrigen);
        }
    }

    // Procesa las paradas según la optimización de dirección[span_26](start_span)[span_26](end_span)[span_27](start_span)[span_27](end_span)
    public void procesarSolicitudes() {
        if (solicitudesPendientes.isEmpty()) return;

        // Ordena las solicitudes para seguir una misma dirección antes de cambiar[span_28](start_span)[span_28](end_span)[span_29](start_span)[span_29](end_span)
        if (ascensor.getDireccion().equals("SUBIENDO") || ascensor.getDireccion().equals("DETENIDO")) {
            Collections.sort(solicitudesPendientes); // Orden ascendente
        } else {
            solicitudesPendientes.sort(Collections.reverseOrder()); // Orden descendente
        }

        while (!solicitudesPendientes.isEmpty()) {
            int siguientePiso = solicitudesPendientes.remove(0);
            ascensor.moverAPiso(siguientePiso);
            
            // Simulación: se atienden los usuarios y se cierran las puertas
            ascensor.getPuerta().cerrar();
        }

        ascensor.setDireccion("DETENIDO");
    }

    // Módulo de Alertas y Gestión de Fallas[span_30](start_span)[span_30](end_span)[span_31](start_span)[span_31](end_span)
    public void reportarFalla(String componente, String descripcion) {
        System.out.println("\n[ALERTA DE SISTEMA] Falla detectada en: " + componente);
        System.out.println("   Detalle: " + descripcion);
        System.out.println("   [NOTIFICACIÓN] Enviando alerta automática al equipo de mantenimiento...");
        
        // Protocolo de emergencia: Detener en piso más cercano y abrir puertas[span_32](start_span)[span_32](end_span)[span_33](start_span)[span_33](end_span)
        System.out.println("   [PROTOCOLO DE SEGURIDAD] Deteniendo ascensor en Piso " + ascensor.getPisoActual() + " por seguridad.");
        ascensor.getPuerta().abrir();
    }

    // Registro de desempeño del ascensor[span_34](start_span)[span_34](end_span)
    public void mostrarReporteMantenimiento() {
        long tiempoSegundos = (System.currentTimeMillis() - tiempoInicioFuncionamiento) / 1000;
        System.out.println("\n=== REPORTE DE DESEMPEÑO Y MANTENIMIENTO ===");
        System.out.println("Tiempo activo del sistema: " + tiempoSegundos + " segundos.");
        System.out.println("Estado actual del ascensor: " + ascensor.getDireccion());
        System.out.println("Piso actual: " + ascensor.getPisoActual());
    }

    public Ascensor getAscensor() { return ascensor; }
}