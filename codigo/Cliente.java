package codigo;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String aniversario;
    private ArrayList<Bilhete> viagens;

    public Cliente (String nom, String cpf, String aniversario){
        this.nome = nom;
        this.cpf = cpf;
        this.aniversario = aniversario;
    }
}
