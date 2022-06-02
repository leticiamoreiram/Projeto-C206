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
            System.out.println("3- Ver minha reserva");
            System.out.println("4- Cancelar reserva");
            System.out.println("5- Sair");
            int op = sc.nextInt();

            switch (op){
                case 1:

                    break;
                case 2:

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
