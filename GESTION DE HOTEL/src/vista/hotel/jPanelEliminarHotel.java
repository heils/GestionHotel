package vista.hotel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Hotel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEliminarHotel extends JPanel {
	private JTextField txtBuscarNit;
	private Hotel auxobjHotel;


	public jPanelEliminarHotel(Hotel objHotelIn) {
		this.auxobjHotel=objHotelIn;
		lanzar_componentes();

	}

	public void eliminar_hotel(){
		try{
			if(this.txtBuscarNit.getText().equals("")){
				throw new Exception();
			}
			long auxBuscar=Long.parseLong(this.txtBuscarNit.getText());
			if(auxBuscar==this.auxobjHotel.getNit()){
				this.auxobjHotel.eliminar_listas();
				this.auxobjHotel=null;
				JOptionPane.showMessageDialog(this, "Hotel Eliminado","Eliminacion De Hotel",
						JOptionPane.INFORMATION_MESSAGE);
				
				Runtime.getRuntime().gc();
			}else{
				JOptionPane.showMessageDialog(this, "No se pudo encontrar el hotel","Eliminacion De Hotel",
						JOptionPane.ERROR_MESSAGE);
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el Nit y teléfono","Eliminar de Hotel",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos Vacios","Eliminar de Hotel",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			this.txtBuscarNit.setText("");
		}
	
	}
	

	public void lanzar_componentes(){
		setLayout(new BorderLayout(0, 0));

		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);

		JLabel lblFormularioEliminarHotel = new JLabel("FORMULARIO ELIMINAR HOTEL");
		panel_sup.add(lblFormularioEliminarHotel);

		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);

		JLabel lblNitABuscar = new JLabel("NIT A BUSCAR DEL HOTEL:");

		txtBuscarNit = new JTextField();
		txtBuscarNit.setColumns(10);

		JButton btnNewButton = new JButton("ELIMINAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar_hotel();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_cen.createSequentialGroup()
					.addGap(111)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNitABuscar, Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtBuscarNit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNitABuscar)
						.addComponent(txtBuscarNit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);
	}
}
