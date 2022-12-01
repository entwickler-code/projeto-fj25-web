package br.com.caelum.financas.util;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;


public class TesteConsultaComCriteriaDinamica {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em);
		Conta contaTitular = new Conta();
		contaTitular.getTitular();
		
		//List<Movimentacao> lista = movDAO.pesquisaCriteriaDinamica(contaTitular, TipoMovimentacao.ENTRADA);
		
		//System.out.println("Resultado da Pesquisa Criteria Dinamica Por Titular e Tipo de movimentação: " + lista);
	}

}
