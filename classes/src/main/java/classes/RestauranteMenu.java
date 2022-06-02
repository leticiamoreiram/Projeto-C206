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
            System.out.println("3- Ver reservas");
            System.out.println("4- Cancelar reserva");
            System.out.println("5- Sair");
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
                    System.out.println("Cadastro realizado com sucesso");
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("*************** RESERVA ***************");
                    System.out.println("Digite as informações solicitadas abaixo");
                    System.out.println("________________________________________");

                    Reserva r = new Reserva();;
                    System.out.println("Cpf: ");
                    r.setCpfCliente(sc.nextLine());
                    System.out.println("Quantidade de pessoas: ");
                    r.setQtdPessoas(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Data (dd/mm/aaaa): ");
                    r.setDataReserva(sc.nextLine());

                    reservaDB.inserirReserva(r);

                    break;
                case 3:

                    clienteDB.buscarCliente();
                    break;
                case 4:


                    clienteDB.deletarCliente("111.111.111-11");

                    break;
                case 5:
                    System.out.println("Volte Sempre!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }

    }
}
