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
				leitura.close();
				System.exit(0);
			}
			
			
		}
	}

}
