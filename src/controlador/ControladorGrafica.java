package controlador;

import vista.VentanaAsignar;
import vista.VentanaLista;
import vista.VentanaPrincipal;
import vista.VentanaRecursos;
import vista.VentanaRegistrar;

public class ControladorGrafica {

    static vista.VentanaPrincipal vpri = new vista.VentanaPrincipal();
    static vista.VentanaRegistrar vreg = new vista.VentanaRegistrar();
    static vista.VentanaLista vlis = new vista.VentanaLista();
    static vista.VentanaAsignar vasg = new vista.VentanaAsignar();
    static vista.VentanaRecursos vrec = new vista.VentanaRecursos();

    public static void Iniciar() {
        vpri.setVisible(true);
        vpri.setLocationRelativeTo(null);
    }

    public static VentanaPrincipal getVpri() {
        return vpri;
    }

    public static VentanaRegistrar getVreg() {
        return vreg;
    }

    public static VentanaLista getVlis() {
        return vlis;
    }

    public static VentanaAsignar getVasg() {
        return vasg;
    }

    public static VentanaRecursos getVrec() {
        return vrec;
    }
}
