public interface ContaTarifavel extends ContaEssencial {

    public void tarifa(double valor) throws ContaException;
    
}
