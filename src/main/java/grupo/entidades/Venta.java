package grupo.entidades;

import java.util.Date;

public class Venta {

    private int id;
    private Date fecha;
    private float montoTotal;

    public Venta(Date fecha, float montoTotal) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }
    public Venta() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public float getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

}
