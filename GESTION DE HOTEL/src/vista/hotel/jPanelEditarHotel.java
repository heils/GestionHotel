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

public class jPanelEditarHotel extends JPanel {
	private JTextField txtActNombre;
	private JTextField txtActNit;
	private JTextField txtActTelefono;
	private JTextField txtActDireccion;
	private JTextField txtActPagina;
	private Hotel auxHotel;


	public jPanelEditarHotel(Hotel hotelIn) {
		lanzar_componentes();
		this.auxHotel=hotelIn;
	}

	public void editar_hotel(){
		try{
			if(this.txtActDireccion.getText().equals("") || this.txtActNit.getText().equals("") || this.txtActNombre.getText().equals("") || this.txtActPagina.getText().equals("") || this.txtActTelefono.getText().equals("")){
				throw new Exception();
			}
			this.auxHotel.setNombre(this.txtActNombre.getText());
			this.auxHotel.setNit(Integer.parseInt(this.txtActNit.getText()));
			this.auxHotel.setTelefono(Integer.parseInt(this.txtActTelefono.getText()));
			this.auxHotel.setDireccion(this.txtActDireccion.getText());
			this.auxHotel.setPagina_web(this.txtActPagina.getText());
			JOptionPane.showMessageDialog(this, "Hotel Actualizado","Registro De Hotel",
					JOptionPane.INFORMATION_MESSAGE);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Debe ingresar valores válidos para el Nit y teléfono","Creación de Hotel",
					JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos Vacios","Creación de Hotel",
					JOptionPane.WARNING_MESSAGE);
		}finally{
			
			this.txtActNit.setText("");
			this.txtActNombre.setText("");
			this.txtActTelefono.setText("");
			this.txtActDireccion.setText("");
			this.txtActPagina.setText("");
		}
			
	}

	public void lanzar_componentes(){
		
		setLayout(new BorderLayout(0, 0));

		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);

		JLabel lblFormularioEditarHotel = new JLabel("FORMULARIO EDITAR HOTEL");
		panel_sup.add(lblFormularioEditarHotel);

		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);

		JLabel lblActualizarNombre = new JLabel("ACTUALIZAR NOMBRE:");

		JLabel lblActualizarNit = new JLabel("ACTUALIZAR NIT:");

		JLabel lblActualizarTelefono = new JLabel("ACTUALIZAR TELEFONO:");

		JLabel lblActualizarDireccion = new JLabel("ACTUALIZAR DIRECCION:");

		JLabel lblActualizarPaginaWeb = new JLabel("ACTUALIZAR PAGINA WEB:");

		txtActNombre = new JTextField();
		txtActNombre.setColumns(10);

		txtActNit = new JTextField();
		txtActNit.setColumns(10);

		txtActTelefono = new JTextField();
		txtActTelefono.setColumns(10);

		txtActDireccion = new JTextField();
		txtActDireccion.setColumns(10);

		txtActPagina = new JTextField();
		txtActPagina.setColumns(10);

		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar_hotel();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
			gl_panel_cen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblActualizarNombre)
							.addGap(1)
							.addComponent(txtActNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblActualizarNit)
							.addGap(3)
							.addComponent(txtActNit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblActualizarTelefono)
							.addGap(3)
							.addComponent(txtActTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblActualizarDireccion)
							.addGap(7)
							.addComponent(txtActDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(lblActualizarPaginaWeb)
							.addGap(1)
							.addComponent(txtActPagina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addComponent(btnActualizar)
							.addGap(164)))
					.addGap(70))
		);
		gl_panel_cen.setVerticalGroup(
			gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGap(3)
							.addComponent(lblActualizarNombre))
						.addComponent(txtActNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGap(3)
							.addComponent(lblActualizarNit))
						.addComponent(txtActNit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGap(5)
							.addComponent(lblActualizarTelefono))
						.addComponent(txtActTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGap(3)
							.addComponent(lblActualizarDireccion))
						.addComponent(txtActDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_cen.createSequentialGroup()
							.addGap(3)
							.addComponent(lblActualizarPaginaWeb))
						.addComponent(txtActPagina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnActualizar)
					.addGap(84))
		);
		panel_cen.setLayout(gl_panel_cen);

	}

}
