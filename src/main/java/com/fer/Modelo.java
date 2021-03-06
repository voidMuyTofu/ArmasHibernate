package com.fer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.fer.HibernateUtil;


public class Modelo {
	
	public Modelo() {
		conectar();
	}
	
	@Override
	public void finalize() {
		desconectar();
	}
	
	private void conectar() {
		HibernateUtil.buildSessionFactory();
	}
	
	private void desconectar() {
		HibernateUtil.closeSessionFactory();
	}
	
	public void guardarPersonaje(Personaje personaje) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(personaje);
		for (Arma arma : personaje.getArmas()) {
			arma.setPersonaje(personaje);
			System.out.println(arma.getNombre());
			sesion.saveOrUpdate(arma);
		}
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void guardarArma(Arma arma) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.saveOrUpdate(arma);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminarArma(Arma arma) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.delete(arma);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public void eliminarPersonaje(Personaje personaje) {
		Session sesion = HibernateUtil.getCurrentSession();
		sesion.beginTransaction();
		sesion.delete(personaje);
		sesion.getTransaction().commit();
		sesion.close();
	}
	
	public boolean existePersonaje(String nombre) {
		Session sesion = HibernateUtil.getCurrentSession();
		Query<Personaje> query = sesion.createQuery("FROM Personaje WHERE nombre = :nombre");
		query.setParameter("nombre", nombre);
		Personaje personaje = query.uniqueResult();

		return (personaje != null);
	}
	
	public List<Personaje> getPersonajes() {
		
		Session sesion = HibernateUtil.getCurrentSession();
		ArrayList<Personaje> personajes = (ArrayList<Personaje>) sesion.createQuery("FROM Personaje").list();
		return personajes;
	}
	
	public List<Arma> getArmas(){
		Session sesion = HibernateUtil.getCurrentSession();
		ArrayList<Arma> armas = (ArrayList<Arma>) sesion.createQuery("FROM Arma").list();
		return armas;
	}
	
	public List<Arma> getArmasLibres(){
		Session sesion = HibernateUtil.getCurrentSession();
		List<Arma> armas = (ArrayList<Arma>)
				sesion.createQuery("FROM Arma a WHERE a.personaje IS NULL").list();
		return armas;
	}
}
