package controlador;

import modelo.modeloCalculadora;
import vista.vistaCalculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class controladorCalculadora implements ActionListener {
    private modeloCalculadora model;
    private vistaCalculadora view;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	modeloCalculadora model = new modeloCalculadora();
        	vistaCalculadora view = new vistaCalculadora();
            // El controlador se instancia a sí mismo y conecta las partes
            new controladorCalculadora(model, view);
            view.setVisible(true);
        });
    }
    public controladorCalculadora(modeloCalculadora model, vistaCalculadora view) {
        this.model = model;
        this.view = view;
        // Vinculamos el listener a los botones de la vista
        this.view.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        Object source = ev.getSource();

        // Control de números 0-9
        if (source == view.b0) handleNumber(0);
        else if (source == view.b1) handleNumber(1);
        else if (source == view.b2) handleNumber(2);
        else if (source == view.b3) handleNumber(3);
        else if (source == view.b4) handleNumber(4);
        else if (source == view.b5) handleNumber(5);
        else if (source == view.b6) handleNumber(6);
        else if (source == view.b7) handleNumber(7);
        else if (source == view.b8) handleNumber(8);
        else if (source == view.b9) handleNumber(9);

        // Operaciones binarias (requieren dos números)
        else if (source == view.sumButton) prepareOperation("s");
        else if (source == view.bExp) prepareOperation("e");

        // Operaciones unarias (se ejecutan al momento)
        else if (source == view.bFact) handleFactorial();
        else if (source == view.circButton) handleCircumference();

        // Botones de control
        else if (source == view.dotButton) handleDot();
        else if (source == view.c) handleClear();
        else if (source == view.equalsButton) handleEquals();
    }

    private void handleNumber(int num) {
        if (model.getDotDigits() == 0) {
            model.setCurrent(model.getCurrent() * 10 + num);
        } else if (model.getDotDigits() < 10) {
            model.setCurrent(model.getCurrent() + num * Math.pow(10, -model.getDotDigits()));
            model.setDotDigits(model.getDotDigits() + 1);
        }
        updateDisplay();
    }

    private void prepareOperation(String op) {
        // Ejecuta la operación anterior si ya había una pendiente
        if (model.getOperation().equals("s")) model.setMemory(model.getMemory() + model.getCurrent());
        else if (model.getOperation().equals("e")) model.setMemory(model.calculatePower(model.getMemory(), model.getCurrent()));
        else model.setMemory(model.getCurrent());

        model.setCurrent(0);
        model.setDotDigits(0);
        model.setOperation(op);
        updateDisplay();
    }

    private void handleEquals() {
        if (model.getOperation().equals("s")) {
            model.setCurrent(model.getMemory() + model.getCurrent());
        } else if (model.getOperation().equals("e")) {
            model.setCurrent(model.calculatePower(model.getMemory(), model.getCurrent()));
        }
        model.setOperation("n");
        model.setDotDigits(0);
        updateDisplay();
    }

    private void handleFactorial() {
        try {
            int result = model.calculateFactorial(model.getCurrent());
            model.setCurrent(result);
            model.setOperation("n");
            model.setDotDigits(0);
            updateDisplay();
        } catch (Exception e) {
            view.setDisplayText("Error");
        }
    }

    private void handleCircumference() {
        // Lógica original: 3.14159 * 2 * radio
        model.setCurrent(3.14159 * 2 * model.getCurrent());
        model.setOperation("n");
        model.setDotDigits(0);
        updateDisplay();
    }

    private void handleDot() {
        if (model.getDotDigits() == 0) {
            model.setDotDigits(1);
        }
        updateDisplay();
    }

    private void handleClear() {
        model.setCurrent(0);
        model.setMemory(0);
        model.setDotDigits(0);
        model.setOperation("n");
        updateDisplay();
    }

    private void updateDisplay() {
        // Formatea el texto para mostrar decimales solo si existen
        if (model.getDotDigits() > 1) {
            view.setDisplayText(String.format("%." + (model.getDotDigits() - 1) + "f", model.getCurrent()));
        } else {
            view.setDisplayText(String.valueOf((int) model.getCurrent()));
        }
    }
}