import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String modo;

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	private String[] columnas = {};

	public void setColumnas(String[] nombreColumnas) {
		columnas = nombreColumnas;
	}

	public String[] getColumnas() {
		return columnas;
	}

	private Object[][] registros;

	public Object[][] getRegistros() {
		return registros;
	}

	public void setRegistros(int rows, int cols) {
		registros = new Object[rows][cols];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return registros.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	public String getColumnName(int col) {
		return columnas[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (registros[rowIndex][columnIndex] == null) {
			return 0;
		} else {
			return registros[rowIndex][columnIndex];
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		registros[row][col] = value;
		fireTableCellUpdated(row, col);
	}

	@Override
	public boolean isCellEditable(int row, int col) {

		if ((modo.equalsIgnoreCase("modificar") && (col != 0) || (this.getColumnName(col).equals("cantidad_det"))
				|| ((this.getColumnName(col).equals("observaciones_prod"))))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();

	}

}
