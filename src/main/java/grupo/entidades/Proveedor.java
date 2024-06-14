package grupo.entidades;

public class Proveedor {

    private int id;
    private String nombreComercial;
    private long cuit;
    private float deuda;
    
    public Proveedor(){}

    public Proveedor(String nombreComercial, long cuit) {
        this.nombreComercial = nombreComercial;
        this.cuit = cuit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }


}
