package modelo;

public class Medico extends Recurso{

    private String nombre;
    private String interno;

    public Medico() {
    }

    public Medico(String nombre, String interno) {
        this.nombre = nombre;
        this.interno = interno;
        super.estado = Estado.ACTIVO;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
