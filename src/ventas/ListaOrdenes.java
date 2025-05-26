package ventas;

import java.util.ArrayList;

public class ListaOrdenes {
    private ArrayList<OrdenDeCompra> ordenes;

    public void AgregarOrden(OrdenDeCompra _orden){
        this.ordenes.add(_orden);
    }

    public ArrayList<OrdenDeCompra> getOrdenes(){
        return this.ordenes;
    }

    public boolean deleteOrden(OrdenDeCompra _orden){
        return this.ordenes.remove(_orden);
    }

    public void exportar(){
        //TODO
    }
}
