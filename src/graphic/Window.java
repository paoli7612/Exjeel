package graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.imageio.ImageIO;
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
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardResizeToggleHandler;
import javax.swing.table.TableCellEditor;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.xml.stream.XMLStreamException;

import App.App;
import core.Cella;
import core.File;
import core.Foglio;
import logging.Critical;
import logging.Error;
import logging.Info;
import logging.Warn;

public final class Window extends JFrame  {
	
	private File file;
	
	private JPanel header;
	
	public JButton binfo;
	public JTabbedPane tabbed;
	
	public Window(File file) {
		super("Exjeel");
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel();

		this.file = file;
		
		 this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		    	  chiudi();
		      }
  		});
	
		// header
		header = new JPanel();
		
		newButton("new-sheet", "Nuovo foglio").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.nuovo_foglio();
			} 
		});
		newButton("del-sheet", "Elimina foglio").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.elimina_foglio(App.finestra.tabbed.getSelectedIndex());
			} 
		});
		newButton("load", "Apri").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFileChooser choser = new JFileChooser();
				choser.showOpenDialog(null);
				try {
					App.carica(choser.getSelectedFile().getPath());					
				} catch (Exception e2) {
					new Error("Non ho caricato un file perchè non è stato selezionato");
				}
			} 
		});
		newButton("save", "Salva").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.salva();
			} 
		});
		newButton("exit", "Chiudi").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				chiudi();
			} 
		});
		binfo = newButton("info", "Info");
		binfo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new graphic.Info();
				JButton button = (JButton)e.getSource();
				button.setEnabled(false);
			} 
		});
			
		// table
		tabbed = new JTabbedPane();
			
		panel.add(header);
		panel.add(tabbed);
				
		super.add(panel);	
		super.setVisible(true);
		super.setBounds(30, 30, 1800, 600);
		
		for (int i=0; i<file.count(); i++) {
			Foglio foglio = file.getFoglio(i);
			aggiungi_foglio(foglio);	
			App.nFogli++;
		}
	}
	
	public void aggiungi_foglio() {
		JTable table = new Table(App.COLONNE+1, App.RIGHE+1);
		tabbed.addTab("foglio " + App.nFogli, table);	
	}
	
	public void aggiungi_foglio(JTable table) {
		tabbed.addTab("foglio " + App.nFogli, table);	
	}
		
	public void aggiungi_foglio(Foglio foglio) {
		JTable table = new Table(App.COLONNE+1, App.RIGHE+1);
		for (int y=0; y<App.COLONNE; y++){
			for (int x=0; x<App.RIGHE; x++){
				Cella c = foglio.getCella(x, y);
				if (!c.empty()) {
					new Info(c.value + " ");
					table.setValueAt(c.value, y+1, x+1);
					
				}
			}
		}
		aggiungi_foglio(table);
	}
	
	public void elimina_foglio(Integer index) {
		tabbed.remove(index);
	}
	
	private JButton newButton(String img, String title) {
		Icon icon = new ImageIcon("./src/img/%s.png".formatted(img));
		JButton button= new JButton(title);
		button.setIcon(icon);
		header.add(button);
		return button;	
	}
	
	public void chiudi() {
		if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0)
			App.chiudi();
	}
}
