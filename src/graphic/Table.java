package graphic;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;

public class Table extends JTable {

	public Table(Integer width, Integer height) {
		super(width, height);
		
		this.setRowHeight(20);
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i=0; i<width; i++) {			
			this.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}
		
		for (int i=1; i<this.getRowCount(); i++) {
			this.setValueAt(i, i, 0);
		}

		for (int i=1; i<this.getColumnCount(); i++) {
			this.setValueAt(Character.toString((char)64+i), 0, i);
		}
		
		this.setPreferredSize(new Dimension(width*75, height*20));
		this.setCellSelectionEnabled(showVerticalLines);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return row != 0 && column != 0;
	}
	
}
