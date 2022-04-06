package model.services;

public interface ServicoPagamentoOnline {
	
		
		Double taxaPagamento(Double valor);
		Double juros(Double valor, Integer meses);
	
}
