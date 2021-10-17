package vista.factura;

import javax.swing.JPanel;

import modelo.Hotel;
import modelo.Tipo_Cargo;
import vista.frmMenuHotel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import modelo.Factura;
import modelo.Formato_Pago;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jPanelCrearFactura extends JPanel {
	private Hotel auxObjHotel;
	private JPanel panel_cent;
	private JTextField txtIdEmpleado;
	private JTextField txtCedulaCliente;
	private JTextField txtNumeroFolio;
	private JTextField txtNumeroFactura;
	private JDateChooser dtcFechaAutorizacion;
	private JDateChooser dtcFechaCaducidad;
	private JButton btnAgregarItem;
	private JButton btnCalcularFactura;
	private JButton btnNuevaFactura;
	private JComboBox <Formato_Pago> cbxMedioPago;
	private int posCliente=-1;
	private int posEmpleado=-1;
	private int x=-1;
	private int cont=-1;
	private int pos;
	private int cantidad=0;
	private double total;
	private float subTotal;
	private double neto;
	private float descuento;

	public jPanelCrearFactura(Hotel objHotelIn) {
		lanzar_componentes();
		this.auxObjHotel=objHotelIn;
		
		
	}
	public void lanzar_componentes(){
		
		panel_cent = new JPanel();
		setLayout(null);
		add(panel_cent);
		panel_cent.setBounds(0, 0, 555, 501);
		
		JLabel lblCrearFactura = new JLabel("CREAR FACTURA");
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setColumns(10);
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar_cliente_empleado();
			}
		});
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblCedula = new JLabel("CEDULA");
		
		dtcFechaAutorizacion = new JDateChooser();
		dtcFechaAutorizacion.getCalendarButton().setEnabled(false);
		dtcFechaAutorizacion.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblNewLabel = new JLabel("FECHA AUTORIZACION");
		
		JLabel lblNewLabel_1 = new JLabel("FECHA CADUCIDAD");
		
		dtcFechaCaducidad = new JDateChooser();
		dtcFechaCaducidad.getCalendarButton().setEnabled(false);
		dtcFechaCaducidad.setDateFormatString("dd/MM/yyyy");
		
		cbxMedioPago = new JComboBox();
		cbxMedioPago.setEnabled(false);
		cbxMedioPago.setModel(new DefaultComboBoxModel(Formato_Pago.values()));
		
		JLabel lblMedioDePago = new JLabel("MEDIO DE PAGO");
		
		JLabel lblNumeroFolio = new JLabel("NUMERO FOLIO");
		
		txtNumeroFolio = new JTextField();
		txtNumeroFolio.setEnabled(false);
		txtNumeroFolio.setColumns(10);
		
		btnAgregarItem = new JButton("AGREGAR ITEM");
		btnAgregarItem.setEnabled(false);
		btnAgregarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lanzar_item();
			}
		});
		
		btnCalcularFactura = new JButton("CALCULAR FACTURA");
		btnCalcularFactura.setEnabled(false);
		btnCalcularFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular_factura();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("NUMERO FACTURA");
		
		txtNumeroFactura = new JTextField();
		txtNumeroFactura.setEnabled(false);
		txtNumeroFactura.setColumns(10);
		
		btnNuevaFactura = new JButton("CREAR NUEVA FACTURA");
		btnNuevaFactura.setEnabled(false);
		btnNuevaFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crear_nueva_factura();
			}
		});
		GroupLayout gl_panel_cent = new GroupLayout(panel_cent);
		gl_panel_cent.setHorizontalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addGap(91)
									.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_cent.createSequentialGroup()
											.addComponent(txtNumeroFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_cent.createSequentialGroup()
												.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
													.addComponent(lblId)
													.addComponent(txtIdEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(dtcFechaAutorizacion, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
													.addComponent(cbxMedioPago, Alignment.TRAILING, 0, 114, Short.MAX_VALUE)
													.addComponent(lblMedioDePago, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
												.addGap(42))
											.addGroup(gl_panel_cent.createSequentialGroup()
												.addComponent(lblNewLabel_2)
												.addPreferredGap(ComponentPlacement.RELATED))))
									.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
											.addComponent(txtNumeroFolio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNumeroFolio)
											.addComponent(dtcFechaCaducidad, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
											.addGroup(gl_panel_cent.createSequentialGroup()
												.addComponent(txtCedulaCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(29)
												.addComponent(btnBuscar))
											.addComponent(lblCedula))
										.addComponent(btnNuevaFactura, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_cent.createSequentialGroup()
									.addGap(157)
									.addComponent(lblCrearFactura)))
							.addGap(194))
						.addGroup(Alignment.LEADING, gl_panel_cent.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCalcularFactura, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAgregarItem, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_cent.setVerticalGroup(
			gl_panel_cent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cent.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCrearFactura)
					.addGap(18)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblCedula))
					.addGap(8)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdEmpleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCedulaCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addComponent(dtcFechaAutorizacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dtcFechaCaducidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addComponent(lblNumeroFolio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNumeroFolio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cent.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNumeroFactura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(17)
					.addComponent(lblMedioDePago)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_cent.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbxMedioPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNuevaFactura, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAgregarItem, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalcularFactura, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		panel_cent.setLayout(gl_panel_cent);

	}


	public void buscar_cliente_empleado(){
		try{
			if(this.txtCedulaCliente.getText().equals("") || this.txtIdEmpleado.getText().equals("")){
				throw new Exception();
			}
			if(Integer.parseInt(this.txtCedulaCliente.getText()) <0 || Integer.parseInt(this.txtIdEmpleado.getText()) <0){
				throw new NumberFormatException();
			}
			for(int i=0;i<this.auxObjHotel.getLstClientes().size();i++){
				if(Integer.parseInt(this.txtCedulaCliente.getText())== this.auxObjHotel.getLstClientes().get(i).getRuc_ci()){
					posCliente=i;
				}
			}
			
			for(int i=0;i<this.auxObjHotel.getLstEmpleados().size();i++){
				if(Integer.parseInt(this.txtIdEmpleado.getText())== this.auxObjHotel.getLstEmpleados().get(i).getRuc_ci()){
					posEmpleado=i;
				}
			}
			
			if(posCliente != -1 && posEmpleado != -1){
				JOptionPane.showMessageDialog(this, "EMPLEADO Y CLIENTE ENCONTRADOS","CREACION DE FACTURA",
						JOptionPane.INFORMATION_MESSAGE);
				this.btnAgregarItem.setEnabled(true);
				this.txtNumeroFactura.setEnabled(true);
				this.txtNumeroFolio.setEnabled(true);
				this.cbxMedioPago.setEnabled(true);
				this.dtcFechaAutorizacion.setEnabled(true);
				this.dtcFechaCaducidad.setEnabled(true);
				this.txtCedulaCliente.setEnabled(false);
				this.txtIdEmpleado.setEnabled(false);
				x=0;
			}else{
				JOptionPane.showMessageDialog(this, "NO SE ENCONTRARON LOS DATOS","CREACION DE FACTURA",
						JOptionPane.ERROR_MESSAGE);
				this.txtCedulaCliente.setText("");
				this.txtIdEmpleado.setText("");
				this.txtNumeroFolio.setText("");
				this.txtNumeroFactura.setText("");
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "DEBE INGRESAR VALORES VALIDOS PARA EL ID Y LA CEDULA","CREACION DE FACTURA",
					JOptionPane.ERROR_MESSAGE);
			if(x!=0){
				this.txtCedulaCliente.setText("");
				this.txtIdEmpleado.setText("");
				this.txtNumeroFolio.setText("");
				this.txtNumeroFactura.setText("");
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "CAMPOS VACIOS","CREACION DE FACTURA",
					JOptionPane.WARNING_MESSAGE);
			if(x!=0){
				this.txtCedulaCliente.setText("");
				this.txtIdEmpleado.setText("");
				this.txtNumeroFolio.setText("");
				this.txtNumeroFactura.setText("");
			}
			
		}
	}
	
	
	public void lanzar_item(){
		try{
			if(this.txtCedulaCliente.getText().equals("") || this.txtIdEmpleado.getText().equals("") || this.txtNumeroFolio.getText().equals("") || this.txtNumeroFactura.getText().equals("")){
				throw new Exception();
			}
			float total=0;
			float subTotal=0;
			float descuento=0;
			float neto=0;
			int index=-1;
			Formato_Pago aux;
			index= this.cbxMedioPago.getSelectedIndex();
			aux=this.cbxMedioPago.getItemAt(index);
			Factura objFactura = new Factura(Integer.parseInt(this.txtNumeroFactura.getText()),Long.parseLong(this.txtNumeroFolio.getText()),aux,neto,descuento,subTotal,total,this.auxObjHotel.getLstClientes().get(posCliente),this.auxObjHotel.getLstEmpleados().get(posEmpleado),this.auxObjHotel);
			objFactura.crear_fecha(this.dtcFechaAutorizacion.getCalendar(),this.dtcFechaCaducidad.getCalendar(),objFactura);
			this.auxObjHotel.getLstFacturas().add(objFactura);
			jDialogAgregarItem objJDItem=new jDialogAgregarItem(this,false,objFactura);
			objJDItem.setVisible(true);
			this.txtNumeroFactura.setEnabled(false);
			this.txtNumeroFolio.setEnabled(false);
			this.dtcFechaAutorizacion.setEnabled(false);
			this.dtcFechaCaducidad.setEnabled(false);
			this.btnNuevaFactura.setEnabled(true);
			this.btnCalcularFactura.setEnabled(true);
			this.btnAgregarItem.setEnabled(false);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "DEBE INGRESAR VALORES VALIDOS PARA EL ID Y LA CEDULA","CREACION DE FACTURA",
					JOptionPane.ERROR_MESSAGE);
			this.txtNumeroFactura.setText("");
			this.txtNumeroFolio.setText("");
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "CAMPOS VACIOS","CREACION DE FACTURA",
					JOptionPane.WARNING_MESSAGE);
			this.txtNumeroFactura.setText("");
			this.txtNumeroFolio.setText("");
		}
	}
	public void calcular_factura(){
		for(int i=0;i<this.auxObjHotel.getLstFacturas().size();i++){
			if(Integer.parseInt(this.txtNumeroFactura.getText()) == this.auxObjHotel.getLstFacturas().get(i).getIdentificador()){
				pos=i;
			}
			for(int j=0;j<this.auxObjHotel.getLstFacturas().get(pos).getLstItem().size();j++){
				cantidad=this.auxObjHotel.getLstFacturas().get(pos).getLstItem().get(j).getCantidad();
				subTotal= cantidad * this.auxObjHotel.getLstFacturas().get(pos).getLstItem().get(j).getPago_unitario();
				neto= subTotal*1.19;
				total=total+neto;
			}
			JOptionPane.showMessageDialog(this, "FACTURA CALCULADA CORRECTAMENTE","CALCULAR FACTURA",
					JOptionPane.INFORMATION_MESSAGE);
			this.btnCalcularFactura.setEnabled(false);
		}
	}
  
	public void crear_nueva_factura(){
		this.txtNumeroFactura.setEnabled(true);
		this.txtNumeroFolio.setEnabled(true);
		this.dtcFechaAutorizacion.setEnabled(true);
		this.dtcFechaCaducidad.setEnabled(true);
		this.txtCedulaCliente.setEnabled(true);
		this.txtIdEmpleado.setEnabled(true);
		this.txtCedulaCliente.setText("");
		this.txtIdEmpleado.setText("");
		this.txtNumeroFolio.setText("");
		this.txtNumeroFactura.setText("");
		this.txtCedulaCliente.setText("");
		this.txtIdEmpleado.setText("");
		this.btnNuevaFactura.setEnabled(false);
		this.btnCalcularFactura.setEnabled(false);
		
	}
}


