package controlador;

public class ControladorNivel {
    
    static vista.VentanaRegistrar vreg = controlador.ControladorGrafica.getVreg();
    
    public static String clasificarNivel(){
        String nivel = "";
        Boolean nivel1 = false;
        Boolean nivel2 = false;
        if(vreg.getBoxTos().isSelected() == true | vreg.getBoxDolorMuscular().isSelected() == true | vreg.getBoxDolorGarganta().isSelected() == true | vreg.getBoxFatiga().isSelected() == true){
            nivel = "1";
            nivel1 = true;
        }
        if(nivel1 == true & (vreg.getBoxFiebre().isSelected() == true | vreg.getBoxNauseas().isSelected() == true | vreg.getBoxDolorCabeza().isSelected() == true | vreg.getBoxEscalofrios().isSelected() == true) | vreg.getBoxFiebre().isSelected() == true | vreg.getBoxNauseas().isSelected() == true | vreg.getBoxDolorCabeza().isSelected() == true | vreg.getBoxEscalofrios().isSelected() == true){
            nivel = "2";
            nivel2 = true;
        }
        if(nivel2 == true & vreg.getBoxDificultadRespirar().isSelected() == true | vreg.getBoxDificultadRespirar().isSelected() == true){
            nivel = "3";
        }
        
        return nivel;
    }
}
