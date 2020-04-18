package controlador;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorAsignar {
    static vista.VentanaAsignar vasig = controlador.ControladorGrafica.getVasg();
    static String niv = "";
    static modelo.Llamada llam = new modelo.Llamada();
    static modelo.Persona per = new modelo.Persona();
    static String can;
    
    public static void Iniciar(String nivel, modelo.Llamada la, modelo.Persona pe, String canti){
        vasig.setVisible(true);
        vasig.setLocationRelativeTo(null);
        vasig.getLbNivel().setText("La persona se encuentrar en el nivel de gravedad N°"+nivel);
        if (nivel.equals("1")){
            MostrarTurno();
        }
        if (nivel.equals("2")){
            MostrarMedicos();
        }
        if (nivel.equals("3")){
            MostrarAmbulancias();
        }
        niv = nivel;
        llam = la;
        per = pe;
        can = canti;
    }
    
    public static Boolean VerificarRecurso(String nivel) {
        Boolean valor = false;

        switch (nivel) {
            case "1":
                int tr = controlador.ControladorMemoria.getTurn().size();
                if (tr != 0) {
                    valor = true;
                }
                break;
            case "2":
                int med = controlador.ControladorMemoria.getMed().size();
                if (med != 0) {
                    valor = true;
                }
                break;
            case "3":
                int amb = controlador.ControladorMemoria.getAmb().size();
                if (amb != 0) {
                    valor = true;
                }
                break;
        }

        return valor;
    }
    
    public static void RegistrarTurno(modelo.Turno tur){
        controlador.ControladorMemoria.AgregarResultadoTur(llam, per, niv, can, tur);
        controlador.ControladorMemoria.EliminarTurno(tur);
        vasig.dispose();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void RegistrarMedico(modelo.Medico med){
        controlador.ControladorMemoria.AgregarResultadoMed(llam, per, niv, can, med);
        controlador.ControladorMemoria.EliminarMedico(med);
        vasig.dispose();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void RegistrarAmbulancia(modelo.Ambulancia amb){
        controlador.ControladorMemoria.AgregarResultadoAmb(llam, per, niv, can, amb);
        controlador.ControladorMemoria.EliminarAmbulancia(amb);
        vasig.dispose();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void MostrarTurno() {
        TableRowSorter<TableModel> sorter; //Necesaria para el filtrado de la tabla
        int i;
        
        ArrayList<modelo.Turno> tur = controlador.ControladorMemoria.getTurn();

        //Se crea un modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //Se definen las columnas del modelo de tabla
        modelo.addColumn("Fecha");  //Columna 0
        modelo.addColumn("Hora");//Columna 1
        modelo.addColumn("Telefono");//Columna 1

        for (i = 0; i < tur.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
            Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                    = {
                        tur.get(i).getFecha(),
                        tur.get(i).getHora(),
                        tur.get(i).getTelefono(),
                    };
            //Se añade el objeto creado al modelo
            modelo.addRow(fila);
        }

        //Se pasa el modelo a la tabla para que muestre los datos
        vasig.getTbAsiganar().setModel(modelo);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(modelo);
        vasig.getTbAsiganar().setRowSorter(sorter);
    }
    
    public static void MostrarMedicos() {
        TableRowSorter<TableModel> sorter; //Necesaria para el filtrado de la tabla
        int i;
        
        ArrayList<modelo.Medico> med = controlador.ControladorMemoria.getMed();

        //Se crea un modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //Se definen las columnas del modelo de tabla
        modelo.addColumn("Nombre");  //Columna 0
        modelo.addColumn("Interno");//Columna 1

        for (i = 0; i < med.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
            Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                    = {
                        med.get(i).getNombre(),
                        med.get(i).getInterno(),
                    };
            //Se añade el objeto creado al modelo
            modelo.addRow(fila);
        }

        //Se pasa el modelo a la tabla para que muestre los datos
        vasig.getTbAsiganar().setModel(modelo);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(modelo);
        vasig.getTbAsiganar().setRowSorter(sorter);
    }
    
    public static void MostrarAmbulancias() {
        TableRowSorter<TableModel> sorter; //Necesaria para el filtrado de la tabla
        int i;
        
        ArrayList<modelo.Ambulancia> amb = controlador.ControladorMemoria.getAmb();

        //Se crea un modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //Se definen las columnas del modelo de tabla
        modelo.addColumn("Numero de Aambulancia");  //Columna 0

        for (i = 0; i < amb.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
            Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                    = {
                        amb.get(i).getNumero(),
                    };
            //Se añade el objeto creado al modelo
            modelo.addRow(fila);
        }

        //Se pasa el modelo a la tabla para que muestre los datos
        vasig.getTbAsiganar().setModel(modelo);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(modelo);
        vasig.getTbAsiganar().setRowSorter(sorter);
    }
    
    public static void AsignarRecurso(String nivel) {

        // CUANDO HACE CLIK SOBRE UNA FILA DE LA TABLA 
        int filaseleccionada;
        try {
            filaseleccionada = vasig.getTbAsiganar().getSelectedRow();

            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

            } else {
                DefaultTableModel modelotabla = (DefaultTableModel) vasig.getTbAsiganar().getModel();
                int resp;
                switch(nivel){
                    case "1":
                String fecha = (String) modelotabla.getValueAt(filaseleccionada, 0);
                String hora = (String) modelotabla.getValueAt(filaseleccionada, 1);
                String telefono = (String) modelotabla.getValueAt(filaseleccionada, 2);
                resp = JOptionPane.showConfirmDialog(null, "Desea asignar el siguiente recurso: \nFecha:'" + fecha + "',\nhora:'" + hora + "',\ntelefono:'" + telefono + "'?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    modelo.Turno tur = new modelo.Turno(fecha, hora, telefono);
                    RegistrarTurno(tur);
                    
                }
                        break;
                    case "2":
                String nombre = (String) modelotabla.getValueAt(filaseleccionada, 0);
                String interno = (String) modelotabla.getValueAt(filaseleccionada, 1);
                resp = JOptionPane.showConfirmDialog(null, "Desea asignar el siguiente recurso: \nNombre:'" + nombre + "',\ninterno:'" + interno + "?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    modelo.Medico med = new modelo.Medico(nombre, interno);
                    RegistrarMedico(med);
                }
                        break;
                    case "3":
                        String numero = (String) modelotabla.getValueAt(filaseleccionada, 0);
                        resp = JOptionPane.showConfirmDialog(null, "Desea asignar el siguiente recurso: \nNumero de ambulancia:'" + numero + "?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    modelo.Ambulancia amb = new modelo.Ambulancia(numero);
                    RegistrarAmbulancia(amb);
                }
                        break;
                }
            }

        } catch (HeadlessException ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static String getNiv() {
        return niv;
    }

    public static void setNiv(String niv) {
        ControladorAsignar.niv = niv;
    }
}
