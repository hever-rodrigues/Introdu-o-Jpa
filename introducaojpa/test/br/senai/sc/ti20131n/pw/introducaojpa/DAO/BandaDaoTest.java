package br.senai.sc.ti20131n.pw.introducaojpa.DAO;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.senai.sc.ti20131n.pw.introducaojpa.entity.Banda;
import br.senai.sc.ti20131n.pw.introducaojpa.util.JpaUtil;

public class BandaDaoTest {

	public static EntityManager entityManager;
	private BandaDao dao;
	

	@BeforeClass
	public static void init() {
		JpaUtil.initFactory();
	}

	@AfterClass
	public static void finish() {
		JpaUtil.closeFactory();
	}

	

	

	@Before
	public void begin() {
		entityManager = JpaUtil.getEntityManager();
		dao = new BandaDao(entityManager);
		entityManager.getTransaction().begin();
		

	}

	@After
	public void close() {
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManager = null;
		dao = null;
	}

	@Test
	public void testSalvar() {
		
		Banda banda = new Banda();
		banda.setNome("Banda Dazaranha");
		banda.setHistoria("Historia da Banda");		
		dao.salvar(banda);

	}
	
	@Test
	
	public void buscarBandaPorId(){		
		Banda banda = dao.buscarPorId(1L);
		System.out.println("Nome" + banda.getNome());
		assertNotNull(banda);		
	}
	
	@Test 
	
	public void alterarBanda(){
		Banda banda = new Banda();
		dao.alterarBanda(1L, "Mario", "Sem Historia");
		System.out.println();
		System.out.println("Novo" + banda.getNome()+ banda.getHistoria());
		
		
	}

}
