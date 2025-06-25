package GUI;

import javax.swing.*;
import java.awt.*;

public class Ecuaciones extends JPanel {

    private static final long serialVersionUID = 1L;

    public Ecuaciones(CardLayout cardLayout, JPanel contenedorDeCartas) {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("ECUACIONES", SwingConstants.CENTER);
        add(titulo, BorderLayout.CENTER);

        add(BotonVolver.crear(cardLayout, contenedorDeCartas), BorderLayout.SOUTH);
    }
}
