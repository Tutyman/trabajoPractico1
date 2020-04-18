package controlador;

public class ControladorCantidadSintoma {
    
    static vista.VentanaRegistrar vreg = controlador.ControladorGrafica.getVreg();
    
    public static String Cantidad(){
        int cant = 0;
        String res = "";
        if (vreg.getBoxTos().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxNauseas().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxFiebre().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxFatiga().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxEscalofrios().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxDolorMuscular().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxDolorGarganta().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxDolorCabeza().isSelected() == true) {
            cant = cant + 1;
        }
        if (vreg.getBoxDificultadRespirar().isSelected() == true) {
            cant = cant + 1;
        }
        res = Integer.toString(cant);
        return res;
        
    }
    
}
