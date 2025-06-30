package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesBasicas extends JPanel {

    private static final long serialVersionUID = 1L;

    public OperacionesBasicas(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        JLabel titulo1 = new JLabel("OPERACIONES BÁSICAS");
        titulo1.setFont(new Font("Tahoma", Font.BOLD, 16));
        titulo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(titulo1);
        panelCentral.add(Box.createVerticalStrut(30));

        JTextField campo1 = new JTextField();
        campo1.setMaximumSize(new Dimension(130, 30));
        campo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(campo1);
        panelCentral.add(Box.createVerticalStrut(10));

        JTextField campo2 = new JTextField();
        campo2.setMaximumSize(new Dimension(130, 30));
        campo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(campo2);
        panelCentral.add(Box.createVerticalStrut(10));

        JTextField resultado = new JTextField("Resultado");
        resultado.setEditable(false);
        resultado.setMaximumSize(new Dimension(130, 30));
        resultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(resultado);
        panelCentral.add(Box.createVerticalStrut(20));

        JPanel panelBotonesOperaciones = new JPanel();
        panelBotonesOperaciones.setLayout(new GridLayout(2, 3, 10, 10));
        panelBotonesOperaciones.setOpaque(false);
        panelBotonesOperaciones.setMaximumSize(new Dimension(420, 70));
        panelBotonesOperaciones.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnSuma = new JButton("+");
        JButton btnResta = new JButton("-");
        JButton btnMult = new JButton("×");
        JButton btnDiv = new JButton("/");
        JButton btnPot = new JButton("^");
        JButton btnRaiz = new JButton("√");

        panelBotonesOperaciones.add(btnSuma);
        panelBotonesOperaciones.add(btnResta);
        panelBotonesOperaciones.add(btnMult);
        panelBotonesOperaciones.add(btnDiv);
        panelBotonesOperaciones.add(btnPot);
        panelBotonesOperaciones.add(btnRaiz);

        panelCentral.add(panelBotonesOperaciones);
        panelCentral.add(Box.createVerticalStrut(15));

        JButton btnAns = new JButton("ANS");
        btnAns.setMaximumSize(new Dimension(80, 30));
        btnAns.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(btnAns);
        panelCentral.add(Box.createVerticalStrut(15));

        JButton btnReg = new JButton("REGRESAR");
        btnReg.setMaximumSize(new Dimension(120, 30));
        btnReg.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(btnReg);

        // Acciones
        btnAns.addActionListener(e -> {
            double ans = Respuestas.obtenerBasico();
            campo1.setText(String.valueOf(ans));
        });

        btnSuma.addActionListener(e -> op(campo1, campo2, resultado, (a, b) -> a + b));
        btnResta.addActionListener(e -> op(campo1, campo2, resultado, (a, b) -> a - b));
        btnMult.addActionListener(e -> op(campo1, campo2, resultado, (a, b) -> a * b));

        btnDiv.addActionListener(e -> {
            if (esNumero(campo1.getText()) && esNumero(campo2.getText())) {
                double a = Double.parseDouble(campo1.getText());
                double b = Double.parseDouble(campo2.getText());
                if (b == 0) {
                    resultado.setText("El denominador es 0");
                } else {
                    double r = a / b;
                    resultado.setText(String.valueOf(r));
                    Respuestas.guardarRespuestas(1, r, null, null);
                }
            } else {
                resultado.setText("Error");
            }
        });

        btnPot.addActionListener(e -> {
            String txt1 = campo1.getText();
            String txt2 = campo2.getText();
            if (esNumero(txt1) && esNumero(txt2)) {
                double a = Double.parseDouble(txt1);
                double b = Double.parseDouble(txt2);
                double r = Math.pow(a, b);
                resultado.setText(String.valueOf(r));
                Respuestas.guardarRespuestas(1, r, null, null);
            } else {
                resultado.setText("Error");
            }
        });

        btnRaiz.addActionListener(e -> {
            String texto = campo1.getText();
            if (esNumero(texto)) {
                double a = Double.parseDouble(texto);
                if (a < 0) {
                    resultado.setText("Raíz de nro negativo");
                } else {
                    double r = Math.sqrt(a);
                    resultado.setText(String.valueOf(r));
                    Respuestas.guardarRespuestas(1, r, null, null);
                }
            } else {
                resultado.setText("Error");
            }
        });

        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contenedorDeCartas.setVisible(false);
                cardLayout.show(contenedorDeCartas, "");
                panelBotones.setVisible(true);
                titulo.setVisible(true);
            }
        });

        add(panelCentral, BorderLayout.CENTER);
    }

    private boolean esNumero(String texto) {
        return texto != null && texto.matches("-?\\d+(\\.\\d+)?");
    }

    private void op(JTextField campo1, JTextField campo2, JTextField resultado, Operacion op) {
        String txt1 = campo1.getText();
        String txt2 = campo2.getText();

        if (esNumero(txt1) && esNumero(txt2)) {
            double a = Double.parseDouble(txt1);
            double b = Double.parseDouble(txt2);
            double r = op.aplicar(a, b);
            resultado.setText(String.valueOf(r));
            Respuestas.guardarRespuestas(1, r, null, null);
        } else {
            resultado.setText("Error");
        }
    }

    interface Operacion {
        double aplicar(double a, double b);
    }
}
