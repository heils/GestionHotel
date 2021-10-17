package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

import datos.GestionArchivo;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Hotel;
import vista.cliente.jPanelCrearCliente;
import vista.cliente.jPanelEditarCliente;
import vista.cliente.jPanelEliminarCliente;
import vista.cliente.jPanelImprimirCliente;
import vista.empleado.jPanelCrearEmpleado;
import vista.empleado.jPanelEditarEmpleado;
import vista.empleado.jPanelEliminarEmpleado;
import vista.empleado.jPanelImprimirEmpleado;
import vista.factura.jPanelCrearFactura;
import vista.factura.jPanelEditarFactura;
import vista.factura.jPanelEliminarFactura;
import vista.factura.jPanelImprimirFactura;
import vista.hotel.jPanelCrearHotel;
import vista.hotel.jPanelEditarHotel;
import vista.hotel.jPanelEliminarHotel;
import vista.hotel.jPanelImprimirHotel;
import vista.hotel.jPanelInformeDeDatos;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.FlowLayout;

public class frmMenuHotel extends JFrame {

	private JPanel contentPane;
	private jPanelCrearHotel objCrearHotel;
	private jPanelEditarHotel objEditarHotel;
	private jPanelEliminarHotel objEliminarHotel;
	private jPanelCrearCliente objCrearCliente;
	private jPanelEditarCliente objEditarCliente;
	private jPanelEliminarCliente objEliminarCliente;
	private jPanelEditarEmpleado objEditarEmpleado;
	private jPanelEliminarEmpleado objEliminarEmpleado;
	private jPanelCrearEmpleado objCrearEmpleado;
	private jPanelImprimirEmpleado objImprimirEmpleado;
	private jPanelImprimirHotel objImprimirHotel;
	private jPanelImprimirCliente objImprimirCliente;
	private jPanelInformeDeDatos objInformeDeDatos;
	private jPanelCrearFactura objCrearFactura;
	private jPanelEditarFactura objEditarFactura;
	private jPanelEliminarFactura objEliminarFactura;
	private jPanelImprimirFactura objImprimirFactura;
	private Hotel auxObjHotel;
	private JPanel panel_cent;

	public frmMenuHotel(Hotel objHotelIn) {
		auxObjHotel = objHotelIn; //reserva de memoria de hotel
		this.objCrearHotel= new jPanelCrearHotel(auxObjHotel);
		this.objEditarHotel=new jPanelEditarHotel(auxObjHotel);
		this.objEliminarHotel=new jPanelEliminarHotel(auxObjHotel);
		this.objCrearCliente= new jPanelCrearCliente(auxObjHotel);
		this.objEditarCliente= new jPanelEditarCliente(auxObjHotel);
		this.objEliminarCliente=new jPanelEliminarCliente(auxObjHotel);
		this.objCrearEmpleado= new jPanelCrearEmpleado(auxObjHotel);
		this.objEditarEmpleado=new jPanelEditarEmpleado(auxObjHotel);
		this.objEliminarEmpleado=new jPanelEliminarEmpleado(auxObjHotel);
		this.objImprimirEmpleado=new jPanelImprimirEmpleado(auxObjHotel);
		this.objInformeDeDatos=new jPanelInformeDeDatos(auxObjHotel);
		this.objImprimirHotel=new jPanelImprimirHotel(auxObjHotel);
		this.objImprimirCliente=new jPanelImprimirCliente(auxObjHotel);
		this.objCrearFactura=new jPanelCrearFactura(auxObjHotel);
		this.objEliminarFactura=new jPanelEliminarFactura(auxObjHotel);
		this.objEditarFactura=new jPanelEditarFactura(auxObjHotel);
		this.objImprimirFactura= new jPanelImprimirFactura(auxObjHotel);
		lanzar_componentes();
		guardar_archivos();
	}
	
	
	
	public void lanzar_componentes(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGestionHotel = new JLabel("GESTION HOTEL");
		lblGestionHotel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblGestionHotel, BorderLayout.NORTH);
		
		JPanel panel_izq = new JPanel();
		panel_izq.setBorder(null);
		contentPane.add(panel_izq, BorderLayout.WEST);
		panel_izq.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup_izq = new JPanel();
		panel_sup_izq.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_izq.add(panel_sup_izq, BorderLayout.NORTH);
		
		JButton btnCrearHotel = new JButton("CREAR");
		btnCrearHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crear_hotel();
			}
		});
		btnCrearHotel.setMaximumSize(new Dimension(69, 23));
		
		JButton btnEliminarHotel = new JButton("ELIMINAR");
		btnEliminarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_hotel();
			}
		});
		
		JButton btnImprimirHotel = new JButton("IMPRIMIR");
		btnImprimirHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimir_hotel();
			}
		});
		btnImprimirHotel.setMinimumSize(new Dimension(69, 23));
		btnImprimirHotel.setMaximumSize(new Dimension(69, 23));
		
		JLabel lblNewLabel = new JLabel("GESTION HOTEL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnEditarHotel = new JButton("EDITAR");
		btnEditarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar_hotel();
			}
		});
		
		JButton btnInfomre = new JButton("INFOMRE");
		btnInfomre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				informe_de_datos();
			}
		});
		GroupLayout gl_panel_sup_izq = new GroupLayout(panel_sup_izq);
		gl_panel_sup_izq.setHorizontalGroup(
			gl_panel_sup_izq.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_sup_izq.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addGroup(gl_panel_sup_izq.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_sup_izq.createSequentialGroup()
							.addGroup(gl_panel_sup_izq.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_sup_izq.createSequentialGroup()
									.addComponent(btnImprimirHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(btnEliminarHotel))
								.addGroup(gl_panel_sup_izq.createSequentialGroup()
									.addComponent(btnCrearHotel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
									.addComponent(btnEditarHotel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addGap(41))
						.addGroup(Alignment.TRAILING, gl_panel_sup_izq.createSequentialGroup()
							.addComponent(btnInfomre)
							.addGap(100))))
				.addGroup(Alignment.LEADING, gl_panel_sup_izq.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(105))
		);
		gl_panel_sup_izq.setVerticalGroup(
			gl_panel_sup_izq.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sup_izq.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_panel_sup_izq.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCrearHotel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditarHotel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInfomre, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_sup_izq.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimirHotel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEliminarHotel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(12))
		);
		panel_sup_izq.setLayout(gl_panel_sup_izq);
		
		JPanel panel_inf_izq = new JPanel();
		panel_inf_izq.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_izq.add(panel_inf_izq, BorderLayout.SOUTH);
		
		JButton btnEditarEmpleado = new JButton("EDITAR");
		btnEditarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar_empleado();
			}
		});
		
		JButton btnImprimirEmpleado = new JButton("IMPRIMIR");
		btnImprimirEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimir_empleado();
			}
		});
		
		JButton btnElminiarEmpleado = new JButton("ELIMINAR");
		btnElminiarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_empleado();
			}
		});
		
		JButton btnCrearEmpleado = new JButton("CREAR");
		btnCrearEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear_empleado();
			}
		});
		
		JLabel lblGestionEmpleados = new JLabel("GESTION EMPLEADOS");
		GroupLayout gl_panel_inf_izq = new GroupLayout(panel_inf_izq);
		gl_panel_inf_izq.setHorizontalGroup(
			gl_panel_inf_izq.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_inf_izq.createSequentialGroup()
					.addGroup(gl_panel_inf_izq.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_inf_izq.createSequentialGroup()
							.addGap(89)
							.addComponent(lblGestionEmpleados))
						.addGroup(gl_panel_inf_izq.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_inf_izq.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnElminiarEmpleado, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
								.addComponent(btnEditarEmpleado, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
							.addGap(47)
							.addGroup(gl_panel_inf_izq.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnCrearEmpleado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnImprimirEmpleado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(65))
		);
		gl_panel_inf_izq.setVerticalGroup(
			gl_panel_inf_izq.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_inf_izq.createSequentialGroup()
					.addComponent(lblGestionEmpleados)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_inf_izq.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditarEmpleado, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrearEmpleado, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_inf_izq.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnElminiarEmpleado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnImprimirEmpleado, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_inf_izq.setLayout(gl_panel_inf_izq);
		
		JPanel panel_der = new JPanel();
		contentPane.add(panel_der, BorderLayout.EAST);
		panel_der.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sup_der = new JPanel();
		panel_sup_der.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_der.add(panel_sup_der, BorderLayout.NORTH);
		
		JButton btnImprimirCliente = new JButton("IMPRIMIR");
		btnImprimirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimir_cliente();
			}
		});
		
		JButton btnEditarCliente = new JButton("EDITAR");
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar_cliente();
			}
		});
		
		JButton btnCrearCliente = new JButton("CREAR");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crear_cliente();
			}
		});
		
		JButton btnEliminarCliente = new JButton("ELIMINAR");
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_cliente();
			}
		});
		
		JLabel lblGestionClientes = new JLabel("GESTION CLIENTES");
		GroupLayout gl_panel_sup_der = new GroupLayout(panel_sup_der);
		gl_panel_sup_der.setHorizontalGroup(
			gl_panel_sup_der.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_sup_der.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_sup_der.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_sup_der.createSequentialGroup()
							.addComponent(lblGestionClientes)
							.addGap(94))
						.addGroup(gl_panel_sup_der.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_panel_sup_der.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnImprimirCliente, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
								.addComponent(btnCrearCliente, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
							.addGap(30)
							.addGroup(gl_panel_sup_der.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnEditarCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminarCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(40))))
		);
		gl_panel_sup_der.setVerticalGroup(
			gl_panel_sup_der.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_sup_der.createSequentialGroup()
					.addComponent(lblGestionClientes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_sup_der.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditarCliente, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnCrearCliente, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_sup_der.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimirCliente, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(btnEliminarCliente, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_sup_der.setLayout(gl_panel_sup_der);
		
		JPanel panel_inf_der = new JPanel();
		panel_inf_der.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_der.add(panel_inf_der, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("GESTION FACTURA");
		
		JButton btnCrearFactura = new JButton("CREAR");
		btnCrearFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crear_factura();
			}
		});
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_factura();
			}
		});
		
		JButton btnImprimirFactura = new JButton("IMPRIMIR");
		btnImprimirFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimir_factura();
			}
		});
		
		JButton btnEditarFactura = new JButton("EDITAR");
		btnEditarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar_factura();
			}
		});
		GroupLayout gl_panel_inf_der = new GroupLayout(panel_inf_der);
		gl_panel_inf_der.setHorizontalGroup(
			gl_panel_inf_der.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_inf_der.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panel_inf_der.createParallelGroup(Alignment.LEADING)
						.addComponent(btnImprimirFactura, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addComponent(btnEditarFactura, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
					.addGap(39)
					.addGroup(gl_panel_inf_der.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCrearFactura, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panel_inf_der.createSequentialGroup()
					.addContainerGap(99, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(84))
		);
		gl_panel_inf_der.setVerticalGroup(
			gl_panel_inf_der.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_inf_der.createSequentialGroup()
					.addGap(4)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_inf_der.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnImprimirFactura, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrearFactura, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_inf_der.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(btnEditarFactura, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_inf_der.setLayout(gl_panel_inf_der);
		panel_cent = new JPanel();
		panel_cent.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		panel_cent.setBounds(new Rectangle(0, 0, 10, 10));
		contentPane.add(panel_cent, BorderLayout.CENTER);
		panel_cent.setLayout(new BorderLayout(0, 0));
	}
	//hotel
	public void crear_hotel(){
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objCrearHotel);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
		
	}
	public void editar_hotel(){
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objEditarHotel);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void eliminar_hotel(){
		this.panel_cent.remove(objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objEliminarHotel);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	//
	//clientes
	public void crear_cliente(){
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objCrearCliente);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	
	public void editar_cliente(){
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objEditarCliente);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	
	public void eliminar_cliente(){
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objEliminarCliente);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	//
	//empleados
	public void crear_empleado(){
		if(auxObjHotel.getNombre()==""){
			JOptionPane.showMessageDialog(this, "NO SE PUEDE CREAR EMPLEADOS SIN CREAR PRIMERO UN HOTEL","ERROR",
					JOptionPane.ERROR_MESSAGE);
			
		}else{
			this.panel_cent.remove(this.objEliminarEmpleado);
			this.panel_cent.remove(this.objEditarEmpleado);	
			this.panel_cent.remove(this.objEliminarCliente);
			this.panel_cent.remove(this.objEditarCliente);
			this.panel_cent.remove(this.objCrearCliente);
			this.panel_cent.remove(this.objEliminarHotel);
			this.panel_cent.remove(this.objEditarHotel);
			this.panel_cent.remove(this.objCrearHotel);
			this.panel_cent.remove(this.objImprimirEmpleado);
			this.panel_cent.remove(this.objImprimirHotel);
			this.panel_cent.remove(this.objInformeDeDatos);
			this.panel_cent.remove(this.objImprimirCliente);
			this.panel_cent.remove(this.objCrearFactura);
			this.panel_cent.remove(this.objEditarFactura);
			this.panel_cent.remove(this.objEliminarFactura);
			this.panel_cent.remove(this.objImprimirFactura);
			this.panel_cent.add(this.objCrearEmpleado);
			this.panel_cent.revalidate();
			this.panel_cent.repaint();	
		}
		
	}
	public void editar_empleado(){
		if(auxObjHotel.getNombre()==""){
			JOptionPane.showMessageDialog(this, "NO SE PUEDE CREAR EMPLEADOS SIN CREAR PRIMERO UN HOTEL","ERROR",
					JOptionPane.ERROR_MESSAGE);
			
		}else{
			this.panel_cent.remove(this.objEliminarEmpleado);
			this.panel_cent.remove(this.objCrearEmpleado);
			this.panel_cent.remove(this.objImprimirEmpleado);
			this.panel_cent.remove(this.objEliminarCliente);
			this.panel_cent.remove(this.objEditarCliente);
			this.panel_cent.remove(this.objImprimirCliente);
			this.panel_cent.remove(this.objCrearCliente);
			this.panel_cent.remove(this.objEliminarHotel);
			this.panel_cent.remove(this.objEditarHotel);
			this.panel_cent.remove(this.objCrearHotel);
			this.panel_cent.remove(this.objInformeDeDatos);
			this.panel_cent.remove(this.objImprimirHotel);
			this.panel_cent.remove(this.objCrearFactura);
			this.panel_cent.remove(this.objEditarFactura);
			this.panel_cent.remove(this.objEliminarFactura);
			this.panel_cent.remove(this.objImprimirFactura);
			this.panel_cent.add(this.objEditarEmpleado);
			this.panel_cent.revalidate();
			this.panel_cent.repaint();
		}
		
	}
	public void eliminar_empleado(){
		if(auxObjHotel.getNombre()==""){
			JOptionPane.showMessageDialog(this, "NO SE PUEDE CREAR EMPLEADOS SIN CREAR PRIMERO UN HOTEL","ERROR",
					JOptionPane.ERROR_MESSAGE);
			
		}else{
			this.panel_cent.remove(this.objCrearEmpleado);
			this.panel_cent.remove(this.objEditarEmpleado);	
			this.panel_cent.remove(this.objEliminarCliente);
			this.panel_cent.remove(this.objEditarCliente);
			this.panel_cent.remove(this.objCrearCliente);
			this.panel_cent.remove(this.objEliminarHotel);
			this.panel_cent.remove(this.objEditarHotel);
			this.panel_cent.remove(this.objCrearHotel);
			this.panel_cent.remove(this.objImprimirEmpleado);
			this.panel_cent.remove(this.objImprimirHotel);
			this.panel_cent.remove(this.objInformeDeDatos);
			this.panel_cent.remove(this.objImprimirCliente);
			this.panel_cent.remove(this.objCrearFactura);
			this.panel_cent.remove(this.objEditarFactura);
			this.panel_cent.remove(this.objEliminarFactura);
			this.panel_cent.remove(this.objImprimirFactura);
			this.panel_cent.add(this.objEliminarEmpleado);
			this.panel_cent.revalidate();
			this.panel_cent.repaint();
		}
		
	}
	public void imprimir_hotel(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objImprimirHotel);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void imprimir_empleado(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objImprimirEmpleado);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void imprimir_cliente(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objImprimirCliente);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void informe_de_datos(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objInformeDeDatos);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void crear_factura(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.add(this.objCrearFactura);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void editar_factura(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.add(this.objEditarFactura);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void eliminar_factura(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objImprimirFactura);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.add(this.objEliminarFactura);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}
	public void imprimir_factura(){
		this.panel_cent.remove(this.objCrearEmpleado);
		this.panel_cent.remove(this.objEditarEmpleado);	
		this.panel_cent.remove(this.objEliminarCliente);
		this.panel_cent.remove(this.objEliminarEmpleado);
		this.panel_cent.remove(this.objEditarCliente);
		this.panel_cent.remove(this.objCrearCliente);
		this.panel_cent.remove(this.objEliminarHotel);
		this.panel_cent.remove(this.objEditarHotel);
		this.panel_cent.remove(this.objCrearHotel);
		this.panel_cent.remove(this.objImprimirHotel);
		this.panel_cent.remove(this.objImprimirEmpleado);
		this.panel_cent.remove(this.objImprimirCliente);
		this.panel_cent.remove(this.objInformeDeDatos);
		this.panel_cent.remove(this.objCrearFactura);
		this.panel_cent.remove(this.objEditarFactura);
		this.panel_cent.remove(this.objEliminarFactura);
		this.panel_cent.add(this.objImprimirFactura);
		this.panel_cent.revalidate();
		this.panel_cent.repaint();
	}	
	public void guardar_archivos(){
		try{
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e){
					confirmar_salida();
				}	
			});
			this.setVisible(true);
		}catch(Exception e){
			
		}finally{
			
		}
	}
	public void confirmar_salida(){
		int valor = JOptionPane.showConfirmDialog(this, "¿DESEA GUARDAR LOS DATOS?","HOTEL",JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_NO_OPTION){
			GestionArchivo objGAHotel = new GestionArchivo(this.auxObjHotel);
			objGAHotel.escribir_archivo_clientes();
			objGAHotel.escribir_archivo_empleados();
			objGAHotel.escribir_archivo_facturas();
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	public interface imprimir{
		void cargar_tabla();
		void lanzar_componentes();
	}
}
