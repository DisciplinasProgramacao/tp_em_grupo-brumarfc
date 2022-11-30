package org.puc.entity.bilhete;

import org.puc.entity.voo.Voo;
import org.puc.entity.cia.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class BilheteFidelidade extends Bilhete implements Serializable{
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected BigDecimal preco;
    protected Date vencimento;
    protected LinkedList<Voo> voo;
    private int idCliente;

    public BilheteFidelidade(String dataVencimento, Cliente cliente, int pontos, BigDecimal preco, LinkedList<Voo> voos) {
        super(dataVencimento, cliente, pontos, preco, voos);
    }


    /**
     * Calcula preco do bilhete fidelidade
     * @return preco do bilhete calculado
     */
    @Override
    public BigDecimal calcularPreco() {
        this.preco = BigDecimal.ZERO;
        return BigDecimal.ZERO;
    }

    /**
     * @param viagens — viagem que deve ser calculada
     * @return a quantidade de pontos do bilhete
     */
    @Override
    public BigDecimal calcularPontos(Bilhete viagens) {
        this.pontosFidelidade = 0;
        return BigDecimal.ZERO;
    }
}
