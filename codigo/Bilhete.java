package codigo;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Bilhete {
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected double preco;
    protected Date vencimento;
    protected ArrayList<Voo> Voo;
    private Cliente idCliente;

    public Bilhete(Date dataVencimento, Cliente cliente, int bilhete, int voos, int pontos, double preco) {
        this.vencimento = dataVencimento;
        this.idCliente = cliente;
        this.qtdeVoo = voos;
        this.pontosFidelidade = pontos;
        this.preco = preco;
    }

    public Voo addVoo(int idVoo) {
        return 0;
    }

    public int verificaVoos() {
        return 0;
    }

    public abstract double calcularPreco();

    public abstract int calcularPontos(Bilhete viagens);
}
