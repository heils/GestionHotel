package datos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.Hotel;

public class GestionArchivo {
	//atributos
	private Hotel auxObjHotel;
	DataInputStream origenDatos= null;
	FileInputStream archivo= null;
	DataOutputStream destinoDatos = null;
	FileOutputStream archivoSalida = null;
	String linea;
	String [] elementos;
	
	
	//Constructor 
	
	public GestionArchivo(Hotel objHotelIn){
		this.auxObjHotel=objHotelIn;
	}

	
	//getters and setters 
	public Hotel getAuxObjHotel() {
		return auxObjHotel;
	}


	public void setAuxObjHotel(Hotel auxObjHotel) {
		this.auxObjHotel = auxObjHotel;
	}
	//metodos
	
	public void leer_archivo_clientes(){
		
		boolean banderita=true;
		Cliente objAuxCliente=null;
		try{
			this.archivo= new FileInputStream("clientes.txt");
			this.origenDatos=new DataInputStream(archivo);
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
	
			while(banderita){
				objAuxCliente= new Cliente();
				linea = origenDatos.readUTF();
				elementos = linea.split(",");
				objAuxCliente.setNombre(elementos[0]);
				objAuxCliente.setRuc_ci(Integer.parseInt(elementos[1]));
				objAuxCliente.setDireccion(elementos[2]);
				objAuxCliente.setEmpresa(elementos[3]);
				objAuxCliente.setNacionalidad(elementos[4]);
				objAuxCliente.setTelefono(Integer.parseInt(elementos[5]));
				this.auxObjHotel.getLstClientes().add(objAuxCliente);		
			}
			
		} catch(EOFException e){
			JOptionPane.showMessageDialog(null, "Carga de datos Hotel con exito", "Gestion de Archivo", JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch (IOException e) {		
			JOptionPane.showMessageDialog(null, "Archivo con informacion no valida", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		finally{
			try {
				archivo.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "No se puede cerrar el archivo", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		
		
		
	}
	public void escribir_archivo_clientes(){
		try {
			archivoSalida = new FileOutputStream("clientes.txt");
			destinoDatos = new DataOutputStream(archivoSalida);
			Cliente objCliente;
			for(int i=0;i<this.auxObjHotel.getLstClientes().size();i++){
				objCliente = this.auxObjHotel.getLstClientes().get(i);
				linea = objCliente.imprimir_informacion();
				destinoDatos.writeUTF(linea);
				
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en la salida de datos", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
				
			
		}finally{
			try {
				archivoSalida.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar el archivo", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			
			}
		}
	 
	}
	
	public void leer_archivo_empleados(){
		
		boolean banderita=true;
		Empleado objAuxEmpleado=null;
		try{
			this.archivo= new FileInputStream("empleados.txt");
			this.origenDatos=new DataInputStream(archivo);
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			while(banderita){
				objAuxEmpleado= new Empleado();
				linea = origenDatos.readUTF();
				elementos = linea.split(",");
				objAuxEmpleado.setNombre(elementos[0]);
				objAuxEmpleado.setRuc_ci(Integer.parseInt(elementos[1]));
				objAuxEmpleado.setDireccion(elementos[2]);
				objAuxEmpleado.setTelefono(Integer.parseInt(elementos[3]));
				this.auxObjHotel.getLstEmpleados().add(objAuxEmpleado);		
			}
			
		} 
		catch (IOException e) {		
			
			return;
		}
		finally{
			try {
				archivo.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "No se puede cerrar el archivo", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		
		
		
	}
	public void escribir_archivo_empleados(){
		try {
			archivoSalida = new FileOutputStream("empleados.txt");
			destinoDatos = new DataOutputStream(archivoSalida);
			Empleado objEmpleado;
			for(int i=0;i<this.auxObjHotel.getLstEmpleados().size();i++){
				objEmpleado = this.auxObjHotel.getLstEmpleados().get(i);
				linea = objEmpleado.imprimir_informacion();
				destinoDatos.writeUTF(linea);
				
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en la salida de datos", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
				
			
		}finally{
			try {
				archivoSalida.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar el archivo", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			
			}
		}
	 
	}
	
	public void leer_archivo_facturas(){
		
		boolean banderita=true;
		Factura objAuxFactura=null;
		try{
			this.archivo= new FileInputStream("facturas.txt");
			this.origenDatos=new DataInputStream(archivo);
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			while(banderita){
				objAuxFactura= new Factura();
				linea = origenDatos.readUTF();
				elementos = linea.split(",");
				objAuxFactura.setIdentificador(Integer.parseInt(elementos[0]));
				objAuxFactura.setNumero_folio(Integer.parseInt(elementos[1]));
				this.auxObjHotel.getLstFacturas().add(objAuxFactura);		
			}
			
		} 
		catch (IOException e) {		
			
			return;
		}
		finally{
			try {
				archivo.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "No se puede cerrar el archivo", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		
		
		
	}
	public void escribir_archivo_facturas(){
		try {
			archivoSalida = new FileOutputStream("facturas.txt");
			destinoDatos = new DataOutputStream(archivoSalida);
			Factura objFactura;
			for(int i=0;i<this.auxObjHotel.getLstFacturas().size();i++){
				objFactura = this.auxObjHotel.getLstFacturas().get(i);
				linea = objFactura.imprimir_informacion();
				destinoDatos.writeUTF(linea);
				
			}
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Archivo no encontrado", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error en la salida de datos", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			return;
				
			
		}finally{
			try {
				archivoSalida.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar el archivo", "Gestion de Archivo", JOptionPane.ERROR_MESSAGE);
			
			}
		}
	 
	}

}
