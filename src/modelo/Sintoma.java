package modelo;

public class Sintoma extends Nivel{

    private String descripcion;

    public Sintoma() {
    }

    public Sintoma(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sintoma(String descripcion, String niv) {
        super(niv);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
