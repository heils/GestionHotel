/**
 * 
 */
package modelo;

import java.util.ArrayList;


public class Cliente extends Persona {
	/*
	 * atributos 
	 */
	private String empresa;
	private String nacionalidad;
	private Hotel refHotel;//completamos la asociacion con clase Hotel
	private ArrayList<Factura> lstFacturas; 
	/*
	 * constructores 
	 */
	public Cliente(){
		
	}
	public Cliente(String nombre, long telefono, String direccion, long nuc_ci, String empresa, 
			String nacionalidad, Hotel refHotel, ArrayList lstFacturasIn) {
		super(nombre, telefono, direccion, nuc_ci);
		this.empresa = empresa;
		this.nacionalidad = nacionalidad;
		this.refHotel = refHotel;
		this.lstFacturas= lstFacturasIn;
	}
	/*
	 * getters and setters
	 */
	
	public String getEmpresa() {
		return empresa;
	}
	public ArrayList<Factura> getLstFacturas() {
		return lstFacturas;
	}
	public void setLstFacturas(ArrayList<Factura> lstFacturas) {
		this.lstFacturas = lstFacturas;
	}
	public Hotel getRefHotel() {
		return refHotel;
	}
	public void setRefHotel(Hotel refHotel) {
		this.refHotel = refHotel;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	/*
	 * metodos u operaciones
	 */
	//POLIMOSRFISMO CON PERSONA
	public String obtener_correo(){
		return this.getNombre()+"@gmail.com";
	}
	//POLIMORFISMO PARA LOS TXT
	public String imprimir_informacion() {
		return this.getNombre()+","+this.getRuc_ci()+","+this.getDireccion()+","+this.getEmpresa()+","+this.getNacionalidad()+","+this.getTelefono();
		
	}

}
