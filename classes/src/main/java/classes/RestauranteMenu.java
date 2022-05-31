package classes;

import java.util.Scanner;

public class RestauranteMenu {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean flag = true;

        System.out.println("******  Bem-vindo ao restaurante    ******");
        System.out.println("__________________________________________");
        while (flag){
            System.out.println("** Menu: **");
            System.out.println("1- Reservar Almoço");
            System.out.println("2- Reservar Jantar");
            System.out.println("3- Mostrar mesas disponiveis");
            System.out.println("4- Ver minha reserva");
            System.out.println("5- Cancelar reserva");
            System.out.println("6- Sair");
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

                    break;
                case 6:
                    System.out.println("Obrigado por visitar o restaurante");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }

    }
}
