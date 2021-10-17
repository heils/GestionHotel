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

public class jPanelCrearCliente extends JPanel {

	private JTextField txtEmpresa;
	private JTextField txtNacionalidad;
	private Hotel auxObjeHotel;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtRuc_ci;


	public jPanelCrearCliente(Hotel objHotelIn) {
		lanzar_componentes();
		this.auxObjeHotel=objHotelIn;
	}

	public void crear_cliente(){
		Cliente objCliente=new Cliente();
		try{
			if(this.txtNombre.getText().equals("") || this.txtDireccion.getText().equals("") || this.txtEmpresa.getText().equals("") || this.txtNacionalidad.getText().equals("")){
				throw new Exception();
			}
			objCliente.setRuc_ci(Integer.parseInt(this.txtRuc_ci.getText()));
			objCliente.setTelefono(Integer.parseInt(this.txtTelefono.getText()));
			objCliente.setNombre(this.txtNombre.getText());
			objCliente.setDireccion(this.txtDireccion.getText());
			objCliente.setEmpresa(this.txtEmpresa.getText());
			objCliente.setNacionalidad(this.txtNacionalidad.getText());
	
			this.auxObjeHotel.agregar_cliente(objCliente);
			JOptionPane.showMessageDialog(this, "Cliente Creado","Registro De Cliente",
					JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el teléfono y la cédula","Registro De Cliente",
					JOptionPane.ERROR_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Campo Sin Llenar","Registro De Cliente",JOptionPane.WARNING_MESSAGE);
			
		}finally{
			
			this.txtTelefono.setText("");
			this.txtRuc_ci.setText("");
			this.txtNombre.setText("");
			this.txtDireccion.setText("");
			this.txtEmpresa.setText("");
			this.txtNacionalidad.setText("");
		}
		
		
	}

	public void lanzar_componentes(){
		setLayout(new BorderLayout(0, 0));

		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);

		JLabel lblFormularioCrearCliente = new JLabel("FORMULARIO CREAR CLIENTE");
		panel_sup.add(lblFormularioCrearCliente);

		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);

		JLabel lblEmpresa = new JLabel("EMPRESA:");

		JLabel lblNacionalidad = new JLabel("NACIONALIDAD:");

		txtEmpresa = new JTextField();
		txtEmpresa.setColumns(10);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crear_cliente();
			}
		});
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		
		JLabel lblDireccion = new JLabel("DIRECCION:");
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		JLabel lblRucci = new JLabel("RUC_CI:");
		
		txtRuc_ci = new JTextField();
		txtRuc_ci.setColumns(10);
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEmpresa)
								.addComponent(lblNombre)
								.addComponent(lblTelefono)
								.addComponent(lblDireccion)
								.addComponent(lblNacionalidad)
								.addComponent(lblRucci))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRuc_ci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(111))
						.addGroup(Alignment.TRAILING, gl_panel_cen.createSequentialGroup()
							.addComponent(btnAceptar)
							.addGap(167))))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_cen.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRucci)
						.addComponent(txtRuc_ci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmpresa)
						.addComponent(txtEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNacionalidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAceptar)
					.addGap(78))
		);
		panel_cen.setLayout(gl_panel_cen);

	}
}
