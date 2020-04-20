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
    static vista.VentanaRegistrar2 vreg2 = new vista.VentanaRegistrar2();

    public static void Iniciar() {
        vreg.setVisible(true);
        vreg.setLocationRelativeTo(null);
    }
    
    public static void Iniciar2() {
        vreg2.setVisible(true);
        vreg2.setLocationRelativeTo(null);
        CargarSintomas();
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
    
    public static void CargarSintomas(){
        TableRowSorter<TableModel> sorter; 
        int i;

        ArrayList<modelo.Nivel> rest = modelo.Memoria.getNiv();
        ArrayList<modelo.Nivel> mos = new ArrayList();
        for (i = 0; i < rest.size(); i++) {
            if (!rest.get(i).getNiv().equals("0")) {
                mos.add(rest.get(i));
            }
        }
        
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                return true;
                return false;
            }
            @Override
            public Class getColumnClass(int columna) {
                if (columna == 0) {
                    return Boolean.class;
                }
                if (columna == 1) {
                    return String.class;
                }
                return Object.class;
            }
            
        };

        Class[] types = new Class[]{
            java.lang.Boolean.class, java.lang.Object.class
        };
        
        modelo.addColumn("Seleccionar");
        modelo.addColumn("Sintomas");
        Boolean valor = false;
        
        for (i = 0; i < mos.size(); i++) {  
            
            Object[] fila 
                    = {
                        valor,
                        mos.get(i).getSintoma()
                    };
            
            modelo.addRow(fila);
        }
        vreg2.getTbSintomas().setModel(modelo);

        sorter = new TableRowSorter<TableModel>(modelo);
        vreg2.getTbSintomas().setRowSorter(sorter);
    }
    
}
