package br.com.caelum.financas.mb;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;

@ManagedBean
public class QtdeMovimentacoesDaContaBean {
	private Conta conta = new Conta();
	//private int quantidade;
	private BigDecimal quantidade;
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	

	public void lista() {
		//EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em);
		quantidade = movDAO.quantidadeMovimentacao(this.conta);
		
		
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	
}
