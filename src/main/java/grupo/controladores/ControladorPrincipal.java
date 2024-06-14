package grupo.controladores;

public class ControladorPrincipal {

    CobrarProductos cobrarProductosControlador = new CobrarProductos();
    IngresoMercaderia ingresoMercaderiaControlador = new IngresoMercaderia();
    PagoProveedor pagoProveedor = new PagoProveedor();
    ConsultaDeVentas consultaDeVentas = new ConsultaDeVentas();
    Balance balance = new Balance();
    NuevoPlato nuevoPlato = new NuevoPlato();
    SolicitarComanda solicitarComanda = new SolicitarComanda();
    PagarCuenta pagarCuenta = new PagarCuenta();
    InfoEstadisticaPlatos infoEstadisticaPlatos = new InfoEstadisticaPlatos();

    public InfoEstadisticaPlatos getInfoEstadisticaPlatos() {
        return infoEstadisticaPlatos;
    }
    public void setInfoEstadisticaPlatos(InfoEstadisticaPlatos infoEstadisticaPlatos) {
        this.infoEstadisticaPlatos = infoEstadisticaPlatos;
    }
    public PagarCuenta getPagarCuenta() {
        return pagarCuenta;
    }
    public void setPagarCuenta(PagarCuenta pagarCuenta) {
        this.pagarCuenta = pagarCuenta;
    }
    public SolicitarComanda getSolicitarComanda() {
        return solicitarComanda;
    }
    public void setSolicitarComanda(SolicitarComanda solicitarComanda) {
        this.solicitarComanda = solicitarComanda;
    }
    public NuevoPlato getNuevoPlato() {
        return nuevoPlato;
    }
    public void setNuevoPlato(NuevoPlato nuevoPlato) {
        this.nuevoPlato = nuevoPlato;
    }
    public Balance getBalance() {
        return balance;
    }
    public void setBalance(Balance balance) {
        this.balance = balance;
    }
    public ConsultaDeVentas getConsultaDeVentas() {
        return consultaDeVentas;
    }
    public void setConsultaDeVentas(ConsultaDeVentas consultaDeVentas) {
        this.consultaDeVentas = consultaDeVentas;
    }
    public PagoProveedor getPagoProveedor() {
        return pagoProveedor;
    }
    public void setPagoProveedor(PagoProveedor pagoProveedor) {
        this.pagoProveedor = pagoProveedor;
    }
    public CobrarProductos getCobrarProductosControlador() {
        return cobrarProductosControlador;
    }
    public void setCobrarProductosControlador(CobrarProductos cobrarProductosControlador) {
        this.cobrarProductosControlador = cobrarProductosControlador;
    }
    public IngresoMercaderia getIngresoMercaderiaControlador() {
        return ingresoMercaderiaControlador;
    }
    public void setIngresoMercaderiaControlador(IngresoMercaderia ingresoMercaderiaControlador) {
        this.ingresoMercaderiaControlador = ingresoMercaderiaControlador;
    }

}
