package classes;

public class ReservaAlmoco extends Reserva{

    private float precoAlmoco;

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Preço por pessoa: " + this.precoAlmoco);
    }

    public ReservaAlmoco(int qtdPessoas, float precoAlmoco) {
        super(qtdPessoas);
        this.precoAlmoco = precoAlmoco;
    }

    public float getPrecoAlmoco() {
        return precoAlmoco;
    }

    public void setPrecoAlmoco(float precoAlmoco) {
        this.precoAlmoco = precoAlmoco;
    }
}
