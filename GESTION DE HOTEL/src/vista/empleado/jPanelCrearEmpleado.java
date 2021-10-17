package vista.empleado;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import modelo.Empleado;
import modelo.Hotel;
import modelo.Tipo_Cargo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelCrearEmpleado extends JPanel {
	
	private JTextField txtNombreEmpleado;
	private JTextField txtTelEmpleado;
	private JTextField txtIdEmpleado;
	private Hotel auxobjHotel;
	private JTextField txtDireccion;
	private JComboBox <Tipo_Cargo> cbxCargoEmpleado;

	/**
	 * Create the panel.
	 */
	public jPanelCrearEmpleado(Hotel objHotelIn) {
		this.auxobjHotel=objHotelIn;
		lanzar_componentes();
	}
	public void lanzar_componentes(){
	JLabel lblCrearEmpleado = new JLabel("Crear Empleado");
		
		JLabel lblDigiteElNombre = new JLabel("Digite el nombre:");
		
		txtNombreEmpleado = new JTextField();
		txtNombreEmpleado.setColumns(10);
		
		JLabel lblDigiteElTelefono = new JLabel("Digite el telefono:");
		
		txtTelEmpleado = new JTextField();
		txtTelEmpleado.setColumns(10);
		
		cbxCargoEmpleado = new JComboBox();
		cbxCargoEmpleado.setModel(new DefaultComboBoxModel(Tipo_Cargo.values()));
		
		JLabel lblSeleccioneCargo = new JLabel("Seleccione cargo:");
		
		JLabel lblNewLabel = new JLabel("Digite identificacion:");
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setText("");
		txtIdEmpleado.setColumns(10);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear_empleado2();		
			}
		});
		
		JLabel lblDrieccion = new JLabel("Direccion:");
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(148)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDigiteElNombre)
								.addComponent(lblDigiteElTelefono))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtTelEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSeleccioneCargo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxCargoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCrear)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblDrieccion)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(228, Short.MAX_VALUE)
					.addComponent(lblCrearEmpleado)
					.addGap(146))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCrearEmpleado)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxCargoEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeleccioneCargo))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombreEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDigiteElNombre))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDigiteElTelefono))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDrieccion))
					.addGap(18)
					.addComponent(btnCrear)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	public void crear_empleado2(){
		
		try{
			
			if(this.txtDireccion.getText().equals("") || this.txtIdEmpleado.getText().equals("") || this.txtNombreEmpleado.getText().equals("") || this.txtTelEmpleado.getText().equals("")){
				throw new Exception();
				//vueltas raras pasan aqui
			}
			int index=-1;
			Tipo_Cargo aux;
			index= this.cbxCargoEmpleado.getSelectedIndex();
			aux=this.cbxCargoEmpleado.getItemAt(index);	
			this.auxobjHotel.contratar_empleado(this.txtNombreEmpleado.getText(), Long.parseLong(this.txtTelEmpleado.getText()), this.txtDireccion.getText(), Long.parseLong(this.txtIdEmpleado.getText()), aux,this.auxobjHotel);
		
			JOptionPane.showMessageDialog(this, "EMPLEADO CREADO","REGISTRO DE EMPLEADO",
					JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el teléfono y la cédula","Registro De Empleado",
					JOptionPane.ERROR_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos Vacios","Registro De Empleado",
					JOptionPane.WARNING_MESSAGE);
		}
		finally{
			this.txtDireccion.setText("");
			this.txtIdEmpleado.setText("");
			this.txtNombreEmpleado.setText("");
			this.txtTelEmpleado.setText("");
		}
		
		
	}
	
}
