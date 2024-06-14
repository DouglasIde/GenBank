package conta;

import conta.util.Cores;

import conta.model.*;
import java.util.Scanner;


public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ContaCorrente contaCorrente1 = new ContaCorrente(2, 123, 1, "Mariana", 1500f, 1000f);
		
		contaCorrente1.visualizar();
		contaCorrente1.sacar(12000f);
		contaCorrente1.visualizar();
		contaCorrente1.depositar(5000f);
		contaCorrente1.visualizar();
		
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(3,123,2,"Victor", 100000f, 15);
		
		contaPoupanca1.visualizar();
		contaPoupanca1.sacar(1000f);
		contaPoupanca1.visualizar();
		contaPoupanca1.depositar(5000f);
		contaPoupanca1.visualizar();
		
		Scanner leitura = new Scanner(System.in);

		int opcao;

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
			opcao = leitura.nextInt();

			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nA Gen Bank Brazil - O seu Futuro começa aqui!");
				sobre();
				leitura.close();
				System.exit(0);
			}
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados na Conta - por número\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida!!\n");
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
}
