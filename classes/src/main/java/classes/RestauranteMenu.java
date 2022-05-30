package classes;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestauranteMenu {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean flag = true;

        System.out.println("**Bem-vindo ao restaurante**");
        while (flag){
            System.out.println("** Menu: **");
            System.out.println("1- Reserva");
            System.out.println("2- Mostrar mesas disponiveis");
            System.out.println("3- Ver minha reserva");
            System.out.println("4- Sair");
            int op = sc.nextInt();

            switch (op){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Obrigado por visitar o restaurante");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }


        }

    }
}
