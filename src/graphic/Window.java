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
import logging.Info;

public final class Window extends JFrame {
	
	private File file;
	
	private JToolBar toolbar;	
	private JTable table;
	
	public Window(core.File file) {
		super("Exjeel");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();

		this.file = file;
				
		// toolbar
		toolbar = new JToolBar(JToolBar.HORIZONTAL);
		
		JButton bApri = new JButton("Apri");
		bApri.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFileChooser choser = new JFileChooser();
				choser.showOpenDialog(null);
				java.io.File file = choser.getSelectedFile();
				String filename = file.getPath();
				App.finestra.caricaFile(filename);
			} 
		});
		JButton bSalva = new JButton("Salva");
		JButton bChiudi = new JButton("Chiudi");
		toolbar.add(bApri);
		toolbar.add(bSalva);
		toolbar.add(bChiudi);
		
		panel.add(toolbar);
		
		// grill
		table = new JTable(25, 25);
		
		panel.add(table);
		
		super.add(panel);	
		super.setVisible(true);
		super.setBounds(30, 30, 400, 400);
	}

	protected void caricaFile(String filename) {
		
		new Info(filename);
		
	}


}
