package codigo;

import java.util.ArrayList;
import java.sql.Date;

public class BilhetePromocional extends Bilhete {
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected double preco;
    protected Date vencimento;
    protected ArrayList<Voo> Voo;
    private Cliente idCliente;

    public BilhetePromocional(Date dataVencimento, Cliente cliente, int bilhete, int voos, int pontos, double preco) {
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
