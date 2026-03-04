package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class vistaCalculadora extends JFrame {
    private JPanel p;
    private JLabel text;
    
    // Botones numéricos
    public JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    // Botones de operación
    public JButton equalsButton, sumButton, c, dotButton, circButton, bFact, bExp;

    public vistaCalculadora() {
        // Configuración de la ventana [cite: 63]
        setTitle("Calculadora Profesional MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        setResizable(false);

        p = new JPanel();
        p.setLayout(null);
        setContentPane(p);

        // Pantalla de texto
        text = new JLabel("0");
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setBounds(50, 20, 300, 50);
        text.setBorder(BorderFactory.createEtchedBorder());
        p.add(text);

        // --- FILA 1 ---
        b7 = new JButton("7"); b7.setBounds(50, 100, 60, 60); p.add(b7);
        b8 = new JButton("8"); b8.setBounds(120, 100, 60, 60); p.add(b8);
        b9 = new JButton("9"); b9.setBounds(190, 100, 60, 60); p.add(b9);
        bExp = new JButton("Exp"); bExp.setBounds(260, 100, 60, 60); p.add(bExp);

        // --- FILA 2 ---
        b4 = new JButton("4"); b4.setBounds(50, 170, 60, 60); p.add(b4);
        b5 = new JButton("5"); b5.setBounds(120, 170, 60, 60); p.add(b5);
        b6 = new JButton("6"); b6.setBounds(190, 170, 60, 60); p.add(b6);
        bFact = new JButton("!"); bFact.setBounds(260, 170, 60, 60); p.add(bFact);

        // --- FILA 3 ---
        b1 = new JButton("1"); b1.setBounds(50, 240, 60, 60); p.add(b1);
        b2 = new JButton("2"); b2.setBounds(120, 240, 60, 60); p.add(b2);
        b3 = new JButton("3"); b3.setBounds(190, 240, 60, 60); p.add(b3);
        circButton = new JButton("Circ"); circButton.setBounds(260, 240, 60, 60); p.add(circButton);

        // --- FILA 4 ---
        b0 = new JButton("0"); b0.setBounds(50, 310, 60, 60); p.add(b0);
        dotButton = new JButton("."); dotButton.setBounds(120, 310, 60, 60); p.add(dotButton);
        sumButton = new JButton("+"); sumButton.setBounds(190, 310, 60, 60); p.add(sumButton);
        c = new JButton("C"); c.setBounds(260, 310, 60, 60); p.add(c);

        // --- FILA 5 (IGUAL) ---
        equalsButton = new JButton("=");
        equalsButton.setBounds(50, 380, 270, 60);
        p.add(equalsButton);
    }

    // Método para actualizar la pantalla (Encapsulamiento) [cite: 77]
    public void setDisplayText(String val) {
        text.setText(val);
    }

    // Método para vincular el controlador a todos los botones de una vez [cite: 85]
    public void setActionListener(ActionListener listener) {
        JButton[] buttons = {
            b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
            equalsButton, sumButton, c, dotButton, circButton, bFact, bExp
        };
        for (JButton btn : buttons) {
            btn.addActionListener(listener);
        }
    }
}