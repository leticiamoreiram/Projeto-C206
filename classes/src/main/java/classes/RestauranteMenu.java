package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public enum RestauranteMenu {;


    private final int id;
    private final String legenda;
    private static final Map<Integer, RestauranteMenu> map = new HashMap<>();

    RestauranteMenu(int id, String legenda){
        this.id = id;
        this.legenda = legenda;
    }

    public int getId() {
        return id;
    }

    static {
        for(RestauranteMenu restauranteMenu: RestauranteMenu.values()) {
            map.put(restauranteMenu.id, restauranteMenu);
        }
    }

    public static RestauranteMenu getOption(int id) {
        if(!map.containsKey(id))
            return null;
        return map.get(id);
    }

    public static RestauranteMenu getUserOption() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to the Hotel Reservation Application");
            RestauranteMenu.mostraOpcao();
            System.out.println("Please select a number for the menu option");
            int id = input.nextInt();
            RestauranteMenu mainMenuOption = RestauranteMenu.getOption(id);
            if(mainMenuOption != null)
                return mainMenuOption;
            System.out.println("Entrada inválida");
        }
    }

    public static void mostraOpcao() {
        for(RestauranteMenu mainMenuOption: RestauranteMenu.values())
            System.out.println(mainMenuOption);
    }

}
