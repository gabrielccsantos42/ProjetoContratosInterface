package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contratos;
import model.entities.Prestacao;

public class ServicoContrato {
	
	private ServicoPagamentoOnline pagamentoOnline;
	
	public ServicoContrato(ServicoPagamentoOnline pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}
	
	public void resultadoContrato(Contratos contrato, Integer meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
        for (int i = 1; i <= meses; i++) {
            Date data = addMeses(contrato.getData(), i);
            double cotaAtualizada = cotaBasica + pagamentoOnline.juros(cotaBasica, i);
            double cotaTotal = cotaAtualizada + pagamentoOnline.taxaPagamento(cotaAtualizada);
            contrato.addPrestacao(new Prestacao(data, cotaTotal));
        }
	}
	
	private Date addMeses(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
