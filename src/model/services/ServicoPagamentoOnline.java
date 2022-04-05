package model.services;

public interface ServicoPagamentoOnline {
	
		
		Double taxaPagament(Double valor);
		Double juros(Double valor, Integer meses);
	
}
