package org.puc.entity.bilhete;

import org.puc.entity.voo.Voo;
import org.puc.entity.cia.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BilheteSimples extends Bilhete implements Serializable{
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected Date vencimento;
    protected LinkedList<Voo> voo;
    private int idCliente;

    public BilheteSimples(String dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id) {
        super(dataVencimento, pontos, preco, voos, id);

    }

    /**
     * Calcula preco do bilhete simples
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
        return this.preco;
    }

    /**
     * @param viagem — viagem que deve ser calculada
     * @return a quantidade de pontos do bilhete
     */
    @Override
    public BigDecimal calcularPontos(Bilhete viagem) {
        BigDecimal pontos;

        int i = preco.divide(viagem.getPrecoBilheteEmPts(), 500, RoundingMode.DOWN).intValue();

        pontos = BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(500));

        this.pontosFidelidade = pontos.intValue();
        return pontos;
    }

}
