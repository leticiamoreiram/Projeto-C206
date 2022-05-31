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
        String sql = "INSERT INTO Cliente(nome, email, telefone, cpf ) VALUES(?, ?, ?, ?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNome());      // concatena nome na primeira ? do comando
            pst.setString(2, cliente.getEmail());        // concatena nome na segunda ? do comando
            pst.setString(3, cliente.getTelefone());        // concatena nome na terceira ? do comando
            pst.setString(4, cliente.getCpf());        // concatena nome na quarta ? do comando
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
    public ArrayList<Cliente> buscarCliente(){
        connect();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Cliente clienteTemp = new Cliente();
                clienteTemp.setCpf(result.getString("cpf"));
                clienteTemp.setTelefone(result.getString("telefone"));
                clienteTemp.setEmail(result.getString("email"));
                clienteTemp.setNome(result.getString("nome"));

                System.out.println("ID = " + clienteTemp.getNome());
                System.out.println("Nome = " + clienteTemp.getEmail());
                System.out.println("CPF = " + clienteTemp.getTelefone());
                System.out.println("CPF = " + clienteTemp.getCpf());
                System.out.println("------------------------------");

                listaClientes.add(clienteTemp);
            }
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return listaClientes;
    }

    // ----------------------------ATUALIZANDO NOME NO REGISTRO----------------------------
    public boolean atualizarCliente(String cpf, Cliente cliente){
        connect();
        String sql = "UPDATE Cliente SET nome=?, email=?, telefone=? WHERE cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cpf);
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
    public boolean deletarCliente(String cpf) {
        connect();
        String sql = "DELETE FROM Cliente where cpf=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
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