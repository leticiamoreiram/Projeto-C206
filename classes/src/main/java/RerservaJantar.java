public class RerservaJantar extends Reserva{

    private float precoJantar;

    public RerservaJantar(int qtdPessoas, float precoJantar) {
        super(qtdPessoas);
        this.precoJantar = precoJantar;
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Preço por pessoa: " + this.precoJantar);
    }

    public float getPrecoJantar() {
        return precoJantar;
    }

    public void setPrecoJantar(float precoJantar) {
        this.precoJantar = precoJantar;
    }
}
