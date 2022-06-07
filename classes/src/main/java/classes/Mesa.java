package classes;

public class Mesa {

    private int numMesa;
    private double preco;
    private String Cliente_cpfCliente;



    public String getCpfCliente() {
        return Cliente_cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.Cliente_cpfCliente = cpfCliente;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}