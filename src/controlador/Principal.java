package controlador;

import controlador.ControladorGrafica;

public class Principal {

    public static void main(String[] args) {
        //El metodo DatosIniciales() carga los datos escenciales para el funcionamiento
        controlador.ControladorCargar.DatosIniciales();
        //El metodo Iniciar() hace visible la ventana principal
        controlador.ControladorGrafica.Iniciar();
    }

}
