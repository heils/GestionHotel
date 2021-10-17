package vista.empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Empleado;
import modelo.Hotel;
import vista.frmMenuHotel.imprimir;

public class jPanelImprimirEmpleado extends JPanel implements imprimir {
	private javax.swing.JScrollPane Jscrollpanel;
	private javax.swing.JTable jTable1;
	private Hotel auxObjHotel;

	
	public jPanelImprimirEmpleado(Hotel objHotelIn){
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();

	}
	
	public void cargar_tabla(){
		Object matriz[][]=new Object[this.auxObjHotel.getLstEmpleados().size()][5];
		for(int i=0;i<this.auxObjHotel.getLstEmpleados().size();i++){
			matriz[i][0]=this.auxObjHotel.getLstEmpleados().get(i).getNombre();
			matriz[i][1]=this.auxObjHotel.getLstEmpleados().get(i).getTelefono();
			matriz[i][2]=this.auxObjHotel.getLstEmpleados().get(i).getDireccion();
			matriz[i][3]=this.auxObjHotel.getLstEmpleados().get(i).getRuc_ci();
			matriz[i][4]=this.auxObjHotel.getLstEmpleados().get(i).getCargo();
			
		}

		jTable1.setModel(new javax.swing.table.DefaultTableModel (
				matriz,
				new String[]{"NOMBRE","TELEFONO","DIRECCION","CEDULA","TIPO CARGO"}
				));
	}
	

		public void lanzar_componentes(){

			this.Jscrollpanel=new javax.swing.JScrollPane();
			this.jTable1=new javax.swing.JTable();

			jTable1.setModel(new javax.swing.table.DefaultTableModel(
					new Object[0][5],
					new String[]{"NOMBRE","TELEFONO","DIRECCION","CEDULA","TIPO CARGO"}
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
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel_cen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_cen, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
			);
			setLayout(groupLayout);
	}


}
