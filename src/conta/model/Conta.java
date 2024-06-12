package conta.model;

public class Conta {

	private int numero, agencia, tipo;
	private String titular;
	private float saldo;
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	// MÉTODOS SACAR / DEPOSITAR / VISUALIZAR
	
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println("Saldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("Saque bem sucedido");
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
		System.out.println("Depósito bem sucedido");
	}
	
	public void visualizar() {
		String tipo = "";
	}
	
	
}