package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contratos;

public class Program {

	public static void main(String[] args)  throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite os dados do contrato: ");
		System.out.print("Número do contrato: ");
		int numero = read.nextInt();
		System.out.print("Data do contrato: ");
		Date data = sdf.parse(read.nextLine());
		System.out.print("Valor do contrato: ");
		double valor = read.nextDouble();
		System.out.print("Número de parcelas: ");
		int parcelas = read.nextInt();
		
		Contratos contrato = new Contratos(numero, data, valor);
		
		System.out.println("Parcelas: ");
		
		
		read.close();
	}

}
