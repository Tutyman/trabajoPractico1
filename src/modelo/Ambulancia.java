package modelo;

public class Ambulancia extends Recurso{

    private String numero;

    public Ambulancia() {
    }

    public Ambulancia(String numero) {
        this.numero = numero;
        super.estado = Estado.ACTIVO;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
