public class RerservaJantar extends Reserva{

    private float precoJantar;


    public RerservaJantar(int qtdPessoas) {
        super(qtdPessoas);
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Preço por pessoa: " + this.precoJantar);
    }
}
