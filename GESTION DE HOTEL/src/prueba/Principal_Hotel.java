/**
 * 
 */
package prueba;

import java.util.ArrayList;

import datos.GestionArchivo;
import modelo.Hotel;
import vista.frmMenuHotel;


public class Principal_Hotel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hotel objHotel = new Hotel();
		GestionArchivo objGAHotel = new GestionArchivo(objHotel);	
		objGAHotel.leer_archivo_clientes();
		objGAHotel.leer_archivo_empleados();
		objGAHotel.leer_archivo_facturas();
	
		frmMenuHotel objFRMMenu=new frmMenuHotel(objHotel);
		objFRMMenu.setVisible(true);
		
	

	}

}
