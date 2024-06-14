package grupo.persistencia;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import grupo.entidades.Comanda;

public class ComandaDAO extends DAO{

    public void insertarComanda(Comanda comanda){

        String sql = "INSERT INTO comanda (fecha_comanda, monto_comanda) VALUES (? , ?);";

        Date fecha = new Date(comanda.getFecha().getTime());

        conectarBase();

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, fecha);
            pstmt.setFloat(2, comanda.getMontoTotal());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

    }

    public void modificarComanda(Comanda comanda){

        String sql = String.format("""
                UPDATE comanda SET
                monto_comanda = %.2f WHERE id_comanda = %d;
                """, comanda.getMontoTotal(), comanda.getId());
        
        insertarModificarEliminar(sql);

    }

    public Comanda consultarComandaPorID(int id){

        String sql = "SELECT * FROM comanda WHERE id_comanda = " + id + ";";

        consultarBase(sql);

        try {
            while (resultSet.next()) {
                
                Comanda comanda = new Comanda();

                comanda.setId(resultSet.getInt(1));
                comanda.setFecha(resultSet.getDate(2));
                comanda.setMontoTotal(resultSet.getFloat(3));

                return comanda;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

        return null;

    }

    public ArrayList<Comanda> consultarComandas(){

        String sql = "SELECT * FROM comanda;";

        consultarBase(sql);

        ArrayList<Comanda> comandas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                
                Comanda comanda = new Comanda();
                comanda.setId(resultSet.getInt(1));
                comanda.setFecha(resultSet.getDate(2));
                comanda.setMontoTotal(resultSet.getFloat(3));

                comandas.add(comanda);

            }

            return comandas;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

        return null;

    }

    public ArrayList<Comanda> consultarComandasAPagar(){

        String sql = "SELECT * FROM comanda WHERE monto_comanda > 0;";

        consultarBase(sql);

        ArrayList<Comanda> comandas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                
                Comanda comanda = new Comanda();
                comanda.setId(resultSet.getInt(1));
                comanda.setFecha(resultSet.getDate(2));
                comanda.setMontoTotal(resultSet.getFloat(3));

                comandas.add(comanda);

            }

            return comandas;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

        return null;

    }

}
