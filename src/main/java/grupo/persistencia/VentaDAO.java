package grupo.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import grupo.entidades.Venta;

public class VentaDAO extends DAO{

    public void insertarVenta(Venta venta){

        String sql = String.format("""
                INSERT INTO venta (fecha_venta, monto_venta) 
                VALUES ('%s', '%f');
                """, venta.getFecha(), venta.getMontoTotal());

        insertarModificarEliminar(sql);

    }

    //    4-Consulta de ventas
    //        a- Diaria
    //        b- Mensual

    public List<Venta> consultarVentasDiarias(Date fecha) {
        List<Venta> ventas = new ArrayList<>();
        String sql = String.format("""
                SELECT * FROM venta 
                WHERE fecha_venta = '%s';
                """, fecha);

        consultarBase(sql);

        try {
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId(resultSet.getInt("id_venta"));
                venta.setFecha(resultSet.getDate("fecha_venta"));
                venta.setMontoTotal(resultSet.getFloat("monto_venta"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectarBase();
        }

        return ventas;
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectarBase();
        }

        return ventas;
    }

}
