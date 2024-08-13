public class ContaPoupanca implements ContaRentavel {
    private Agencia agencia;
    private String numeroConta;
    private double saldo;
    
    public ContaPoupanca(Agencia agencia, String numeroConta, double saldo) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    @Override
    public void saque(double valor) throws ContaException {
        if (valor > 0) {
            if (valor <= this.saldo) {
                this.saldo -= valor;
            } else {
                throw new ContaException("Saldo insuficiente para saque "+valor);
            }
        } else {
            throw new ContaException("Valor inválido para saque "+valor);
        }
    }
    
    public void atualizarRendimento(double taxaRendimento){
        this.saldo += this.saldo * taxaRendimento;
    }

    @Override
    public void deposito(double valor) throws ContaException {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new ContaException("Valor inválido para depósito "+valor);
        }
    }

    @Override
    public String getNumeroConta() {
        return this.numeroConta;
    }

    @Override
    public void atualizaRendimento(double taxa) {
        this.saldo += this.saldo * taxa;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Agencia getAgencia() {
        return this.agencia;
    }

    @Override
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" + "agencia=" + agencia + ", numeroConta=" + numeroConta + ", saldo=" + saldo + '}';
    }
}
