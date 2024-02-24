package tests;

import java.util.ArrayList;
import java.util.Scanner;

import connection.ConnectionWHW;
import whohavewashed.WhW;
import whwnit.WhWNIT;

public class TestSave {
	
	ConnectionWHW conecta = new ConnectionWHW();
	
	public static void main(String[] args) {
		
		Exibir();
		
	}
	
	public static void Salvar() {
	
		Scanner scan = new Scanner (System.in); 
		WhW w = new WhW();
		WhWNIT wNIT = new WhWNIT();
		
		String dia;
		String pessoa;
		String louca;
		String refeicao;
		String outros;
		
		System.out.print("Dia: "); dia = scan.nextLine();
		System.out.print("Pessoa: "); pessoa = scan.nextLine();
		System.out.print("Refeicao: "); refeicao = scan.nextLine();
		System.out.print("Louça: "); louca = scan.nextLine();
		System.out.print("Outros: "); outros = scan.nextLine();
		
		w.setDia(dia);
		w.setPessoa(pessoa);
		w.setRefeicao(refeicao);
		w.setLouca(louca);
		w.setOutros(outros);
		
		wNIT.create(w);
		
		scan.close();
	}
	public static void Exibir() {
		
		WhWNIT wNIT = new WhWNIT();
		ArrayList<WhW> whw = wNIT.mostrarTodos();
		
		for(WhW whwf:whw) {
			System.out.println("===============================");
			System.out.println();
			System.out.println("Dia: " + whwf.getDia());
			System.out.println("Pessoa: " + whwf.getPessoa());
			System.out.println("Refeição: "  + whwf.getRefeicao());
			System.out.println("Louça: " + whwf.getLouca());
			System.out.println("Outros: " + whwf.getOutros());
			System.out.println();
		}
		
		/*
		w.getDia();
		w.getPessoa();
		w.getLouca();
		w.getRefeicao();
		w.getQtd_lavada();
		
		conecta.executaSQL("SELECT * FROM");
		/*
		*/
	}
	
	public String diaLouca(String data) {
		
		String dia = "";
		String mes = "";
		String ano = "";
		String diaLouca = ano+"-"+mes+"-"+dia;
		System.out.println(diaLouca);
		
		return diaLouca;
	}
}
