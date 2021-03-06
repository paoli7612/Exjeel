package graphic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import App.App;
import App.GUIApp;
import core.Foglio;
import core.Pos;
import logging.Error;
import logging.Info;
import logging.Warn;

import java.awt.event.*;

public final class Finestra extends JFrame  {
	
	public GUIApp app;
	
	private JPanel header;
	
	public JButton binfo;
	public JScrollPane scrollPane;
	public JTabbedPane tabbed;
	public JTextField tf;
		
	public Finestra(GUIApp app) {
		super("Exjeel");
		this.app = app;
		
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		JPanel panel = new JPanel();

		super.setBounds(30, 30, 1820, 620);
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
		
			// textfield.tf
			tf = new JTextField(26);
			tf.addActionListener(new AbstractAction() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
		    		app.finestra.enter();
			    }
			});
			
			header.add(tf);
			// _____ _____
		
			// button.nuovo
			newButton("new-sheet", "Nuovo foglio").addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					app.newFoglio();
				} 
			});
			// button.elimina
			newButton("del-sheet", "Elimina foglio").addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					app.remFoglio();
				} 
			});
			// button.apri
			newButton("load", "Apri").addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					JFileChooser choser = new JFileChooser();
					choser.showOpenDialog(null);
					try {
						app.load(choser.getSelectedFile().getPath());					
					} catch (Exception e2) {
						new Error("Non ho caricato un file perch? non ? stato selezionato");
					}
				} 
			});
			// button.salva
			newButton("save", "Salva").addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					//app.salva();
				} 
			});
			// button.chiudi
			newButton("exit", "Chiudi").addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					app.quit();
				} 
			});
			// button.print
			binfo = newButton("print", "Print");
			binfo.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					app.print();
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
		scrollPane = new JScrollPane(tabbed);
		tabbed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				try {
					app.file.setSelezionato(app.finestra.tabbed.getSelectedIndex());
					//app.finestra.selezionaCella();
				} catch (Exception e2) {}
			}
		});
		
		// carica il file della applicazione
		for (int i=0; i<app.file.countFogli(); i++) {
			Foglio f = app.file.getFoglio(i);
			aggiungi_foglio(f);
		}
		
		
		panel.add(header);
		panel.add(scrollPane);		
		super.add(panel);	
		// _____ _____
		
		super.setVisible(true);
		
			
	}
	
	public void resize() {
		new Info("Resize");
		Dimension d = app.finestra.getContentPane().getSize();
        Dimension dd = new Dimension(d.width-100, d.height/5*4);
		scrollPane.setPreferredSize(dd);
	}
	
	public void aggiungi_foglio(JTable table) {
		new Info("Nuovo foglio");
		tabbed.addTab(app.file.nextNome(), table);	
	}
	
	public void aggiungi_foglio() {
		aggiungi_foglio(new Tabella(app));
	}

	public void aggiungi_foglio(Foglio foglio) {
		Tabella table = new Tabella(app);
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
		new Info("Rimuovi foglio");
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
			app.quit();
	}
	
	public void clearTf() {
		this.tf.setText("");
	}

	public void selezionaCella() {
		Tabella t = (Tabella) tabbed.getSelectedComponent();
		t.selezionaCella();
	}

	protected void enter() {
		new Info(tabbed.getTitleAt(tabbed.getSelectedIndex()));
		Tabella table = (Tabella) this.tabbed.getSelectedComponent();
		Pos p = table.getSelectedPos();
		app.write(p, tf.getText());
	}

	public void newFoglio() {
		tabbed.add(new Tabella(app), app.file.nextNome());
				
	}

	public void write(Pos pos, String v) {
		Tabella tabella = (Tabella) this.tabbed.getSelectedComponent();
		tabella.write(pos, v);
	}	

	
}
