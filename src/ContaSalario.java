public class ContaSalario implements ContaEssencial {
    private String numeroConta;
    private double saldo;
    private Agencia agencia;
    
    public ContaSalario(String numeroConta, double saldo, Agencia agencia) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.agencia = agencia;
    }
    
    @Override
    public void saque(double valor) throws ContaException {
        if (valor > saldo) {
            throw new ContaException("Saldo insuficiente");
        }
        saldo -= valor;
    }
    
    @Override
    public void deposito(double valor) throws ContaException {
        if (valor <= 0) {
            throw new ContaException("Valor inválido");
        }
        saldo += valor;
    }
    
    @Override
    public String getNumeroConta() {
        return numeroConta;
    }
    
    @Override
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public Agencia getAgencia() {
        return agencia;
    }
    
    @Override
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    @Override
    public String toString() {
        return "ContaSalario{" + "numeroConta=" + numeroConta + ", saldo=" + saldo + ", agencia=" + agencia + '}';
    }

}
