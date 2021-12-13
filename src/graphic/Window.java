package graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.print.attribute.standard.SheetCollate;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardResizeToggleHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import App.App;
import core.Foglio;
import core.Pos;
import logging.Error;
import logging.Info;

import java.awt.event.*;

public final class Window extends JFrame  {
	
	public static App app;
	
	private JPanel header;
	
	public JButton binfo;
	public JScrollPane scrollPane;
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
		 
		 super.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent componentEvent) {
		    	try {
		    		resize();					
				} catch (Exception e) {

				}
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
		aggiungi_foglio();
		scrollPane = new JScrollPane(tabbed);
		elimina_foglio(0);

		header.setPreferredSize(new DimensionUIResource(90000, 60));
		panel.add(header);
		panel.add(scrollPane, BorderLayout.CENTER);		
		super.add(panel);	
		
		super.setVisible(true);
		super.setBounds(30, 30, 1800, 600);
		
		for (int i=0; i<app.file.nFogli(); i++) {
			Foglio f = app.file.getFoglio(i);
			aggiungi_foglio(f);
		}
		
		
	}
	
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
		for (int y=0; y<App.RIGHE; y++){
			for (int x=0; x<App.COLONNE; x++){
				table.setValueAt(foglio.getValue(x, y), y+1, x+1);	
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
