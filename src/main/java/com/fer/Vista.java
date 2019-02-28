package com.fer;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import com.fer.componentes.beans.JEstados;
import com.fer.componentes.beans.JPanelPersonajes;
import com.fer.componentes.beans.JPanelArmas;
import com.fer.componentes.beans.JListaBusqueda;

public class Vista extends JFrame {

	public JPanel contentPane;
	public DefaultListModel<Personaje> mPersonajes;
	public JEstados estados;
	public JTabbedPane tabbedPane;
	public JPanelPersonajes panelPersonajes;
	public JPanelArmas panelArmas;

	public Vista() {
		setTitle("CRUD Hibernate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 455);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Opciones");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		estados = new JEstados();
		contentPane.add(estados, BorderLayout.SOUTH);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panelArmas = new JPanelArmas();
		tabbedPane.addTab("Armas", null, panelArmas, null);
		
		panelPersonajes = new JPanelPersonajes();
		tabbedPane.addTab("Personajes", null, panelPersonajes, null);
		
		mPersonajes = new DefaultListModel<Personaje>();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}


