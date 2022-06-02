package conexaoDAO;

import classes.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservaDB extends Database {

    public boolean inserirReserva(Reserva reserva){
        connect();
        String sql = "INSERT INTO Reserva(numReserva, cpfCliente, numMesa, qtdPessoas, dataReserva) VALUES(?, ?, ?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, reserva.getNumReserva());
            pst.setString(2, reserva.getCpfCliente());
            pst.setInt(3, reserva.getNumMesa());
            pst.setInt(4, reserva.getQtdPessoas());
            pst.setString(5, reserva.getDataReserva());
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

    public ArrayList<Reserva> buscarReserva(){
        connect();
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        String sql = "SELECT * FROM Reserva";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Reserva reservaTemp = new Reserva();
                reservaTemp.setNumReserva(result.getInt("numReserva"));
                reservaTemp.setCpfCliente(result.getString("cpfCliente"));
                reservaTemp.setNumMesa(result.getInt("numMesa"));
                reservaTemp.setQtdPessoas(result.getInt("qtdPessoas"));
                reservaTemp.setDataReserva(result.getString("dataReserva"));

                System.out.println("NUMERO DA RESERVA = " + reservaTemp.getNumReserva());
                System.out.println("CPF DO CLIENTE = " + reservaTemp.getCpfCliente());
                System.out.println("NUMERO DA MESA= " + reservaTemp.getNumMesa());
                System.out.println("QUANTIDADE DE PESSOAS = " + reservaTemp.getQtdPessoas());
                System.out.println("DATA DA RESERVA = " + reservaTemp.getDataReserva());
                System.out.println("-------------------------------------------");

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

    public boolean atualizarReserva(int numReserva, Reserva reserva){
        connect();
        String sql = "UPDATE Reserva SET cpfCliente=?, numMesa=?, qtdPessoas=?, dataReserva=? WHERE numReserva=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, reserva.getCpfCliente());
            pst.setInt(2, reserva.getNumMesa());
            pst.setInt(3, reserva.getQtdPessoas());
            pst.setString(4, reserva.getDataReserva());
            pst.setInt(5, reserva.getNumReserva());
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
