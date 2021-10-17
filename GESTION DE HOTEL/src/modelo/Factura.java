/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;


public class Factura {
	/*
	 * atributos 
	 */
	private long identificador;
	private long numero_folio;
	private Formato_Pago medio_pago;
	private float neto;
	private float descuento;
	private float subtotal;
	private float total;
	private Fecha ref_fecha;
	private Cliente ref_cliente;
	private Empleado ref_empleado;
	private Hotel ref_hotel;
	private ArrayList <Item> lstItem;
	/*
	 * constructores 
	 */
	public Factura() {
		this.lstItem  =new ArrayList<Item>();
	}
	
	public Factura(long identificadorIn,long numero_folioIn,Formato_Pago medio_pagoIn,
			Float netoIn,Float descuentoIn,Float subtotalIn,Float totalIn,
			Cliente ref_clienteIn,Empleado ref_empleadoIn,Hotel ref_hotelIn) {
		this.identificador=identificadorIn;
		this.numero_folio=numero_folioIn;
		this.medio_pago=medio_pagoIn;
		this.neto=netoIn;
		this.descuento=descuentoIn;
		this.subtotal=subtotalIn;
		this.ref_cliente=ref_clienteIn;
		this.ref_empleado=ref_empleadoIn;
		this.ref_hotel=ref_hotelIn;
		this.lstItem = new ArrayList<Item>();
	}
	/*
	 * getters and setters
	 */
	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public long getNumero_folio() {
		return numero_folio;
	}

	public void setNumero_folio(long numero_folio) {
		this.numero_folio = numero_folio;
	}
	public Formato_Pago getMedio_pago() {
		return medio_pago;
	}

	public void setMedio_pago(Formato_Pago medio_pago) {
		this.medio_pago = medio_pago;
	}

	public float getNeto() {
		return neto;
	}

	public void setNeto(float neto) {
		this.neto = neto;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Fecha getRef_fecha() {
		return ref_fecha;
	}

	public void setRef_fecha(Fecha ref_fecha) {
		this.ref_fecha = ref_fecha;
	}

	public Cliente getRef_cliente() {
		return ref_cliente;
	}

	public void setRef_cliente(Cliente ref_cliente) {
		this.ref_cliente = ref_cliente;
	}

	public Empleado getRef_empleado() {
		return ref_empleado;
	}

	public void setRef_empleado(Empleado ref_empleado) {
		this.ref_empleado = ref_empleado;
	}

	public Hotel getRef_hotel() {
		return ref_hotel;
	}

	public void setRef_hotel(Hotel ref_hotel) {
		this.ref_hotel = ref_hotel;
	}

	public ArrayList<Item> getLstItem() {
		return lstItem;
	}

	public void setLstItem(ArrayList<Item> lstItem) {
		this.lstItem = lstItem;
	}
	/*
	 * metodos u operaciones
	 */
	//composicion con clase Item
	public void crear_item(Calendar fecha, String detalle, int cantidad, long pago_unitario,Factura ref_factura) {
		Item obJItem = new Item(fecha, detalle, cantidad, pago_unitario,ref_factura);
		this.lstItem.add(obJItem);
	}
	

	//composicion con clase fecha
	public void crear_fecha(Calendar fecha_entrada,Calendar fecha_salida,Factura ref_factura){
	 this.ref_fecha = new Fecha(fecha_entrada, fecha_salida,ref_factura);
	}
	
	//POLIMORFISMO TXT
	
	public String imprimir_informacion() {
		return this.getIdentificador()+","+this.getNumero_folio()+","+this.getTotal();
		
	}
				
}//fin clase