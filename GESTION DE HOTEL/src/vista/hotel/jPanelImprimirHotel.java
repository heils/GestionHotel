package vista.hotel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Hotel;
import vista.frmMenuHotel.imprimir;

public class jPanelImprimirHotel extends JPanel implements imprimir{
	
	private javax.swing.JScrollPane Jscrollpanel;
	private Hotel auxObjHotel;
	private javax.swing.JTable jTable1;
	
	public jPanelImprimirHotel(Hotel objHotelIn){
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();
		
	}
	
	public void cargar_tabla(){
		Object matriz[][]=new Object[1][5];
		
			matriz[0][0]=this.auxObjHotel.getNombre();
			matriz[0][1]=this.auxObjHotel.getNit();
			matriz[0][2]=this.auxObjHotel.getTelefono();
			matriz[0][3]=this.auxObjHotel.getDireccion();
			matriz[0][4]=this.auxObjHotel.getPagina_web();
			
		

		jTable1.setModel(new javax.swing.table.DefaultTableModel (
				matriz,
				new String[]{"NOMBRE","NIT","TELEFONO","DIRECCION" ,"PAGINA WEB"}
				));
	}
	

		public void lanzar_componentes(){

			this.Jscrollpanel=new javax.swing.JScrollPane();
			this.jTable1=new javax.swing.JTable();

			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					new Object[1][5],
					new String[]{"NOMBRE","NIT","TELEFONO","DIRECCION" ,"PAGINA WEB"}
					));

			Jscrollpanel.setViewportView(jTable1);

			JPanel panel_sup = new JPanel();

			JLabel lblInformeDeDatos = new JLabel("INFORME DE DATOS");
			panel_sup.add(lblInformeDeDatos);

			JPanel panel_cen = new JPanel();

			JButton btnCargar = new JButton("CARGAR");
			btnCargar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cargar_tabla();
				}
			});
			GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
			gl_panel_cen.setHorizontalGroup(
				gl_panel_cen.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_cen.createSequentialGroup()
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_cen.createSequentialGroup()
								.addGap(18)
								.addComponent(Jscrollpanel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_cen.createSequentialGroup()
								.addGap(178)
								.addComponent(btnCargar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(18, Short.MAX_VALUE))
			);
			gl_panel_cen.setVerticalGroup(
				gl_panel_cen.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_cen.createSequentialGroup()
						.addGap(34)
						.addComponent(Jscrollpanel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnCargar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
			);
			panel_cen.setLayout(gl_panel_cen);
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_cen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_cen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			);
			setLayout(groupLayout);
	}

}

