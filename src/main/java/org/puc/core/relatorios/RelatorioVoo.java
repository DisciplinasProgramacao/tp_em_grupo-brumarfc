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

    public String relatorioDeVoosUmaCidadeCemVoos(LinkedList<Voo> voos, Date data, String cidade){
        StringBuilder message = new StringBuilder();

        voos.stream()
                .filter(v -> v.getPassagens().size() > 100 && v.getTrechos().stream().anyMatch(t -> t.getDestino().equalsIgnoreCase(cidade)))
                .filter(v -> {
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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

    public String clienteComMaisPontos(LinkedList<Cliente> clientes) {
        return clientes.stream().max(Comparator.comparing(Cliente::getQtdePontos)).toString();
    }
}
