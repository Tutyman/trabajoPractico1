package controlador;

import controlador.ControladorGrafica;

public class Principal {

    public static void main(String[] args) {
        
        ControladorGrafica contGra = new ControladorGrafica();
        
        controlador.ControladorCargar.DatosIniciales();
        contGra.Iniciar();
    }
    
}
