public class App {
    public static void main(String[] args) throws Exception {
        //testar as classes
        Agencia agencia = new Agencia("1234");
        ContaCorrente cc = new ContaCorrente(agencia, "1234", 1000, 500);
        ContaPoupanca cp = new ContaPoupanca(agencia, "1234", 1000);
        ContaSalario cs = new ContaSalario("1234", 1000, agencia);
        //testar os métodos herdados e imprimir o saldo
        cc.saque(300);
        cp.saque(200);
        cs.saque(100);
        cc.deposito(200);
        cp.deposito(400);
        cs.deposito(300);
        System.out.println("Saldo conta corrente:" + cc.getSaldo());
        System.out.println("Saldo conta poupança:" + cp.getSaldo());
        System.out.println("Saldo conta salario:" + cs.getSaldo());
        cc.tarifa(10);
        cp.atualizarRendimento(0.01);
        System.out.println("Saldo conta corrente:" + cc.getSaldo());
        System.out.println("Saldo conta poupança:" + cp.getSaldo());
        System.out.println("Saldo conta salario:" + cs.getSaldo());
    }
}
