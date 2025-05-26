package MVC.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MVC.controlador.Coordinador;

public class VentanaOperaciones extends JDialog implements ActionListener {

    private JTextField txtNumero1, txtNumero2;
    private JComboBox<String> comboOperacion;
    private JButton btnCalcular, btnCerrar;
    private JLabel lblResultado;
    private Coordinador coordinador;

    public VentanaOperaciones(VentanaPrincipal ventanaPrincipal, boolean modal) {
        super(ventanaPrincipal, modal);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 5, 5));

        // Campos para números
        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();

        // Combo con las operaciones
        String[] operaciones = {"suma", "resta", "multiplicacion", "division"};
        comboOperacion = new JComboBox<>(operaciones);

        // Botones
        btnCalcular = new JButton("Calcular");
        btnCerrar = new JButton("Cerrar");

        // Label resultado
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

        // Añadir componentes al diálogo
        add(new JLabel("Número 1:"));
        add(txtNumero1);
        add(new JLabel("Número 2:"));
        add(txtNumero2);
        add(comboOperacion);
        add(btnCalcular);
        add(lblResultado);
        add(btnCerrar);

        // Acción botones
        btnCalcular.addActionListener(this);
        btnCerrar.addActionListener(this);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            // Validar datos
            String num1 = txtNumero1.getText().trim();
            String num2 = txtNumero2.getText().trim();
            String operacion = (String) comboOperacion.getSelectedItem();

            if (!coordinador.validarNumero(num1) || !coordinador.validarNumero(num2)) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos y no negativos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calcular operación
            String resultado = coordinador.calcularOperacion(operacion, num1, num2);
            lblResultado.setText("Resultado: " + resultado);

        } else if (e.getSource() == btnCerrar) {
            dispose();
        }
    }
}
