package grupo.persistencia;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import grupo.entidades.Venta;

public class VentaDAO extends DAO{

    public void insertarVenta(Venta venta){

        String sql = "INSERT INTO venta (fecha_venta, monto_venta) VALUES (? , ?);";

        Date fecha = new Date(venta.getFecha().getTime());

        conectarBase();

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, fecha);
            pstmt.setFloat(2, venta.getMontoTotal());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

    }
    
    public List<Venta> consultarVentasDiarias(LocalDate fecha) {
        List<Venta> ventas = new ArrayList<>();
        String sql = """
                SELECT * FROM venta 
                WHERE fecha_venta = ?;""";
        
        conectarBase();

        

        Date fechaSql = Date.valueOf(fecha);

        try {

            pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, fechaSql);

            resultSet = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        

        try {
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId(resultSet.getInt("id_venta"));
                venta.setFecha(resultSet.getDate("fecha_venta"));
                venta.setMontoTotal(resultSet.getFloat("monto_venta"));
                ventas.add(venta);
            }

            return ventas;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectarBase();
        }

        return null;
    }

  
    public List<Venta> consultarVentasMensuales(int mes, int año) {
        List<Venta> ventas = new ArrayList<>();
        String sql = String.format("""
                SELECT * FROM venta 
                WHERE MONTH(fecha_venta) = %d AND YEAR(fecha_venta) = %d;
                """, mes, año);

        consultarBase(sql);

        try {
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId(resultSet.getInt("id_venta"));
                venta.setFecha(resultSet.getDate("fecha_venta"));
                venta.setMontoTotal(resultSet.getFloat("monto_venta"));
                ventas.add(venta);
            }

            return ventas;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectarBase();
        }

        return null;
    }

    public ArrayList<Venta> consultarVentas(){

        String sql = "SELECT * FROM venta;";

        consultarBase(sql);

        ArrayList<Venta> ventas = new ArrayList<>();

        try {
            while (resultSet.next()) {
                
                Venta venta = new Venta();
                venta.setId(resultSet.getInt(1));
                venta.setFecha(resultSet.getDate(2));
                venta.setMontoTotal(resultSet.getFloat(3));

                ventas.add(venta);

            }

            return ventas;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

        return null;

    }

}
