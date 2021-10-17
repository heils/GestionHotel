package vista.cliente;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Cliente;
import modelo.Hotel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class jPanelEliminarCliente extends JPanel {
	private JTextField txtBuscar_Ruc;
	private Hotel auxObjHotel;


	public jPanelEliminarCliente(Hotel objHotelIn) {
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();

	}

	public void eliminar_cliente(){
		
		try{
			if(this.txtBuscar_Ruc.getText().equals("")){
				throw new Exception ();
			}
			int h=-1;
			long BuscarRuc_Ci;
			BuscarRuc_Ci=(Integer.parseInt(this.txtBuscar_Ruc.getText()));
		
			
			for(int i=0; i<this.auxObjHotel.getLstClientes().size();i++) {
				if(BuscarRuc_Ci==this.auxObjHotel.getLstClientes().get(i).getRuc_ci()) {	
					this.auxObjHotel.getLstClientes().remove(i);
					JOptionPane.showMessageDialog(this, "Cliente Eliminado","Eliminacion De Cliente",
							JOptionPane.INFORMATION_MESSAGE);
				
					h=-1;
				}
				else{
					h=0;
				}
			}
			if(h!=-1){
				JOptionPane.showMessageDialog(this, "Error Al Eliminar Cliente","Eliminar Cliente",JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Digite un valor válido","Eliminar Cliente",JOptionPane.ERROR_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Campo Sin Llenar","Eliminar Cluente",JOptionPane.WARNING_MESSAGE);
			
		}finally{
			this.txtBuscar_Ruc.setText("");
		}
	
	}

	public void lanzar_componentes(){
		setLayout(new BorderLayout(0, 0));

		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);

		JLabel lblFormularioEliminarCliente = new JLabel("FORMULARIO ELIMINAR CLIENTE");
		panel_sup.add(lblFormularioEliminarCliente);

		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);

		JLabel lblRucciABuscar = new JLabel("RUC_CI A BUSCAR CLIENTE:");

		txtBuscar_Ruc = new JTextField();
		txtBuscar_Ruc.setColumns(10);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_cliente();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
				gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_cen.createSequentialGroup()
										.addGap(103)
										.addComponent(lblRucciABuscar)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtBuscar_Ruc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_cen.createSequentialGroup()
										.addGap(167)
										.addComponent(btnEliminar)))
						.addContainerGap(118, Short.MAX_VALUE))
				);
		gl_panel_cen.setVerticalGroup(
				gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
						.addGap(85)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRucciABuscar)
								.addComponent(txtBuscar_Ruc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEliminar)
						.addContainerGap(142, Short.MAX_VALUE))
				);
		panel_cen.setLayout(gl_panel_cen);
	}

}
