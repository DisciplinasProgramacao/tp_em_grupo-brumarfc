package org.puc.entity.bilhete;

import org.puc.entity.voo.Voo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class BilheteFidelidade extends Bilhete {
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected BigDecimal preco;
    protected Date vencimento;
    protected List<Voo> voo;
    private int idCliente;

    public BilheteFidelidade(Date dataVencimento, int cliente, int bilhete, int voos, int pontos, BigDecimal preco) {
        super(dataVencimento, cliente, bilhete, voos, pontos, preco);
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
