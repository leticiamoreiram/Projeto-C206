public class ReservaAlmoco extends Reserva{

    private float precoAlmoco;

    public ReservaAlmoco(int qtdPessoas) {
        super(qtdPessoas);
    }
    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Preço por pessoa: " + this.precoAlmoco);
    }
}
