package controlador;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class ControladorPersona {

    static vista.VentanaRegistrar vreg = controlador.ControladorGrafica.getVreg();

    public static void Iniciar() {
        vreg.setVisible(true);
        vreg.setLocationRelativeTo(null);
    }

    public static void Registrar() {
        Boolean valor = controlador.ControladorVerificar.VerificarCampo();
        JOptionPane op1 = new JOptionPane();
        if (valor == false) {
            String fecha = SacarFecha();
            String hora = SacarHora();
            int dni = Integer.parseInt(vreg.getTxtDNI().getText());
            String nombreapellido = vreg.getTxtApellido().getText() + " " + vreg.getTxtNombre().getText();
            String domicilio = vreg.getTxtDomicilio().getText();
            String telefono = vreg.getTxtTelefono().getText();

            modelo.Llamada llam = new modelo.Llamada(fecha, hora);
            modelo.Persona per = new modelo.Persona(dni, nombreapellido, domicilio, telefono);
            String ca = controlador.ControladorCantidadSintoma.Cantidad();
            String niv = controlador.ControladorNivel.clasificarNivel();
            if (controlador.ControladorAsignar.VerificarRecurso(niv) == true) {
                controlador.ControladorAsignar.Iniciar(niv, llam, per, ca);
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
}
