package org.puc.entity.bilhete;

import org.puc.entity.voo.Voo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public abstract class Bilhete {
    private int idCliente;
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected BigDecimal preco;
    protected Date vencimento;
    protected List<Voo> voo;

    public Bilhete(Date dataVencimento, int cliente, int bilhete, int voos, int pontos, BigDecimal preco) {
        this.vencimento = dataVencimento;
        this.idCliente = cliente;
        this.qtdeVoo = voos;
        this.pontosFidelidade = pontos;
        this.preco = preco;
    }

    public Voo addVoo(int idVoo) {
        return null;
    }

    public int verificaVoos() {
        return 0;
    }

    public abstract BigDecimal calcularPreco();

    public abstract BigDecimal calcularPontos(Bilhete viagens);
}
