import java.util.ArrayList;
import java.util.List;

public class Agencia {
   @SuppressWarnings("unused")
   private String numero;
   private List<ContaEssencial> contasEsssenciais = new ArrayList<>();
   private List<ContaRentavel> contasRentaveis = new ArrayList<>();

   public Agencia(String numero) {
      this.numero = numero;
   }

   public void addContaEssencial(ContaEssencial conta) {
      contasEsssenciais.add(conta);
   }

   public void addContaRentavel(ContaRentavel conta) {
      contasRentaveis.add(conta);
   }

   public void saque(String numeroConta, double valor) throws ContaException {
      ContaEssencial conta = getConta(numeroConta);
      conta.saque(valor);
   }

   public void deposito(String numeroConta, double valor) throws ContaException {
      ContaEssencial conta = getConta(numeroConta);
      conta.deposito(valor);
   }

   public void atualizarRendimento(double taxa) {
      for (ContaRentavel conta : contasRentaveis) {
         conta.atualizaRendimento(taxa);
      }
   }

   private ContaEssencial getConta(String numeroConta) throws ContaException {
      for (ContaEssencial conta : contasEsssenciais) {
         if (conta.getNumeroConta().equals(numeroConta)) {
            return conta;
         }
      }
      for (ContaRentavel conta : contasRentaveis) {
         if (conta.getNumeroConta().equals(numeroConta)) {
            return conta;
         }
      }
      throw new ContaException("Conta não encontrada");
   }
}
