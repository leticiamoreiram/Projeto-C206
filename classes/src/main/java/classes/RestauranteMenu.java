package classes;

import conexaoDAO.ClienteDB;
import conexaoDAO.MesaDB;
import conexaoDAO.ReservaDB;

import java.util.Scanner;

public class RestauranteMenu {
    public static void main(String[] args) {

        ClienteDB clienteDB = new ClienteDB();
        ReservaDB reservaDB = new ReservaDB();
        MesaDB mesaDB = new MesaDB();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        System.out.println("******  Bem-vindo ao Restaurante    ******");
        System.out.println("__________________________________________");
        while (flag){
            System.out.println("** Menu: **");
            System.out.println("1- Cadastro");
            System.out.println("2- Fazer reserva");
            System.out.println("3- Ver minha reserva");
            System.out.println("4- Alterar data da reserva");
            System.out.println("5- Cancelar reserva");
            System.out.println("6- Finalizar");
            System.out.println("_______________________");
            System.out.println(" ");
            System.out.println("Sua opção: ");

            int op = sc.nextInt();

            switch (op){
                case 1:
                    sc.nextLine();
                    System.out.println("*************** CADASTRO ***************");
                    System.out.println("Digite as informações solicitadas abaixo");
                    System.out.println("________________________________________");

                    Cliente c = new Cliente();;
                    System.out.println("Nome: ");
                    c.setNome(sc.nextLine());
                    System.out.println("E-mail: ");
                    c.setEmail(sc.nextLine());
                    System.out.println("CPF: ");
                    c.setCpfCliente(sc.nextLine());

                    clienteDB.inserirCliente(c);

                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("**************** RESERVA ***************");
                    System.out.println("Digite as informações solicitadas abaixo");
                    System.out.println("________________________________________");

                    Reserva r = new Reserva();;
                    Mesa m = new Mesa();

                    System.out.println("Cpf: ");
                    String cpf = sc.nextLine();
                    r.setCpfCliente(cpf);
                    m.setCpfCliente(cpf);

                    int qtdPessoas = 0;
                    do
                    {
                        System.out.println("Quantidade de pessoas (permitido até 10 pessoas em cada mesa): ");
                        qtdPessoas = sc.nextInt();
                    }
                    while(qtdPessoas < 1 || qtdPessoas > 10);

                    r.setQtdPessoas(qtdPessoas);

                    sc.nextLine();
                    System.out.println("Data (dd/mm/aaaa): ");
                    r.setDataReserva(sc.nextLine());

                    int numMesa = 0;
                    do
                    {
                        System.out.println("Escolha uma mesa de 1 a 10");
                        numMesa = sc.nextInt();
                    }
                    while(numMesa < 1 || numMesa > 10);

                    m.setNumMesa(numMesa);
                    r.setNumMesa(numMesa);

                    double preco = 40.8 * qtdPessoas;
                    m.setPreco(preco);

                    mesaDB.inserirMesa(m);
                    reservaDB.inserirReserva(r);


                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("********************** DADOS DA RESERVA **********************");
                    System.out.println("Para verificar informações sobre a sua reserva, informe seu CPF");

                    String cpfCliente = sc.nextLine();

                    reservaDB.buscarReservaPorCpf(cpfCliente);
                    mesaDB.buscarMesaPorCpf(cpfCliente);

                    break;
                case 4:


                    sc.nextLine();
                    System.out.println("********************** ALTERAR RESERVA **********************");
                    System.out.println("Para alterar informações sobre a sua reserva, insira os dados solicitados");
                    System.out.println();

                    System.out.println("Cpf do titular da reserva: ");
                    String clienteCpf = sc.nextLine();

                    System.out.println("Nova data: ");
                    String dia = sc.nextLine();

                    reservaDB.atualizarReserva(clienteCpf, dia);

                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("************ CANCELAR RESERVA ************");
                    System.out.println("Para cancelar sua reserva, informe seu CPF");
                    System.out.println("__________________________________________");

                    String CPF = sc.nextLine();

                    reservaDB.deletarReserva(CPF);
                    mesaDB.deletarMesa(CPF);


                    break;
                case 6:
                    System.out.println("Volte Sempre!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }

    }
}