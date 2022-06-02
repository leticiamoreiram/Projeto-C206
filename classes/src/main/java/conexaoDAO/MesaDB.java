package conexaoDAO;

import classes.Cliente;
import classes.Mesa;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesaDB extends Database {

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean inserirMesa(Mesa mesa){
        connect();
        String sql = "INSERT INTO Mesa(preco, numMesa) VALUES(?, ?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setDouble(1, mesa.getPreco());      // concatena nome na primeira ? do comando
            pst.setInt(2, mesa.getNumMesa());        // concatena nome na segunda ? do comando
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
    public ArrayList<Mesa> buscarMesa(){
        connect();
        ArrayList<Mesa> listaMesas = new ArrayList<>();
        String sql = "SELECT * FROM Mesa";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Mesa mesaTemp = new Mesa();
                mesaTemp.setPreco(result.getDouble("preco"));
                mesaTemp.setNumMesa(result.getInt("numMesa"));

                System.out.println("PRECO POR PESSOA = " + mesaTemp.getNumMesa());
                System.out.println("EMAIL = " + mesaTemp.getPreco());;
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

    // ----------------------------ATUALIZANDO NOME NO REGISTRO----------------------------
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

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deletarMesa(int numMesa) {
        connect();
        String sql = "DELETE FROM Mesa where cpfCliente=?";
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



}
