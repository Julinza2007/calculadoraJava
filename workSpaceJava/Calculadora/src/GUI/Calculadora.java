package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculadora G3L");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setBounds(160, 11, 128, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnEj1 = new JButton("Operaciones Básicas");
		btnEj1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaOperaciones = new JFrame("Operaciones Básicas");
				

				OperacionesBasicas panel = new OperacionesBasicas();
				ventanaOperaciones.setContentPane(panel);
				
				ventanaOperaciones.setVisible(true);
			}
		});
		
		// HideAllFrames

		
		
		btnEj1.setBounds(-3, 59, 438, 23);
		contentPane.add(btnEj1);
		
		JButton btnEj2 = new JButton("Operaciones Vectoriales");
		btnEj2.setBounds(0, 98, 435, 23);
		contentPane.add(btnEj2);
		
		JButton btnEj3 = new JButton("Operaciones Matriciales");
		btnEj3.setBounds(-1, 142, 435, 23);
		contentPane.add(btnEj3);
		
		JButton btnEj4 = new JButton("Ecuaciones de 2X2 y 3X3");
		btnEj4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEj4.setBounds(-2, 185, 438, 23);
		contentPane.add(btnEj4);


	}
}
