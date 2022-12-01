package br.com.caelum.financas.mb;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;


@ManagedBean
public class MovimentacoesDaContaBean {
	private List<Movimentacao> movimentacoes;	
	private Movimentacao movimentacao = new Movimentacao();
	private Conta conta = new Conta();
	public Integer contaId;
	
	
	/*@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}*/

	
	public void lista() {
		
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em);
				
		this.movimentacoes = movDAO.listaTodasMovimentacoes(contaId);		
		em.close();
				
		
	}
	public Integer getContaId() {
		return contaId;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	public List<Movimentacao> getMovimentacoes() {
		
		
		
		return movimentacoes;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Movimentacao getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	


}
