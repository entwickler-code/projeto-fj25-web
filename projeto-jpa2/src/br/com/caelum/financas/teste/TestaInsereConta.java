package br.com.caelum.financas.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;


import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		long inicio = System.currentTimeMillis();
		int cod;
		cod = sc.nextInt();
		switch(cod){
		  case 1: 
		
		
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		
		Conta conta = new Conta();
		conta.setTitular("Maria Rita");
		conta.setBanco("HSBC");
		conta.setNumero("545454-7");
		conta.setAgencia("1300");
		entityManager.getTransaction().begin();
		contaDAO.adiciona(conta);
		
		entityManager.getTransaction().commit();
		
		
		//entityManager.persist(conta);
		
		entityManager.close();
		
		
		System.out.println("Itaú-Unibanco --- Conta gravada com sucesso!");
		  break;
		  case 2:
		// Realiza pesquisa pelo ID do cliente
		TestaPesquisaIdConta.pesquisaIdConta();
		  break;
		  case 3:
		// Lista conta do cliente
		TestaListagemConta.listaConta();
		  break;
		  default: System.out.println("Codigo nào encontrado");
		}
		
		
		long fim = System.currentTimeMillis();
		System.out.println("Executado em " + (fim - inicio));
		
		
	}
	
	

}
