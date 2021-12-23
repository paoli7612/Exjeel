package graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import App.App;
import core.Foglio;
import core.Pos;
import logging.Error;
import logging.Info;
import logging.Warn;

import java.awt.event.*;

public final class Window extends JFrame  {
	
	public static App app;
	
	private JPanel header;
	
	public JButton binfo;
	public JScrollPane scrollPane;
	public JTabbedPane tabbed;
	public JTextField tf;
		
	public Window(App app) {
		super("Exjeel");
		this.app = app;
		
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel();
		
		// close window
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				chiudi();
			}
		});
 
		// resize window
		super.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				try { resize(); } catch (Exception e) { /*new Warn(e.toString());*/ }
			}
		});
	
		// _____ panel.header _____
		header = new JPanel();
		tf = new JTextField(26);
		header.add(tf);
		// _____ _____
		
		// button.nuovo
		newButton("new-sheet", "Nuovo foglio").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.nuovo_foglio();
			} 
		});
		// button.elimina
		newButton("del-sheet", "Elimina foglio").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.elimina_foglio(app.finestra.tabbed.getSelectedIndex());
			} 
		});
		// button.apri
		newButton("load", "Apri").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JFileChooser choser = new JFileChooser();
				choser.showOpenDialog(null);
				try {
					app.carica(choser.getSelectedFile().getPath());					
				} catch (Exception e2) {
					new Error("Non ho caricato un file perchè non è stato selezionato");
				}
			} 
		});
		// button.salva
		newButton("save", "Salva").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.salva();
			} 
		});
		// button.chiudi
		newButton("exit", "Chiudi").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				chiudi();
			} 
		});
		// button.info
		binfo = newButton("info", "Info");
		binfo.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				new graphic.Info(app);
				JButton button = (JButton)e.getSource();
				button.setEnabled(false);
			} 
		});
			
		// _____ panel.tabbed _____
		tabbed = new JTabbedPane();
		aggiungi_foglio();
		scrollPane = new JScrollPane(tabbed);
		elimina_foglio(0);
		panel.add(header);
		panel.add(scrollPane);		
		super.add(panel);	
		// _____ _____
		
		super.setVisible(true);
		super.setBounds(30, 30, 1800, 600);
		
		
		if (app.file != null) {		
			// carica il file della applicazione
			for (int i=0; i<app.file.nFogli(); i++) {
				Foglio f = app.file.getFoglio(i);
				aggiungi_foglio(f);
			}		
		}
	}
	
	/**
	 * 
	 */
	public void resize() {
		Dimension d = app.finestra.getContentPane().getSize();
        Dimension dd = new Dimension(d.width-100, d.height/5*4);
		scrollPane.setPreferredSize(dd);
	}

	public void aggiungi_foglio() {
		Table table = new Table(app, App.COLONNE+1, App.RIGHE+1);
		tabbed.addTab("foglio " + app.file.nFogli(), table);	
	}
	
	public void aggiungi_foglio(Table table) {
		tabbed.addTab("foglio " + app.file.nFogli(), table);	
	}
		
	public void aggiungi_foglio(Foglio foglio) {
		Table table = new Table(app, App.COLONNE+1, App.RIGHE+1);
		for (int y=0; y<App.RIGHE; y++) {
			for (int x=0; x<App.COLONNE; x++) {
				if (foglio.leggiSopra(x, y) != null) {
					table.setValueAt(foglio.leggiSopra(x, y), y+1, x+1);	
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
			app.chiudi();
	}

	public void aggiorna(Pos pos, Integer index) {
		new Info("Window.aggiorna " + pos.coord());
		Table table = (Table)this.tabbed.getComponentAt(index);
		table.scrivi(pos, app.leggiSopra(pos));
	}
	
	public void aggiorna(Pos pos) {
		aggiorna(pos, app.file.getSelezionato());
	}

	public void clearTf() {
		this.tf.setText("");
		
	}
	
}
