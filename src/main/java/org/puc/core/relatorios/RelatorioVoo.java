package org.puc.core.relatorios;

import org.puc.core.bilhete.Bilhete;
import org.puc.core.cia.Cliente;
import org.puc.core.voo.Voo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

public class RelatorioVoo {

    //#region Métodos de funcionamento
    /**
     * Relatório de voos para uma cidade, em uma data, com mais de 100 reservas
     * @param voos Lista de Voos
     * @param data Data 
     * @param cidade Cidade dos voos
     * @return Relatório
     */
    public String relatorioDeVoosUmaCidadeCemVoos(LinkedList<Voo> voos, Date data, String cidade){
        StringBuilder message = new StringBuilder();

        voos.stream()
                .filter(v -> v.getPassagens().size() > 100 && v.getTrechos().stream().anyMatch(t -> t.getDestino().equalsIgnoreCase(cidade)))
                .filter(v -> {
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date date;
                    try {
                        date = df.parse(v.getData());
                    } catch (ParseException e) {
                        date = new Date();
                    }

                    return date.compareTo(data) >= 0;
                }).forEach(t -> {
                    message.append(t.toString()).append("/n");
                });

        return message.toString();
    }


    /**
    * Relatório de valores arrecadados com bilhetes pela empresa por mês escolhido ou desde o início de funcionamento da empresa
    * @param date Mês a ser verificado
    * @param bilhetes Lista de bilhetes
    * @return Valor arrecadado
    */
    public String relatorioValorArrecadado(int date, LinkedList<Bilhete> bilhetes) {

        if (date != -1) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, date);
            calendar.set(Calendar.DAY_OF_MONTH, 1);


            Calendar calendar2 = calendar;
            calendar2.add(Calendar.MONTH, 1);

            return bilhetes.stream()
                    .filter(b -> b.getDataVencimento().after(calendar.getTime()) && b.getDataVencimento().before(calendar2.getTime()))
                    .map(Bilhete::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .toPlainString();
        }

        return bilhetes.stream()
                .map(Bilhete::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .toPlainString();
    }

    /**
     * Filtra e encontra o cliente com mais pontos
     * @param clientes Lista de clientes
     * @return Cliente com mais pontos
     */
    public String clienteComMaisPontos(LinkedList<Cliente> clientes) {
        return clientes.stream().max(Comparator.comparing(Cliente::getQtdePontos)).toString();
    }
}
