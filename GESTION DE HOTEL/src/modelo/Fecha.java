/**
 * 
 */
package modelo;

import java.util.Calendar;

/**
 * @author Milton Caicedo10
 *
 */
public class Fecha {
	/*
	 * atributos 
	 */
	private Calendar fecha_entrada;
	
	private Calendar fecha_salida;
	private Factura refFactura;//completamos la composicion con  factura
	/*
	 * constructores 
	 */
	public Fecha() {
		
	}
	public Fecha(Calendar fecha_entrada, Calendar fecha_salida, Factura refFactura) {
		this.fecha_entrada=fecha_entrada;
		this.fecha_salida=fecha_salida;
		this.refFactura = refFactura;
	}
	/*
	 * getters and setters
	 */
	

	public Factura getRefFactura() {
		return refFactura;
	}
	public void setRefFactura(Factura refFactura) {
		this.refFactura = refFactura;
	}
	public Calendar getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(Calendar fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public Calendar getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Calendar fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	
	
	
	/*
	 * metodos u operaciones
	 */

}
