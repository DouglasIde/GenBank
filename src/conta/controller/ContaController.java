package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.IContaRepository;

public class ContaController implements IContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if(conta != null) {
			conta.visualizar();
		} else {
			System.out.println("A Conta número: " + numero + " não foi encontrada!");
		}
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A Conta número " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());

		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A Conta número: " + conta.getNumero() + " foi atualizada com Sucesso!");
		} else {
			System.out.println("A Conta número: " + conta.getNumero() + " não foi encontrada!");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if(conta != null) {
			if(listaContas.remove(conta) == true) 
				System.out.println("A Conta número: " + numero + " foi deletada com sucesso!");
		} else 
			System.out.println("A conta número: " + numero + " não foi encontrado!");
	}



	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if(conta != null) {
			if(conta.sacar(valor) == true) 
				System.out.println("O Saque na Conta numero: " + numero + " foi efetuado com sucesso!");
		} else 
			System.out.println("A Conta número: " + numero + " não foi encontrado!"); 
	}


	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if(conta != null) {
			conta.depositar(valor);
			System.out.println("O Depósito na Conta Número: " + numero + " foi efetuado com sucesso!");
		} else 
			System.out.println("A Conta Número: " + numero + " NÃO foi encontrada ou a Conta destino NÃO é uma Conta Corrente!");

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("A Transferência foi efetuada com Sucesso!");
			}
		} else {
			System.out.println("A conta de Origem e/ou Destino NÃO foram encontradas!");
		}

	}

	public int gerarNumero() {
		return++ numero;
	}

	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
