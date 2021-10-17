package vista.hotel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelo.Hotel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class jPanelCrearHotel extends JPanel {
	private JTextField txtNombre;
	private JTextField txtNit;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtPagina;
	private Hotel auxHotel;
	private JPanel panel_sup;
	private JPanel panel_cen;


	public jPanelCrearHotel(Hotel objHotel) {
		this.auxHotel = objHotel;
		lanzar_componentes();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_cen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_sup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_cen, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
	
	public void crear_hotel(){
		try{
			if(this.txtDireccion.getText().equals("") || this.txtNit.getText().equals("") || this.txtNombre.getText().equals("")
					|| this.txtPagina.getText().equals("") || this.txtTelefono.getText().equals("")){
				throw new Exception();
			}
			auxHotel.setNombre(this.txtNombre.getText());
			auxHotel.setNit(Integer.parseInt(this.txtNit.getText()));
			auxHotel.setTelefono(Integer.parseInt(this.txtTelefono.getText()));
			auxHotel.setDireccion(this.txtDireccion.getText());
			auxHotel.setPagina_web(this.txtPagina.getText());
			JOptionPane.showMessageDialog(this, "Hotel Creado","Registro De Hotel",
					JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el Nit y teléfono","Creación de Hotel",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos Vacios","Creación de Hotel",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			
			this.txtNombre.setText("");
			this.txtNit.setText("");
			this.txtTelefono.setText("");
			this.txtDireccion.setText("");
			this.txtPagina.setText("");
		}
		
	}

	public void lanzar_componentes(){

		panel_sup = new JPanel();

		JLabel lblFormularioCrearHotel = new JLabel("FORMULARIO CREAR HOTEL");
		lblFormularioCrearHotel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_sup = new GroupLayout(panel_sup);
		gl_panel_sup.setHorizontalGroup(
			gl_panel_sup.createParallelGroup(Alignment.LEADING)
				.addComponent(lblFormularioCrearHotel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel_sup.setVerticalGroup(
			gl_panel_sup.createParallelGroup(Alignment.LEADING)
				.addComponent(lblFormularioCrearHotel)
		);
		panel_sup.setLayout(gl_panel_sup);

		panel_cen = new JPanel();

		JLabel lblNombre = new JLabel("NOMBRE:");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		JLabel lblNit = new JLabel("NIT:");

		txtNit = new JTextField();
		txtNit.setColumns(10);

		JLabel lblTelefono = new JLabel("TELEFONO:");

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);

		JLabel lblDireccion = new JLabel("DIRECCION:");

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);

		JLabel lblPaginaWeb = new JLabel("PAGINA WEB:");

		txtPagina = new JTextField();
		txtPagina.setColumns(10);

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crear_hotel();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(186)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAceptar)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPaginaWeb)
								.addComponent(lblDireccion)
								.addComponent(lblTelefono)
								.addComponent(lblNit)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPagina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(107))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNit)
						.addComponent(txtNit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefono)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccion)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaginaWeb)
						.addComponent(txtPagina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAceptar)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		panel_cen.setLayout(gl_panel_cen);

	}
}
