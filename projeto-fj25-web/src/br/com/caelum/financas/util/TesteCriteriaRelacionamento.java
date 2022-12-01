package br.com.caelum.financas.util;

import java.math.BigDecimal;


import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;



public class TesteCriteriaRelacionamento {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em);
		BigDecimal soma = movDAO.somaMovimentacaoesDoTitulat("%paulo%");
		System.out.println("A soma da movimentaçao do titular é: " + soma);
	}

}
