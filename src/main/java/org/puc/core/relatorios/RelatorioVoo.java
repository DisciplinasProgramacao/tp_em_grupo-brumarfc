package org.puc.core.relatorios;

import org.puc.core.bilhete.Bilhete;
import org.puc.core.cia.Cliente;
import org.puc.core.voo.Voo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class RelatorioVoo {

    public String relatorioDeVoosUmaCidadeCemVoos(LinkedList<Voo> voos, Date data, String cidade) {
        StringBuilder message = new StringBuilder();

        voos.stream()
                .filter(v -> v.getPassagens().size() > 100
                        && v.getTrechos().stream().anyMatch(t -> t.getDestino().equalsIgnoreCase(cidade)))
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

    public String relatorioValorArrecadado(int date, LinkedList<Bilhete> bilhetes) {

        if (date != -1) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, date);
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            Calendar calendar2 = calendar;
            calendar2.add(Calendar.MONTH, 1);

            return bilhetes.stream()
                    .filter(b -> b.getDataVencimento().after(calendar.getTime())
                            && b.getDataVencimento().before(calendar2.getTime()))
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
        Calendar calendar = Calendar.getInstance();
        Calendar c2 = calendar;
        c2.add(Calendar.YEAR, -1);
        try{
            return clientes
                    .stream()
//                    .filter(c -> c.getViagens().stream().anyMatch(b -> b.getDataVencimento().before(calendar.getTime()) && b.getDataVencimento().after(c2.getTime())))
                    .max(Comparator.comparing(Cliente::getQtdePontos))
                    .orElseThrow()
                    .relatorio();
        }catch (NoSuchElementException e){
            return "cliente não encontrado";
        }
    }

    public List<Bilhete> bilhetesUltimoAno(Cliente cliente) {
        
        Calendar hoje =  Calendar.getInstance();
        Calendar umAno = hoje;
        umAno.add(Calendar.YEAR, -1);

        return cliente.getViagens()
                .stream()
                .filter(c -> c.getDataVencimento().after(hoje.getTime()) && c.getDataVencimento().before(umAno.getTime()))
                .collect(Collectors.toList());
        
    }
}
