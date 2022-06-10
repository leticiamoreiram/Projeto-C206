package conexaoDAO;

import classes.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservaDB extends Database {

    public boolean inserirReserva(Reserva reserva){
        connect();
        String sql = "INSERT INTO Reserva(numReserva, Cliente_cpfCliente, qtdPessoas, dataReserva) VALUES(?, ?,?,?)";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, reserva.getNumReserva());
            pst.setString(2, reserva.getCpfCliente());
              pst.setInt(3, reserva.getQtdPessoas());
            pst.setString(4, reserva.getDataReserva());
            pst.execute();
            check = true;
            System.out.println("Reserva efetuada com sucesso!");
            System.out.println(" ");

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
                reservaTemp.setQtdPessoas(result.getInt("qtdPessoas"));
                reservaTemp.setDataReserva(result.getString("dataReserva"));

                System.out.println("CPF DO CLIENTE = " + reservaTemp.getCpfCliente());
                System.out.println("NUMERO DA RESERVA = " + reservaTemp.getNumReserva());
                System.out.println("QUANTIDADE DE PESSOAS = " + reservaTemp.getQtdPessoas());
                System.out.println("DATA DA RESERVA = " + reservaTemp.getDataReserva());
                System.out.println(" ");

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

    public boolean atualizarReserva(String Cliente_cpfCliente, String dataReserva){
        connect();
        String sql = "UPDATE Reserva SET  dataReserva=? WHERE Cliente_cpfCliente=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, dataReserva);
            pst.setString(2,Cliente_cpfCliente);
            pst.execute();
            check = true;
            System.out.println("Alterações realizadas com sucesso!");
            System.out.println(" ");
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

    public boolean deletarReserva(String Cliente_cpfCliente) {
        connect();
        String sql = "DELETE FROM Reserva where Cliente_cpfCliente=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, Cliente_cpfCliente);
            pst.execute();
            check = true;
            System.out.println("Reserva cancelada!");
            System.out.println(" ");
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

    public Reserva buscarReservaPorCpf(String Cliente_cpfCliente) {
        Reserva reservaTemp = null;
        connect();

        String sql = "SELECT * FROM Reserva WHERE Cliente_cpfCliente=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Cliente_cpfCliente);
            result = pst.executeQuery();

            while (result.next()) {

                reservaTemp = new Reserva();
                reservaTemp.setNumReserva(result.getInt("numReserva"));
                reservaTemp.setCpfCliente(result.getString("Cliente_cpfCliente"));
                reservaTemp.setQtdPessoas(result.getInt("qtdPessoas"));
                reservaTemp.setDataReserva(result.getString("dataReserva"));

                System.out.println("CPF DO CLIENTE = " + reservaTemp.getCpfCliente());
                System.out.println("NUMERO DA RESERVA = " + reservaTemp.getNumReserva());
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




    public boolean reservaHasMesa(int Reserva_numReserva, int Mesa_numMesa) {

        connect();
        String sql = "INSERT INTO Reserva_has_Mesa (Reserva_numReserva, Mesa_numMesa) values(?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Reserva_numReserva);
            pst.setInt(2, Mesa_numMesa);
            pst.execute();
            check = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return check;
    }
}
