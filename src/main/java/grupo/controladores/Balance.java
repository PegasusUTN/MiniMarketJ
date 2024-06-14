package grupo.controladores;

import java.util.ArrayList;

import grupo.entidades.Proveedor;
import grupo.entidades.Venta;

public class Balance extends EsquemaOpciones{

    public void balance(){

        float montoAFavor = calcularMontoFavor();

        float montoEnContra = calcularMontoContra();

        LOGGER.info(String.format("Monto a favor: $%.2f", montoAFavor));

        LOGGER.info(String.format("Monto en contra: $%.2f", montoEnContra));

        LOGGER.info(String.format("""
                ---------------------------
                Balance general: $%.2f
                ---------------------------
                """, (montoAFavor-montoEnContra)));

    }

    public float calcularMontoFavor(){

        ArrayList<Venta> ventas = new ArrayList<>(ventaDAO.consultarVentas());

        float montoFavor = 0;

        for (Venta venta : ventas) {
            montoFavor += venta.getMontoTotal();
        }

        return montoFavor;

    }

    public float calcularMontoContra(){

        ArrayList<Proveedor> proveedores = new ArrayList<>(proveedorDAO.buscarProveedores());

        float montoContra = 0;

        for (Proveedor proveedor : proveedores) {
            montoContra += proveedor.getDeuda();
        }

        return montoContra;

    }

}
