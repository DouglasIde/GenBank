package conta;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leitura = new Scanner(System.in);

		// VARIÁVEIS
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;


		while(true) {
			System.out.println(Cores.TEXT_YELLOW + """

*****************************************************

					
░██████╗░███████╗███╗░░██╗  ██████╗░░█████╗░███╗░░██╗██╗░░██╗
██╔════╝░██╔════╝████╗░██║  ██╔══██╗██╔══██╗████╗░██║██║░██╔╝
██║░░██╗░█████╗░░██╔██╗██║  ██████╦╝███████║██╔██╗██║█████═╝░
██║░░╚██╗██╔══╝░░██║╚████║  ██╔══██╗██╔══██║██║╚████║██╔═██╗░
╚██████╔╝███████╗██║░╚███║  ██████╦╝██║░░██║██║░╚███║██║░╚██╗
░╚═════╝░╚══════╝╚═╝░░╚══╝  ╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝

██████╗░██████╗░░█████╗░███████╗██╗██╗░░░░░
██╔══██╗██╔══██╗██╔══██╗╚════██║██║██║░░░░░
██████╦╝██████╔╝███████║░░███╔═╝██║██║░░░░░
██╔══██╗██╔══██╗██╔══██║██╔══╝░░██║██║░░░░░
██████╦╝██║░░██║██║░░██║███████╗██║███████╗
╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝╚═╝╚══════╝            

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
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＣＲＩＡＲ ＣＯＮＴＡ\n");
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
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = leitura.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＬＩＳＴＡＲ ＴＯＤＡＳ ＡＳ ＣＯＮＴＡＳ\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＣＯＮＳＵＬＴＡＲ ＤＡＤＯＳ ＮＡ ＣＯＮＴＡ － ＰＯＲ ＮＵＭＥＲＯ\n");
				System.out.println("Digite o número da Conta: ");
				numero = leitura.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＡＴＵＡＬＩＺＡＲ ＤＡＤＯＳ ＤＡ ＣＯＮＴＡ\n");
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
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＡＰＡＧＡＲ Ａ ＣＯＮＴＡ\n");
				System.out.println("Digite o número da Conta: ");
				numero = leitura.nextInt();
				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＳＡＱＵＥ\n");

				System.out.println("Digite o Número da Conta: ");
				numero = leitura.nextInt();

				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = leitura.nextFloat();
				} while(valor <= 0);

				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＤＥＰＯＳＩＴＡＲ\n");

				System.out.println("Digite o Número da Conta: ");
				numero = leitura.nextInt();

				do {
					System.out.println("Digite o valor do Depósito (R$): ");
					valor = leitura.nextFloat();
				} while(valor <= 9);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "ＴＲＡＮＳＦＥＲＩＲ ＶＡＬＯＲＥＳ ＥＮＴＲＥ ＣＯＮＴＡＳ\n");
				
				System.out.println("Digite o Número da Conta de Origem: ");
				numero = leitura.nextInt();
				
				System.out.println("Digite o Número da Conta de Destino: ");
				numeroDestino = leitura.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = leitura.nextFloat();
				} while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
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

	public static void keyPress(){
		try {
			System.out.println(Cores.TEXT_RESET + "Pressione ENTER para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de ENTER!");
		}
	}
}
