package org.puc.entity.bilhete;


import org.puc.entity.voo.Voo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;

public class BilhetePromocional extends Bilhete {
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected BigDecimal preco;
    protected Date vencimento;
    protected List<Voo> voo;
    private int idCliente;

    public BilhetePromocional(Date dataVencimento, int cliente, int bilhete, int voos, int pontos, BigDecimal preco) {
        super(dataVencimento, cliente, bilhete, voos, pontos, preco);
    }

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

        int i = preco.divide(BigDecimal.valueOf(500), 2, RoundingMode.DOWN).intValue();

        pontos = BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(500));

        pontos = pontos.multiply(BigDecimal.valueOf(0.5));

        this.pontosFidelidade = pontos.intValue();
        return pontos;
    }
}
