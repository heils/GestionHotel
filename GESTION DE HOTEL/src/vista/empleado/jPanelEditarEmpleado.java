package vista.empleado;

import java.util.ArrayList;

import javax.swing.JPanel;

import modelo.Empleado;
import modelo.Hotel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Tipo_Cargo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEditarEmpleado extends JPanel {
	
	private JTextField txtIdBuscar;
	private JTextField txtNombreActualizar;
	private JTextField txtActualizarDireccion;
	private JTextField txtActualizarTel;
	private JComboBox <Tipo_Cargo> cbxEditarCargo;
	private Hotel objHotel;



	public jPanelEditarEmpleado(Hotel objHotel){
		this.objHotel=objHotel;
		lanzar_componentes();
	}
	
	
	
	public void lanzar_componentes(){
		this.objHotel=objHotel;
		
		JLabel lblEditarEmpleado = new JLabel("EDITAR EMPLEADO");
		
		JLabel lblNewLabel = new JLabel("ID A BUSCAR:");
		
		JLabel lblNewLabel_1 = new JLabel("ACTUALIZAR NOMBRE:");
		
		JLabel lblNewLabel_2 = new JLabel("ACTUALIZAR DIRECCION:");
		
		JLabel lblNewLabel_3 = new JLabel("ACTUALIZAR TELEFONO:");
		
		txtIdBuscar = new JTextField();
		txtIdBuscar.setColumns(10);
		
		txtNombreActualizar = new JTextField();
		txtNombreActualizar.setColumns(10);
		
		JLabel lblActualizarCargo = new JLabel("ACTUALIZAR CARGO:");
		
		txtActualizarDireccion = new JTextField();
		txtActualizarDireccion.setColumns(10);
		
		txtActualizarTel = new JTextField();
		txtActualizarTel.setColumns(10);
		
		cbxEditarCargo = new JComboBox();
		cbxEditarCargo.setModel(new DefaultComboBoxModel(Tipo_Cargo.values()));
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar_empleado();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(lblEditarEmpleado))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(17)
												.addComponent(lblNewLabel)))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtIdBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtNombreActualizar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_2)
											.addComponent(lblNewLabel_3))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtActualizarTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtActualizarDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(6)))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblActualizarCargo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cbxEditarCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(btnActualizar)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblEditarEmpleado)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNombreActualizar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtActualizarDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtActualizarTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxEditarCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblActualizarCargo))
					.addGap(18)
					.addComponent(btnActualizar)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public void actualizar_empleado(){
		try{
			if(this.txtActualizarDireccion.getText().equals("") || this.txtActualizarTel.getText().equals("") || this.txtIdBuscar.getText().equals("") || this.txtNombreActualizar.getText().equals("")){
				throw new Exception();
			}
			long idBuscar=Long.parseLong(this.txtIdBuscar.getText());
			int index=-1;
			int h=-1;
			Tipo_Cargo aux;
			for(int i=0;i<this.objHotel.getLstEmpleados().size();i++){
				if(idBuscar==this.objHotel.getLstEmpleados().get(i).getRuc_ci()){
					this.objHotel.getLstEmpleados().get(i).setNombre(this.txtNombreActualizar.getText());
					this.objHotel.getLstEmpleados().get(i).setDireccion(this.txtActualizarDireccion.getText());
					this.objHotel.getLstEmpleados().get(i).setTelefono(Long.parseLong(this.txtActualizarTel.getText()));
					index= this.cbxEditarCargo.getSelectedIndex();
					aux=this.cbxEditarCargo.getItemAt(index);
					this.objHotel.getLstEmpleados().get(i).setCargo(aux);
					JOptionPane.showMessageDialog(this, "EL EMPLEADO HA SIDO EDITADO CORRECTAMENTE","EDITAR EMPLEADO",JOptionPane.INFORMATION_MESSAGE);
					h=-1;		
				}else{
					h=0;
				}
			}
			if(h!=-1){
				JOptionPane.showMessageDialog(this, "ERROR AL EDITAR EMPLEADO","EDITAR EMPLEADO",JOptionPane.ERROR_MESSAGE);			
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el teléfono y la cédula","Editor De Empleado",
					JOptionPane.ERROR_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos Vacios","Editor De Empleado",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			
			this.txtActualizarDireccion.setText("");
			this.txtActualizarTel.setText("");
			this.txtIdBuscar.setText("");
			this.txtNombreActualizar.setText("");
		}

	} 
}
