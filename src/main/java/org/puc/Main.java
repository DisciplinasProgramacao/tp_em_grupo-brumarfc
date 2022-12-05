package org.puc;

import org.puc.core.bilhete.Bilhete;
import org.puc.core.bilhete.BilheteFidelidade;
import org.puc.core.bilhete.BilhetePromocional;
import org.puc.core.bilhete.BilheteSimples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.puc.core.boost.Type;
import org.puc.core.cia.Cliente;
import org.puc.core.relatorios.RelatorioVoo;
import org.puc.core.voo.Trecho;
import org.puc.core.voo.Voo;

public class Main {
    static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    static LinkedList<Trecho> trechos = new LinkedList<Trecho>();
    static LinkedList<Voo> voos = new LinkedList<Voo>();
    static LinkedList<Bilhete> bilhetes = new LinkedList<Bilhete>();

    static String arqDadosClientes = "dadosClientes.bin";
    static String arqDadosTrechos = "dadosTrechos.bin";
    static String arqDadosVoos = "dadosVoos.bin";
    static String arqDadosBilhetes = "dadosBilhetes.bin";

    public static void gravarDadosClientes(LinkedList<Cliente> clientes) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosClientes));
        for (Cliente cliente : clientes) {
            obj.writeObject(cliente);
        }
        obj.close();
    }

    public static void gravarDadosTrechos(LinkedList<Trecho> trechos) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosTrechos));
        for (Trecho trecho : trechos) {
            obj.writeObject(trecho);
        }
        obj.close();
    }

    public static void gravarDadosVoos(LinkedList<Voo> voos) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosVoos));
        for (Voo voo : voos) {
            obj.writeObject(voo);
        }
        obj.close();
    }

    public static void gravarDadosBilhetes(LinkedList<Bilhete> bilhetes) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosBilhetes));
        for (Bilhete bilhete : bilhetes) {
            obj.writeObject(bilhete);
        }
        obj.close();
    }

    public static LinkedList<Cliente> carregarDadosClientes(Scanner teclado) {
        FileInputStream dados;
        LinkedList<Cliente> todosClientes = new LinkedList<>();

        try {
            dados = new FileInputStream(arqDadosClientes);
            ObjectInputStream obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Cliente novo = (Cliente) obj.readObject();
                todosClientes.add(novo);
            }
            obj.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioEx) {
            System.out.println("Problema ao abrir o arquivo.");
            System.out.println("Gentileza reiniciar o sistema.");
        } catch (ClassNotFoundException cnEx) {
            System.out.println("Clientes em branco.");
            todosClientes = new LinkedList<Cliente>();
            // pausa(teclado);
        }

        return todosClientes;
    }

    public static LinkedList<Trecho> carregarDadosTrechos(Scanner teclado) {
        FileInputStream dados;
        LinkedList<Trecho> todosTrechos = new LinkedList<>();

        try {
            dados = new FileInputStream(arqDadosTrechos);
            ObjectInputStream obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Trecho novo = (Trecho) obj.readObject();
                todosTrechos.add(novo);
            }
            obj.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioEx) {
            System.out.println("Problema ao abrir o arquivo.");
            System.out.println("Gentileza reiniciar o sistema.");
        } catch (ClassNotFoundException cnEx) {
            System.out.println("Trechos em branco.");
            todosTrechos = new LinkedList<Trecho>();
            // pausa(teclado);
        }

        return todosTrechos;
    }

    public static LinkedList<Voo> carregarDadosVoos(Scanner teclado) {
        FileInputStream dados;
        LinkedList<Voo> todosVoos = new LinkedList<>();

        try {
            dados = new FileInputStream(arqDadosVoos);
            ObjectInputStream obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Voo novo = (Voo) obj.readObject();
                todosVoos.add(novo);
            }
            obj.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioEx) {
            System.out.println("Problema ao abrir o arquivo.");
            System.out.println("Gentileza reiniciar o sistema.");
        } catch (ClassNotFoundException cnEx) {
            System.out.println("Voos em branco.");
            todosVoos = new LinkedList<Voo>();
            // pausa(teclado);
        }

        return todosVoos;
    }

    public static LinkedList<Bilhete> carregarDadosBilhetes(Scanner teclado) {
        FileInputStream dados;
        LinkedList<Bilhete> todosBilhetes = new LinkedList<>();

        try {
            dados = new FileInputStream(arqDadosBilhetes);
            ObjectInputStream obj = new ObjectInputStream(dados);
            while (dados.available() != 0) {
                Bilhete novo = (Bilhete) obj.readObject();
                todosBilhetes.add(novo);
            }
            obj.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado.");
        } catch (IOException ioEx) {
            System.out.println("Problema ao abrir o arquivo.");
            System.out.println("Gentileza reiniciar o sistema.");
        } catch (ClassNotFoundException cnEx) {
            System.out.println("Bilhetes em branco.");
            todosBilhetes = new LinkedList<Bilhete>();
            // pausa(teclado);
        }

        return todosBilhetes;
    }

    public static int menu(Scanner teclado) {
        System.out.println("------------------------------------------------------");
        System.out.println("BrumarFC Airlines");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar trecho");
        System.out.println("3 - Cadastrar voo");
        System.out.println("4 - Comprar bilhetes");
        System.out.println("5 - Relatorios");
        System.out.println("99 - Popular class");
        System.out.println("0 - Sair");
        System.out.println("------------------------------------------------------");

        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (clientes == null || trechos == null || voos == null || bilhetes==null ||
                clientes.isEmpty() || trechos.isEmpty() || voos.isEmpty() || bilhetes.isEmpty()){
            popularDados();
        }
        else {
            clientes = carregarDadosClientes(sc);
            trechos = carregarDadosTrechos(sc);
            voos = carregarDadosVoos(sc);
            bilhetes = carregarDadosBilhetes(sc);
        }
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
                    break;
                case 4:
                    comprar(sc);
                    break;
                case 5:
                    submenu();
                    break;
                case 99:

            }
        } while (opcao != 0);
        gravarDadosBilhetes(bilhetes);
        gravarDadosClientes(clientes);
        gravarDadosTrechos(trechos);
        gravarDadosVoos(voos);
    }

    private static void popularDados() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        clientes.add(new Cliente("lucas", "123456", df.parse("20/05/1999"), clientes.size()));
        clientes.add(new Cliente("laura", "123457", df.parse("13/07/1958"), clientes.size()));
        clientes.add(new Cliente("monica", "123458", df.parse("01/09/1997"), clientes.size()));
        clientes.add(new Cliente("joão", "123459", df.parse("25/12/1986"), clientes.size()));
        clientes.add(new Cliente("maria", "123461", df.parse("10/10/2001"), clientes.size()));
        clientes.add(new Cliente("moana", "123471", df.parse("01/07/1988"), clientes.size()));

        trechos.add(new Trecho("belo horizonte", "maldivas"));
        trechos.add(new Trecho("sao paulo", "santa catarina"));
        trechos.add(new Trecho("dublin", "roraima"));
        trechos.add(new Trecho("fortaleza", "nova iorque"));
        trechos.add(new Trecho("natal", "rio de janeiro"));

        Voo voo = new Voo(df.parse("20/06/2022"));
        voo.addTrecho(recuperarTrechos(1));
        voos.add(voo);

        voo = new Voo(df.parse("20/07/2022"));
        voo.addTrecho(recuperarTrechos(2));
        voos.add(voo);

        voo = new Voo(df.parse("30/06/2021"));
        voo.addTrecho(recuperarTrechos(3));
        voos.add(voo);

        voo = new Voo(df.parse("23/12/2021"));
        voo.addTrecho(recuperarTrechos(4));
        voos.add(voo);

        voo = new Voo(df.parse("26/01/2022"));
        voo.addTrecho(recuperarTrechos(5));
        voos.add(voo);

        LinkedList<Voo> voosBilhete = new LinkedList<Voo>();
        voosBilhete.add(voos.get(1));
        voosBilhete.add(voos.get(3));

        Bilhete bilheteProm = new BilhetePromocional(df.parse("24/04/2022"), new BigDecimal(500), new BigDecimal(500.50), voosBilhete,
                bilhetes.size());
        bilhetes.add(bilheteProm);

        Bilhete bilheteFidel = new BilhetePromocional(df.parse("23/05/2025"), new BigDecimal(280), new BigDecimal(280.00), voosBilhete,
                bilhetes.size());
        bilhetes.add(bilheteFidel);

        Bilhete bilheteSimples = new BilheteSimples(df.parse("20/03/2030"), new BigDecimal(780), new BigDecimal(780.88), voosBilhete,
                bilhetes.size());
        bilhetes.add(bilheteSimples);

        LinkedList<Voo> voosBilhete2 = new LinkedList<Voo>();
        voosBilhete2.add(voos.get(0));
        voosBilhete2.add(voos.get(2));

        Bilhete bilheteSimples2 = new BilheteSimples(df.parse("23/05/2022"), new BigDecimal(120), new BigDecimal(120.88), voosBilhete2,
                bilhetes.size());
        bilhetes.add(bilheteSimples2);

        Bilhete bilheteProm2 = new BilhetePromocional(df.parse("24/09/2022"), new BigDecimal(345), new BigDecimal(345.50),
                voosBilhete2, bilhetes.size());
        bilhetes.add(bilheteProm2);

        Bilhete bilheteFidel2 = new BilheteFidelidade(df.parse("23/02/2025") , new BigDecimal(280), new BigDecimal(280.00),
                voosBilhete2, bilhetes.size());
        bilhetes.add(bilheteFidel2);
    }

    public static void comprar(Scanner sc) {
        Cliente clienteCompra = null;
        while (clienteCompra == null) {
            System.out.println("Informe o código do cliente:");
            int idCliente = sc.nextInt();
            for (Cliente item : clientes) {
                if (idCliente == item.getIdCliente()) {
                    clienteCompra = item;
                }
            }
            if (clienteCompra == null) {
                System.out.println("Cliente não encontrado, informe um codigo de cliente existente");
            }
        }

        Bilhete bilheteCompra = null;
        boolean bilheteIndisponivel = false;
        while (bilheteCompra == null) {
            System.out.println("Informe o código do bilhete");
            int idBilhete = sc.nextInt();
            for (Bilhete item : bilhetes) {
                if (idBilhete == item.getIdBilhete()) {
                    if (item.disponivel()) {
                        bilheteCompra = item;
                        break;
                    } else {
                        System.out.println("Bilhete indisponível, gentileza informar outro código:");
                        bilheteIndisponivel = true;
                        break;
                    }
                }
            }
            if (bilheteCompra == null && bilheteIndisponivel == false) {
                System.out.println("Bilhete não encontrado, informe um codigo de bilhete existente");
            }
            bilheteIndisponivel = false;
        }
        System.out.println("Deseja comprar com os pontos do programa fidelidade? (s/n)");
        String utilizarPts = sc.next();
        if (utilizarPts.toUpperCase().equals("S")) {
            // Transformar o bilhete em um bilhete fidelidade para não contabilizar os pts;
            bilheteCompra = new BilheteFidelidade(bilheteCompra.getDataVencimento(), bilheteCompra.getPrecoBilheteEmPts(), bilheteCompra.getPreco(), bilheteCompra.getVoos(), bilheteCompra.getId());
        }

        System.out.println("Deseja incluir um acelerador de pontos? (s/n)");
        String useBoost = sc.next();

        if (useBoost.equalsIgnoreCase("s")) {
            boolean success = false;

            System.out.println("Temos os seguintes aceleradores: ");

            Arrays.stream(Type.values()).forEach(b -> {
                System.out.println("----------------------------");
                System.out.println("Codigo - " + b.name() + " ,informacoes:");
                System.out.println(b.longName + " que multiplica os pontos em " + b.boost + " e custa " + b.cost);
            });
            System.out.println("Escolha o seu! (digite o codigo do acelerador)");
            String opcBoost = sc.next();
            while (!success) {
                try {
                    Type type = Type.valueOf(opcBoost.toUpperCase());
                    bilheteCompra.giveBooster(type);
                    success = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Houve um problema ao digitar o código, tente novamente");
                }
            }
        }

        try {
            BigDecimal valorCompra = clienteCompra.comprarBilhete(bilheteCompra, useBoost);
            System.out.println("O valor total da compra é: R$ " + valorCompra.toString());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void submenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("BrumarFC Airlines - Relatorios");
        System.out.println("1 - Relatorio de voos para uma cidade, numa data, com mais de 100 reservas");
        System.out.println("2 - Relatorio de faturament");
        System.out.println("3 - Cliente com mais pontos acumulados");
        System.out.println("4 - Relatório Cliente");
        System.out.println("5 - Procurar Voo");
        System.out.println("6 - Relatorio cliente");
        System.out.println("0 - Sair");
        System.out.println("------------------------------------------------------");

        int opcao = sc.nextInt();
        sc.nextLine();
        RelatorioVoo relatorioVoo = new RelatorioVoo();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        switch (opcao){
            case 1:
                System.out.println("Cidade: ");
                String city = sc.next();
                System.out.println("Data (dd/MM/yyyy) :");
                String dateString = sc.next();
                Date date;
                try {
                    date = df.parse(dateString);
                } catch (ParseException e) {
                    date = new Date();
                }
                System.out.println(relatorioVoo.relatorioDeVoosUmaCidadeCemVoos(voos, date, city));
                break;

            case 2:
                System.out.println("Insira o numero do mes, ou -1 para calcular todas as datas");
                int month = sc.nextInt();
                System.out.println(relatorioVoo.relatorioValorArrecadado(month, bilhetes));
                break;
            case 3:
                System.out.println(relatorioVoo.clienteComMaisPontos(clientes));
                break;
            case 4:
                System.out.println("Informe o código do cliente:");
                int idCliente = sc.nextInt();
                Cliente procurado = procurarCliente(idCliente);
                if (procurado == null) {
                    System.out.println("Cliente não encontrado, informe um codigo de cliente existente");
                } else {
                    System.out.println(procurado.relatorio());
                }
                break;
            case 5:
                System.out.println("digite o id vo voo");
                int idV = sc.nextInt();
                sc.nextLine();
                try {
                    Voo voo = procurarVoo(idV);
                     System.out.println(voo.toString());
                } catch (NoSuchElementException e){
                    System.out.println("Voo não encontrado");
                }
                break;
            case 6:
                System.out.println("Informe o código do cliente:");
                int idClient = sc.nextInt();
                Cliente procurad = procurarCliente(idClient);
                if (procurad == null) {
                    System.out.println("Cliente não encontrado, informe um codigo de cliente existente");
                } else {
                    System.out.println(relatorioVoo.bilhetesUltimoAno(procurad));
                }
                break;
            default:
                System.out.println("opc invalida");
        }
    }

    // Métodos Switches

    public static Cliente cadastrarCliente(Scanner sc) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = sc.nextLine();
        System.out.println("Informe a data de nascimento:");
        String aniversario = sc.nextLine();
        Date dob;
        try{
            dob = df.parse(aniversario);
        }catch (ParseException e){
            dob = new Date();
        }
        return new Cliente(nome, cpf, dob, clientes.size());
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
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Informe a data do voo:");
        String data = sc.nextLine();
        Voo voo;
        try {
            voo = new Voo(df.parse(data));
        }catch (ParseException e){
            voo = new Voo(new Date());
        }
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

    public static Cliente procurarCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public static Voo procurarVoo(int idVoo) {
        return voos.stream().filter(v -> v.getIdVoo() == idVoo).findFirst().orElseThrow();
    }

}