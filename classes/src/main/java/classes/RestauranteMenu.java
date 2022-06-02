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

        System.out.println("******  Bem-vindo ao restaurante    ******");
        System.out.println("__________________________________________");
        while (flag){
            System.out.println("** Menu: **");
            System.out.println("1- Cadastro");
            System.out.println("2- Fazer reserva");
            //System.out.println("3- Ver minha reserva");
            //System.out.println("4- Cancelar reserva");
            System.out.println("5- Sair");

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
                    System.out.println("*************** RESERVA ***************");
                    System.out.println("Digite as informações solicitadas abaixo");
                    System.out.println("________________________________________");

                    Reserva r = new Reserva();;
                    System.out.println("Cpf: ");
                    r.setCpfCliente(sc.nextLine());
                    System.out.println("Quantidade de pessoas: ");
                    r.setQtdPessoas(sc.nextInt());


                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Obrigado por visitar o restaurante");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }

    }
}
