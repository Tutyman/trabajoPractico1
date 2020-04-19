package controlador;

import java.awt.Component;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorGestionarLlamada {

    static vista.VentanaRegistrar vreg = controlador.ControladorGrafica.getVreg();

    public static void Iniciar() {
        vreg.setVisible(true);
        vreg.setLocationRelativeTo(null);
    }

    public static void Registrar() throws ParseException {
        Boolean valor = VerificarCampo();
        JOptionPane op1 = new JOptionPane();
        if (valor == false) {
            String fecha = SacarFecha();
            String hora = SacarHora();
            int dni = Integer.parseInt(vreg.getTxtDNI().getText());
            String nombre = vreg.getTxtNombre().getText();
            String apellido = vreg.getTxtApellido().getText();
            String domicilio = vreg.getTxtDomicilio().getText();
            String telefono = vreg.getTxtTelefono().getText();

            modelo.Llamada llam = new modelo.Llamada(fecha, hora);
            modelo.Persona per = new modelo.Persona(dni, nombre, apellido, domicilio, telefono);
            String ca = controlador.ControladorGestionRecursos.Cantidad();
            String niv = controlador.ControladorGestionRecursos.clasificarNivel();
            if (controlador.ControladorGestionRecursos.VerificarRecurso(niv, SacarFecha()) == true) {
                controlador.ControladorGestionRecursos.Iniciar(niv, llam, per, ca);
                vreg.dispose();
            } else {
                op1.showMessageDialog(vreg, "No se posee recursos para asignar");
            }
        }
    }

    public static String SacarFecha() {
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String año = Integer.toString(c1.get(Calendar.YEAR));
        String fecha = (dia + "/" + mes + "/" + año);
        return fecha;
    }
    
    public static String SacarHora(){
        Calendar c1 = Calendar.getInstance();
        String hora = Integer.toString(c1.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(c1.get(Calendar.MINUTE));
        String segundo = Integer.toString(c1.get(Calendar.SECOND));
        String horahoy = (hora + ":" + minuto + ":" + segundo);
        return horahoy;
    }
    
    public static Boolean VerificarCampo(){
        Boolean valor = false;
        JOptionPane op1 = new JOptionPane();
        if (vreg.getTxtDNI().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el DNI");
            vreg.getTxtDNI().requestFocus();
        } else if (vreg.getTxtNombre().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Nombre");
            vreg.getTxtNombre().requestFocus();
        }else if (vreg.getTxtApellido().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Apellido");
            vreg.getTxtApellido().requestFocus();
        } else if (vreg.getTxtDomicilio().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Domicilio");
            vreg.getTxtDomicilio().requestFocus();
        }else if (vreg.getTxtTelefono().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Telefono");
            vreg.getTxtTelefono().requestFocus();
        }else if(vreg.getBoxTos().isSelected() == false & vreg.getBoxDolorMuscular().isSelected() == false & vreg.getBoxDolorGarganta().isSelected() == false & vreg.getBoxFatiga().isSelected() == false & vreg.getBoxFiebre().isSelected() == false & vreg.getBoxNauseas().isSelected() == false & vreg.getBoxDolorCabeza().isSelected() == false & vreg.getBoxEscalofrios().isSelected() == false & vreg.getBoxDificultadRespirar().isSelected() == false){
            valor = true;
            op1.showMessageDialog(vreg, "No se seleeciono ningun sintoma");
        }
        return valor;
    }
    
    public static void Limpiar(){
        vreg.getTxtDNI().setText("");
        vreg.getTxtNombre().setText("");
        vreg.getTxtApellido().setText("");
        vreg.getTxtDomicilio().setText("");
        vreg.getTxtTelefono().setText("");
        vreg.getBoxTos().setSelected(false);
        vreg.getBoxNauseas().setSelected(false);
        vreg.getBoxFiebre().setSelected(false);
        vreg.getBoxFatiga().setSelected(false);
        vreg.getBoxEscalofrios().setSelected(false);
        vreg.getBoxDolorMuscular().setSelected(false);
        vreg.getBoxDolorGarganta().setSelected(false);
        vreg.getBoxDolorCabeza().setSelected(false);
        vreg.getBoxDificultadRespirar().setSelected(false);
    }
    
}
