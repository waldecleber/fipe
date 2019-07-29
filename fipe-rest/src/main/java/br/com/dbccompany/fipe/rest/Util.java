package br.com.dbccompany.fipe.rest;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public abstract class Util {
	
	public static double converterPreco(String preco) {
		Locale Local = new Locale("pt", "BR");
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Local));
		String number = preco.replace("R$", "");
		try {
			return df.parse(number.trim()).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}