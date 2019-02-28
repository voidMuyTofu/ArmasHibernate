package com.fer;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Controller implements ActionListener, ListSelectionListener, FocusListener, KeyListener {

	private Vista vista;
	private Modelo modelo;
	
	public enum Accion {
		NUEVO, MODIFICAR, GUARDAR, ELIMINAR
	}
	private Accion accion;
	private Personaje personajeActual;
	
	public Controller(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		addListeners();
		cargarDatos();
	}
	
	private void addListeners() {
		
	}
	
	private void cargarDatos() {
		List<Personaje> personajes = modelo.getPersonajes();
		vista.mPersonajes.removeAllElements();
		for (Personaje personaje : personajes) 
			vista.mPersonajes.addElement(personaje);
	}
	
	private void cargarPersonajeActual() {
		
	}
	
	private void modoEdicion(boolean edicion) {
		
	}
	
	private void nuevoPersonaje() {
		
		modoEdicion(true);
	}
	
	private void modificarPersonaje() {
		
		
		modoEdicion(true);
	}
	
	private void guardarPersonaje() {
		
	}
	
	private void eliminarPersonaje() {
		if (JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Modificar", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
			return;
		
		modelo.eliminarPersonaje(personajeActual);
		cargarDatos();
	}

	public void actionPerformed(ActionEvent event) {
		Accion accion = Accion.valueOf(event.getActionCommand());
		switch (accion) {
			case NUEVO:
				nuevoPersonaje();
				break;
			case MODIFICAR:
				modificarPersonaje();
				break;
			case GUARDAR:
				guardarPersonaje();
				break;
			case ELIMINAR:
				eliminarPersonaje();
				break;
			default:
					break;
		}
	}
	
	private void comprobarNombre() {
		
			}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
/*
	@Override
	public void valueChanged(ListSelectionEvent event) {
		int posicion = vista.lPersonajes.getSelectedIndex();
		if (posicion == -1)
			return;
		
		personajeActual = vista.lPersonajes.getSelectedValue();
		cargarPersonajeActual();
	}

	@Override
	public void focusGained(FocusEvent event) {
	}

	@Override
	public void focusLost(FocusEvent event) {
		comprobarNombre();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		comprobarNombre();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}*/