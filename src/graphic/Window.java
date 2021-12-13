package graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.App;
import core.Cella;
import core.Foglio;
import core.Pos;
import logging.Critical;
import logging.Error;
import logging.Info;

public final class Window extends JFrame  {
	
	public static App app;
	
	private JPanel header;
	
	public JButton binfo;
	public JTabbedPane tabbed;
		
	public Window(App app) {
		super("Exjeel");
		this.app = app;
		
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel();
		
		 this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		    	  chiudi();
		      }
  		});
	
		// header
		header = new JPanel();
		
		newButton("new-sheet", "Nuovo foglio").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.nuovo_foglio();
			} 
		});
		newButton("del-sheet", "Elimina foglio").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.elimina_foglio(app.finestra.tabbed.getSelectedIndex());
			} 
		});
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
		newButton("save", "Salva").addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				app.salva();
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
				new graphic.Info(app);
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
		
		new Critical(app.file.nFogli() + " nfogli");
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
		for (int y=0; y<App.RIGHE; y++){
			for (int x=0; x<App.COLONNE; x++){
				Cella c = foglio.getCella(x, y);
				table.setValueAt(c.getValue(), y+1, x+1);
				
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
		table.scrivi(pos, app.leggi(pos));
	}
	
	public void aggiorna(Pos pos) {
		aggiorna(pos, app.file.getSelezionato());
	}
}
