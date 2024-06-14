package grupo.controladores;

import java.util.Date;

import grupo.entidades.Producto;
import grupo.entidades.Venta;

public class CobrarProductos extends EsquemaOpciones{

    public void cobrarProductos(){

        String nombre;

        float montoTotal = 0;

        do {
            
            LOGGER.info("Ingrese el nombre del producto. Si no desea ingresar mas productos unicamente presione ENTER");
            nombre = sc.nextLine();

            if (!nombre.equals("")) {
                
                Producto producto = productoDAO.buscarProducto(nombre);
    
                if((producto != null)){
    
                    LOGGER.info("Cuantas unidades del producto se venderan?");
                    int cantidad = Integer.parseInt(sc.nextLine());
    
                    if ((producto.getStock() - cantidad) >= 0){
    
                        producto.setStock(producto.getStock()-cantidad);

                        montoTotal += cantidad*producto.getPrecio();

                        productoDAO.modificarProducto(producto);
    
                    }else{
                        LOGGER.info("No hay suficientes unidades del producto seleccionado!");
                    }
    
                }else{
                    LOGGER.info("El producto ingresado no existe!");
                }

            }else{
                if (nombre.equals("")) break;
            }

        } while (true);

        Venta venta = new Venta(new Date(), montoTotal);
        
        ventaDAO.insertarVenta(venta);

    }

}
