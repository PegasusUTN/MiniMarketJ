package grupo.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import grupo.entidades.Plato;

public class PlatoDAO extends DAO{

    public void insertarPlato(Plato plato){
        
        String sql = String.format("""
                        INSERT INTO plato (nombre_plato, precio_plato, pedido_plato)
                        VALUES ('%s', %.2f, %d);
                    """, plato.getNombre(), plato.getPrecio(), plato.getVecesPedido());
        
        insertarModificarEliminar(sql);

    }

    public void modificarPlato(Plato plato){

        String sql = String.format("""
                UPDATE plato SET
                pedido_plato = %d 
                WHERE nombre_plato = '%s';
                """, plato.getVecesPedido(), plato.getNombre());
        
        insertarModificarEliminar(sql);

    }

    public Plato consultarPlato(String nombre) {

        String sql = String.format("SELECT * FROM plato WHERE nombre_plato = '%s';", nombre);

        consultarBase(sql);

        try {
            if (!resultSet.next()) {
                return null;
            } else {
                Plato plato = new Plato();
                plato.setId(resultSet.getInt(1));
                plato.setNombre(resultSet.getString(2));
                plato.setPrecio(resultSet.getFloat(3));
                plato.setVecesPedido(resultSet.getInt(4));

                return plato;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectarBase();
        }

        return null;

    }

    public ArrayList<Plato> consultarPlatos(){

        String sql = "SELECT * FROM plato;";

        consultarBase(sql);

        ArrayList<Plato> platos = new ArrayList<>();

        try {
            while (resultSet.next()) {
                
                Plato plato = new Plato();

                plato.setId(resultSet.getInt(1));
                plato.setNombre(resultSet.getString(2));
                plato.setPrecio(resultSet.getFloat(3));
                plato.setVecesPedido(resultSet.getInt(4));

                platos.add(plato);

            }

            return platos;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

        return null;

    }

}
