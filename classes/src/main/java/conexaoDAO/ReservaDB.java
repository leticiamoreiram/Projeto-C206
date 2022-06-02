package conexaoDAO;

import classes.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservaDB extends Database {

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean inserirReserva(Reserva reserva){
        connect();
        String sql = "INSERT INTO Reserva(numReserva, cpfCliente, numMesa, qtdPessoas) VALUES(?, ?, ?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, reserva.getNumReserva());      // concatena nome na primeira ? do comando
            pst.setString(2, reserva.getCpfCliente());        // concatena nome na segunda ? do comando
            pst.setInt(3, reserva.getNumMesa());        // concatena nome na terceira ? do comando
            pst.setInt(3, reserva.getQtdPessoas());        // concatena nome na quarta ? do comando
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
    public ArrayList<Reserva> buscarReserva(){
        connect();
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        String sql = "SELECT * FROM Reserva";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Reserva reservaTemp = new Reserva();
                reservaTemp.setNumReserva(result.getInt("reserva"));
                reservaTemp.setCpfCliente(result.getString("cpf"));
                reservaTemp.setNumMesa(result.getInt("mesa"));
                reservaTemp.setQtdPessoas(result.getInt("pessoas"));

                System.out.println("NUMERO DA RESERVA = " + reservaTemp.getNumReserva());
                System.out.println("CPF DO CLIENTE = " + reservaTemp.getCpfCliente());
                System.out.println("NUMERO DA MESA= " + reservaTemp.getNumMesa());
                System.out.println("QUANTIDADE DE PESSOAS = " + reservaTemp.getQtdPessoas());
                System.out.println("------------------------------");

                listaReservas.add(reservaTemp);
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
        return listaReservas;
    }

    // ----------------------------ATUALIZANDO NOME NO REGISTRO----------------------------
    public boolean atualizarReserva(int numReserva, Reserva reserva){
        connect();
        String sql = "UPDATE Reserva SET cpfCliente=?, numMesa=?, qtdPessoas=? WHERE numReserva=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, reserva.getCpfCliente());
            pst.setInt(2, reserva.getNumMesa());
            pst.setInt(3, reserva.getQtdPessoas());
            pst.setInt(4, reserva.getNumReserva());
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
    public boolean deletarReserva(int numReserva) {
        connect();
        String sql = "DELETE FROM Reserva where numReserva=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, numReserva);
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
