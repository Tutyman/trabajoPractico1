package modelo;

public class Llamada {

    private String fecha;
    private String hora;

    public Llamada() {
    }

    public Llamada(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
