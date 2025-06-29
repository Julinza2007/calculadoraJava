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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DebugGraphics;
import java.awt.Font;
import java.awt.Component;

public class Vectores extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Vectores(CardLayout cardLayout, JPanel contenedorDeCartas, JPanel panelBotones, JLabel titulo) {
		
		setLayout(new BorderLayout());
		
		JPanel centroLibre = new JPanel(null);
		add(centroLibre, BorderLayout.CENTER);

        JLabel tituloVectores = new JLabel("VECTORES", SwingConstants.CENTER);
        tituloVectores.setFont(new Font("Tahoma", Font.BOLD, 14));
        tituloVectores.setBounds(179, 11, 92, 40);
        centroLibre.add(tituloVectores);      
        
        JPanel panel = new JPanel();
        panel.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        panel.setBounds(112, 52, 225, 195);
        centroLibre.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
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
        
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn4.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Luego agrégalos como ya lo haces
        panel.add(btn);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btn1);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btn2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btn3);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btn4);
        
        Dimension buttonSize = new Dimension(151, 30); // 151px width, 30px height (adjust height as needed)
        btn.setMaximumSize(buttonSize);
        btn.setPreferredSize(buttonSize);
        btn1.setMaximumSize(buttonSize);
        btn1.setPreferredSize(buttonSize);
        btn2.setMaximumSize(buttonSize);
        btn2.setPreferredSize(buttonSize);
        btn3.setMaximumSize(buttonSize);
        btn3.setPreferredSize(buttonSize);
        btn4.setMaximumSize(buttonSize);
        btn4.setPreferredSize(buttonSize);
               
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
        btnReg.setBounds(10, 269, 100, 20);
		centroLibre.add(btnReg);
        btnReg.setMaximumSize(new Dimension(200, 30));
        
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	contenedorDeCartas.setVisible(false);
                cardLayout.show(contenedorDeCartas, "");
                panelBotones.setVisible(true);
                titulo.setVisible(true);
            }
        });

        
	}
}
