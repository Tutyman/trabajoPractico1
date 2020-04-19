package controlador;

public class Principal {

    public static void main(String[] args) {
        controlador.ControladorGrafica.Iniciar();
        modelo.Turno tur1 = new modelo.Turno("17/4/2020", "9:00", "4624");
        modelo.Turno tur2 = new modelo.Turno("18/4/2020", "10:00", "45756");
        modelo.Turno tur3 = new modelo.Turno("19/4/2020", "11:00", "456456");
        modelo.Medico med1 = new modelo.Medico("Eli", "425125");
        modelo.Medico med2 = new modelo.Medico("Alix", "42555125");
        modelo.Medico med3 = new modelo.Medico("Clainer", "42235125");
        modelo.Ambulancia amb1 = new modelo.Ambulancia("1");
        modelo.Ambulancia amb2 = new modelo.Ambulancia("2");
        modelo.Ambulancia amb3 = new modelo.Ambulancia("3");
        modelo.Memoria.AgregarTurno(tur1);
        modelo.Memoria.AgregarTurno(tur2);
        modelo.Memoria.AgregarTurno(tur3);
        modelo.Memoria.AgregarMedico(med1);
        modelo.Memoria.AgregarMedico(med2);
        modelo.Memoria.AgregarMedico(med3);
        modelo.Memoria.AgregarAmbulancia(amb1);
        modelo.Memoria.AgregarAmbulancia(amb2);
        modelo.Memoria.AgregarAmbulancia(amb3);
    }
    
}
