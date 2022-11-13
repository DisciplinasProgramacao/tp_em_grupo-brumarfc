package org.puc;

import java.util.LinkedList;
import java.util.Scanner;

import org.puc.entity.cia.Cliente;
import org.puc.entity.voo.Trecho;
import org.puc.entity.voo.Voo;

public class Main {
    static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    static LinkedList<Trecho> trechos = new LinkedList<Trecho>();
    static LinkedList<Voo> voos = new LinkedList<Voo>();

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
            }
        } while (opcao != 0);
    }

    public static int menu(Scanner teclado) {
        System.out.println("------------------------------------------------------");
        System.out.println("Brumarc Airlines");
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