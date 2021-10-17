/**
 * 
 */
package modelo;

/**
 * @author Milton Caicedo10
 *
 */
public abstract class Persona {
	/*
	 * atributos 
	 */
	private String nombre;
	private long telefono;
	private String direccion; 
	private long ruc_ci;
	/*
	 * constructores 
	 */
	public Persona() {
		
	}
	public Persona(String nombre, long telefono, String direccion, long ruc_ci) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ruc_ci = ruc_ci;
	}
	/*
	 * getters and setters
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getRuc_ci() {
		return ruc_ci;
	}
	public void setRuc_ci(long ruc_ci) {
		this.ruc_ci = ruc_ci;
	}
	
	/*
	 * POLIMORFISMO
	 */
	public abstract String obtener_correo();

}
