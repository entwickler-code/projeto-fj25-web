package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.caelum.financas.infra.ValidatorUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaValidacaoValorMovimentacao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Validator validator = new ValidatorUtil().getValidator();
		
		Movimentacao mov = new Movimentacao();
		mov.setValor(BigDecimal.ZERO);
		
		Set<ConstraintViolation<Movimentacao>> erros = validator.validate(mov);
		
		for(ConstraintViolation<Movimentacao> erro: erros){
			System.out.println(erro.getPropertyPath() + " - " + erro.getMessage());
			
		}

	}

}
