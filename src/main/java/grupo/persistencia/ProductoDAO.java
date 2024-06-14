package grupo.persistencia;

import java.sql.SQLException;

import java.util.ArrayList;

import grupo.entidades.Producto;

public class ProductoDAO extends DAO{

    public void insertarProducto(Producto producto){

        String sql = String.format("""
                        INSERT INTO producto (nombre_producto, precio_producto, stock_producto)
                        VALUES ('%s', '%.2f', '%d');
                    """, producto.getNombre(), producto.getPrecio(), producto.getStock());
        
        insertarModificarEliminar(sql);

    }

    public void modificarProducto(Producto producto){

        String sql = String.format("""
                UPDATE producto SET
                nombre_producto = '%s',
                precio_producto = '%.2f',
                stock_producto = '%d'
                WHERE nombre_producto = '%s';
                """, producto.getNombre(), producto.getPrecio(), producto.getStock(), producto.getNombre());

        insertarModificarEliminar(sql);

    }

    public void modificarProductoStock(Producto producto){

        String sql = String.format("""
                UPDATE producto SET
                stock_producto = %d WHERE nombre_producto = '%s';
                """, producto.getStock(), producto.getNombre());
        
        insertarModificarEliminar(sql);

    }

    public Producto buscarProducto(String nombre){

        String sql = String.format("""
                SELECT * FROM producto WHERE nombre_producto = '%s'
                """, nombre);
        
        consultarBase(sql);

        try {

            while (resultSet.next()) {
                
                Producto producto = new Producto();
                producto.setId(resultSet.getInt(1));
                producto.setNombre(resultSet.getString(2));
                producto.setPrecio(resultSet.getFloat(3));
                producto.setStock(resultSet.getInt(4));

                return producto;
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }finally{
            desconectarBase();
        }

        return null;
    
    }

    public ArrayList<Producto> buscarProductos() {
        String sql = String.format("SELECT * FROM producto WHERE stock_producto > 0");
        ArrayList<Producto> productos = new ArrayList<>();
        this.consultarBase(sql);
        //while para retornar un arrayList de proveedores

        try {
            if (!this.resultSet.next()) {
                return null;
            }
            do {
                Producto producto = new Producto();
                producto.setId(this.resultSet.getInt("id_producto"));
                producto.setNombre(this.resultSet.getString("nombre_producto"));
                producto.setPrecio(this.resultSet.getFloat("precio_producto"));
                producto.setStock(this.resultSet.getInt("stock_producto"));
                productos.add(producto);
            } while (this.resultSet.next());
            return productos;
        } catch (SQLException ex) {
            ex.getMessage();
            return null;
        } finally {
            desconectarBase();
        }
    }

}
