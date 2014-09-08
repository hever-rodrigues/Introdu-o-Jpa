package br.senai.sc.ti20131n.pw.introducaojpa.DAO;

import javax.persistence.EntityManager;

import br.senai.sc.ti20131n.pw.introducaojpa.entity.Banda;

public class BandaDao {
	private EntityManager entityManager;
	
	public BandaDao(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public void salvar(Banda banda){
		this.entityManager.persist(banda);
	}
	
	public Banda buscarPorId(long id){
		return entityManager.find(Banda.class, id);
	}
	
	public void alterarBanda(long id, String nome, String historia){
		Banda banda = entityManager.find(Banda.class, id);
		banda.setNome(nome);
		banda.setHistoria(historia);
		
	}
	
	
}
