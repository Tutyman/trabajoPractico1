package controlador;

public class Principal {

    public static void main(String[] args) {
        modelo.Nivel nie1 = new modelo.Nivel("1","Tos seca");
        modelo.Nivel nie2 = new modelo.Nivel("1","Dolor muscular");
        modelo.Nivel nie3 = new modelo.Nivel("1","Dolor de garganta");
        modelo.Nivel nie4 = new modelo.Nivel("1","Fatiga");
        modelo.Nivel nie5 = new modelo.Nivel("2","Fiebre");
        modelo.Nivel nie6 = new modelo.Nivel("2","Nauseas o vomito");
        modelo.Nivel nie7 = new modelo.Nivel("2","Dolor de cabeza");
        modelo.Nivel nie8 = new modelo.Nivel("2","Escalofrios");
        modelo.Nivel nie9 = new modelo.Nivel("3","Dificultad para respirar");
        modelo.Nivel nie10 = new modelo.Nivel("0","Flema");
        modelo.Nivel nie11 = new modelo.Nivel("0","Disnea");
        modelo.Nivel nie12 = new modelo.Nivel("0","Congestion nasal");
        modelo.Memoria.AgregarNivelS(nie1);
        modelo.Memoria.AgregarNivelS(nie2);
        modelo.Memoria.AgregarNivelS(nie3);
        modelo.Memoria.AgregarNivelS(nie4);
        modelo.Memoria.AgregarNivelS(nie5);
        modelo.Memoria.AgregarNivelS(nie6);
        modelo.Memoria.AgregarNivelS(nie7);
        modelo.Memoria.AgregarNivelS(nie8);
        modelo.Memoria.AgregarNivelS(nie9);
        modelo.Memoria.AgregarNivelS(nie10);
        modelo.Memoria.AgregarNivelS(nie11);
        modelo.Memoria.AgregarNivelS(nie12);
        
        controlador.ControladorGestionarLlamada.Iniciar2();
        /*controlador.ControladorGrafica.Iniciar();
        modelo.Turno tur1 = new modelo.Turno("18/04/2020", "9:00", "4624");
        modelo.Turno tur2 = new modelo.Turno("19/04/2020", "10:00", "45756");
        modelo.Turno tur3 = new modelo.Turno("20/04/2020", "11:00", "456456");
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
        modelo.Memoria.AgregarAmbulancia(amb3);*/
        /*modelo.Llamada lla = new modelo.Llamada(controlador.ControladorGestionarLlamada.SacarFecha(), controlador.ControladorGestionarLlamada.SacarHora());
        
        ArrayList<modelo.Turno> ter = controlador.ControladorFecha.VerificarFecha2(lla.getFecha(), modelo.Memoria.getTurn());
        for (int i = 0; i<ter.size(); i++){
            System.out.println(ter.get(i).getFecha());
        }*/
        //System.out.println(controlador.ControladorGestionarLlamada.SacarFecha());
    }
    
}
