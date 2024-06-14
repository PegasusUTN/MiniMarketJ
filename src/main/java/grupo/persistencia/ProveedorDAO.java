package grupo.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupo.entidades.Proveedor;

public class ProveedorDAO extends DAO {
    
    
    public ProveedorDAO(){}
    
    public void insertarProveedor(Proveedor proveedor) {
        // Construir la instrucción SQL usando String.format correctamente
        String sql = String.format("INSERT INTO proveedor (nombre_comercial, cuit, deuda) VALUES ('%s', %d, %.2f);",
                proveedor.getNombreComercial(), proveedor.getCuit(), proveedor.getDeuda());
    
        // Llamar al método para ejecutar la instrucción SQL
        insertarModificarEliminar(sql);
    }
    

    public void modificarProveedor(Proveedor proveedor){
        // El ID es lo unico que no se actualiza
        // y como no se sabe qué campo se actualiza porque no sabemos
        // que metodo u operacion lo invoco, se actualiza todo con el proveedor 
        // ya actualizado en la logica.
        // Perdon mati jajaja
        String sql = "UPDATE proveedor SET nombre_comercial='" + proveedor.getNombreComercial() + "', cuit=" + proveedor.getCuit()+ ", deuda = " + proveedor.getDeuda() + " WHERE proveedor.proveedor_id = " + proveedor.getId();
        this.insertarModificarEliminar(sql);
    }
    // NO IMPLEMENTADO
    public void eliminarProveedor(){}

    public Proveedor buscarProveedor(String nombre){

        String sql = String.format("""
                SELECT * FROM proveedor WHERE nombre_comercial = '%s'
                """, nombre);
        
        consultarBase(sql);

        try {
            while (resultSet.next()) {
                
                Proveedor proveedor = new Proveedor();
                proveedor.setId(resultSet.getInt(1));
                proveedor.setNombreComercial(resultSet.getString(2));
                proveedor.setCuit(resultSet.getLong(3));
                proveedor.setDeuda(resultSet.getFloat(4));
                
                return proveedor;
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }finally{
            desconectarBase();
        }

        return null;

    }
    
    public ArrayList<Proveedor> buscarProveedores(){
        String sql = String.format("SELECT * FROM proveedor");
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        this.consultarBase(sql);
        //while para retornar un arrayList de proveedores
        
        try {
            while(this.resultSet.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(this.resultSet.getInt("proveedor_id"));
                proveedor.setNombreComercial(this.resultSet.getString("nombre_comercial"));
                proveedor.setCuit(this.resultSet.getLong("cuit"));
                proveedor.setDeuda(this.resultSet.getFloat("deuda"));
                proveedores.add(proveedor);
            }
            return proveedores;
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            desconectarBase();
        }
    }
}