package graphic;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import App.App;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.Cella;
import core.Pos;
import logging.Critical;
import logging.Info;
import logging.Warn;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class Table extends JTable {

	private App app;
	
	public Table(App app, Integer width, Integer height) {
		
		super(width, height);
		this.app = app;
		this.setRowHeight(20);
		
		// Allineamento celle centrato
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i=0; i<App.COLONNE+1; i++) {			
			this.getColumnModel().getColumn(i).setCellRenderer(r);
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
			Pos pos = getSelectedPos();
			char key = e.getKeyChar();
			if (key == '=') {
			  Object o = getValueAt(pos.getY(), pos.getX());
			  if (o == null || o.equals("")) {		
		        new Info("Startr formula at " + pos.coord());
		      }
		    }
		    if (key == '\n') {
		    	String s = (String) getValueAt(pos.getY()+1, pos.getX()+1);
		    	new Info(pos.coord());
		    	new Info(s);
		    	//app.scrivi(pos, s);
			}
		  }
		});	

		   super.addMouseListener(new MouseInputListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Pos p = getSelectedPos();
				if (p.intestazione()) {					
					app.finestra.clearTf();
				} else {					
					app.finestra.tf.setText(app.leggiSotto(p));
				}
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private Pos getSelectedPos() {
		return new Pos(getSelectedColumn()-1, getSelectedRow()-1);
	}
	
	public void scrivi(Integer x, Integer y, String value) {
		setValueAt(value, y, x);
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
