public class ContaCorrente implements ContaTarifavel{

    private Agencia agencia;
    private String numeroConta;
    private double saldo;
    private double limiteChequeEspecial;

    public ContaCorrente(Agencia agencia, String numeroConta, double saldo, double limiteChequeEspecial) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void saque(double valor) throws ContaException {
        if (valor > 0) {
            if (valor <= (this.saldo + this.limiteChequeEspecial)) {
                this.saldo -= valor;
            } else {
                throw new ContaException("Saldo insuficiente para saque "+valor);
            }
        } else {
            throw new ContaException("Valor inválido para saque "+valor);
        }
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
    public void tarifa(double valor) throws ContaException {
        //sempre cobra a tarifa mas verifica se o valor é maior que zero
        if (valor > 0) {
            this.saldo -= valor;
        } else {
            throw new ContaException("Valor inválido para tarifa "+valor);
        }
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
        return "ContaCorrente{" + "agencia=" + agencia + ", numeroConta=" + numeroConta + ", saldo=" + saldo + ", limiteChequeEspecial=" + limiteChequeEspecial + '}';
    }
}
