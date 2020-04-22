package controlador;

import vista.VentanaAsignar;
import vista.VentanaLista;
import vista.VentanaPrincipal;
import vista.VentanaRegistrar;
import vista.VentanaRegistrar2;

public class ControladorGrafica {

    static vista.VentanaPrincipal vpri = new vista.VentanaPrincipal();
    static vista.VentanaRegistrar vreg = new vista.VentanaRegistrar();
    static vista.VentanaLista vlis = new vista.VentanaLista();
    static vista.VentanaAsignar vasg = new vista.VentanaAsignar();

    public static void Iniciar() {
        vpri.setVisible(true);
        vpri.setLocationRelativeTo(null);
    }

    public static VentanaPrincipal getVpri() {
        return vpri;
    }

    public static void setVpri(VentanaPrincipal vpri) {
        ControladorGrafica.vpri = vpri;
    }

    public static VentanaLista getVlis() {
        return vlis;
    }

    public static void setVlis(VentanaLista vlis) {
        ControladorGrafica.vlis = vlis;
    }

    public static VentanaAsignar getVasg() {
        return vasg;
    }

    public static void setVasg(VentanaAsignar vasg) {
        ControladorGrafica.vasg = vasg;
    }

    public static VentanaRegistrar getVreg() {
        return vreg;
    }

    public static void setVreg(VentanaRegistrar vreg) {
        ControladorGrafica.vreg = vreg;
    }
}
