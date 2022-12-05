package org.puc.core.bilhete;

import org.puc.core.voo.Voo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BilhetePromocional extends Bilhete implements Serializable{
    
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
     * Construtor simples: Cria um bilhete do tipo Promocional.
     * @param dataVencimento data de vencimento do bilhete
     * @param pontos Pontos que serão gerados
     * @param preco Preço do bilhete
     * @param voos Voos atrelados ao bilhete
     * @param id Identificador do bilhete
     */
    public BilhetePromocional(Date dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id) {
        super(dataVencimento, pontos, preco, voos, id);
        this.vencimento = dataVencimento;
        this.idBilhete = id;
        this.pontosFidelidade = pontos.intValue();
    }
    // #endregion

    // #region Métodos de funcionamento

    /**
     * Calcula preco do bilhete promocional
     * @return preco do bilhete calculado
     */
    @Override
    public BigDecimal calcularPreco() {
        if (voo.isEmpty()){
            this.preco = BigDecimal.ZERO;
        }

        else if (voo.size() == 1){
            this.preco = voo.stream().findFirst().get().getPrecoBase().multiply(BigDecimal.valueOf(0.1));
        }
        else {
            List<Voo> auxVoo = voo;

            Voo maisCaro = auxVoo.stream().max(Comparator.comparing(Voo::getPrecoBase)).get();
            auxVoo.remove(maisCaro);

            preco = maisCaro.getPrecoBase();

            for (Voo v : auxVoo) {
                BigDecimal meioPreco = v.getPrecoBase().divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);

                preco = preco.add(meioPreco);
            }
        }
        //calculando valor especial do bilhete promocional
        this.preco = preco.multiply(BigDecimal.valueOf(0.6));
        return this.preco;
    }

    /**
     * @param viagens — viagem que deve ser calculada
     * @return a quantidade de pontos do bilhete
     */
    @Override
    public BigDecimal calcularPontos(Bilhete viagens) {
        BigDecimal pontos;

        int i = preco.divide(viagens.getPrecoBilheteEmPts(), 500, RoundingMode.DOWN).intValue();

        pontos = BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(500));

        pontos = pontos.multiply(BigDecimal.valueOf(0.5));

        this.pontosFidelidade = pontos.intValue();
        return pontos;
    }
    // #endregion
}
