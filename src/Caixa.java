import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Caixa {

    private Scanner entrada = new Scanner(System.in);

    private ArrayList<Conta> contas;

    public Caixa(){
        contas = new ArrayList<>();
    }

    public void cadastrarContaSaldo(){

        System.out.println("Digite seu nome:\n");
        String nome = entrada.nextLine();

        System.out.println("Digite seu cpf:\n");
        String cpf = entrada.nextLine();

        System.out.println("Digite o saldo:\n");
        int saldo = Integer.parseInt(entrada.nextLine());

        Cliente cliente = new Cliente(nome, cpf);
        Conta conta = new Conta(saldo, 1000, cliente, 0);
        
        contas.add(conta);
       
        System.out.println("Conta criada!\n" + "O numero da sua conta é: " + conta.getNumeroConta());
    }

    public void cadastrarContaSemSaldo(){

        System.out.println("Digite seu nome:\n");
        String nome = entrada.nextLine();

        System.out.println("Digite seu cpf:\n");
        String cpf = entrada.nextLine(); 

        Cliente cliente = new Cliente(nome, cpf);
        Conta conta = new Conta(1000, cliente, 0);
        
        contas.add(conta);

        System.out.println("Conta criada!\n" + "O numero da sua conta é: " + conta.getNumeroConta());
    }

    public void consultarSaldo(){

        System.out.println("Digite o numero da conta:\n");
        int numero = Integer.parseInt(entrada.nextLine());
        
        boolean contaEncontrada = false;

        for(Conta c : contas){
            if(c.getNumeroConta() == numero){
                System.out.println("Conta do cliente: " + c.getNumeroConta() + " " + "O saldo da sua conta eh: " + c.getSaldo());
                contaEncontrada = true;
            }
        }
        if(!contaEncontrada){
            System.out.println("Conta nao encontrada \n");
        }
    }

    public void depositar(){

        System.out.println("Digite o numero da conta:\n");
        int numero = Integer.parseInt(entrada.nextLine());

        System.out.println("Digite o quanto deseja depositar:\n ");
        int valor = Integer.parseInt(entrada.nextLine());
        
        boolean contaEncontrada = false;

        for(Conta c : contas){
            if(c.getNumeroConta() == numero){
                c.deposito(valor);
                System.out.println("Deposito concluido!\n ");
                contaEncontrada = true;
            }
        }
        if(!contaEncontrada){
            System.out.println("Conta nao encontrada!\n ");
        }
    }

    public void sacar(){
        
        System.out.println("Digite o numero da conta:\n");
        int numero = Integer.parseInt(entrada.nextLine());

        System.out.println("Digite o valor que deseja sacar:\n ");
        int valor = Integer.parseInt(entrada.nextLine());

        boolean contaEncontrada = false;

        for(Conta c : contas){
            if(c.getNumeroConta() == numero){
                c.saque(valor);
                System.out.println("saque concluido!\n ");
                contaEncontrada = true;
            }
        }
        if(!contaEncontrada){
            System.out.println("Conta nao encontrada!\n ");
        }
    }

    public void transferir() {
        System.out.println("Digite o numero da conta de origem:");
        int numeroOrigem = Integer.parseInt(entrada.nextLine());
    
        System.out.println("Digite o numero da conta de destino:");
        int numeroDestino = Integer.parseInt(entrada.nextLine());
    
        System.out.println("Digite o valor da transferencia:");
        int valor = Integer.parseInt(entrada.nextLine());
    
        Conta contaOrigem = null;
        Conta contaDestino = null;
    
        for (Conta c : contas) {
            if (c.getNumeroConta() == numeroOrigem) {
                contaOrigem = c;
            }
            if (c.getNumeroConta() == numeroDestino) {
                contaDestino = c;
            }
        }
    
        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.getSaldo() >= valor) {
                contaOrigem.transferencia(valor, contaOrigem, contaDestino);
                System.out.println("Transferencia concluida com sucesso");
            } else {
                System.out.println("Saldo insuficiente na conta de origem");
            }
        } else {
            System.out.println("Contas não existem");
        }
    }
    
    public void listaContasCriadas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta criada.");
        } else {
            for (Conta c : contas) {
                if (c != null) {
                    System.out.println("Conta do cliente: " + c.getNomeCliente() + " - Número da conta: " + c.getNumeroConta());
                }
            }
        }
    }

    public void removerConta(){
        System.out.println("Informe o numero da conta a ser excluida: ");
        int numero = Integer.parseInt(entrada.nextLine());

        Iterator<Conta> it = contas.iterator();
        
        while(it.hasNext()){
            Conta c = it.next();
            if(c.getNumeroConta() == numero){
                if(c.getSaldo() == 0){
                    it.remove();
                    c.contaRemovida();
                    System.out.println("Conta excluida");
                }
                if(c.getSaldo() > 0){
                    System.out.println("Conta nao pode ser excluida: Saldo existente");
                }
                if(c.getSaldo() < 0){
                    System.out.println("Nao é possivel cancelar contas em debito");
                }
            }
        }
    }

    public void consultaNome() {
        System.out.println("Digite o nome do cliente:");
        String nome = entrada.nextLine();

        boolean contaEncontrada = false;

        for (Conta conta : contas) {
            if (conta.getNomeCliente().contains(nome)) {
                System.out.println("Número da Conta: " + conta.getNumeroConta() + " " + "Nome do Cliente: " + conta.getNomeCliente());
                contaEncontrada = true;
            }
        }
        if(!contaEncontrada){
            System.out.println("Conta nao encontrada");
        }
    }
}