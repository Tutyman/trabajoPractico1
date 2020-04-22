package controlador;

import static controlador.ControladorGrafica.vreg;
import static controlador.ControladorGrafica.vasg;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Estado;
import modelo.Nivel;

public class ControladorGestionRecursos {

    static modelo.Nivel niv = new modelo.Nivel("");
    static modelo.Llamada llam = new modelo.Llamada();
    static modelo.Persona per = new modelo.Persona();
    static String can;
    
    
    public static void Iniciar(String nivel, modelo.Llamada la, modelo.Persona pe, String canti) throws ParseException{
        vasg.setVisible(true);
        vasg.setLocationRelativeTo(null);
        vasg.getLbNivel().setText("La persona se encuentrar en el nivel de gravedad N°"+nivel);
        niv.setNiv(nivel);
        llam = la;
        per = pe;
        can = canti;
        CargarRecursos(nivel);
    }

    public static modelo.Nivel clasificarNivel(ArrayList<modelo.Nivel> nive) {
        int i;
        modelo.Nivel nivel = new modelo.Nivel("");
        for (i = 0; i < nive.size(); i++) {
            if (nive.get(i).getNiv().equals("1")) {
                nivel.setNiv("1");
            }
            if (nive.get(i).getNiv().equals("1") & nive.get(i).getNiv().equals("2") | nive.get(i).getNiv().equals("2")) {
                nivel.setNiv("2");
            }
            if (nive.get(i).getNiv().equals("2") & nive.get(i).getNiv().equals("3") | nive.get(i).getNiv().equals("3")) {
                nivel.setNiv("3");
            }
        }
        return nivel;
    }

    public static String Cantidad() {
        int i;
        int aux = 0;
        String fila = "";
        for(i=0;i<vreg.getTbSintomas().getRowCount();i++){
            if((Boolean)vreg.getTbSintomas().getValueAt(i, 0) == true){
                aux++;
            }
        }
        fila = Integer.toString(aux);
        return fila;

    }

    public static Boolean VerificarRecurso(String nivel, String fecha) throws ParseException {
        Boolean valor = false;
        int i;
        int aux = 0;

        switch (nivel) {
            case "1":
                for (i=0; i<VerificarFecha(fecha, modelo.Memoria.getTurpre()).size();i++) {
                    if(VerificarFecha(fecha, modelo.Memoria.getTurpre()).get(i).estado != Estado.ACTIVO & aux == 0){
                        valor = false;
                    }else {
                        valor = true;
                        aux++;
                    }
                }
                break;
            case "2":
                for (i=0; i<modelo.Memoria.getMedpre().size();i++) {
                    if(modelo.Memoria.getMedpre().get(i).estado != Estado.ACTIVO & aux == 0){
                        valor = false;
                    }else {
                        valor = true;
                        aux++;
                    }
                }
                break;
            case "3":
                for (i=0; i<modelo.Memoria.getAmbpre().size();i++) {
                    if(modelo.Memoria.getAmbpre().get(i).estado != Estado.ACTIVO & aux == 0){
                        valor = false;
                    }else {
                        valor = true;
                        aux++;
                    }
                }
                break;
        }

        return valor;
    }
    
    public static void RegistrarTurno(modelo.Turno tur, Estado estado){
        modelo.Memoria.AgregarLlamada(llam);
        modelo.Memoria.AgregarPersona(per);
        modelo.Memoria.AgregarNivel(niv);
        modelo.Memoria.AgregarSintomaCantidad(can);
        modelo.Memoria.AgregarRecurso("Fecha: "+tur.getFecha() + ", Hora: " + tur.getHora());
        modelo.Memoria.EstadoTurno(tur);
        vasg.dispose();
        controlador.ControladorGestionarLlamada.Limpiar();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void RegistrarMedico(modelo.Medico med, Estado estado){
        modelo.Memoria.AgregarLlamada(llam);
        modelo.Memoria.AgregarPersona(per);
        modelo.Memoria.AgregarNivel(niv);
        modelo.Memoria.AgregarSintomaCantidad(can);
        modelo.Memoria.AgregarRecurso("Medico: "+med.getNombre());
        modelo.Memoria.EstadoMedico(med);
        vasg.dispose();
        controlador.ControladorGestionarLlamada.Limpiar();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void RegistrarAmbulancia(modelo.Ambulancia amb, Estado estado){
        modelo.Memoria.AgregarLlamada(llam);
        modelo.Memoria.AgregarPersona(per);
        modelo.Memoria.AgregarNivel(niv);
        modelo.Memoria.AgregarSintomaCantidad(can);
        modelo.Memoria.AgregarRecurso("Ambulancia N°: "+amb.getNumero());
        modelo.Memoria.EstadoAmbulancia(amb);
        vasg.dispose();
        controlador.ControladorGestionarLlamada.Limpiar();
        controlador.ControladorGrafica.Iniciar();
    }
    
    public static void CargarRecursos(String nivel) throws ParseException {
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
                ArrayList<modelo.Turno> tur = new ArrayList();
                for (i=0; i<VerificarFecha(llam.getFecha(), modelo.Memoria.getTurpre()).size();i++) {
                    if(VerificarFecha(llam.getFecha(), modelo.Memoria.getTurpre()).get(i).estado == Estado.ACTIVO){
                        tur.add(VerificarFecha(llam.getFecha(), modelo.Memoria.getTurpre()).get(i));
                    }
                }
                mod.addColumn("Fecha");  //Columna 0
                mod.addColumn("Hora");//Columna 1
                mod.addColumn("Telefono");//Columna 1

                for (i = 0; i < tur.size(); i++) {  //Con 'tur' se recorre la lista 'Turno'
                    Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                            = {
                                tur.get(i).getFecha(),
                                tur.get(i).getHora(),
                                tur.get(i).getTelefono()
                            };
                    //Se añade el objeto creado al modelo
                    mod.addRow(fila);
                }
                break;
            case "2":
                ArrayList<modelo.Medico> med = new ArrayList();
                for (i=0; i<modelo.Memoria.getMedpre().size();i++) {
                    if(modelo.Memoria.getMedpre().get(i).estado == Estado.ACTIVO){
                        med.add(modelo.Memoria.getMedpre().get(i));
                    }
                }
                mod.addColumn("Nombre");  //Columna 0
                mod.addColumn("Interno");//Columna 1

                for (i = 0; i < med.size(); i++) {  //Con 'med' se recorre la lista 'Medico'
                    Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                            = {
                                med.get(i).getNombre(),
                                med.get(i).getInterno(),};
                    //Se añade el objeto creado al modelo
                    mod.addRow(fila);
                }
                break;
            case "3":
                ArrayList<modelo.Ambulancia> amb = new ArrayList();
                for (i=0; i<modelo.Memoria.getAmbpre().size();i++) {
                    if(modelo.Memoria.getAmbpre().get(i).estado == Estado.ACTIVO){
                        amb.add(modelo.Memoria.getAmbpre().get(i));
                    }
                }
                mod.addColumn("Numero de Aambulancia");  //Columna 0

                for (i = 0; i < amb.size(); i++) {  //Con 'amb' se recorre la lista 'Ambulancia'
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
        vasg.getTbAsiganar().setModel(mod);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(mod);
        vasg.getTbAsiganar().setRowSorter(sorter);
    }
    
    public static void AsignarRecurso(String nivel) {

        int filaseleccionada;
        try {
            filaseleccionada = vasg.getTbAsiganar().getSelectedRow();

            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

            } else {
                DefaultTableModel modelotabla = (DefaultTableModel) vasg.getTbAsiganar().getModel();
                int resp;
                switch(nivel){
                    case "1":
                String fecha = (String) modelotabla.getValueAt(filaseleccionada, 0);
                String hora = (String) modelotabla.getValueAt(filaseleccionada, 1);
                String telefono = (String) modelotabla.getValueAt(filaseleccionada, 2);
                resp = JOptionPane.showConfirmDialog(null, "Desea asignar el siguiente recurso: \nFecha:'" + fecha + "',\nhora:'" + hora + "',\ntelefono:'" + telefono + "'?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    modelo.Turno tur = new modelo.Turno(fecha, hora, telefono);
                    tur.estado = Estado.ASIGNADO;
                    RegistrarTurno(tur, tur.estado);
                    
                }
                        break;
                    case "2":
                String nombre = (String) modelotabla.getValueAt(filaseleccionada, 0);
                String interno = (String) modelotabla.getValueAt(filaseleccionada, 1);
                resp = JOptionPane.showConfirmDialog(null, "Desea asignar el siguiente recurso: \nNombre:'" + nombre + "',\ninterno:'" + interno + "?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    modelo.Medico med = new modelo.Medico(nombre, interno);
                    med.estado = Estado.ASIGNADO;
                    RegistrarMedico(med, med.estado);
                }
                        break;
                    case "3":
                        String numero = (String) modelotabla.getValueAt(filaseleccionada, 0);
                        resp = JOptionPane.showConfirmDialog(null, "Desea asignar el siguiente recurso: \nNumero de ambulancia:'" + numero + "?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {
                    modelo.Ambulancia amb = new modelo.Ambulancia(numero);
                    amb.estado = Estado.ASIGNADO;
                    RegistrarAmbulancia(amb, amb.estado);
                }
                        break;
                }
            }

        } catch (HeadlessException ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public static ArrayList<modelo.Turno> VerificarFecha(String fecha, ArrayList<modelo.Turno> tur) throws ParseException{
        ArrayList<modelo.Turno> res = new ArrayList();
        int i;
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cal.setTime(sdf.parse(fecha));
        for (i = 0; i<tur.size() ; i++){
            cal2.setTime(sdf.parse(tur.get(i).getFecha()));
            if(cal2.getTime().getDate()> cal.getTime().getDate() & (cal2.getTime().getMonth()+1) >= (cal.getTime().getMonth()+1) & (cal2.getTime().getYear()+1900) == (cal.getTime().getYear()+1900)){
                res.add(tur.get(i));
            }
        }
        return res;
    }

    public static Nivel getNiv() {
        return niv;
    }

    public static void setNiv(Nivel niv) {
        ControladorGestionRecursos.niv = niv;
    }
}
