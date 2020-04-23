package controlador;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorListarLlamadas {
    
    static vista.VentanaLista vlis = controlador.ControladorGrafica.getVlis();

    //El metodo Iniciar() hace visible la ventana para listar las llamadas registradas
    public static void Iniciar() {
        vlis.setVisible(true);
        vlis.setLocationRelativeTo(null);
        MostrarLista();
    }
    
    //El metodo MostrarLista() carga los datos registrados de las llamadas
    public static void MostrarLista() {
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

        mod.addColumn("Fecha y hora");
        mod.addColumn("DNI");
        mod.addColumn("Nombre");
        mod.addColumn("Telefono");
        mod.addColumn("Nivel");
        mod.addColumn("Cantidad");
        mod.addColumn("Recursos");
        
        //Recogemos los arraylist para crear un objeto y agregarlos al JTable
        for (i = 0; i < modelo.Memoria.getLlam().size(); i++) {
            Object[] fila 
                    = {
                        modelo.Memoria.getLlam().get(i).getFecha() + " " + modelo.Memoria.getLlam().get(i).getHora(),
                        modelo.Memoria.getPer().get(i).getDni(),
                        modelo.Memoria.getPer().get(i).getNombre(),
                        modelo.Memoria.getPer().get(i).getTelefono(),
                        modelo.Memoria.getNiv().get(i).getNiv(),
                        modelo.Memoria.getCansin().get(i),
                        modelo.Memoria.getRecurso().get(i),
                    };
            mod.addRow(fila);
        }

        //Se pasa el modelo a la tabla para que muestre los datos
        vlis.getTbLista().setModel(mod);

        // Para filtrar la tabla
        sorter = new TableRowSorter<TableModel>(mod);
        vlis.getTbLista().setRowSorter(sorter);
    }
}
