package org.puc;
import org.puc.entity.bilhete.Bilhete;
import org.puc.entity.bilhete.BilheteFidelidade;
import org.puc.entity.bilhete.BilhetePromocional;
import org.puc.entity.bilhete.BilheteSimples;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;

import org.puc.entity.bilhete.Bilhete;
import org.puc.entity.cia.Cliente;
import org.puc.entity.voo.Trecho;
import org.puc.entity.voo.Voo;

public class Main {
    static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    static LinkedList<Trecho> trechos = new LinkedList<Trecho>();
    static LinkedList<Voo> voos = new LinkedList<Voo>();
    static LinkedList<Bilhete> bilhetes = new LinkedList<Bilhete>();

    public static int menu(Scanner teclado) {
        System.out.println("------------------------------------------------------");
        System.out.println("BrumarFC Airlines");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar trecho");
        System.out.println("3 - Cadastrar voo");
        System.out.println("99 - Popular class");
        System.out.println("0 - Sair");
        System.out.println("------------------------------------------------------");

        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            opcao = menu(sc);
            switch (opcao) {
                case 1:
                    Cliente novoCliente = cadastrarCliente(sc);
                    clientes.add(novoCliente);
                    break;
                case 2:
                    Trecho novoTrecho = cadastrarTrecho(sc);
                    trechos.add(novoTrecho);
                    break;
                case 3:
                    Voo novoVoo = cadastrarVoo(sc);
                    voos.add(novoVoo);
                case 99: 
                    clientes.add(new Cliente("lucas", "123456", "20309"));
                    clientes.add(new Cliente("laura", "123457", "24343"));
                    clientes.add(new Cliente("monica", "123458", "24343"));
                    clientes.add(new Cliente("joão", "123459", "24343"));
                    clientes.add(new Cliente("maria", "123461", "24343"));
                    
                    trechos.add(new Trecho("belo horizonte", "maldivas"));
                    trechos.add(new Trecho("sao paulo", "santa catarina"));
                    trechos.add(new Trecho("dublin", "roraima"));
                    trechos.add(new Trecho("fortaleza", "nova iorque"));
                    trechos.add(new Trecho("natal", "rio de janeiro"));
                    
                    Voo voo = new Voo("1221");
                    voo.addTrecho(recuperarTrechos(1));
                    voos.add(voo);

                    voo = new Voo("1222");
                    voo.addTrecho(recuperarTrechos(2));
                    voos.add(voo);

                    voo = new Voo("1223");
                    voo.addTrecho(recuperarTrechos(3));
                    voos.add(voo);

                    voo = new Voo("1224");
                    voo.addTrecho(recuperarTrechos(4));
                    voos.add(voo);

                    voo = new Voo("1225");
                    voo.addTrecho(recuperarTrechos(5));
                    voos.add(voo);

                    LinkedList<Voo> voosBilhete = new LinkedList<Voo>();
                    voosBilhete.add(voos.get(1));
                    voosBilhete.add(voos.get(3));


                    Bilhete bilheteProm = new BilhetePromocional("24/04/2022", clientes.get(1), 34, new BigDecimal(345.50), voosBilhete);
                    bilhetes.add(bilheteProm);

                    Bilhete bilheteFidel = new BilheteFidelidade("23/05/2025", clientes.get(3), 22, new BigDecimal(280.00), voosBilhete);
                    bilhetes.add(bilheteFidel);

                    Bilhete bilheteSimples = new BilheteSimples("20/03/2030", clientes.get(5), 12, new BigDecimal(120.88), voosBilhete);
                    bilhetes.add(bilheteSimples);

                    LinkedList<Voo> voosBilhete2 = new LinkedList<Voo>();
                    voosBilhete2.add(voos.get(0));
                    voosBilhete2.add(voos.get(2));

                    Bilhete bilheteSimples2 = new BilheteSimples("23/05/2022", clientes.get(0), 12, new BigDecimal(120.88), voosBilhete2);
                    bilhetes.add(bilheteSimples2);

                    Bilhete bilheteProm2 = new BilhetePromocional("24/09/2022", clientes.get(2), 34, new BigDecimal(345.50), voosBilhete2);
                    bilhetes.add(bilheteProm2);

                    Bilhete bilheteFidel2 = new BilheteFidelidade("23/02/2025", clientes.get(4), 22, new BigDecimal(280.00), voosBilhete2);
                    bilhetes.add(bilheteFidel2);
            }
        } while (opcao != 0);
    }


    // Métodos Switches

    public static Cliente cadastrarCliente(Scanner sc) {
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = sc.nextLine();
        System.out.println("Informe a data de nascimento:");
        String aniversario = sc.nextLine();
        return new Cliente(nome, cpf, aniversario);
    }

    public static Trecho cadastrarTrecho(Scanner sc) {
        System.out.println("Informe a origem:");
        String origem = sc.nextLine();
        System.out.println("Informe o destino:");
        String destino = sc.nextLine();
        return new Trecho(origem, destino);
    }

    public static Voo cadastrarVoo(Scanner sc) {
        int opcao;
        System.out.println("Informe a data do voo:");
        String data = sc.nextLine();
        Voo voo = new Voo(data);
        do {
            opcao = menu(sc);
            System.out.println(" 1 - Vincular trechos:");
            System.out.println("2 - Todos os trechos já cadastrados!");
            if (opcao == 1) {
                System.out.println("Informe a identificação do trecho:");
                int idTrecho = sc.nextInt();
                Trecho trecho = recuperarTrechos(idTrecho);
                if (trecho != null) {
                    voo.addTrecho(trecho);
                } else
                    System.out.println("Trecho não encontrado.");
            }
        } while (opcao != 2);
        return voo;
    }

    public static Trecho recuperarTrechos(int idTrecho) {
        for (Trecho trecho : trechos) {
            if (trecho.getIdTrecho() == idTrecho) {
                return trecho;
            }
        }
        return null;
    }

}