package modelo;

public class modeloCalculadora {
	private double current = 0;
	private double memory = 0;
	private int dotDigits = 0;
	private String operation = "n"; // s (sum), e (exp), n (none)

	// Lógica matemática (Refactorizada de Main.java)
	public int calculateFactorial(double n) {
		if (n % 1 != 0 || n < 0)
			throw new IllegalArgumentException("Número no válido para factorial");
		int r = 1;
		for (int i = 2; i <= n; i++)
			r *= i;
		return r;
	}

	public double calculatePower(double base, double exponent) {
		if (exponent < 0 || exponent % 1 != 0)
			throw new IllegalArgumentException("Exponente debe ser natural");
		if (base == 0 && exponent == 0)
			throw new ArithmeticException("0^0 es indefinido");
		return Math.pow(base, exponent);
	}

	// Getters y Setters para el estado
	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public int getDotDigits() {
		return dotDigits;
	}

	public void setDotDigits(int dotDigits) {
		this.dotDigits = dotDigits;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String op) {
		this.operation = op;
	}
}