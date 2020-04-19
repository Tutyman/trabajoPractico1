package modelo;

import java.util.ArrayList;

public class Memoria {
    static ArrayList<modelo.Turno> turn = new ArrayList();
    static ArrayList<modelo.Medico> med = new ArrayList();
    static ArrayList<modelo.Ambulancia> amb = new ArrayList();
    static ArrayList<modelo.Resultado> result = new ArrayList();
    static ArrayList<modelo.Nivel> niv = new ArrayList();
    
    public static void AgregarTurno(modelo.Turno val){
        if(!turn.contains(val)){
            turn.add(val);
        }
    }
    
    public static void AgregarNivelS(modelo.Nivel val){
        niv.add(val);
    }
    
    public static void AgregarMedico(modelo.Medico val){
        if(!med.contains(val)){
            med.add(val);
        }
    }
    
    public static void AgregarAmbulancia(modelo.Ambulancia val){
        if(!amb.contains(val)){
            amb.add(val);
        }
    }
  
    public static void EliminarTurno(modelo.Turno val) {
        for (int i = 0; i < turn.size(); i++) {
            if (turn.get(i).getFecha().equals(val.getFecha()) & turn.get(i).getHora().equals(val.getHora())) {
                turn.remove(i);
            }
        }

    }

    public static void EliminarMedico(modelo.Medico val) {
        for (int i = 0; i < med.size(); i++) {
            if (med.get(i).getNombre().equals(val.getNombre()) & med.get(i).getInterno().equals(val.getInterno())) {
                med.remove(i);
            }
        }

    }

    public static void EliminarAmbulancia(modelo.Ambulancia val) {
        for (int i = 0; i < amb.size(); i++) {
            if (amb.get(i).getNumero().equals(val.getNumero())) {
                amb.remove(i);
            }
        }

    }
    public static void AgregarResultadoTur(modelo.Llamada llam, modelo.Persona per, String niv, String cant, modelo.Turno tur){
            modelo.Resultado res = new modelo.Resultado(llam.getFecha() +" "+llam.getHora(), Integer.toString(per.getDni()), per.getNombre() + "" + per.getApellido(), per.getTelefono(), niv, cant, "Turno: "+ tur.getFecha()+ " " + tur.getHora());
        if(!result.contains(res)){
            result.add(res);
        }
        
    }
    public static void AgregarResultadoMed(modelo.Llamada llam, modelo.Persona per, String niv, String cant, modelo.Medico med){
            modelo.Resultado res = new modelo.Resultado(llam.getFecha() +" "+llam.getHora(), Integer.toString(per.getDni()), per.getNombre() + "  " + per.getApellido(), per.getTelefono(), niv, cant, "Medico: " + med.getNombre());
        if(!result.contains(res)){
            result.add(res);
        }
        
    }
    public static void AgregarResultadoAmb(modelo.Llamada llam, modelo.Persona per, String niv, String cant, modelo.Ambulancia amb){
            modelo.Resultado res = new modelo.Resultado(llam.getFecha() +" "+llam.getHora(), Integer.toString(per.getDni()), per.getNombre() + " " + per.getApellido(), per.getTelefono(), niv, cant, "Numero de Ambulancia: " + amb.getNumero());
        if(!result.contains(res)){
            result.add(res);
        }
        
    }

    public static ArrayList<Turno> getTurn() {
        return turn;
    }

    public static void setTurn(ArrayList<Turno> turn) {
        Memoria.turn = turn;
    }

    public static ArrayList<Medico> getMed() {
        return med;
    }

    public static void setMed(ArrayList<Medico> med) {
        Memoria.med = med;
    }

    public static ArrayList<Ambulancia> getAmb() {
        return amb;
    }

    public static void setAmb(ArrayList<Ambulancia> amb) {
        Memoria.amb = amb;
    }

    public static ArrayList<Resultado> getResult() {
        return result;
    }

    public static void setResult(ArrayList<Resultado> result) {
        Memoria.result = result;
    }

    public static ArrayList<Nivel> getNiv() {
        return niv;
    }

    public static void setNiv(ArrayList<Nivel> niv) {
        Memoria.niv = niv;
    }

    
}
