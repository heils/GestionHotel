/**
 * 
 */
package modelo;

import java.util.Calendar;

/**
 * @author Milton Caicedo10
 *
 */
public class Item {
	/*
	 * atributos 
	 */
	private Calendar fecha;
	private String detalle="";
	private int cantidad;
	private float pago_unitario;
	private Factura refFactura;//completamos la composicion con factura
	/*
	 * constructores 
	 */
	public Item() {
		
	}
	public Item(Calendar fecha, String detalle, int cantidad, float pago_unitario, Factura refFactura) {
		this.fecha = fecha;
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.pago_unitario = pago_unitario;
		this.refFactura = refFactura;
	}
	/*
	 * getters and setters
	 */
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPago_unitario() {
		return pago_unitario;
	}
	public void setPago_unitario(float pago_unitario) {
		this.pago_unitario = pago_unitario;
	}
	public Factura getRefFactura() {
		return refFactura;
	}
	public void setRefFactura(Factura refFactura) {
		this.refFactura = refFactura;
	}
	
	

	/*
	 * metodos u operaciones
	 */

}
