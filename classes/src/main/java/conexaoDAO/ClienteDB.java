package conexaoDAO;

import classes.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDB extends Database {

    public boolean inserirCliente(Cliente cliente){
        connect();
        String sql = "INSERT INTO Cliente( cpfCliente, nome, email) VALUES(?, ?, ?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getCpfCliente());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getEmail());
            pst.execute();
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

    public ArrayList<Cliente> buscarCliente(){
        connect();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Cliente clienteTemp = new Cliente();
                clienteTemp.setCpfCliente(result.getString("cpfCliente"));
                clienteTemp.setNome(result.getString("nome"));
                clienteTemp.setEmail(result.getString("email"));

                System.out.println("NOME = " + clienteTemp.getNome());
                System.out.println("EMAIL = " + clienteTemp.getEmail());
                System.out.println("CPF = " + clienteTemp.getCpfCliente());
                System.out.println("------------------------------");

                listaClientes.add(clienteTemp);
            }

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

    public boolean atualizarCliente(String cpf, Cliente cliente){
        connect();
        String sql = "UPDATE Cliente SET nome=?, email=? WHERE cpfCliente=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getCpfCliente());
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

    public boolean deletarCliente(String cpf) {
        connect();
        String sql = "DELETE FROM Cliente where cpfCliente=?";
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
