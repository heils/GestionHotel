package vista.factura;

import javax.swing.JPanel;

import modelo.Hotel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Formato_Pago;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelEditarFactura extends JPanel {
	
	private Hotel auxObjHotel;
	private JTextField txtNumeroFactura;
	private JTextField txtfac;
	private JTextField txtNumeroFolio;
	private int x=-1;
	private int aux=-1;
	private JComboBox <Formato_Pago> cbxPago;

	public jPanelEditarFactura(Hotel objHotelIn) {
		this.auxObjHotel=objHotelIn;
		lanzar_componentes();
	}
	public void lanzar_componentes(){
		
		JPanel panel_cent = new JPanel();
		JButton btnActualizar = new JButton("ACEPTAR");
		btnActualizar.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("EDITAR FACTURA");
		
		txtNumeroFactura = new JTextField();
		txtNumeroFactura.setColumns(10);
		
		txtfac = new JTextField();
		txtfac.setColumns(10);
		
		txtNumeroFolio = new JTextField();
		txtNumeroFolio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NUMERO DE FACTURA A EDITAR");
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar_factura();
			}
		});
		
		JLabel lblNumeroDeFactura = new JLabel("NUMERO DE FACTURA");
		
		JLabel lblNumeroFolio = new JLabel("NUMERO FOLIO");
		
		JLabel lblNewLabel_2 = new JLabel("FORMATO PAGO");
		
		cbxPago = new JComboBox();
		cbxPago.setModel(new DefaultComboBoxModel(Formato_Pago.values()));
		GroupLayout gl_panel_cent = new GroupLayout(panel_cent);
		gl_panel_cent.setHorizontalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGap(265)
					.addComponent(lblNewLabel)
					.addContainerGap(250, Short.MAX_VALUE))
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnActualizar))
						.addGroup(Alignment.LEADING, gl_panel_cent.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addGap(86)
									.addGroup(gl_panel_cent.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_cent.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
											.addComponent(lblNewLabel_1))
										.addComponent(lblNumeroFolio)))
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_2)))
							.addGroup(gl_panel_cent.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNumeroDeFactura))))
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNumeroFolio)
								.addComponent(txtfac)
								.addComponent(cbxPago, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(178))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNumeroFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnBuscar)
							.addContainerGap())))
		);
		gl_panel_cent.setVerticalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(111)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtfac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumeroDeFactura)))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(txtNumeroFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))))
					.addGap(18)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNumeroFolio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumeroFolio))
					.addGap(18)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(33)
					.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
		);
		panel_cent.setLayout(gl_panel_cent);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_cent, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_cent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	public void buscar_factura(){
		try{
			int index=-1;
			Formato_Pago auxi;
			x=-1;
			if(this.txtNumeroFactura.getText().equals("")){
				throw new Exception();
			}
			for(int i=0;i<this.auxObjHotel.getLstFacturas().size();i++){
				if(Integer.parseInt(this.txtNumeroFactura.getText()) == this.auxObjHotel.getLstFacturas().get(i).getIdentificador()){
					JOptionPane.showMessageDialog(this, "FACTURA ENCONTRADA","EDITAR FACTURA",JOptionPane.INFORMATION_MESSAGE);
					x=0;
					aux=i;
					
				}
			}
			if(x==-1){
				JOptionPane.showMessageDialog(this, "NO SE PUDO ENCONTRAR LA FACTURA","IMPRIMIR FACTURA",JOptionPane.ERROR_MESSAGE);
			}
			this.auxObjHotel.getLstFacturas().get(aux).setIdentificador(Long.parseLong(this.txtNumeroFactura.getText()));
			this.auxObjHotel.getLstFacturas().get(aux).setNumero_folio(Integer.parseInt(this.txtNumeroFolio.getText()));
			index= this.cbxPago.getSelectedIndex();
			auxi=this.cbxPago.getItemAt(index);
			this.auxObjHotel.getLstFacturas().get(aux).setMedio_pago(auxi);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "DEBE INGRESAR VALORES VALIDOS PARA EL ID Y LA CEDULA","EDICION DE FACTURA",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "CAMPOS VACIOS","EDICION DE FACTURA",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
