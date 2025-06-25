package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotonVolver {

	public static JButton crear(CardLayout layout, JPanel contenedor) {
	    JButton volver = new JButton("Volver al menú");
	    volver.addActionListener(e -> layout.show(contenedor, "menu"));
	    return volver;
	}

}
