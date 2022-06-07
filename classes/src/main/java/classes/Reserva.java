package classes;

public class Reserva {

    private int numReserva;
    private String Cliente_cpfCliente;
    private int qtdPessoas;
    private String dataReserva;

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public String getCpfCliente() {
        return Cliente_cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.Cliente_cpfCliente = cpfCliente;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
}