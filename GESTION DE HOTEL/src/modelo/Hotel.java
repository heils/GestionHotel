/**
 * 
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Milton Caicedo10
 *
 */
public class Hotel {
	/*
	 * atributos 
	 */
	private long nit;
	private String nombre=""; 
	private long telefono;
	private String direccion; 
	private String pagina_web;
	private ArrayList<Factura> lstFacturas;//esta linea de codig hace referencia al metodo de composocion con factura
	private ArrayList<Empleado> lstEmpleados;//esta linea de codig hace referencia al metodo de agregacion con empleado
	private ArrayList<Cliente> lstClientes;
	/*
	 * constructores 
	 */
	public Hotel() {
		this.lstFacturas = new ArrayList<Factura>();
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstClientes = new ArrayList<Cliente>();
	}
	public Hotel(long nit,String nombre, long telefono, String direccion, String pagina_web) {
		this.nit  = nit; 
		this.nombre = nombre; 
		this.telefono = telefono;
		this.direccion = direccion;
		this.pagina_web = pagina_web;
		this.lstFacturas = new ArrayList<Factura>();
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstClientes = new ArrayList<Cliente>();
	}
	/*
	 * getters and setters
	 */
	
	public long getNit(){
		return nit;
	}
	public ArrayList<Cliente> getLstClientes() {
		return lstClientes;
	}
	public void setLstClientes(ArrayList<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}
	public ArrayList<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	public void setLstEmpleados(ArrayList<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}
	public void setNit(long nit) {
		this.nit = nit;
	}
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
	public String getPagina_web() {
		return pagina_web;
	}
	public void setPagina_web(String pagina_web) {
		this.pagina_web = pagina_web;
	}
	public ArrayList<Factura> getLstFacturas() {
		return lstFacturas;
	}
	public void setLstFacturas(ArrayList<Factura> lstFacturas) {
		this.lstFacturas = lstFacturas;
	}
	/*
	 * metodos u operaciones
	 */
	//composicion con factura 
	public void crear_factura(long identificadorIn,long numero_folioIn,Calendar fecha_autIn,Calendar fecha_cadIn,Formato_Pago medio_pagoIn,
			Float netoIn,Float descuentoIn,Float subtotalIn,Float totalIn,Fecha ref_fechaIn,
			Cliente ref_clienteIn,Empleado ref_empleadoIn,Hotel ref_hotelIn) {
		Factura objFactura = new Factura(identificadorIn,numero_folioIn,medio_pagoIn,
				netoIn,descuentoIn,subtotalIn,totalIn,
				ref_clienteIn,ref_empleadoIn,ref_hotelIn);
		this.lstFacturas.add(objFactura);
	}
	//composicion con la clase empleado
	public void contratar_empleado(String nombre, long telefono, String direccion, long nuc_ci,Tipo_Cargo cargo,Hotel objHotel) {
		Empleado objEmpleado = new Empleado(nombre, telefono, direccion, nuc_ci, cargo,objHotel,lstFacturas);
		this.lstEmpleados.add(objEmpleado);
	}
	//agregacion con la clase cliente 
	public boolean agregar_cliente(Cliente objCliente) {
		this.lstClientes.add(objCliente);
		return true;
		
	}
	public void eliminar_listas(){
		this.lstClientes=null;
		this.lstEmpleados=null;
		this.lstFacturas=null;
		Runtime.getRuntime().gc();
	}

}//fin clase
