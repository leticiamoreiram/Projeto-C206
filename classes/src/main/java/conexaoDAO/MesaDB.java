package conexaoDAO;

import classes.Mesa;
import classes.Reserva;

import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDB extends Database {

    public boolean inserirMesa(Mesa mesa){
        connect();
        String sql = "INSERT INTO Mesa(numMesa, preco, cpfCliente) VALUES(?, ?, ?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, mesa.getNumMesa());      // concatena nome na primeira ? do comando
            pst.setDouble(2, mesa.getPreco());        // concatena nome na segunda ? do comando
            pst.setString(3, mesa.getCpfCliente());        // concatena nome na segunda ? do comando
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

    public ArrayList<Mesa> buscarMesa(){
        connect();
        ArrayList<Mesa> listaMesas = new ArrayList<>();
        String sql = "SELECT * FROM Mesa";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Mesa mesaTemp = new Mesa();
                mesaTemp.setNumMesa(result.getInt("numMesa"));
                mesaTemp.setPreco(result.getDouble("preco"));
                mesaTemp.setPreco(result.getDouble("cpfCliente"));

                System.out.println("PRECO POR PESSOA = " + mesaTemp.getNumMesa());
                System.out.println("NUMERO DA MESA = " + mesaTemp.getPreco());;
                System.out.println("------------------------------");

                listaMesas.add(mesaTemp);
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
        return listaMesas;
    }

    public boolean atualizarMesa(Mesa mesa, String cpfCliente){
        connect();
        String sql = "UPDATE Cliente SET preco=?, cpfCliente=? WHERE numMesa=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, mesa.getPreco());
            pst.setInt(2, mesa.getNumMesa());
            pst.setString(3, mesa.getCpfCliente());
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

    public boolean deletarMesa(String cpfCliente) {
        connect();
        String sql = "DELETE FROM Mesa where cpfCliente=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpfCliente);
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

    public Mesa buscarMesaPorCpf(String cpfCliente) {
        Mesa mesaTemp = null;
        connect();

        String sql = "SELECT * FROM Mesa WHERE cpfCliente=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpfCliente);
            result = pst.executeQuery();

            while (result.next()) {

                mesaTemp = new Mesa();
                mesaTemp.setNumMesa(result.getInt("numMesa"));
                mesaTemp.setPreco(result.getDouble("preco"));
                mesaTemp.setCpfCliente(result.getString("cpfCliente"));

                System.out.println("VALOR TOTAL DA RESERVA CORRESPONDENTE À MESA " +  mesaTemp.getNumMesa() +" = R$"+ mesaTemp.getPreco());

            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return mesaTemp;
    }

}