package modelo;

public class Persona {

    private Integer dni;
    private String nombreYApellido;
    private String domicilio;
    private String telefono;

    public Persona() {
    }

    public Persona(Integer dni, String nombreYApellido, String domicilio, String telefono) {
        this.dni = dni;
        this.nombreYApellido = nombreYApellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
