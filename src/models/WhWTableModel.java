package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import whohavewashed.WhW;


@SuppressWarnings("serial")
public class WhWTableModel  extends AbstractTableModel{
	
	private List<WhW> dados = new ArrayList<>();
	@SuppressWarnings("rawtypes")
	private ArrayList linhas = null;
	private String[] colunas = null;
	
	@SuppressWarnings("rawtypes")
	public WhWTableModel(ArrayList lin,String[] col) {
		setLinhas(lin);
		setColunas(col);
	}
	@SuppressWarnings("rawtypes")
	public ArrayList getLinhas() {
		return linhas;
	}
	@SuppressWarnings("rawtypes")
	public void setLinhas(ArrayList dados) {
		linhas=dados;
	}
	public String[] getColunas() {
		return colunas;
	}
	public void setColunas(String[] nomes) {
		colunas = nomes;
	}
	public int getColumnCount() {
		return colunas.length;
	}
	public int getRowCount() {
		return linhas.size();
	}
	public String getColumnName(int numCol) {
		return colunas[numCol];
	}
	public Object getValueAt(int numLin, int numCol) {
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}
	public void addRow(WhW w){
		this.dados.add(w);
		this.fireTableDataChanged();
	}
	public void removeRow(int linha) {
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
}