package br.com.caelum.financas.mb;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


import javax.persistence.EntityManager;


import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.dao.TagDAO;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Tag;
import br.com.caelum.financas.modelo.TipoMovimentacao;


@ManagedBean
public class MovimentacoesBean {
	private List<Movimentacao> movimentacoes;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private String tags;
	
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void grava() {
		//EntityManager em = new JPAUtil().getEntityManager();
		//em.getTransaction().begin();
		ContaDAO contaDAO = new ContaDAO(em);
		MovimentacaoDAO movDao = new MovimentacaoDAO(em);
		Conta contaRelacionada = contaDAO.busca(contaId);
		
		movimentacao.setConta(contaRelacionada);
		gravaEAssociaAsTags(em);
		movDao.adiciona(movimentacao);	
		
		//em.getTransaction().commit();
		
		this.movimentacoes = movDao.lista();	
		//em.close();
		
		limpaFormularioDoJSF();
	}
	

	public void remove() {
		
		//EntityManager em = new JPAUtil().getEntityManager();
		//em.getTransaction().begin();
		MovimentacaoDAO MovDAO = new MovimentacaoDAO(em);
		
		Movimentacao movParaRemover = MovDAO.busca(this.movimentacao.getId());
		MovDAO.remove(movParaRemover);
		movimentacoes = MovDAO.lista();
		
		//em.getTransaction().commit();
		//em.close();
		
		limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		//EntityManager em = new JPAUtil().getEntityManager();
		if(movimentacoes == null){			
			MovimentacaoDAO dao = new MovimentacaoDAO(em);			
			movimentacoes = dao.lista();			
		}
		
		
		return movimentacoes;
	}
	
	private void gravaEAssociaAsTags(EntityManager em){
		String[] nomeDasTags = this.tags.split(" ");
		TagDAO tagDAO = new TagDAO(em);
		
		for(String nome: nomeDasTags){
			Tag tag = tagDAO.adicionaOuBuscaTagComNome(nome);
			movimentacao.getTags().add(tag);
		}
		
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	

	public Movimentacao getMovimentacao() {
		if(movimentacao.getData()==null) {
			movimentacao.setData(Calendar.getInstance());
		}
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	/**
	 * Esse método apenas limpa o formulário da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulário vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
		this.tags = null;
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
}
