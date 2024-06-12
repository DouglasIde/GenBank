package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leitura = new Scanner(System.in);

		int opcao;

		while(true) {
			System.out.println("""
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

					""");
			opcao = leitura.nextInt();

			if(opcao == 9) {
				System.out.println("\nA Gen Brazil - O seu Futuro começa aqui!");
				sobre();
				leitura.close();
				System.exit(0);
			}
			switch(opcao) {
			case 1:
				System.out.println("Criar Conta\n");
				break;
			case 2:
				System.out.println("Listar todas as Contas\n");
				break;
			case 3:
				System.out.println("Consultar dados na Conta - por número\n");
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n");
				break;
			case 5:
				System.out.println("Apagar a Conta\n");
				break;
			case 6:
				System.out.println("Saque\n");
				break;
			case 7:
				System.out.println("Depósito\n");
				break;
			case 8:
				System.out.println("Transferência entre Contas\n");
				break;
			default:
				System.out.println("Opção Inválida!!\n");
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
