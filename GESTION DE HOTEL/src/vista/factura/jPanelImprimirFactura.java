package vista.factura;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.Hotel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelImprimirFactura extends JPanel {



	private Hotel auxObjHotel;
	private javax.swing.JScrollPane Jscrollpanel;
	private javax.swing.JTable jTable1;
	private JButton btnImprimir;
	private JButton btnEncontrar;
	private int x=-1;
	private JTextField txtEncontrar;
	private JTextArea textAreaItems;
	private int aux=-1;
	private JTextField txtCliente;
	private JTextField txtEmpleado;
	


	public jPanelImprimirFactura(Hotel objHotelIn) {
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();
	}
	
	public void lanzar_componentes(){
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_cent = new JPanel();
		add(panel_cent, BorderLayout.CENTER);
		
		JLabel lblImprimirFactura = new JLabel("IMPRIMIR FACTURA");
		
		txtEncontrar = new JTextField();
		txtEncontrar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DIGITE EL NUMERO DE FACTURA");
		
		btnEncontrar = new JButton("BUSCAR");
		btnEncontrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar_factura();
			}
		});
		
		btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimir_datos();
			}
		});
		btnImprimir.setEnabled(false);
		
		textAreaItems = new JTextArea();
		textAreaItems.setEditable(false);
		
		JLabel ITEMS = new JLabel("ITEMS");
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setColumns(10);
		
		txtEmpleado = new JTextField();
		txtEmpleado.setEnabled(false);
		txtEmpleado.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("ID CLIENTE");
		
		JLabel lblIdEmpleado = new JLabel("ID EMPLEADO");
		GroupLayout gl_panel_cent = new GroupLayout(panel_cent);
		gl_panel_cent.setHorizontalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(216)
							.addComponent(lblImprimirFactura))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(272)
							.addComponent(ITEMS))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(67)
							.addComponent(textAreaItems, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEncontrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnEncontrar)
									.addGap(6)
									.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addComponent(lblIdCliente)
									.addGap(18)
									.addComponent(txtCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(lblIdEmpleado)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_panel_cent.setVerticalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGap(5)
					.addComponent(lblImprimirFactura)
					.addGap(54)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtEncontrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEncontrar)
						.addComponent(btnImprimir, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdCliente)
						.addComponent(lblIdEmpleado))
					.addGap(32)
					.addComponent(ITEMS)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textAreaItems, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel_cent.setLayout(gl_panel_cent);
	}
	
	public void buscar_factura(){
		try{
			if(this.txtEncontrar.getText().equals("")){
				throw new Exception();
			}
			for(int i=0;i<this.auxObjHotel.getLstFacturas().size();i++){
				if(Integer.parseInt(this.txtEncontrar.getText()) == this.auxObjHotel.getLstFacturas().get(i).getIdentificador()){
					JOptionPane.showMessageDialog(this, "FACTURA ENCONTRADA","IMPRIMIR FACTURA",JOptionPane.INFORMATION_MESSAGE);
					x=0;
					this.btnImprimir.setEnabled(true);
					aux=i;
				}
			}
			if(x==-1){
				JOptionPane.showMessageDialog(this, "NO SE PUDO ENCONTRAR LA FACTURA","IMPRIMIR FACTURA",JOptionPane.ERROR_MESSAGE);
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "DEBE INGRESAR VALORES VALIDOS", "IMPRMIR FACTURA",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "CAMPOS VACIOS","IMPRIMIR FACTURA",JOptionPane.WARNING_MESSAGE);
		}finally{
			this.txtEncontrar.setText("");
		}
	}
	public void imprimir_datos(){
		
		this.textAreaItems.setRows(this.auxObjHotel.getLstFacturas().get(aux).getLstItem().size());
		for(int i=0;i<this.auxObjHotel.getLstFacturas().get(aux).getLstItem().size();i++){
			this.textAreaItems.insert(("\n"+"Detalle: "+this.auxObjHotel.getLstFacturas().get(aux).getLstItem().get(i).getDetalle()+ " Cantidad: "+this.auxObjHotel.getLstFacturas().get(aux).getLstItem().get(i).getCantidad()+ " Valor unitario "+this.auxObjHotel.getLstFacturas().get(aux).getLstItem().get(i).getPago_unitario()+"\n"),i);
		}
		this.txtCliente.setText(""+this.auxObjHotel.getLstFacturas().get(aux).getRef_cliente().getRuc_ci());
		this.txtEmpleado.setText(""+this.auxObjHotel.getLstFacturas().get(aux).getRef_empleado().getRuc_ci());
	}
}
