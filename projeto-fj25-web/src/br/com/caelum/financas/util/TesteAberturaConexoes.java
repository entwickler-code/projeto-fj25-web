package br.com.caelum.financas.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;

public class TesteAberturaConexoes {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		List<EntityManager> emList = new ArrayList<>();
		for (int i = 0; i <= 1000; i++) {
			System.out.println("Resultado do laço FOR - valor  (i) e igual a: " + i);
			
			EntityManager em = new JPAUtil().getEntityManager();
			emList.add(em);
			em.getTransaction().begin();
		}
		Thread.sleep(60*1000);
	}

}
