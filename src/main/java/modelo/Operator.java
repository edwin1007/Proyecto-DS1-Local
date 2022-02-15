package modelo;

public class Operator {

    String usuario;
    String contr;

    public Operator(String usuario, String contr) {
        this.usuario = usuario;
        this.contr = contr;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContr() {
        return contr;
    }

    public void setContr(String contr) {
        this.contr = contr;
    }
}
