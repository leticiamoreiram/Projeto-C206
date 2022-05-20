package classes;

public abstract class Reserva {

    public int qtdPessoas;

    public Reserva(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public void mostraInfo(){
        System.out.println("Quantidade de pessoas: " + this.qtdPessoas);
    }



}
