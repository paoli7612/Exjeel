package graphic;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import App.App;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.Cella;
import core.Pos;
import logging.Info;
import logging.Warn;

import java.awt.*;
import java.awt.event.KeyListener;

public class Table extends JTable {

	private App app;
	
	public Table(App app, Integer width, Integer height) {
		super(width, height);
		
		this.app = app;
		
		this.setRowHeight(20);
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<App.COLONNE; i++) {			
			this.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
		}

		// imposta NUMERI
		for (int i=1; i<this.getRowCount(); i++) {
			this.setValueAt(i, i, 0);
		}
		
		// imposta LETTERE
		for (int i=1; i<this.getColumnCount(); i++) {
			this.setValueAt(Character.toString((char)64+i), 0, i);
		}
		
		this.setCellSelectionEnabled(showVerticalLines);
		
		super.addKeyListener(new KeyAdapter() {
		  public void keyPressed(KeyEvent e) {
			Pos pos = new Pos(getSelectedColumn(), getSelectedRow());
			char key = e.getKeyChar();
			if (key == '=') {
			  Object o = getValueAt(pos.getY(), pos.getX());
			  if (o == null || o.equals("")) {		
		        scrivi(pos, "=A1+B2");
		      }
		    }
		    if (key == '\n') {
		    	String s = (String) getValueAt(pos.getY(), pos.getX());
		    	app.scrivi(pos, s);
			}
		  }
		});	
	}
	
	public void scrivi(Integer x, Integer y, String value) {
		setValueAt(value, x, y);
	}
	
	public void scrivi(Pos pos, String s) {
		scrivi(pos.getX()+1, pos.getY()+1, s);
	}
	
	public String read(Pos pos) {
		new logging.Info(pos.getX() + " " + pos.getY());
		return (String) getValueAt(pos.getY(), pos.getX());
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return row != 0 && column != 0;
	}
			
}
