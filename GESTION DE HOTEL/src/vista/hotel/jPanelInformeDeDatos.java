package vista.hotel;

import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Hotel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.FlowLayout;

public class jPanelInformeDeDatos extends JPanel {
	
	private Hotel auxObjHotel;
	private TextArea textAreaEmpleados;
	private TextArea textAreaClientes;
	

	

	
	public jPanelInformeDeDatos(Hotel objHotelIn) {
		
		this.auxObjHotel=objHotelIn;	
		lanzar_componentes();

	}
	
	public void lanzar_componentes(){
	
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_cent = new JPanel();
		add(panel_cent, BorderLayout.CENTER);
		panel_cent.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_cent.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGestorDeInformacion = new JLabel("EMPLEADOS");
		panel.add(lblGestorDeInformacion);
		
		textAreaEmpleados = new TextArea();
		textAreaEmpleados.setEditable(false);
		panel.add(textAreaEmpleados);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		panel.add(lblClientes);
		
		textAreaClientes = new TextArea();
		textAreaClientes.setEditable(false);
		panel.add(textAreaClientes);
		
		JButton btnCargar = new JButton("CARGAR EMPLEADOS");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar_datos_empleados();
			}
		});
		panel.add(btnCargar);
		
		JButton btnNewButton = new JButton("CARGAR CLIENTES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar_datos_clientes();
			}
		});
		panel.add(btnNewButton);
		
	}
	
	public void cargar_datos_empleados(){
		this.textAreaEmpleados.setRows(this.auxObjHotel.getLstEmpleados().size());
		for(int i=0;i<this.auxObjHotel.getLstEmpleados().size();i++){
			this.textAreaEmpleados.insert(("\n"+"Nombre: "+this.auxObjHotel.getLstEmpleados().get(i).getNombre()+ " Identificación: "+this.auxObjHotel.getLstEmpleados().get(i).getRuc_ci()+"\n"),i);
		}
	
	}
	public void cargar_datos_clientes(){
		this.textAreaClientes.setRows(this.auxObjHotel.getLstClientes().size());
		for(int i=0;i<this.auxObjHotel.getLstClientes().size();i++){
			this.textAreaClientes.insert(("\n"+"Nombre: "+this.auxObjHotel.getLstClientes().get(i).getNombre()+ " Dirección: "+this.auxObjHotel.getLstClientes().get(i).getDireccion()+ " Nacionalidad: " + this.auxObjHotel.getLstClientes().get(i).getNacionalidad()+"\n"),i);
		}
		
	}
}
	
	
