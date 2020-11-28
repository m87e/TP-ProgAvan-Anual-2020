package util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.usal.tp.negocio.dao.dominio.Cliente;

public class BuildTableModel extends AbstractTableModel{

	private ArrayList list;
	private String[] columnas;

	 
	public BuildTableModel (ArrayList list, String[] columnas) {
		setColumnas(columnas);
		setList(list);
	}
	
	 public ArrayList getList() {
			return list;
		}
	public void setList(ArrayList<Cliente> datos) {
			list = datos;
		}
	
	public String[] getColumnas() {
			return columnas;
		}
	public void setColumnas(String[] columnas) {
			this.columnas = columnas;
		}

	
	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	

    public String getColumnName(int columnIndex) {
        return columnas[columnIndex];

    }
	@Override
	public Object getValueAt(int numLineas, int columnIndex) {
	
		Object[] lineas = (Object[]) getList().get(numLineas);
		
		return lineas[columnIndex];
	}

}
