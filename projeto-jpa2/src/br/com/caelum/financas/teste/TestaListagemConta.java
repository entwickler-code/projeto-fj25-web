package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaListagemConta {
	
	
	public static void listaConta(){
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		ContaDAO contaDAO = new ContaDAO(entityManager);
		entityManager.getTransaction().begin();
		
		List<Conta> lista = contaDAO.lista();
		
		for(Conta conta: lista){
			System.out.println(conta.getNumero());
		}	
		
		
		//entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}

}
