package conta;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContaController contas = new ContaController();

		Scanner leitura = new Scanner(System.in);

		// VARIÁVEIS
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;


		while(true) {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + """

					*****************************************************

					GEN BANK BRAZIL                

					*****************************************************

					1 - Criar Conta                          
					2 - Listar todas as Contas               
					3 - Buscar Conta por Numero              
					4 - Atualizar Dados da Conta             
					5 - Apagar Conta                         
					6 - Sacar                                
					7 - Depositar                            
					8 - Transferir valores entre Contas      
					9 - Sair                                 

					*****************************************************
					Entre com a opção desejada:                          

					""" + Cores.TEXT_RESET);

			try {
				opcao = leitura.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leitura.nextLine();
				opcao = 0;
			}


			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nA Gen Bank Brazil - O seu Futuro começa aqui!");
				sobre();
				leitura.close();
				System.exit(0);
			}
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n");
				System.out.println("Digite o Número da Agência: ");
				agencia = leitura.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leitura.skip("\\R?");
				titular = leitura.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1 - CC ou 2 - CP");
					tipo = leitura.nextInt();
				} while(tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leitura.nextFloat();

				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite de Crédito (R$): ");
					limite = leitura.nextInt();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Anviersário da Conta: ");
					aniversario = leitura.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados na Conta - por número\n");
				System.out.println("Digite o número da Conta: ");
				numero = leitura.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n");
				System.out.println("Digite o número da Conta: ");
				numero = leitura.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if(buscaConta != null) {
					tipo = buscaConta.getTipo();

					System.out.println("Digite o Número da Agência: ");
					agencia = leitura.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leitura.skip("\\R?");
					titular = leitura.nextLine();

					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leitura.nextFloat();

					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leitura.nextInt();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = leitura.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de Conta Inválido!!");
					}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida!!\n");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Douglas Yugo - douglasymide@gmail.com");
		System.out.println("https://github.com/DouglasIde");
		System.out.println("*********************************************************");
	}

	// MÉTODOS
	public static void keyPress(){
		try {
			System.out.println(Cores.TEXT_RESET + "Pressione ENTER para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de ENTER!");
		}
	}
}
