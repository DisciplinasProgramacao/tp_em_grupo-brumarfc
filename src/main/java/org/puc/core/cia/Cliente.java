package org.puc.core.cia;

import org.puc.core.bilhete.Bilhete;
import org.puc.core.bilhete.BilheteFidelidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;

public class Cliente implements Serializable {
    private int idCliente;
    private BigDecimal qtdePontos;
    private String nome;
    private String cpf;
    private String aniversario;
    private LinkedList<Bilhete> viagens;

    public Cliente (String nom, String cpf, String aniversario, int id){
        this.nome = nom;
        this.cpf = cpf;
        this.aniversario = aniversario;
        this.idCliente = id;
        this.qtdePontos = new BigDecimal(0);
        viagens = new LinkedList<Bilhete>();
    }

    public BigDecimal comprarBilhete(Bilhete bilhete) throws Exception{
        BigDecimal preco;
        if (bilhete instanceof BilheteFidelidade) {
            if (this.qtdePontos.intValue() < bilhete.getPrecoBilheteEmPts().intValue())  {
                throw (new Exception("Quantidade de pontos insuficiente"));
            }
            preco = BigDecimal.ZERO;
            this.qtdePontos = this.qtdePontos.subtract(this.qtdePontos);
        }
        else {
            this.qtdePontos = this.qtdePontos.add(bilhete.calcularPontos(bilhete).multiply(bilhete.getAcelerador()));
            preco = bilhete.getPreco().add(bilhete.getPrecoAcelerador());
        }
        // Vincula o bilhete ao cliente e add o bilhete na sua lista de viagens
        viagens.add(bilhete);
        bilhete.vender(this);
        return preco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public BigDecimal getQtdePontos() {
        return qtdePontos;
    }

    public String relatorio(){
        return "ID do Cliente: " + this.idCliente + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nAniversário: " + this.aniversario + "\nViagens: " + this.viagens.toString();    
    }
}
