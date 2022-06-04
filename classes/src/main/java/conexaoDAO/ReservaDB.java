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
            System.out.println("Reserva efetuada com sucesso!");

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

    public boolean atualizarReserva(String cpfCliente, int qtdPessoas, String dataReserva){
        connect();
        String sql = "UPDATE Reserva SET qtdPessoas=?, dataReserva=? WHERE cpfCliente=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, qtdPessoas);
            pst.setString(2, dataReserva);
            pst.setString(3,cpfCliente);

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

    public boolean deletarReserva(String cpfCliente) {
        connect();
        String sql = "DELETE FROM Reserva where cpfCliente=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpfCliente);
            pst.execute();
            check = true;
            System.out.println("Reserva cancelada");
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

    public Reserva buscarReservaPorCpf(String cpfCliente) {
        Reserva reservaTemp = null;
        connect();

        String sql = "SELECT * FROM Reserva WHERE cpfCliente=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpfCliente);
            result = pst.executeQuery();

            while (result.next()) {

                reservaTemp = new Reserva();
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

        return reservaTemp;
    }


}