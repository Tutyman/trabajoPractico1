package controlador;

import vista.VentanaAsignar;
import vista.VentanaLista;
import vista.VentanaNiveles;
import vista.VentanaPrincipal;
import vista.VentanaRecursos;
import vista.VentanaRegistrar;

public class ControladorGrafica {

    VentanaPrincipal vpri = new vista.VentanaPrincipal();
    VentanaRegistrar vreg = new vista.VentanaRegistrar();
    VentanaLista vlis = new vista.VentanaLista();
    VentanaAsignar vasg = new vista.VentanaAsignar();
    VentanaRecursos vrec = new vista.VentanaRecursos();
    VentanaNiveles vniv = new vista.VentanaNiveles();

    public void Iniciar() {
        vpri.setVisible(true);
        vpri.setLocationRelativeTo(null);
    }

    public VentanaPrincipal getVpri() {
        return vpri;
    }

    public VentanaRegistrar getVreg() {
        return vreg;
    }

    public VentanaLista getVlis() {
        return vlis;
    }

    public VentanaAsignar getVasg() {
        return vasg;
    }

    public VentanaRecursos getVrec() {
        return vrec;
    }

    public VentanaNiveles getVniv() {
        return vniv;
    }

}
