package conexaoDAO;

public class Principal {

    public static void main(String[] args) {
        Database database = new Database();
        database.connect();
        // criando objetos de usuário para serem inseridos no banco
        User user = new User("Flávio", "111.111.111-11");
        User user1 = new User("Fernando", "222.222.222-22");
        User user2 = new User("Vânia", "333.333.333-33");
        // Inserindo usuários no banco
        database.insertUser(user);
        database.insertUser(user1);
        database.insertUser(user2);
        //mostrando todos os usuarios
        database.researchUser();
        System.out.println("-----------Atualizando nome-----------");
        database.updateUser(1, "Flavinho");

        database.researchUser();

        System.out.println("----------Excluindo usuário-----------");
        database.deleteUser(1);
        database.researchUser();
    }
}