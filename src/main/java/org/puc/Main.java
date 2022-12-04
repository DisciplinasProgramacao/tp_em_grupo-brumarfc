package org.puc;

import org.puc.entity.bilhete.Bilhete;
import org.puc.entity.bilhete.BilheteFidelidade;
import org.puc.entity.bilhete.BilhetePromocional;
import org.puc.entity.bilhete.BilheteSimples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        System.out.println("99 - Popular class");
        System.out.println("0 - Sair");
        System.out.println("------------------------------------------------------");

        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        clientes = carregarDadosClientes(sc);
        trechos = carregarDadosTrechos(sc);
        voos = carregarDadosVoos(sc);
        bilhetes = carregarDadosBilhetes(sc);

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
                    Cliente clienteCompra = null;
                    while (clienteCompra == null) {
                        System.out.println("Informe o código do cliente:");
                        int idCliente = sc.nextInt();
                        for (Cliente item : clientes) {
                            if (idCliente == item.getIdCliente()) {
                                clienteCompra = item;
                                break;
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
                    clienteCompra.comprarBilhete(bilheteCompra);
                    break;
                case 99:
                    clientes.add(new Cliente("lucas", "123456", "20309", clientes.size()));
                    clientes.add(new Cliente("laura", "123457", "24343", clientes.size()));
                    clientes.add(new Cliente("monica", "123458", "24343", clientes.size()));
                    clientes.add(new Cliente("joão", "123459", "24343", clientes.size()));
                    clientes.add(new Cliente("maria", "123461", "24343", clientes.size()));
                    clientes.add(new Cliente("moana", "123471", "24453", clientes.size()));

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

                    Bilhete bilheteProm = new BilhetePromocional("24/04/2022", 34, new BigDecimal(345.50), voosBilhete,
                            bilhetes.size());
                    bilhetes.add(bilheteProm);

                    Bilhete bilheteFidel = new BilheteFidelidade("23/05/2025", 22, new BigDecimal(280.00), voosBilhete,
                            bilhetes.size());
                    bilhetes.add(bilheteFidel);

                    Bilhete bilheteSimples = new BilheteSimples("20/03/2030", 12, new BigDecimal(120.88), voosBilhete,
                            bilhetes.size());
                    bilhetes.add(bilheteSimples);

                    LinkedList<Voo> voosBilhete2 = new LinkedList<Voo>();
                    voosBilhete2.add(voos.get(0));
                    voosBilhete2.add(voos.get(2));

                    Bilhete bilheteSimples2 = new BilheteSimples("23/05/2022", 12, new BigDecimal(120.88), voosBilhete2,
                            bilhetes.size());
                    bilhetes.add(bilheteSimples2);

                    Bilhete bilheteProm2 = new BilhetePromocional("24/09/2022", 34, new BigDecimal(345.50),
                            voosBilhete2, bilhetes.size());
                    bilhetes.add(bilheteProm2);

                    Bilhete bilheteFidel2 = new BilheteFidelidade("23/02/2025", 22, new BigDecimal(280.00),
                            voosBilhete2, bilhetes.size());
                    bilhetes.add(bilheteFidel2);
            }
        } while (opcao != 0);
        gravarDadosBilhetes(bilhetes);
        gravarDadosClientes(clientes);
        gravarDadosTrechos(trechos);
        gravarDadosVoos(voos);
    }

    // Métodos Switches

    public static Cliente cadastrarCliente(Scanner sc) {
        System.out.println("Informe o nome:");
        String nome = sc.nextLine();
        System.out.println("Informe o cpf:");
        String cpf = sc.nextLine();
        System.out.println("Informe a data de nascimento:");
        String aniversario = sc.nextLine();
        return new Cliente(nome, cpf, aniversario, clientes.size());
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