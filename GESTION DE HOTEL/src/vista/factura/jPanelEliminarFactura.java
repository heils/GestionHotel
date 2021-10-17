package vista.factura;

import javax.swing.JPanel;

import modelo.Hotel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEliminarFactura extends JPanel {
	
	private Hotel auxObjHotel;
	private JTextField txtEliminarFactura;
	private int pos=0;


	public jPanelEliminarFactura(Hotel objHotelIn) {
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();

	}
	public void lanzar_componentes(){
		JPanel panel_cent = new JPanel();
		
		JButton btnNewButton = new JButton("ELIMINAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_factura();
			}
		});
		
		JLabel lblNewLabel = new JLabel("DIGITE EL NUMERO DE FACTURA:");
		
		JLabel lblEliminarFactura = new JLabel("ELIMINAR FACTURA");
		
		txtEliminarFactura = new JTextField();
		txtEliminarFactura.setColumns(10);
		GroupLayout gl_panel_cent = new GroupLayout(panel_cent);
		gl_panel_cent.setHorizontalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEliminarFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(189)
							.addComponent(lblEliminarFactura)))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		gl_panel_cent.setVerticalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEliminarFactura)
					.addGap(80)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtEliminarFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		panel_cent.setLayout(gl_panel_cent);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_cent, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(198, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_cent, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(193, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	public void eliminar_factura(){
		int auxpos =-1;
		try{
			if(this.txtEliminarFactura.getText().equals("")){
				throw new Exception();
			}
			for(int i=0;i<this.auxObjHotel.getLstFacturas().size();i++){
				if(Integer.parseInt(this.txtEliminarFactura.getText()) == this.auxObjHotel.getLstFacturas().get(i).getIdentificador()){
					this.auxObjHotel.getLstFacturas().remove(i);
					pos=i;
					auxpos=0;
					JOptionPane.showMessageDialog(this, "LA FACTURA HA SIDO ELIMINADA CORRECTAMENTE","ELIMINAR FACTURA",JOptionPane.INFORMATION_MESSAGE);
					for(int j=0;j<this.auxObjHotel.getLstFacturas().get(pos).getLstItem().size();j++){
						this.auxObjHotel.getLstFacturas().get(pos).getLstItem().remove(j);
					}
				}	
			}	
			if(auxpos==0){
				JOptionPane.showMessageDialog(this, "NO SE PUDO ENCONTRAR LA FACTURA","ELIMINAR FACTURA",JOptionPane.ERROR_MESSAGE);
			}

		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "DEBE INGRESAR UN VALOR VALIDO PARA EL NUMERO DE FACTURA","ELIMINAR EMPLEADO",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "CAMPOS VACIOS","ELIMINAR FACTURA",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			this.txtEliminarFactura.setText("");
		}
	}
}
