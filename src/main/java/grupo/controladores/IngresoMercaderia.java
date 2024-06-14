package grupo.controladores;

import grupo.entidades.Producto;
import grupo.entidades.Proveedor;

public class IngresoMercaderia extends EsquemaOpciones{

    public void ingresoMercaderia(){

        LOGGER.info("Ingrese el nombre del proveedor: ");
        String nombreProveedor = sc.nextLine();

        Proveedor proveedor = proveedorDAO.buscarProveedor(nombreProveedor);

        if(proveedor == null){

            proveedor = new Proveedor();

            LOGGER.info("El proveedor " + nombreProveedor + " no existe, ingrese los datos del nuevo proveedor");

            proveedor.setNombreComercial(nombreProveedor);
            
            LOGGER.info("Ingrese el CUIT del proveedor: ");
            proveedor.setCuit(Long.parseLong(sc.nextLine()));

            proveedor.setDeuda(0);

            proveedorDAO.insertarProveedor(proveedor);

        }

        LOGGER.info("Proveedor listo!");

        LOGGER.info("Ingreso de mercaderia...");

        String nombreProducto;
        
        do {

            LOGGER.info("Ingrese el nombre del producto. Si no desea ingresar mas productos solo presione ENTER. ");
            nombreProducto = sc.nextLine();

            if (nombreProducto.equals("")) break;

            Producto producto = productoDAO.buscarProducto(nombreProducto);

            if (producto == null){

                producto = new Producto();

                producto.setNombre(nombreProducto);

                LOGGER.info("Ingrese el precio de venta unitario del producto");
                producto.setPrecio(Float.parseFloat(sc.nextLine()));
                
                LOGGER.info("Ingrese la cantidad que ingresa del producto " + producto.getNombre() + ": ");
                producto.setStock(Integer.parseInt(sc.nextLine()));

                productoDAO.insertarProducto(producto);

            }else{

                LOGGER.info("Ingrese la cantidad que ingresa del producto " + producto.getNombre() + ": ");
                producto.setStock(producto.getStock()+Integer.parseInt(sc.nextLine()));

                productoDAO.modificarProducto(producto);

            }

            

        } while (true);

        LOGGER.info("Ingrese el costo total del ingreso de mercaderias: $ ");
        float montoTotal = Float.parseFloat(sc.nextLine());

        Proveedor proveedor1 = proveedorDAO.buscarProveedor(proveedor.getNombreComercial());

        montoTotal += proveedor1.getDeuda();

        proveedor1.setDeuda(montoTotal);

        proveedorDAO.modificarProveedor(proveedor1);

    }

}
