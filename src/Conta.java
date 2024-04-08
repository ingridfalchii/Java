public class Conta {
    
    private int saldo;
    private int limite = -1000;
    private Cliente cliente;
    private static int ultimoNumero = 100;
    private int numeroConta;


    public Conta(int saldo, int limite, Cliente cliente, int numeroConta){
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
        this.numeroConta = ultimoNumero;
        ultimoNumero++;
    }
    public Conta(int limite, Cliente cliente, int numeroConta){
        this(0, limite, cliente, ultimoNumero);
    }

    public int getSaldo(){
        return saldo;
    }

    public int getLimite(){
        return limite;
    }

    public void deposito(int valor){
        saldo+=valor;
    }

    public void saque(int valor){
        if(valor <= saldo){
            saldo-=valor;
        }
    }

    public String getNomeCliente(){
        return cliente.getNome();
    }
    
    public Cliente cliente(){
        return cliente;
    }

    public int getNumeroConta(){
        return numeroConta;
    }

    public void transferencia(int valor, Conta contaOrigem, Conta contaDestino){
        contaOrigem.saque(valor);    
        contaDestino.deposito(valor);    
    }

    public void contaRemovida(){
        ultimoNumero--;
    }
}