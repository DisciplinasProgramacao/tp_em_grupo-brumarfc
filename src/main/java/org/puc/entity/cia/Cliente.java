package org.puc.entity.cia;

import org.puc.entity.bilhete.Bilhete;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private Date aniversario;
    private ArrayList<Bilhete> viagens;
}