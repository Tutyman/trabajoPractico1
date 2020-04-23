package controlador;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorGestionarLlamada {

    static vista.VentanaRegistrar vreg = controlador.ControladorGrafica.getVreg();

    //El metodo Iniciar() hace visible la ventana para registrar
    public static void Iniciar() {
        vreg.setVisible(true);
        vreg.setLocationRelativeTo(null);
        CargarSintomas();
    }

    //El metodo Registrar() captura los datos y los añade a la memoria
    public static void Registrar() throws ParseException {
        JOptionPane op1 = new JOptionPane();
        if (VerificarCampo() == false) {
            String fecha = ObtenerFecha();
            String hora = ObtenerHora();
            int dni = Integer.parseInt(vreg.getTxtDNI().getText());
            String nombre = vreg.getTxtNombre().getText();
            String apellido = vreg.getTxtApellido().getText();
            String domicilio = vreg.getTxtDomicilio().getText();
            String telefono = vreg.getTxtTelefono().getText();

            modelo.Llamada llam = new modelo.Llamada(fecha, hora);
            modelo.Persona per = new modelo.Persona(dni, nombre, apellido, domicilio, telefono);
            String ca = controlador.ControladorGestionRecursos.Cantidad();
            modelo.Nivel niv = controlador.ControladorGestionRecursos.clasificarNivel(CargarSeleccionados());
            
            if (controlador.ControladorGestionRecursos.VerificarRecurso(niv.getNiv(), ObtenerFecha()) == true) {
                controlador.ControladorGestionRecursos.Iniciar(niv.getNiv(), llam, per, ca);
                vreg.dispose();
            } else {
                op1.showMessageDialog(vreg, "No se posee recursos para asignar");
            }
        }
    }

    //El metodo ObtenerFecha() obtiene la fecha de hoy
    public static String ObtenerFecha() {
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String año = Integer.toString(c1.get(Calendar.YEAR));
        String fecha = (dia + "/" + mes + "/" + año);
        return fecha;
    }
    
    //El metodo ObtenerHora() obtiene la hora en este momento
    public static String ObtenerHora() {
        Calendar c1 = Calendar.getInstance();
        String hora = Integer.toString(c1.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(c1.get(Calendar.MINUTE));
        String segundo = Integer.toString(c1.get(Calendar.SECOND));
        String horahoy = (hora + ":" + minuto + ":" + segundo);
        return horahoy;
    }

    //El metodo VerificarCampo() verificar si los campos estan vacios
    public static Boolean VerificarCampo() {
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
        } else if (vreg.getTxtApellido().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Apellido");
            vreg.getTxtApellido().requestFocus();
        } else if (vreg.getTxtDomicilio().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Domicilio");
            vreg.getTxtDomicilio().requestFocus();
        } else if (vreg.getTxtTelefono().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el Telefono");
            vreg.getTxtTelefono().requestFocus();
        } else if (VerificarSeleccion() == false) {
            valor = true;
            op1.showMessageDialog(vreg, "No se seleeciono ningun sintoma");
        }
        return valor;
    }

    //El metodo Limpiar() elimina los datos ingresados en los texfield
    public static void Limpiar() {
        vreg.getTxtDNI().setText("");
        vreg.getTxtNombre().setText("");
        vreg.getTxtApellido().setText("");
        vreg.getTxtDomicilio().setText("");
        vreg.getTxtTelefono().setText("");
        CargarSintomas();
    }

    //El metodo CargarSintomas() carga todos los sintomas en la tabla 
    public static void CargarSintomas() {
        TableRowSorter<TableModel> sorter;
        int i;
        
        //Obtenemos todos los sintomas y niveles
        ArrayList<modelo.Nivel> rest = modelo.Memoria.getNivpre();
        ArrayList<modelo.Sintoma> sin = modelo.Memoria.getSinpre();
        ArrayList<modelo.Sintoma> mos = new ArrayList();
        //Eliminamos los sintomas que no poseen nivel, en este caso los que poseen valor 0
        for (i = 0; i < rest.size(); i++) {
            if (!rest.get(i).getNiv().equals("0")) {
                mos.add(sin.get(i));
            }
        }
        
        //Cargamos el modelo a la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            //Sobreescribimos el metodo isCellEditable para que la primera columna sea editable
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return true;
                }
                return false;
            }
            
            //Sobreescribimos el metodo getColumnClass para que el primer valor
            //sea del tipo booleano y de ese modo que inserte un jcheckbox
            //y pueda ser seleccionable
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

        modelo.addColumn("Seleccionar");
        modelo.addColumn("Sintomas");

        for (i = 0; i < mos.size(); i++) {

            Object[] fila
                    = {
                        false,
                        mos.get(i).getDescripcion()
                    };

            modelo.addRow(fila);
        }
        vreg.getTbSintomas().setModel(modelo);

        sorter = new TableRowSorter<TableModel>(modelo);
        vreg.getTbSintomas().setRowSorter(sorter);
    }

    //El metodo CargarSeleccionados() nos devuelve una lista de todos los sintomas
    //que fueron seleccionados
    public static ArrayList<modelo.Nivel> CargarSeleccionados() {
        ArrayList<modelo.Nivel> niv = new ArrayList();
        ArrayList<modelo.Nivel> val1 = modelo.Memoria.getNivpre();
        ArrayList<modelo.Sintoma> sin = modelo.Memoria.getSinpre();
        int i;
        int j;

        //Recorremos la tabla y verificamos que la primera columna sea verdadera
        for (i = 0; i < vreg.getTbSintomas().getRowCount(); i++) {
            for (j = 0; j < val1.size(); j++) {
                if ((Boolean) vreg.getTbSintomas().getValueAt(i, 0) == true 
                        & sin.get(j).getDescripcion().equals((String) vreg.getTbSintomas().getValueAt(i, 1))) {
                    niv.add(val1.get(j));
                }
            }

        }

        return niv;
    }

    //El metodo VerificarSeleccion() nos indica si ningun sintoma fue seleccionado
    public static Boolean VerificarSeleccion() {
        Boolean valor = false;
        int i;
        int aux = 0;

        for (i = 0; i < vreg.getTbSintomas().getRowCount(); i++) {
            if ((Boolean) vreg.getTbSintomas().getValueAt(i, 0) == false & aux == 0) {
                valor = false;
            } else {
                valor = true;
                aux = aux + 1;
            }
        }
        return valor;
    }
    
    //El metodo agregarSintoma() captura los datos del sintoma y los agrega a memoria
    public static void AgregarSintoma() {
        if (VerificarSintoma() == false) {
            modelo.Nivel ns = new modelo.Nivel(vreg.getBoxNivel().getSelectedItem().toString());
            modelo.Sintoma si = new modelo.Sintoma(vreg.getTxtSintoma().getText());
            modelo.Memoria.AgregarNivelCarga(ns);
            modelo.Memoria.AgregarSintomaCarga(si);
            CargarSintomas();
        }

    }
    
    //El metodo VerificarSintoma() verifica si el campo esta vacio
    public static Boolean VerificarSintoma(){
        Boolean valor = false;
        JOptionPane op1 = new JOptionPane();
        if(vreg.getTxtSintoma().getText().isEmpty()){
            valor = true;
            op1.showMessageDialog(vreg, "Debe ingresar el sintoma");
            vreg.getTxtSintoma().requestFocus();
        }else {
            valor = false;
        }
        return valor;
    }
    
}
