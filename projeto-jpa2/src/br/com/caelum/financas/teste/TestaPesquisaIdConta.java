package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaPesquisaIdConta {
	
	public static void pesquisaIdConta(){
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(entityManager);
		entityManager.getTransaction().begin();
		
		Conta encontrado = contaDAO.busca(5);		
		System.out.println(encontrado.getTitular());
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
		
	}

}
