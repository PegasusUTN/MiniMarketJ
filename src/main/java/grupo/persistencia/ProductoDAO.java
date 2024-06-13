package grupo.persistencia;

import java.sql.SQLException;

import grupo.entidades.Producto;

public class ProductoDAO extends DAO{

    public void insertarProducto(Producto producto){

        String sql = String.format("""
                        INSERT INTO producto (nombre_producto, precio_producto, stock_producto)
                        VALUES ('%s', '%f', '%d');
                    """, producto.getNombre(), producto.getPrecio(), producto.getStock());
        
        insertarModificarEliminar(sql);

    }

    public void modificarProducto(Producto producto){

        String sql = String.format("""
                UPDATE producto SET
                nombre_producto = '%s',
                precio_producto = '%f',
                stock_producto = '%d'
                WHERE nombre_producto = '%s';
                """, producto.getNombre(), producto.getPrecio(), producto.getStock(), producto.getNombre());

        insertarModificarEliminar(sql);

    }

    public void modificarProductoStock(Producto producto){

        String sql = String.format("""
                UPDATE producto SET
                stock_producto = '%d' WHERE nombre_producto = '%s';
                """, producto.getStock(), producto.getNombre());
        
        insertarModificarEliminar(sql);

    }

    public Producto buscarProducto(String nombre){

        String sql = String.format("""
                SELECT * FROM producto
                WHERE nombre_producto = '%s'
                """, nombre);
        
        consultarBase(sql);

        Producto producto = new Producto();
        try {

            while (resultSet.next()) {
                
                producto.setId(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getFloat(3));
                producto.setStock(resultSet.getInt(4));

            }

            desconectarBase();
            return producto;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    
    }

}
