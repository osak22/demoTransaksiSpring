package com.example.demo.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaksi;
import com.example.demo.services.TransaksiService;

import java.util.List;

@Service
public class TransaksiDao implements TransaksiService{

	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	// menampilkan	
	public List<Transaksi> listTransaksi(){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Transaksi", Transaksi.class).getResultList();
		
	}
	// simpan
	@Override
	public Transaksi saveOrUpdate(Transaksi transaksi) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Transaksi saved = em.merge(transaksi);
        em.getTransaction().commit();
		return saved;
	}
	
	// get id atau ke edit
	@Override
	public Transaksi getIdTransaksi(Integer id) {
		EntityManager em = emf.createEntityManager();
        return em.find(Transaksi.class, id); // diambil dr model
	}
	
	// hapus data
	@Override
	public void hapusIdTransaksi(Integer id) {
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Transaksi.class, id));
        em.getTransaction().commit();		
	}
}
