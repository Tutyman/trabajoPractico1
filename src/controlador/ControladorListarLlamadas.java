package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorListarLlamadas {

    static vista.VentanaLista vlis = controlador.ControladorGrafica.getVlis();

    public static void Iniciar() {
        vlis.setVisible(true);
        vlis.setLocationRelativeTo(null);
        MostrarLista();
    }
    
    public static void MostrarLista() {
        TableRowSorter<TableModel> sorter; //Necesaria para el filtrado de la tabla
        int i;
        
        ArrayList<modelo.Resultado> rest = modelo.Memoria.getResult();

        //Se crea un modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        //Se definen las columnas del modelo de tabla
        modelo.addColumn("Fecha y hora");  //Columna 0
        modelo.addColumn("DNI");//Columna 1
        modelo.addColumn("Nombre");//Columna 1
        modelo.addColumn("Telefono");//Columna 1
        modelo.addColumn("Nivel");//Columna 1
        modelo.addColumn("Cantidad");//Columna 1
        modelo.addColumn("Recursos");//Columna 1

        for (i = 0; i < rest.size(); i++) {  //Con 'cli' se recorre la lista 'Cliente'
            Object[] fila //Se crea un objeto 'fila' que almacena cada elemento de la lista
                    = {
                        rest.get(i).getFechahora(),
                        rest.get(i).getDni(),
                        rest.get(i).getNombre(),
                        rest.get(i).getTelefono(),
                        rest.get(i).getNivel(),
                        rest.get(i).getCantidad(),
                        rest.get(i).getRecurso()
                    };
            //Se añade el objeto creado al modelo
            modelo.addRow(fila);
        }

        //Se pasa el modelo a la tabla para que muestre los datos
        vlis.getTbLista().setModel(modelo);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(modelo);
        vlis.getTbLista().setRowSorter(sorter);
    }
}
