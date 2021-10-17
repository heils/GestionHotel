package vista.cliente;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

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
import java.awt.event.ActionEvent;

public class jPanelEditarCliente extends JPanel {
	private JTextField txtBuscarRuc;
	private JTextField txtActNombre;
	private JTextField txtActTelefono;
	private JTextField txtActDireccion;
	private JTextField txtActRuc_ci;
	private JTextField txtActEmpresa;
	private JTextField txtActNacionalidad;
	private Hotel auxObjHotel;


	public jPanelEditarCliente(Hotel objHotelIn) {
		lanzar_componentes();
		this.auxObjHotel=objHotelIn;

	}

	public void editar_cliente(){
		try{
			if(this.txtActNombre.getText().equals("") || this.txtActTelefono.getText().equals("") || this.txtActDireccion.getText().equals("") || this.txtActRuc_ci.getText().equals("") || this.txtActEmpresa.getText().equals("") || this.txtActNacionalidad.getText().equals("") ){
				throw new Exception();
			}
			int h=-1;
			long RucBuscar;
			RucBuscar=(Integer.parseInt(this.txtBuscarRuc.getText()));
			for(int i=0; i<this.auxObjHotel.getLstClientes().size();i++) {
				if(RucBuscar==this.auxObjHotel.getLstClientes().get(i).getRuc_ci()) {
					this.auxObjHotel.getLstClientes().get(i).setNombre(this.txtActNombre.getText());
					this.auxObjHotel.getLstClientes().get(i).setTelefono(Integer.parseInt(this.txtActTelefono.getText()));
					this.auxObjHotel.getLstClientes().get(i).setDireccion((this.txtActDireccion.getText()));
					this.auxObjHotel.getLstClientes().get(i).setRuc_ci(Integer.parseInt(this.txtActRuc_ci.getText()));
					this.auxObjHotel.getLstClientes().get(i).setEmpresa(this.txtActEmpresa.getText());
					this.auxObjHotel.getLstClientes().get(i).setNacionalidad(this.txtActNacionalidad.getText());
					JOptionPane.showMessageDialog(this, "Cliente Actualizado","Registro De Cliente",
							JOptionPane.INFORMATION_MESSAGE);
					h=-1;	
				}
				else{
					h=0;
				}
			}
			if(h!=-1){
				JOptionPane.showMessageDialog(this, "Error Al Actualizar Cliente",
						"Crear Cliente",JOptionPane.ERROR_MESSAGE);
			}
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Revise los valores de cédula y teléfono","Registro De Cliente",
					JOptionPane.ERROR_MESSAGE);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Campos vacios","Registro De Cliente",
					JOptionPane.WARNING_MESSAGE);
			
		}finally{
			
			this.txtBuscarRuc.setText("");
			this.txtActNombre.setText("");
			this.txtActTelefono.setText("");
			this.txtActRuc_ci.setText("");
			this.txtActDireccion.setText("");
			this.txtActEmpresa.setText("");
			this.txtActNacionalidad.setText("");
		}

	}

	public void lanzar_componentes(){
		setLayout(new BorderLayout(0, 0));

		JPanel panel_sup = new JPanel();
		add(panel_sup, BorderLayout.NORTH);

		JLabel lblFormularioEditarCliente = new JLabel("FORMULARIO EDITAR CLIENTE");
		panel_sup.add(lblFormularioEditarCliente);

		JPanel panel_cen = new JPanel();
		add(panel_cen, BorderLayout.CENTER);

		JLabel lblNombreABuscar = new JLabel("RUC_CI A BUSCAR CLIENTE:");

		txtBuscarRuc = new JTextField();
		txtBuscarRuc.setText("");
		txtBuscarRuc.setColumns(10);

		JLabel lblActualizarNombre = new JLabel("ACTUALIZAR NOMBRE:");

		txtActNombre = new JTextField();
		txtActNombre.setColumns(10);

		JLabel lblActualizarTelefono = new JLabel("ACTUALIZAR TELEFONO:");

		txtActTelefono = new JTextField();
		txtActTelefono.setColumns(10);

		JLabel lblActualizarDireccion = new JLabel("ACTUALIZAR DIRECCION:");

		txtActDireccion = new JTextField();
		txtActDireccion.setColumns(10);

		JLabel lblActualizarDire = new JLabel("ACTUALIZAR RUC_CI:");

		txtActRuc_ci = new JTextField();
		txtActRuc_ci.setColumns(10);

		JLabel lblActualizarEmpresa = new JLabel("ACTUALIZAR EMPRESA:");

		JLabel lblActualizarNacionalidad = new JLabel("ACTUALIZAR NACIONALIDAD");

		txtActEmpresa = new JTextField();
		txtActEmpresa.setColumns(10);

		txtActNacionalidad = new JTextField();
		txtActNacionalidad.setColumns(10);

		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar_cliente();
			}
		});
		GroupLayout gl_panel_cen = new GroupLayout(panel_cen);
		gl_panel_cen.setHorizontalGroup(
				gl_panel_cen.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_cen.createSequentialGroup()
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_cen.createSequentialGroup()
										.addGap(106)
										.addGroup(gl_panel_cen.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblActualizarNombre)
												.addComponent(lblActualizarEmpresa)
												.addComponent(lblActualizarDire)
												.addComponent(lblActualizarDireccion)
												.addComponent(lblActualizarTelefono)
												.addComponent(lblActualizarNacionalidad)))
								.addGroup(Alignment.TRAILING, gl_panel_cen.createSequentialGroup()
										.addContainerGap(96, Short.MAX_VALUE)
										.addComponent(lblNombreABuscar)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_cen.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
										.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
												.addComponent(txtActNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtActTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtActDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtActRuc_ci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtActEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtActNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(111))
								.addGroup(gl_panel_cen.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtBuscarRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				.addGroup(Alignment.LEADING, gl_panel_cen.createSequentialGroup()
						.addGap(178)
						.addComponent(btnActualizar)
						.addContainerGap(177, Short.MAX_VALUE))
				);
		gl_panel_cen.setVerticalGroup(
				gl_panel_cen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_cen.createSequentialGroup()
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtBuscarRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreABuscar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.LEADING)
								.addComponent(txtActNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblActualizarNombre))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActualizarTelefono)
								.addComponent(txtActTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActualizarDireccion)
								.addComponent(txtActDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActualizarDire)
								.addComponent(txtActRuc_ci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActualizarEmpresa)
								.addComponent(txtActEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_cen.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblActualizarNacionalidad)
								.addComponent(txtActNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnActualizar)
						.addContainerGap(71, Short.MAX_VALUE))
				);
		panel_cen.setLayout(gl_panel_cen);
	}

}
