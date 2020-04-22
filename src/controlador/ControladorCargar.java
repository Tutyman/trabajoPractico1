package controlador;

import javax.swing.JOptionPane;

public class ControladorCargar {

    public static void DatosIniciales() {
        modelo.Nivel nie1 = new modelo.Nivel("1");
        modelo.Nivel nie2 = new modelo.Nivel("1");
        modelo.Nivel nie3 = new modelo.Nivel("1");
        modelo.Nivel nie4 = new modelo.Nivel("1");
        modelo.Nivel nie5 = new modelo.Nivel("2");
        modelo.Nivel nie6 = new modelo.Nivel("2");
        modelo.Nivel nie7 = new modelo.Nivel("2");
        modelo.Nivel nie8 = new modelo.Nivel("2");
        modelo.Nivel nie9 = new modelo.Nivel("3");
        modelo.Nivel nie10 = new modelo.Nivel("0");
        modelo.Nivel nie11 = new modelo.Nivel("0");
        modelo.Nivel nie12 = new modelo.Nivel("0");
        
        modelo.Sintoma sin1 = new modelo.Sintoma("Tos seca");
        modelo.Sintoma sin2 = new modelo.Sintoma("Dolor muscular");
        modelo.Sintoma sin3 = new modelo.Sintoma("Dolor de garganta");
        modelo.Sintoma sin4 = new modelo.Sintoma("Fatiga");
        modelo.Sintoma sin5 = new modelo.Sintoma("Fiebre");
        modelo.Sintoma sin6 = new modelo.Sintoma("Nauseas o vomito");
        modelo.Sintoma sin7 = new modelo.Sintoma("Dolor de cabeza");
        modelo.Sintoma sin8 = new modelo.Sintoma("Escalofrios");
        modelo.Sintoma sin9 = new modelo.Sintoma("Dificultad para respirar");
        modelo.Sintoma sin10 = new modelo.Sintoma("Flema");
        modelo.Sintoma sin11 = new modelo.Sintoma("Disnea");
        modelo.Sintoma sin12 = new modelo.Sintoma("Congestion nasal");
        
        modelo.Turno tur1 = new modelo.Turno("23/04/2020", "17:00", "4624");
        modelo.Turno tur2 = new modelo.Turno("24/04/2020", "18:00", "45756");
        modelo.Turno tur3 = new modelo.Turno("24/04/2020", "18:00", "456456");
        
        modelo.Medico med1 = new modelo.Medico("Eli", "425125");
        modelo.Medico med2 = new modelo.Medico("Alix", "42555125");
        modelo.Medico med3 = new modelo.Medico("Clainer", "42235125");
        
        modelo.Ambulancia amb1 = new modelo.Ambulancia("1");
        modelo.Ambulancia amb2 = new modelo.Ambulancia("2");
        modelo.Ambulancia amb3 = new modelo.Ambulancia("3");
        
        modelo.Memoria.AgregarTurnoCarga(tur1);
        modelo.Memoria.AgregarTurnoCarga(tur2);
        modelo.Memoria.AgregarTurnoCarga(tur3);
        
        modelo.Memoria.AgregarMedicoCarga(med1);
        modelo.Memoria.AgregarMedicoCarga(med2);
        modelo.Memoria.AgregarMedicoCarga(med3);
        
        modelo.Memoria.AgregarAmbulanciaCarga(amb1);
        modelo.Memoria.AgregarAmbulanciaCarga(amb2);
        modelo.Memoria.AgregarAmbulanciaCarga(amb3);
        
        modelo.Memoria.AgregarNivelCarga(nie1);
        modelo.Memoria.AgregarNivelCarga(nie2);
        modelo.Memoria.AgregarNivelCarga(nie3);
        modelo.Memoria.AgregarNivelCarga(nie4);
        modelo.Memoria.AgregarNivelCarga(nie5);
        modelo.Memoria.AgregarNivelCarga(nie6);
        modelo.Memoria.AgregarNivelCarga(nie7);
        modelo.Memoria.AgregarNivelCarga(nie8);
        modelo.Memoria.AgregarNivelCarga(nie9);
        modelo.Memoria.AgregarNivelCarga(nie10);
        modelo.Memoria.AgregarNivelCarga(nie11);
        modelo.Memoria.AgregarNivelCarga(nie12);
        
        modelo.Memoria.AgregarSintomaCarga(sin1);
        modelo.Memoria.AgregarSintomaCarga(sin2);
        modelo.Memoria.AgregarSintomaCarga(sin3);
        modelo.Memoria.AgregarSintomaCarga(sin4);
        modelo.Memoria.AgregarSintomaCarga(sin5);
        modelo.Memoria.AgregarSintomaCarga(sin6);
        modelo.Memoria.AgregarSintomaCarga(sin7);
        modelo.Memoria.AgregarSintomaCarga(sin8);
        modelo.Memoria.AgregarSintomaCarga(sin9);
        modelo.Memoria.AgregarSintomaCarga(sin10);
        modelo.Memoria.AgregarSintomaCarga(sin11);
        modelo.Memoria.AgregarSintomaCarga(sin12);
    }
}
