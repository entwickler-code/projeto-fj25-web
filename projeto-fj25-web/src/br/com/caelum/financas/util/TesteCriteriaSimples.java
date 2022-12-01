package br.com.caelum.financas.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TesteCriteriaSimples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em); 
		List<Movimentacao> lista = movDAO.todasComCriteria();
		
		
		System.out.println("Resultado da Lista de Movimentação: " + lista);
		 
		
	}

}
