package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ecuaciones extends JPanel {

    private static final long serialVersionUID = 1L;

    public Ecuaciones(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        JLabel tituloEcuaciones = new JLabel("ECUACIONES", SwingConstants.CENTER);
        tituloEcuaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
        tituloEcuaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(tituloEcuaciones);
        panelCentral.add(Box.createVerticalStrut(30));

        JButton btn2x2 = new JButton("Sistema 2x2");
        JButton btn3x3 = new JButton("Sistema 3x3");
        JButton btnVerUltimo = new JButton("Ver último resultado");
        JButton btnReg = new JButton("REGRESAR");

        Dimension btnSize = new Dimension(200, 30);
        for (JButton btn : new JButton[]{btn2x2, btn3x3, btnVerUltimo, btnReg}) {
            btn.setMaximumSize(btnSize);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setFocusPainted(false);
        }
        btnReg.setBackground(Color.WHITE);

        panelCentral.add(btn2x2);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btn3x3);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnVerUltimo);
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(btnReg);

        // Acciones
        btn2x2.addActionListener(e -> resolver2x2());
        btn3x3.addActionListener(e -> resolver3x3());
        btnVerUltimo.addActionListener(e -> mostrarUltimoResultado());

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

    private void resolver2x2() {
        JTextField a1 = new JTextField(3);
        JTextField b1 = new JTextField(3);
        JTextField c1 = new JTextField(3);
        JTextField a2 = new JTextField(3);
        JTextField b2 = new JTextField(3);
        JTextField c2 = new JTextField(3);

        JPanel panel = new JPanel(new GridLayout(2, 6));
        panel.add(new JLabel("a1:")); panel.add(a1);
        panel.add(new JLabel("b1:")); panel.add(b1);
        panel.add(new JLabel("c1:")); panel.add(c1);
        panel.add(new JLabel("a2:")); panel.add(a2);
        panel.add(new JLabel("b2:")); panel.add(b2);
        panel.add(new JLabel("c2:")); panel.add(c2);

        int res = JOptionPane.showConfirmDialog(this, panel, "Ingrese los coeficientes", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            try {
                double A1 = Double.parseDouble(a1.getText());
                double B1 = Double.parseDouble(b1.getText());
                double C1 = Double.parseDouble(c1.getText());
                double A2 = Double.parseDouble(a2.getText());
                double B2 = Double.parseDouble(b2.getText());
                double C2 = Double.parseDouble(c2.getText());

                double D = A1 * B2 - A2 * B1;
                double Dx = C1 * B2 - C2 * B1;
                double Dy = A1 * C2 - A2 * C1;

                String resultado;

                if (D != 0) {
                    double x = Dx / D;
                    double y = Dy / D;
                    resultado = "Solución 2x2:\nx = " + x + "\ny = " + y;
                } else {
                    resultado = (Dx == 0 && Dy == 0)
                        ? "Sistema 2x2 con infinitas soluciones."
                        : "Sistema 2x2 sin solución.";
                }

                JOptionPane.showMessageDialog(this, resultado);
                Respuestas.guardarEcuacion(resultado);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: Verificá que ingresaste todos los datos correctamente.");
            }
        }
    }

    private void resolver3x3() {
        JTextField[] campos = new JTextField[12];
        JPanel panel = new JPanel(new GridLayout(3, 4));

        for (int i = 0; i < 12; i++) {
            campos[i] = new JTextField(3);
        }

        panel.add(new JLabel("a1:")); panel.add(campos[0]);
        panel.add(new JLabel("b1:")); panel.add(campos[1]);
        panel.add(new JLabel("c1:")); panel.add(campos[2]);
        panel.add(new JLabel("d1:")); panel.add(campos[3]);

        panel.add(new JLabel("a2:")); panel.add(campos[4]);
        panel.add(new JLabel("b2:")); panel.add(campos[5]);
        panel.add(new JLabel("c2:")); panel.add(campos[6]);
        panel.add(new JLabel("d2:")); panel.add(campos[7]);

        panel.add(new JLabel("a3:")); panel.add(campos[8]);
        panel.add(new JLabel("b3:")); panel.add(campos[9]);
        panel.add(new JLabel("c3:")); panel.add(campos[10]);
        panel.add(new JLabel("d3:")); panel.add(campos[11]);

        int res = JOptionPane.showConfirmDialog(this, panel, "Ingrese los coeficientes", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            try {
                double[][] m = new double[3][4];

                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 4; j++)
                        m[i][j] = Double.parseDouble(campos[i * 4 + j].getText());

                gaussJordan(m);

                String resultado = "Solución 3x3:\nx = " + m[0][3] + "\ny = " + m[1][3] + "\nz = " + m[2][3];
                JOptionPane.showMessageDialog(this, resultado);
                Respuestas.guardarEcuacion(resultado);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: Verificá que ingresaste todos los datos correctamente.");
            }
        }
    }

    private void gaussJordan(double[][] m) {
        int n = 3;
        for (int i = 0; i < n; i++) {
            double max = Math.abs(m[i][i]);
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(m[k][i]) > max) {
                    max = Math.abs(m[k][i]);
                    maxRow = k;
                }
            }

            double[] temp = m[i];
            m[i] = m[maxRow];
            m[maxRow] = temp;

            double div = m[i][i];
            for (int j = 0; j < 4; j++) {
                m[i][j] /= div;
            }

            for (int k = 0; k < n; k++) {
                if (k == i) continue;
                double factor = m[k][i];
                for (int j = 0; j < 4; j++) {
                    m[k][j] -= factor * m[i][j];
                }
            }
        }
    }

    private void mostrarUltimoResultado() {
        String resultado = Respuestas.obtenerEcuacion();
        if (resultado == null || resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún resultado guardado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, resultado, "Último resultado guardado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
