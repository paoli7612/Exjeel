package graphic;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;

public class Table extends JTable {

	public Table(Integer width, Integer height) {
		super(width, height);
		
		this.setRowHeight(20);
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		for (int i=0; i<width; i++) {			
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			this.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}
		
		this.setPreferredSize(new Dimension(width*75, height*20));
		this.setCellSelectionEnabled(showVerticalLines);
	}
	
}
