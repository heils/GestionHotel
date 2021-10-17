package vista.factura;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Factura;
import modelo.Item;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class jDialogAgregarItem extends JDialog {
	
	private Factura auxObjFactura;
	private JTextField txtDetalle;
	private JTextField txtCantidad;
	private JTextField txtPrecioUnitario;
	private JDateChooser dtcFechaItem;
	
	
	public jDialogAgregarItem(jPanelCrearFactura jPanelCrearFactura,boolean modo,Factura objFacturaIn) {
		super();
		auxObjFactura=objFacturaIn;
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		
		setBounds(100, 100, 526, 295);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_cent = new JPanel();
		getContentPane().add(panel_cent, BorderLayout.CENTER);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregar_item();
			}
		});
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		
		dtcFechaItem = new JDateChooser();
		dtcFechaItem.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblDetalle = new JLabel("DETALLE");
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		
		JLabel lblPrecioUnitario = new JLabel("PRECIO UNITARIO");
		
		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setColumns(10);
		
		JLabel lblFecha = new JLabel("FECHA");
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrar_ventana();
			}
		});
		GroupLayout gl_panel_cent = new GroupLayout(panel_cent);
		gl_panel_cent.setHorizontalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(102)
							.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(btnCerrar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDetalle))
							.addGap(18)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtPrecioUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addComponent(lblCantidad)
									.addGap(18)
									.addComponent(lblPrecioUnitario)))
							.addGap(33)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
								.addComponent(dtcFechaItem, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFecha))))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_panel_cent.setVerticalGroup(
			gl_panel_cent.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDetalle)
						.addComponent(lblCantidad)
						.addComponent(lblPrecioUnitario)
						.addComponent(lblFecha))
					.addGap(18)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPrecioUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(dtcFechaItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
						.addComponent(btnCerrar, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addGap(59))
		);
		panel_cent.setLayout(gl_panel_cent);
		{
			{
			
		 }
			
		}
		
	}
	public void agregar_item(){
		try{
			if(this.txtCantidad.getText().equals("") || this.txtDetalle.getText().equals("") || this.txtPrecioUnitario.getText().equals("") ){
				throw new Exception();
			}
			if(Integer.parseInt(this.txtCantidad.getText()) < 0 ||  Integer.parseInt(this.txtPrecioUnitario.getText()) < 0){
				throw new NumberFormatException();
			}
			Item objItem = new Item();
			objItem.setDetalle(this.txtDetalle.getText());
			objItem.setCantidad(Integer.parseInt(this.txtCantidad.getText()));
			objItem.setPago_unitario(Integer.parseInt(this.txtPrecioUnitario.getText()));
			objItem.setFecha(this.dtcFechaItem.getCalendar());
			this.auxObjFactura.getLstItem().add(objItem);
			JOptionPane.showMessageDialog(this, "ITEM AGREGADO CORRECTAMENTE","AGREGAR ITEM",
					JOptionPane.INFORMATION_MESSAGE);
			System.out.print(this.auxObjFactura.getLstItem().size());
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "DEBE INGRESAR VALORES VALIDOS PARA LA CANTIDAD EL DETALLE Y EL PRECIO","AGREGAR ITEM",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "CAMPOS VACIOS","AGREGAR ITEM",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			this.txtCantidad.setText("");
			this.txtDetalle.setText("");
			this.txtPrecioUnitario.setText("");
		}
	}
	public void cerrar_ventana(){
		int valor = JOptionPane.showConfirmDialog(this, "SEGURO DESEA SALIR? NO PODRA AGREGAR MAS ITEMS","CERRAR",JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_NO_OPTION){
			this.setVisible(false);
			this.dispose();
		}
	
	}
	
	
}
