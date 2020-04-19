package controlador;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorGestionRecursos {

    static vista.VentanaRegistrar vreg = controlador.ControladorGrafica.getVreg();
    static vista.VentanaAsignar vasig = controlador.ControladorGrafica.getVasg();
    static String niv = "";
    static modelo.Llamada llam = new modelo.Llamada();
    static modelo.Persona per = new modelo.Persona();
    static String can;

    public static String clasificarNivel() {

        String nivel = "";
        Boolean nivel1 = false;
        Boolean nivel2 = false;
        if (vreg.getBoxTos().isSelected() == true | vreg.getBoxDolorMuscular().isSelected() == true | vreg.getBoxDolorGarganta().isSelected() == true | vreg.getBoxFatiga().isSelected() == true) {
            nivel = "1";
            nivel1 = true;
        }
        if (nivel1 == true & (vreg.getBoxFiebre().isSelected() == true | vreg.getBoxNauseas().isSelected() == true | vreg.getBoxDolorCabeza().isSelected() == true | vreg.getBoxEscalofrios().isSelected() == true) | vreg.getBoxFiebre().isSelected() == true | vreg.getBoxNauseas().isSelected() == true | vreg.getBoxDolorCabeza().isSelected() == true | vreg.getBoxEscalofrios().isSelected() == true) {
            nivel = "2";
            nivel2 = true;
        }
        if (nivel2 == true & vreg.getBoxDificultadRespirar().isSelected() == true | vreg.getBoxDificultadRespirar().isSelected() == true) {
            nivel = "3";
        }

        return nivel;
    }

    public static String Cantidad() {
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

    public static void Iniciar(String nivel, modelo.Llamada la, modelo.Persona pe, String canti){
        vasig.setVisible(true);
        vasig.setLocationRelativeTo(null);
        vasig.getLbNivel().setText("La persona se encuentrar en el nivel de gravedad N°"+nivel);
        CargarRecursos(nivel);
        niv = nivel;
        llam = la;
        per = pe;
        can = canti;
    }
    
    public static Boolean VerificarRecurso(String nivel) {
        Boolean valor = false;

        switch (nivel) {
            case "1":
                int tr = modelo.Memoria.getTurn().size();
                if (tr != 0) {
                    valor = true;
                }
                break;
            case "2":
                int med = modelo.Memoria.getMed().size();
                if (med != 0) {
                    valor = true;
                }
                break;
            case "3":
                int amb = modelo.Memoria.getAmb().size();
                if (amb != 0) {
                    valor = true;
                }
                break;
        }

        return valor;
    }
    
    public static void RegistrarTurno(modelo.Turno tur){
        modelo.Memoria.AgregarResultadoTur(llam, per, niv, can, tur);
        modelo.Memoria.EliminarTurno(tur);
        vasig.dispose();
        controlador.ControladorGestionarLlamada.Limpiar();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void RegistrarMedico(modelo.Medico med){
        modelo.Memoria.AgregarResultadoMed(llam, per, niv, can, med);
        modelo.Memoria.EliminarMedico(med);
        vasig.dispose();
        controlador.ControladorGestionarLlamada.Limpiar();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void RegistrarAmbulancia(modelo.Ambulancia amb){
        modelo.Memoria.AgregarResultadoAmb(llam, per, niv, can, amb);
        modelo.Memoria.EliminarAmbulancia(amb);
        vasig.dispose();
        controlador.ControladorGestionarLlamada.Limpiar();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void CargarRecursos(String nivel) {
        TableRowSorter<TableModel> sorter; //Necesaria para el filtrado de la tabla
        int i;

        //Se crea un modelo de la tabla
        DefaultTableModel mod = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        switch (nivel) {
            case "1":
                ArrayList<modelo.Turno> tur = modelo.Memoria.getTurn();
                mod.addColumn("Fecha");  //Columna 0
                mod.addColumn("Hora");//Columna 1
                mod.addColumn("Telefono");//Columna 1

                for (i = 0; i < tur.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
                    Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                            = {
                                tur.get(i).getFecha(),
                                tur.get(i).getHora(),
                                tur.get(i).getTelefono(),};
                    //Se añade el objeto creado al modelo
                    mod.addRow(fila);
                }
                break;
            case "2":
                ArrayList<modelo.Medico> med = modelo.Memoria.getMed();
                mod.addColumn("Nombre");  //Columna 0
                mod.addColumn("Interno");//Columna 1

                for (i = 0; i < med.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
                    Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                            = {
                                med.get(i).getNombre(),
                                med.get(i).getInterno(),};
                    //Se añade el objeto creado al modelo
                    mod.addRow(fila);
                }
                break;
            case "3":
                ArrayList<modelo.Ambulancia> amb = modelo.Memoria.getAmb();
                mod.addColumn("Numero de Aambulancia");  //Columna 0

                for (i = 0; i < amb.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
                    Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                            = {
                                amb.get(i).getNumero(),};
                    //Se añade el objeto creado al modelo
                    mod.addRow(fila);
                }
                break;
        }

        //Se definen las columnas del modelo de tabla
        //Se pasa el modelo a la tabla para que muestre los datos
        vasig.getTbAsiganar().setModel(mod);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(mod);
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
        ControladorGestionRecursos.niv = niv;
    }
}
