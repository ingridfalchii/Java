import java.util.Scanner;

public class Menu {
    
    private Scanner entrada = new Scanner(System.in);
    Caixa caixa = new Caixa();

    public void menu(){

        System.out.println(

        "Digite a opçao desejada:\n" + 
        "1) Criar Conta com saldo inicial\n" +
        "2) Criar Conta sem saldo inicial\n" +  
        "3) Consultar Saldo\n" + 
        "4) Depositar\n" + 
        "5) Sacar\n" + 
        "6) Transferir\n" +
        "7) Lista de contas\n" + 
        "8) Excluir conta\n" +
        "9) Consultar conta pelo nome\n" + 
        "10) Sair\n"
        );
    }

    public void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                caixa.cadastrarContaSaldo();
                break;
            case 2:
                caixa.cadastrarContaSemSaldo();
                break;
            case 3:
                caixa.consultarSaldo();
                break;
            case 4:
                caixa.depositar();
                break;
            case 5:
                caixa.sacar();
                break;
            case 6:
                caixa.transferir();
                break;
            case 7:
                caixa.listaContasCriadas();
                break;
            case 8:
                caixa.removerConta();
                break;
            case 9:
                caixa.consultaNome();
                break;
            case 10:
                System.out.println("Saindo do programa...");
                entrada.close();
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void executar(){
        int i = 1;

        while(i!= 10){
            menu();
            int menu = Integer.parseInt(entrada.nextLine());
            tratarMenu(menu);
        }
    }
}
