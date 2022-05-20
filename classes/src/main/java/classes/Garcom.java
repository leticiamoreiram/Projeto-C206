package classes;

public class Garcom {

    public String nome;
    private String turno;
    private int id;

    public Garcom(String nome, String turno, int id) {
        this.nome = nome;
        this.turno = turno;
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
