package conexaoDAO;

import classes.Cliente;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection connection;   // objeto responsável por fazer a conexão com o servidor do MySQL
    Statement statement;     // objeto responsável por preparar consultas "SELECT"
    ResultSet result;        // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst;   // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE, DELETE)

    static final String user = "root";                  // usuário da instância local do servidor
    static final String password = "root";    // senha do usuário da instância local do servidor
    static final String database = "model";           // nome do banco de dados a ser utilizado

    // string com URL de conexão com servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;

    public void connect(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: "+ connection);
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean inserirCliente(Cliente cliente){
        connect();
        String sql = "INSERT INTO usuario(nome, cpf, telefone, email) VALUES(?, ?, ?, ?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNome());      // concatena nome na primeira ? do comando
            pst.setString(2, cliente.getCpf());        // concatena nome na segunda ? do comando
            pst.setString(3, cliente.getTelefone());        // concatena nome na terceira ? do comando
            pst.setString(4, cliente.getEmail());        // concatena nome na quarta ? do comando
            pst.execute();                           // executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<User> researchUser(){
        connect();
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                User userTemp = new User(result.getString("nome"), result.getString("cpf"));
                userTemp.id = result.getInt("id");
                System.out.println("ID = " + userTemp.id);
                System.out.println("Nome = " + userTemp.getNome());
                System.out.println("CPF = " + userTemp.getCpf());
                System.out.println("------------------------------");
                users.add(userTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return users;
    }

    // ----------------------------ATUALIZANDO NOME NO REGISTRO----------------------------
    public boolean updateUser(int id, String nome){
        connect();
        String sql = "UPDATE usuario SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteUser(int id) {
        connect();
        String sql = "DELETE FROM usuario WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}