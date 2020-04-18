package controlador;

public class Principal {

    public static void main(String[] args) {
        controlador.ControladorGrafica.Iniciar();
        modelo.Turno tur1 = new modelo.Turno("18/4/2020", "9:00", "4624");
        modelo.Turno tur2 = new modelo.Turno("18/4/2020", "10:00", "45756");
        modelo.Turno tur3 = new modelo.Turno("18/4/2020", "11:00", "456456");
        modelo.Medico med1 = new modelo.Medico("Eli", "425125");
        modelo.Medico med2 = new modelo.Medico("Alix", "42555125");
        modelo.Medico med3 = new modelo.Medico("Clainer", "42235125");
        modelo.Ambulancia amb1 = new modelo.Ambulancia("1");
        modelo.Ambulancia amb2 = new modelo.Ambulancia("2");
        modelo.Ambulancia amb3 = new modelo.Ambulancia("3");
        controlador.ControladorMemoria.AgregarTurno(tur1);
        controlador.ControladorMemoria.AgregarTurno(tur2);
        controlador.ControladorMemoria.AgregarTurno(tur3);
        controlador.ControladorMemoria.AgregarMedico(med1);
        controlador.ControladorMemoria.AgregarMedico(med2);
        controlador.ControladorMemoria.AgregarMedico(med3);
        controlador.ControladorMemoria.AgregarAmbulancia(amb1);
        controlador.ControladorMemoria.AgregarAmbulancia(amb2);
        controlador.ControladorMemoria.AgregarAmbulancia(amb3);
    }
    
}
