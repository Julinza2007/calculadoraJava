package GUI.Vectores;
import GUI.Vectores.Operaciones.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Component;

public class Vectores extends JPanel {

    private static final long serialVersionUID = 1L;

    public Vectores(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {

        setLayout(new BorderLayout());
        setBackground(new Color(210, 210, 210));

        // Panel central con BoxLayout para centrar verticalmente
        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        JLabel tituloVectores = new JLabel("VECTORES", SwingConstants.CENTER);
        tituloVectores.setFont(new Font("Tahoma", Font.BOLD, 14));
        tituloVectores.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(tituloVectores);
        panelCentral.add(Box.createVerticalStrut(30));

        JButton btn = new JButton("Suma");
        btn.setFocusPainted(false);
        JButton btn1 = new JButton("Resta");
        btn1.setFocusPainted(false);
        JButton btn2 = new JButton("Multiplicación por Escalar");
        btn2.setFocusPainted(false);
        JButton btn3 = new JButton("Producto Escalar");
        btn3.setFocusPainted(false);
        JButton btn4 = new JButton("Producto Vectorial");
        btn4.setFocusPainted(false);

        Dimension buttonSize = new Dimension(220, 30);
        
        btn.setMaximumSize(buttonSize);
        btn.setPreferredSize(buttonSize);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn1.setMaximumSize(buttonSize);
        btn1.setPreferredSize(buttonSize);
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn2.setMaximumSize(buttonSize);
        btn2.setPreferredSize(buttonSize);
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn3.setMaximumSize(buttonSize);
        btn3.setPreferredSize(buttonSize);
        btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn4.setMaximumSize(buttonSize);
        btn4.setPreferredSize(buttonSize);
        btn4.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(btn);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btn1);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btn2);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btn3);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btn4);

        panelSuma panelSuma = new panelSuma(cardLayout, contenedorDeCartas);
        panelResta panelResta = new panelResta(cardLayout, contenedorDeCartas);
        panelMultiPorEscalar panelMultiPorEscalar = new panelMultiPorEscalar(cardLayout, contenedorDeCartas);
        panelProductoEscalar panelProductoEscalar = new panelProductoEscalar(cardLayout, contenedorDeCartas);
        panelProductoVectorial panelProductoVectorial = new panelProductoVectorial(cardLayout, contenedorDeCartas);

        contenedorDeCartas.add(panelSuma, "Suma");
        contenedorDeCartas.add(panelResta, "Resta");
        contenedorDeCartas.add(panelMultiPorEscalar, "Multiplicacion por Escalar");
        contenedorDeCartas.add(panelProductoEscalar, "Producto Escalar");
        contenedorDeCartas.add(panelProductoVectorial, "Producto Vectorial");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contenedorDeCartas, "Suma");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contenedorDeCartas, "Resta");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contenedorDeCartas, "Multiplicacion por Escalar");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contenedorDeCartas, "Producto Escalar");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelProductoVectorial.imprimirVectores();
                cardLayout.show(contenedorDeCartas, "Producto Vectorial");
                panelBotones.setVisible(false);
                titulo.setVisible(false);
            }
        });

        JButton btnReg = new JButton("REGRESAR");
        btnReg.setBackground(new Color(255, 255, 255));
        btnReg.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReg.setMaximumSize(buttonSize);
        btnReg.setFocusPainted(false);
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contenedorDeCartas.setVisible(false);
                cardLayout.show(contenedorDeCartas, "");
                panelBotones.setVisible(true);
                titulo.setVisible(true);
            }
        });
        panelCentral.add(Box.createVerticalStrut(20));
        panelCentral.add(btnReg);

        add(panelCentral, BorderLayout.CENTER);
    }
}