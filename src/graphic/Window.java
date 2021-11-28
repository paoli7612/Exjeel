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
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.TableCellEditor;
import javax.xml.stream.XMLStreamException;

import App.App;
import core.File;
import logging.Critical;
import logging.Error;
import logging.Info;
import logging.Warn;

public final class Window extends JFrame  {
	
	private File file;
	
	private JPanel header;
	private JPanel toolbar;	
	
	public JButton binfo;
	public JTabbedPane tabbed;
	
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
		Icon iApri = new ImageIcon("./src/img/load.png");
		JButton bApri = new JButton("Carica");
		bApri.setIcon(iApri);
		bApri.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFileChooser choser = new JFileChooser();
				choser.showOpenDialog(null);
				java.io.File file = choser.getSelectedFile();
				String filename = file.getPath();
				App.carica(filename);
			} 
		});
		Icon iSalva = new ImageIcon("./src/img/save.png");
		JButton bSalva = new JButton("Salva");
		bSalva.setIcon(iSalva);
		bSalva.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.salva();
			} 
		});
		Icon iChiudi = new ImageIcon("./src/img/exit.png");
		JButton bChiudi = new JButton("Chiudi");
		bChiudi.setIcon(iChiudi);
		bChiudi.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Sei sicuro?") == 0)
					App.chiudi();
			} 
		});
		Icon iInfo = new ImageIcon("./src/img/info.png");
		binfo = new JButton("Info");
		binfo.setIcon(iInfo);
		binfo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new graphic.Info();
				JButton button = (JButton)e.getSource();
				button.setEnabled(false);
			} 
		});
		Icon iNuovoSheet = new ImageIcon("./src/img/new-sheet.png");
		JButton bNuovoSheet = new JButton("Nuovo foglio");
		bNuovoSheet.setIcon(iNuovoSheet);
		bNuovoSheet.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.nuovo_foglio();
			} 
		});
		Icon iEliminaSheet = new ImageIcon("./src/img/del-sheet.png");
		JButton bEliminaSheet = new JButton("Elimina foglio");
		bEliminaSheet.setIcon(iEliminaSheet);
		bEliminaSheet.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				App.elimina_foglio(App.finestra.tabbed.getSelectedIndex());
			} 
		});
		
		toolbar.add(bNuovoSheet);
		toolbar.add(bEliminaSheet);
		toolbar.add(bApri);
		toolbar.add(bSalva);
		toolbar.add(bChiudi);
		toolbar.add(binfo);
		
		header.add(toolbar);
		
		// table
		tabbed = new JTabbedPane();
		aggiungi_foglio();
		
		panel.add(header);
		panel.add(tabbed);
		
		super.add(panel);	
		super.setVisible(true);
		super.setBounds(30, 30, 800, 600);
	}
	
	public void aggiungi_foglio() {
		JTable table = new Table(10, 10);
		tabbed.addTab("foglio " + (tabbed.getTabCount()+1), table);	
	}
	
	public void elimina_foglio(Integer index) {
		tabbed.remove(index);
	}
	
}
