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

        //Proveedores
        sql = """
                CREATE TABLE IF NOT EXISTS proveedor (
                    proveedor_id INT AUTO_INCREMENT,
                    nombre_comercial VARCHAR(30) NOT NULL,
                    cuit BIGINT NOT NULL,
                    deuda FLOAT,
                    PRIMARY KEY (proveedor_id));
                """;
        insertarModificarEliminar(sql);

        //Platos

        sql = """
                CREATE TABLE IF NOT EXISTS plato (
                    id_plato INT AUTO_INCREMENT PRIMARY KEY,
                    nombre_plato VARCHAR(255) NOT NULL,
                    precio_plato FLOAT NOT NULL,
                    pedido_plato INT NOT NULL
                );
                """;
        insertarModificarEliminar(sql);

        //Comandas

        sql = """
                CREATE TABLE IF NOT EXISTS comanda (
                    id_comanda INT AUTO_INCREMENT PRIMARY KEY,
                    fecha_comanda DATE NOT NULL,
                    monto_comanda FLOAT NOT NULL
                );
                """;

        insertarModificarEliminar(sql);

    }

}
