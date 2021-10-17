package vista.empleado;

import java.util.ArrayList;

import javax.swing.JPanel;

import modelo.Empleado;
import modelo.Hotel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEliminarEmpleado extends JPanel {
	
private JTextField txtEliminarEmpleado;
private Hotel auxObjHotel;



	public jPanelEliminarEmpleado(Hotel objHotelIn){
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();
	}
	public void lanzar_componentes(){
		
		JPanel panel_cent = new JPanel();
		
		txtEliminarEmpleado = new JTextField();
		txtEliminarEmpleado.setColumns(10);
		
		JLabel lblDigiteLaCedula = new JLabel("Digite la cedula del empleado:");
		
		JButton btnEliminarEmpleado = new JButton("ACEPTAR");
		btnEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_empleado();
			}
		});
		
		JLabel lblEliminarEmpleado = new JLabel("ELIMINAR EMPLEADO");
		GroupLayout gl_panel_cent = new GroupLayout(panel_cent);
		gl_panel_cent.setHorizontalGroup(
			gl_panel_cent.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addContainerGap(109, Short.MAX_VALUE)
							.addComponent(lblDigiteLaCedula)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEliminarEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(159)
							.addComponent(btnEliminarEmpleado))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(172)
							.addComponent(lblEliminarEmpleado)))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_panel_cent.setVerticalGroup(
			gl_panel_cent.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGap(53)
					.addComponent(lblEliminarEmpleado)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEliminarEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDigiteLaCedula))
					.addGap(38)
					.addComponent(btnEliminarEmpleado)
					.addGap(96))
		);
		panel_cent.setLayout(gl_panel_cent);
		setLayout(new BorderLayout(0, 0));
		add(panel_cent);

	}
	public void eliminar_empleado(){
		try{
			if(this.txtEliminarEmpleado.getText().equals("")){
				throw new Exception();
			}
			int h=-1;
			long nitBuscar=Long.parseLong(this.txtEliminarEmpleado.getText());
			
			for(int i=0;i<this.auxObjHotel.getLstEmpleados().size();i++){
				
				if(nitBuscar==this.auxObjHotel.getLstEmpleados().get(i).getRuc_ci()){
					this.auxObjHotel.getLstEmpleados().remove(i);
					JOptionPane.showMessageDialog(this, "EL EMPLEADO HA SIDO ELIMINADO CORRECTAMENTE","ELIMINAR EMPLEADO",JOptionPane.INFORMATION_MESSAGE);
					h=-1;
				}else{
					h=0;
				}
			}
			if(h!=-1){
				JOptionPane.showMessageDialog(this, "ERROR AL ELIMINAR EMPLEADO","ELIMINAR EMPLEADO",JOptionPane.ERROR_MESSAGE);	
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el teléfono y la cédula","Eliminar Empleado",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos Vacios","Eliminar Empleado",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			this.txtEliminarEmpleado.setText("");
		}

	}
}
