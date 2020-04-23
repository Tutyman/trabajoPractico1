package controlador;

import static controlador.ControladorGrafica.vrec;
import javax.swing.JOptionPane;


public class ControladorRecursos {
    
    //El metodo Iniciar() hace visible la ventana para gestionar los recursos
    public static void Iniciar() {
        vrec.setVisible(true);
        vrec.setLocationRelativeTo(null);
    }
    
    //El metodo RegistrarTurno() captura los valores ingresados y lo agregar a la memoria
    public static void RegistrarTurno() {
        if (VerificarTurno() == false) {
            modelo.Turno tur = new modelo.Turno(vrec.getTxtFecha().getText(), vrec.getTxtHora().getText(), vrec.getTxtTelefono().getText());
            modelo.Memoria.AgregarTurnoCarga(tur);
            LimpiarCasillas();
        }
    }
    
    //El metodo RegistrarMedico() captura los valores ingresados y lo agregar a la memoria
    public static void RegistrarMedico() {
        if (VerificarMedico() == false) {
            modelo.Medico med = new modelo.Medico(vrec.getTxtNombre().getText(), vrec.getTxtInterno().getText());
            modelo.Memoria.AgregarMedicoCarga(med);
            LimpiarCasillas();
        }
        
    }
    
    //El metodo RegistrarAmbulancia() captura los valores ingresados y lo agregar a la memoria
    public static void RegistrarAmbulancia() {
        if (VerificarAmbulancia() == false) {
            modelo.Ambulancia amb = new modelo.Ambulancia(vrec.getTxtAmbulancia().getText());
            modelo.Memoria.AgregarAmbulanciaCarga(amb);
            LimpiarCasillas();
        }
    }
    
    //El metodo LimpiarCasillas() elimina todos los datos ingresados en los textfield
    public static void LimpiarCasillas() {
        vrec.getTxtFecha().setText("");
        vrec.getTxtHora().setText("");
        vrec.getTxtTelefono().setText("");
        vrec.getTxtNombre().setText("");
        vrec.getTxtInterno().setText("");
        vrec.getTxtAmbulancia().setText("");
    }

    //El metodo VerificarTurno() verifica si los campos estan vacios
    public static Boolean VerificarTurno() {
        Boolean valor = false;
        JOptionPane op1 = new JOptionPane();
        if (vrec.getTxtFecha().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vrec, "Debe ingresar la fecha");
            vrec.getTxtFecha().requestFocus();
        } else if (vrec.getTxtHora().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vrec, "Debe ingresar la hora");
            vrec.getTxtHora().requestFocus();
        } else if (vrec.getTxtTelefono().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vrec, "Debe ingresar el telefono");
            vrec.getTxtTelefono().requestFocus();
        } else {
            valor = false;
        }
        return valor;
    }

    //El metodo VerificarMedico() verifica si los campos estan vacios
    public static Boolean VerificarMedico() {
        Boolean valor = false;
        JOptionPane op1 = new JOptionPane();
        if (vrec.getTxtNombre().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vrec, "Debe ingresar el nombre");
            vrec.getTxtNombre().requestFocus();
        } else if (vrec.getTxtInterno().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vrec, "Debe ingresar el interno");
            vrec.getTxtInterno().requestFocus();
        } else {
            valor = false;
        }
        return valor;
    }

    //El metodo VerificarAmbulancia() verifica si los campos estan vacios
    public static Boolean VerificarAmbulancia() {
        Boolean valor = false;
        JOptionPane op1 = new JOptionPane();
        if (vrec.getTxtAmbulancia().getText().isEmpty()) {
            valor = true;
            op1.showMessageDialog(vrec, "Debe ingresar el N° de ambulancia");
            vrec.getTxtAmbulancia().requestFocus();
        } else {
            valor = false;
        }
        return valor;
    }
}
