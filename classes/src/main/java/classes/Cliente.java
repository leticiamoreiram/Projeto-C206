package classes;

public class Cliente {

    private String nome;
    private String email;
    private String cpfCliente;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpf) {
        this.cpfCliente = cpf;
    }

}
