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
import java.math.RoundingMode;
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

    /**
     * grava os dados dos clientes no arquivo local
     *
     * @param clientes lista dos clientes gerados
     */
    public static void gravarDadosClientes(LinkedList<Cliente> clientes) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosClientes));
        for (Cliente cliente : clientes) {
            obj.writeObject(cliente);
        }
        obj.close();
    }

    /**
     * grava os dados dos trechos no arquivo local
     *
     * @param trechos lista dos trechos gerados
     */
    public static void gravarDadosTrechos(LinkedList<Trecho> trechos) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosTrechos));
        for (Trecho trecho : trechos) {
            obj.writeObject(trecho);
        }
        obj.close();
    }

    /**
     * grava os dados dos voos no arquivo local
     *
     * @param voos lista dos voos gerados
     */
    public static void gravarDadosVoos(LinkedList<Voo> voos) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosVoos));
        for (Voo voo : voos) {
            obj.writeObject(voo);
        }
        obj.close();
    }

    /**
     * grava os dados dos bilhetes no arquivo local
     *
     * @param bilhetes lista dos bilhetes gerados
     */
    public static void gravarDadosBilhetes(LinkedList<Bilhete> bilhetes) throws IOException {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(arqDadosBilhetes));
        for (Bilhete bilhete : bilhetes) {
            obj.writeObject(bilhete);
        }
        obj.close();
    }

    /**
     * carrega os dados dos clientes no arquivo local
     *
     * @return lista de clientes
     */
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
            System.out.println("Arquivo n??o encontrado.");
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

    /**
     * carrega os dados dos trechos no arquivo local
     *
     * @return lista de trechos
     */
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
            System.out.println("Arquivo n??o encontrado.");
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

    /**
     * carrega os dados dos voos no arquivo local
     *
     * @return lista de voos
     */
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
            System.out.println("Arquivo n??o encontrado.");
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

    /**
     * carrega os dados dos bilhetes no arquivo local
     *
     * @return lista de bilhetes
     */
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
            System.out.println("Arquivo n??o encontrado.");
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


    /**
     * mostra o menu para o user
     *
     * @param teclado - scanner do teclado
     */
    public static int menu(Scanner teclado) {
        System.out.println("------------------------------------------------------");
        System.out.println("BrumarFC Airlines");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar trecho");
        System.out.println("3 - Cadastrar voo");
        System.out.println("4 - Comprar bilhetes");
        System.out.println("5 - Relat??rios");
        System.out.println("99 - Popular class");
        System.out.println("0 - Sair");
        System.out.println("------------------------------------------------------");

        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }

    /**
     * executa o menu para intera????o com o user
     *
     * @param args default param of main
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (clientes == null || trechos == null || voos == null || bilhetes == null ||
                clientes.isEmpty() || trechos.isEmpty() || voos.isEmpty() || bilhetes.isEmpty()) {
            popularDados();
        } else {
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
                    System.out.println(novoCliente.toString());
                    clientes.add(novoCliente);
                    break;
                case 2:
                    Trecho novoTrecho = cadastrarTrecho(sc);
                    System.out.println(novoTrecho.toString());
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

    /**
     * popula os dados locais com dados mockups
     *
     * @throws ParseException
     */
    private static void popularDados() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        clientes.add(new Cliente("lucas", "123456", df.parse("20/05/1999"), clientes.size(), BigDecimal.valueOf(100000))); //0
        clientes.add(new Cliente("laura", "123457", df.parse("13/07/1958"), clientes.size()));//1
        clientes.add(new Cliente("monica", "123458", df.parse("01/09/1997"), clientes.size()));//2
        clientes.add(new Cliente("jo??o", "123459", df.parse("25/12/1986"), clientes.size()));//3
        clientes.add(new Cliente("maria", "123461", df.parse("10/10/2001"), clientes.size()));//4
        clientes.add(new Cliente("moana", "123471", df.parse("01/07/1988"), clientes.size()));//5

        trechos.add(new Trecho("belo horizonte", "maldivas"));//0
        trechos.add(new Trecho("sao paulo", "santa catarina"));//1
        trechos.add(new Trecho("dublin", "roraima"));//2
        trechos.add(new Trecho("fortaleza", "nova iorque"));//3
        trechos.add(new Trecho("natal", "rio de janeiro"));//4

        Voo voo = new Voo(df.parse("20/06/2022"));
        voo.addTrecho(recuperarTrechos(1));
        voos.add(voo);

        voo = new Voo(df.parse("20/07/2022"));
        voo.addTrecho(recuperarTrechos(2));
        voos.add(voo);

        voo = new Voo(df.parse("30/06/2022"));
        voo.addTrecho(recuperarTrechos(3));
        voos.add(voo);

        voo = new Voo(df.parse("23/12/2022"));
        voo.addTrecho(recuperarTrechos(4));
        voos.add(voo);

        voo = new Voo(df.parse("26/01/2022"));
        voo.addTrecho(recuperarTrechos(5));
        voos.add(voo);

        LinkedList<Voo> voosBilhete = new LinkedList<Voo>();
        voosBilhete.add(voos.get(1));
        voosBilhete.add(voos.get(3));

        Bilhete bilheteProm = new BilhetePromocional(df.parse("24/04/2022"), new BigDecimal(500), new BigDecimal(500.50), voosBilhete, bilhetes.size());//0
        bilhetes.add(bilheteProm);

        Bilhete bilheteFidel = new BilhetePromocional(df.parse("23/05/2025"), new BigDecimal(280), new BigDecimal(280.00), voosBilhete, bilhetes.size());//1
        bilhetes.add(bilheteFidel);

        Bilhete bilheteSimples = new BilheteSimples(df.parse("20/03/2030"), new BigDecimal(780), new BigDecimal(780.88), voosBilhete, bilhetes.size());//2
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

        Bilhete bilheteFidel2 = new BilheteFidelidade(df.parse("23/02/2025"), new BigDecimal(280), new BigDecimal(280.00),
                voosBilhete2, bilhetes.size());
        bilhetes.add(bilheteFidel2);
    }

    /**
     * compra o bilhete
     * @param sc scanner
     */
    public static void comprar(Scanner sc) {
        Cliente clienteCompra = null;
        while (clienteCompra == null) {
            System.out.println("Informe o c??digo do cliente:");
            int idCliente = sc.nextInt();
            for (Cliente item : clientes) {
                if (idCliente == item.getIdCliente()) {
                    clienteCompra = item;
                }
            }
            if (clienteCompra == null) {
                System.out.println("Cliente n??o encontrado, informe um c??digo de cliente existente");
            }
        }

        Bilhete bilheteCompra = null;
        boolean bilheteIndisponivel = false;
        while (bilheteCompra == null) {
            System.out.println("Informe o c??digo do bilhete");
            int idBilhete = sc.nextInt();
            for (Bilhete item : bilhetes) {
                if (idBilhete == item.getIdBilhete()) {
                    if (item.disponivel()) {
                        bilheteCompra = item;
                        break;
                    } else {
                        System.out.println("Bilhete indispon??vel, gentileza informar outro c??digo:");
                        bilheteIndisponivel = true;
                        break;
                    }
                }
            }
            if (bilheteCompra == null && bilheteIndisponivel == false) {
                System.out.println("Bilhete n??o encontrado, informe um c??digo de bilhete existente");
            }
            bilheteIndisponivel = false;
        }
        System.out.println("Deseja comprar com os pontos do programa fidelidade? (s/n)");
        String utilizarPts = sc.next();
        if (utilizarPts.toUpperCase().equals("S")) {
            // Transformar o bilhete em um bilhete fidelidade para n??o contabilizar os pts;
            bilheteCompra = new BilheteFidelidade(bilheteCompra.getDataVencimento(), bilheteCompra.getPrecoBilheteEmPts(), bilheteCompra.getPreco(), bilheteCompra.getVoos(), bilheteCompra.getId());
        }

        System.out.println("Deseja incluir um acelerador de pontos? (s/n)");
        String useBoost = sc.next();

        if (useBoost.equalsIgnoreCase("s")) {
            boolean success = false;

            System.out.println("Temos os seguintes aceleradores: ");

            Arrays.stream(Type.values()).forEach(b -> {
                System.out.println("----------------------------");
                System.out.println("C??digo - " + b.name() + " ,informa????es:");
                System.out.println(b.longName + " que multiplica os pontos em " + b.boost + " e custa " + b.cost);
            });
            System.out.println("Escolha o seu! (digite o c??digo do acelerador)");
            String opcBoost = sc.next();
            while (!success) {
                try {
                    Type type = Type.valueOf(opcBoost.toUpperCase());
                    bilheteCompra.giveBooster(type);
                    success = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Houve um problema ao digitar o c??digo, tente novamente");
                }
            }
        }

        try {
            BigDecimal valorCompra = clienteCompra.comprarBilhete(bilheteCompra, useBoost);
            System.out.println("O valor total da compra ??: R$ " + valorCompra.setScale(2, RoundingMode.HALF_DOWN).toString());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * mostra o submenu para o user, na opcao de relatorios
     */
    private static void submenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        System.out.println("BrumarFC Airlines - Relatorios");
        System.out.println("1 - Relat??rio de voos para uma cidade, numa data, com mais de 100 reservas");
        System.out.println("2 - Relat??rio de faturamento");
        System.out.println("3 - Cliente com mais pontos acumulados");
        System.out.println("4 - Relat??rio Cliente");
        System.out.println("5 - Procurar Voo");
        System.out.println("6 - Relat??rio bilhetes");
        System.out.println("0 - Sair");
        System.out.println("------------------------------------------------------");

        int opcao = sc.nextInt();
        sc.nextLine();
        RelatorioVoo relatorioVoo = new RelatorioVoo();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        switch (opcao) {
            case 1:
                System.out.println("Cidade: ");
                String city = sc.nextLine();
                System.out.println("Data (dd/MM/yyyy) :");
                String dateString = sc.nextLine();
                Date date;
                try {
                    date = df.parse(dateString);
                } catch (ParseException e) {
                    date = new Date();
                }
                System.out.println(relatorioVoo.relatorioDeVoosUmaCidadeCemVoos(voos, date, city));
                break;

            case 2:
                System.out.println("Insira o numero do m??s, ou -1 para calcular todas as datas");
                int month = sc.nextInt();
                System.out.println(relatorioVoo.relatorioValorArrecadado(month, bilhetes));
                break;
            case 3:
                System.out.println(relatorioVoo.clienteComMaisPontos(clientes));
                break;
            case 4:
                System.out.println("Informe o c??digo do cliente:");
                int idCliente = sc.nextInt();
                Cliente procurado = procurarCliente(idCliente);
                if (procurado == null) {
                    System.out.println("Cliente n??o encontrado, informe um c??digo de cliente existente");
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
                } catch (NoSuchElementException e) {
                    System.out.println("Voo n??o encontrado");
                }
                break;
            case 6:
                System.out.println("Informe o c??digo do cliente:");
                int idClient = sc.nextInt();
                Cliente procurad = procurarCliente(idClient);
                if (procurad == null) {
                    System.out.println("Cliente n??o encontrado, informe um c??digo de cliente existente");
                } else {
                    System.out.println(relatorioVoo.bilhetesUltimoAno(procurad).toString());
                }
                break;
            default:
                System.out.println("opc invalida");
        }
    }


    /**
     * cadastra um cliente
     *
     * @param sc scanner do teclado
     * @return cliente cadastrado
     */
    public static Cliente cadastrarCliente(Scanner sc) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = sc.nextLine();
        System.out.println("Informe a data de nascimento:");
        String aniversario = sc.nextLine();
        Date dob;
        try {
            dob = df.parse(aniversario);
        } catch (ParseException e) {
            dob = new Date();
        }
        return new Cliente(nome, cpf, dob, clientes.size());
    }

    /**
     * cadastra um trecho
     *
     * @param sc scanner do teclado
     * @return o trecho cadastrado
     */
    public static Trecho cadastrarTrecho(Scanner sc) {
        System.out.println("Informe a origem:");
        String origem = sc.nextLine();
        System.out.println("Informe o destino:");
        String destino = sc.nextLine();
        return new Trecho(origem, destino);
    }


    /**
     * cadastra um voo
     *
     * @param sc scanner do teclado
     * @return o voo cadastrado
     */
    public static Voo cadastrarVoo(Scanner sc) {
        int opcao;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Informe a data do voo:");
        String data = sc.nextLine();
        Voo voo;
        try {
            voo = new Voo(df.parse(data));
        } catch (ParseException e) {
            voo = new Voo(new Date());
        }
        do {
            System.out.println("1 - Vincular trechos:");
            System.out.println("2 - Todos os trechos j?? cadastrados!");
            opcao = sc.nextInt();
            sc.next();
            if (opcao == 1) {
                System.out.println("Informe a identifica????o do trecho:");
                int idTrecho = sc.nextInt();
                sc.next();
                Trecho trecho = recuperarTrechos(idTrecho);
                if (trecho != null) {
                    voo.addTrecho(trecho);
                    System.out.println("trecho vinculado!");
                    System.out.println(voo.getTrechos().toString());
                } else
                    System.out.println("Trecho n??o encontrado.");
            }
        } while (opcao != 2);
        return voo;
    }


    /**
     * procura um trecho
     *
     * @param idTrecho id do trecho para procurar
     * @return a informa????o do trecho
     */
    public static Trecho recuperarTrechos(int idTrecho) {
        for (Trecho trecho : trechos) {
            if (trecho.getIdTrecho() == idTrecho) {
                return trecho;
            }
        }
        return null;
    }

    /**
     * procura por um cliente a partir de um id
     *
     * @param idCliente id do cliente que deseja procurar
     * @return o cliente procurado
     */
    public static Cliente procurarCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    /**
     * procura por um voo a partir de um id
     *
     * @param idVoo id do voo que deseja procurar
     * @return o voo procurado
     * @throws NoSuchElementException se n??o encontrar nada a partir do id
     */
    public static Voo procurarVoo(int idVoo) {
        return voos.stream().filter(v -> v.getIdVoo() == idVoo).findFirst().orElseThrow();
    }

}