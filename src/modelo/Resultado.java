package modelo;

public class Resultado {

    private String fechahora;
    private String dni;
    private String nombre;
    private String telefono;
    private String nivel;
    private String cantidad;
    private String recurso;

    public Resultado() {
    }

    public Resultado(String fechahora, String dni, String nombre, String telefono, String nivel, String cantidad, String recurso) {
        this.fechahora = fechahora;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nivel = nivel;
        this.cantidad = cantidad;
        this.recurso = recurso;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
