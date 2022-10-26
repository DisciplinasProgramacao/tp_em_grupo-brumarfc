package codigo;

import java.sql.Date;
import java.util.ArrayList;

public class BilheteSimples extends Bilhete {
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected double preco;
    protected Date vencimento;
    protected ArrayList<Voo> Voo;
    private Cliente idCliente;

    public BilheteSimples(Date dataVencimento, Cliente cliente, int bilhete, int voos, int pontos, double preco) {
        super(dataVencimento, cliente, bilhete, voos, pontos, preco);
    }

    @Override
    public double calcularPreco() {
        return 0;
    }

    @Override
    public int calcularPontos(Bilhete viagens) {
        return 0;
    }

}
