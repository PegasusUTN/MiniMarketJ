package grupo.persistencia;

public class CrearTablasDAO extends DAO{

    public void crearTablas(){

        String sql;


        //Productos
        sql = """
                CREATE TABLE IF NOT EXISTS producto (
                    id_producto INT AUTO_INCREMENT PRIMARY KEY,
                    nombre_producto VARCHAR(255) NOT NULL,
                    precio_producto FLOAT NOT NULL,
                    stock_producto INT NOT NULL
                );
                """;

        insertarModificarEliminar(sql);

        //Ventas
        sql = """
                CREATE TABLE IF NOT EXISTS venta (
                    id_venta INT AUTO_INCREMENT PRIMARY KEY,
                    fecha_venta DATE NOT NULL,
                    monto_venta FLOAT NOT NULL
                );
                """;

        insertarModificarEliminar(sql);

    }

}
