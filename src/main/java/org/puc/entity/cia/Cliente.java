package org.puc.entity.cia;

import org.puc.entity.bilhete.Bilhete;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class Cliente implements Serializable {
    private int idCliente;
    private String nome;
    private String cpf;
    private String aniversario;
    private LinkedList<Bilhete> viagens;

    public Cliente (String nom, String cpf, String aniversario, int id){
        this.nome = nom;
        this.cpf = cpf;
        this.aniversario = aniversario;
        this.idCliente = id;

        viagens = new LinkedList<Bilhete>();
    }

    public void comprarBilhete(Bilhete bilhete){
        viagens.add(bilhete);
        bilhete.vender(this);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String relatorio(){
        String desc = "ID do Cliente: " + this.idCliente + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nAniversário: " + this.aniversario + "\nViagens: " + viagens.toString();
        return desc;
    }
}

