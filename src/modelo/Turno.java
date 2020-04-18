package modelo;

public class Turno {

    private String fecha;
    private String hora;
    private String telefono;

    public Turno() {
    }

    public Turno(String fecha, String hora, String telefono) {
        this.fecha = fecha;
        this.hora = hora;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
