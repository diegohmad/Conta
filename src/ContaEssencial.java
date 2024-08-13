public interface ContaEssencial {

    public void saque(double valor) throws ContaException;

    public void deposito(double valor) throws ContaException;

    public String getNumeroConta(); 

    public double getSaldo();

    public void setSaldo(double saldo);

    public Agencia getAgencia();

    public void setAgencia(Agencia agencia);
    
}

