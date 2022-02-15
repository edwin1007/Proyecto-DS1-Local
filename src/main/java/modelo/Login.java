package modelo;

import java.util.Vector;

public class Login {

    Vector<Operator> listaUsuarios;

    public Login(){
        listaUsuarios = new Vector<>();
    }

    public void agregarUsuario(Operator usuario) {
        listaUsuarios.add(usuario);
    }

    public void verUsuarios(){
        listaUsuarios.forEach(x -> {
            System.out.println(x.getUsuario() + " : " + x.getContr());
        });
    }
}

