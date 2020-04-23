package controlador;

import controlador.ControladorGrafica;
import javax.swing.JOptionPane;
import vista.VentanaRecursos;


public class ControladorRecursos {

    VentanaRecursos vrec = new VentanaRecursos();
    
    public void Iniciar() {
        vrec.setVisible(true);
        vrec.setLocationRelativeTo(null);

    }

    public void RegistrarTurno() {
        if (VerificarTurno() == true) {
            modelo.Turno tur = new modelo.Turno(vrec.getTxtFecha().getText(), vrec.getTxtHora().getText(), vrec.getTxtTelefono().getText());
            modelo.Memoria.AgregarTurnoCarga(tur);
            Vaciar();
        }
    }

    public void RegistrarMedico() {
        
        if (VerificarMedico() == true) {
            modelo.Medico med = new modelo.Medico(vrec.getTxtNombre().getText(), vrec.getTxtInterno().getText());
            modelo.Memoria.AgregarMedicoCarga(med);
            Vaciar();
        }
        
    }

    public void RegistrarAmbulancia() {
        if (VerificarAmbulancia() == true) {
            modelo.Ambulancia amb = new modelo.Ambulancia(vrec.getTxtAmbulancia().getText());
            modelo.Memoria.AgregarAmbulanciaCarga(amb);
            Vaciar();
        }
    }

    public void Vaciar() {
        vrec.getTxtFecha().setText("");
        vrec.getTxtHora().setText("");
        vrec.getTxtTelefono().setText("");
        vrec.getTxtNombre().setText("");
        vrec.getTxtInterno().setText("");
        vrec.getTxtAmbulancia().setText("");
    }

    public Boolean VerificarTurno() {
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
            valor = true;
        }
        return valor;
    }
    
    public Boolean VerificarTurno2() {
            Boolean valor = true;
            if (vrec.getTxtFecha().getText().equals("")) {
                valor=false;
                JOptionPane.showMessageDialog(null, "Ingrese la fecha");
                vrec.getTxtFecha().requestFocus();
            } 
            
            if (vrec.getTxtHora().getText().equals("")) {
                valor=false;
                JOptionPane.showMessageDialog(null, "Ingrese la hora");
                vrec.getTxtHora().requestFocus();
            } 
            
            if (vrec.getTxtTelefono().getText().equals("")) {
                valor=false;
                JOptionPane.showMessageDialog(null, "Ingrese un telefono");
                vrec.getTxtTelefono().requestFocus();
            }
            return valor;
    }

    public Boolean VerificarMedico() {
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

    public Boolean VerificarAmbulancia() {
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
