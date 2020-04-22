package controlador;

import static controlador.ControladorGrafica.vrec;

public class ControladorRecursos {
    
    public static void Iniciar(){
        vrec.setVisible(true);
        vrec.setLocationRelativeTo(null);
    }
    
    public static void RegistrarTurno(){
        modelo.Turno tur = new modelo.Turno(vrec.getTxtFecha().getText(), vrec.getTxtHora().getText(), vrec.getTxtTelefono().getText());
        modelo.Memoria.AgregarTurnoCarga(tur);
        Vaciar();
    }
    
    public static void RegistrarMedico(){
        modelo.Medico med = new modelo.Medico(vrec.getTxtNombre().getText(), vrec.getTxtInterno().getText());
        modelo.Memoria.AgregarMedicoCarga(med);
        Vaciar();
    }
    
    public static void RegistrarAmbulancia(){
        modelo.Ambulancia amb = new modelo.Ambulancia(vrec.getTxtAmbulancia().getText());
        modelo.Memoria.AgregarAmbulanciaCarga(amb);
        Vaciar();
    }
    
    public static void Vaciar(){
        vrec.getTxtFecha().setText("");
        vrec.getTxtHora().setText("");
        vrec.getTxtTelefono().setText("");
        vrec.getTxtNombre().setText("");
        vrec.getTxtInterno().setText("");
        vrec.getTxtAmbulancia().setText("");
    }
}
