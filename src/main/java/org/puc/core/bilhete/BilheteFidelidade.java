package org.puc.core.bilhete;

import org.puc.core.voo.Voo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

public class BilheteFidelidade extends Bilhete implements Serializable{
    
    // #region atributos
    // atributos
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected Date vencimento;
    protected LinkedList<Voo> voo;
    private int idCliente;
    // #endregion

    // #region Construtor

    /**
     * Construtor simples: Cria um bilhete do tipo Fidelidade
     * @param dataVencimento data de vencimento do bilhete
     * @param pontos Pontos que serão gerados
     * @param preco Preço do bilhete
     * @param voos Voos atrelados ao bilhete
     * @param id Identificador do bilhete
     */
    public BilheteFidelidade(Date dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id) {
        super(dataVencimento, pontos, preco, voos, id);
    }
    // #endregion

    // #region Métodos de funcionamento

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
    // #endregion
}
