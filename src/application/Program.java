package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contratos;
import model.entities.Prestacao;
import model.services.PaypalService;
import model.services.ServicoContrato;

public class Program {

	public static void main(String[] args)  throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite os dados do contrato: ");
		System.out.print("Número do contrato: ");
		int numero = read.nextInt();
		System.out.print("Data do contrato: ");
		Date data = sdf.parse(read.next());
		System.out.print("Valor do contrato: ");
		double valor = read.nextDouble();
		
		Contratos contrato = new Contratos(numero, data, valor);
		
		System.out.print("Número de parcelas: ");
		int parcelas = read.nextInt();
		
		ServicoContrato sc = new ServicoContrato(new PaypalService());
		
		sc.resultadoContrato(contrato, parcelas);
		
		System.out.println("Parcelas: ");
		for(Prestacao parcela : contrato.getListaPrestacao()) {
			System.out.println(parcela);
		}
		
		read.close();
	}

}
