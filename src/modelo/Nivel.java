package modelo;

public class Nivel {

    private String niv;
    private String sintoma;

    public Nivel(String niv) {
        this.niv = niv;
    }

    public Nivel(String niv, String sintoma) {
        this.niv = niv;
        this.sintoma = sintoma;
    }

    public String getNiv() {
        return niv;
    }

    public void setNiv(String niv) {
        this.niv = niv;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    
}
