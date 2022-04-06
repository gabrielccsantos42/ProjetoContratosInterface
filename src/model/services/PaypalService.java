package model.services;

public class PaypalService implements ServicoPagamentoOnline{

	@Override
	public Double taxaPagamento(Double valor) {
		return valor * 0.02;
	}

	@Override
	public Double juros(Double valor, Integer meses) {
		return valor * 0.01 * meses;
	}

}
