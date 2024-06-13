package grupo.persistencia;

import grupo.entidades.Venta;

public class VentaDAO extends DAO{

    public void insertarVenta(Venta venta){

        String sql = String.format("""
                INSERT INTO venta (fecha_venta, monto_venta) 
                VALUES ('%s', '%f');
                """, venta.getFecha(), venta.getMontoTotal());

        insertarModificarEliminar(sql);

    }

}
