public class Piso {
    private int numeroPiso;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        this.botonSubir = new Boton("SUBIDA");
        this.botonBajar = new Boton("BAJADA");
    }

    public int getNumeroPiso() { return numeroPiso; }
    public Boton getBotonSubir() { return botonSubir; }
    public Boton getBotonBajar() { return botonBajar; }
}