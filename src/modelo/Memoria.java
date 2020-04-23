package modelo;

import java.util.ArrayList;

public class Memoria {
    static ArrayList<modelo.Llamada> llam = new ArrayList();
    static ArrayList<modelo.Persona> per = new ArrayList();
    static ArrayList<modelo.Nivel> niv = new ArrayList();
    static ArrayList<modelo.Nivel> nivpre = new ArrayList();
    static ArrayList<modelo.Sintoma> sin = new ArrayList();
    static ArrayList<modelo.Sintoma> sinpre = new ArrayList();
    static ArrayList<String> cansin = new ArrayList();
    static ArrayList<String> recurso = new ArrayList();
    static ArrayList<modelo.Turno> turpre = new ArrayList();
    static ArrayList<modelo.Medico> medpre = new ArrayList();
    static ArrayList<modelo.Ambulancia> ambpre =  new ArrayList();
    
    public static void AgregarLlamada(modelo.Llamada valor){
        llam.add(valor);
    }
    
    public static void AgregarPersona(modelo.Persona valor){
        per.add(valor);
    }
    
    public static void AgregarNivel(modelo.Nivel valor){
        niv.add(valor);
    }
    
    public static void AgregarNivelCarga(modelo.Nivel valor){
        nivpre.add(valor);
    }
    
    public static void AgregarSintomaCarga(modelo.Sintoma valor){
        sinpre.add(valor);
    }
    
    public static void AgregarSintoma(modelo.Sintoma valor){
        sin.add(valor);
    }
    
    public static void AgregarSintomaCantidad(String valor){
        cansin.add(valor);
    }
    
    public static void AgregarRecurso(String valor){
        recurso.add(valor);
    }
    
    public static void AgregarTurnoCarga(modelo.Turno valor){
        turpre.add(valor);
    }
    
    public static void AgregarMedicoCarga(modelo.Medico valor){
        medpre.add(valor);
    }
    
    public static void AgregarAmbulanciaCarga(modelo.Ambulancia valor){
        ambpre.add(valor);
    }
    
    public static void EstadoTurno(modelo.Turno valor){
        for (int i = 0; i < turpre.size(); i++) {
            if (turpre.get(i).getFecha().equals(valor.getFecha()) & turpre.get(i).getHora().equals(valor.getHora())) {
                turpre.get(i).estado = Estado.ASIGNADO;
            }
        }
    }
    
    public static void EstadoMedico(modelo.Medico valor){
        for (int i = 0; i < medpre.size(); i++) {
            if (medpre.get(i).getNombre().equals(valor.getNombre()) & medpre.get(i).getInterno().equals(valor.getInterno())) {
                medpre.get(i).estado = Estado.ASIGNADO;
            }
        }
    }
    
    public static void EstadoAmbulancia(modelo.Ambulancia valor){
        for (int i = 0; i < ambpre.size(); i++) {
            if (ambpre.get(i).getNumero().equals(valor.getNumero())) {
                ambpre.get(i).estado = Estado.ASIGNADO;
            }
        }
    }

    public static ArrayList<Llamada> getLlam() {
        return llam;
    }

    public static ArrayList<Persona> getPer() {
        return per;
    }

    public static ArrayList<Nivel> getNiv() {
        return niv;
    }

    public static ArrayList<Nivel> getNivpre() {
        return nivpre;
    }

    public static ArrayList<Sintoma> getSin() {
        return sin;
    }

    public static ArrayList<String> getCansin() {
        return cansin;
    }

    public static ArrayList<Turno> getTurpre() {
        return turpre;
    }

    public static ArrayList<Medico> getMedpre() {
        return medpre;
    }

    public static ArrayList<Ambulancia> getAmbpre() {
        return ambpre;
    }

    public static ArrayList<String> getRecurso() {
        return recurso;
    }

    public static ArrayList<Sintoma> getSinpre() {
        return sinpre;
    }

}
