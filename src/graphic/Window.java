package graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.TableCellEditor;
import javax.xml.stream.XMLStreamException;

import App.App;
import core.File;
import logging.Critical;
import logging.Info;
import logging.Warn;

public final class Window extends JFrame  {
	
	private File file;
	
	private JPanel header;
	private JPanel toolbar;	
	private JTable table;
	
	public Window(core.File file) {
		super("Exjeel");
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel();

		this.file = file;
		
		 this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		    	  if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0)
		    		  App.chiudi();
		      }
	    });

		
		header = new JPanel();
		 
		// toolbar
		toolbar = new JPanel();
		
		JButton bApri = new JButton("Apri");
		bApri.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFileChooser choser = new JFileChooser();
				choser.showOpenDialog(null);
				java.io.File file = choser.getSelectedFile();
				String filename = file.getPath();
				App.carica(filename);
			} 
		});
		JButton bSalva = new JButton("Salva");
		bSalva.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.salva();
			} 
		});
		JButton bChiudi = new JButton("Chiudi");
		bChiudi.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0)
					App.chiudi();
			} 
		});
		JButton binfo = new JButton("Info");
		binfo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new graphic.Info();
			} 
		});
		toolbar.add(bApri);
		toolbar.add(bSalva);
		toolbar.add(bChiudi);
		toolbar.add(binfo);
		
		header.add(toolbar);
		
		// input
		
		JTextField input = new JTextField(22);
		header.add(input);
		
		// grill
		table = new JTable(25, 25);
		
		panel.add(header);
		panel.add(table);
		
		super.add(panel);	
		super.setVisible(true);
		super.setBounds(30, 30, 400, 400);
	}

	protected void caricaFile(String filename) {
		java.io.File file = new java.io.File(filename);
	}
	


}
