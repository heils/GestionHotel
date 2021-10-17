/**
 * 
 */
package modelo;

import java.util.ArrayList;


public class Empleado extends Persona{
	/*
	 * atributos 
	 */
	private Tipo_Cargo cargo;
	private Hotel refHotel; //completamos la composocion con clase hotel
	private ArrayList<Factura> lstFacturas; // tlavez este no es OJOOOO
	/*
	 * constructores 
	 */
	public Empleado(){
		
	}
	public Empleado(String nombre, long telefono, String direccion, long nuc_ci,Tipo_Cargo cargo, Hotel objHotel, ArrayList lstFacturasIn) {
		super(nombre, telefono, direccion, nuc_ci);
		this.cargo = cargo;
		this.refHotel=objHotel;
		this.lstFacturas=lstFacturasIn;
	}
	/*
	 * getters and setters
	 */
	
	public Tipo_Cargo getCargo() {
		return cargo;
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
	public void setCargo(Tipo_Cargo cargo) {
		this.cargo = cargo;
	}
      
	/*
	 * POLIMORFISMO CON PERSONA
	 */
	public String obtener_correo(){
		return this.getNombre()+this.getRuc_ci()+"@unicauca.edu.co";
	}
	//POLIMORFISMO TXT
	public String imprimir_informacion() {
		return this.getNombre()+","+this.getRuc_ci()+","+this.getDireccion()+","+this.getTelefono();
		
	}

}
