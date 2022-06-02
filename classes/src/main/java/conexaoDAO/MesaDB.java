package conexaoDAO;

import classes.Mesa;
import classes.Reserva;

import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDB extends Database {

    public boolean inserirMesa(Mesa mesa){
        connect();
        String sql = "INSERT INTO Mesa(numMesa, preco ) VALUES(?, ?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, mesa.getNumMesa());      // concatena nome na primeira ? do comando
            pst.setDouble(2, mesa.getPreco());        // concatena nome na segunda ? do comando
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

    public boolean atualizarMesa(Double preco, Mesa mesa){
        connect();
        String sql = "UPDATE Cliente SET preco=? WHERE numMesa=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, mesa.getPreco());
            pst.setInt(2, mesa.getNumMesa());
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

    public boolean deletarMesa(int numMesa) {
        connect();
        String sql = "DELETE FROM Mesa where numMesa=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, numMesa);
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

    public Mesa buscarMesaPorNum(int numMesa) {
        Mesa mesaTemp = null;
        connect();

        String sql = "SELECT * FROM Mesa WHERE numMesa=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, numMesa);
            result = pst.executeQuery();

            while (result.next()) {

                mesaTemp = new Mesa();
                mesaTemp.setNumMesa(result.getInt("numMesa"));
                mesaTemp.setPreco(result.getDouble("preco"));

                System.out.println("NUMERO DA MESA = " + mesaTemp.getNumMesa());
                System.out.println("PRECO POR PESSOA = " + mesaTemp.getPreco());;

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
