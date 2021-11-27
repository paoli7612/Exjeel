package graphic;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import App.App;

public class Info extends JFrame {

	public Info() {

		super("Info");

		JPanel panel = new JPanel();

		JLabel titolo = new JLabel("Exjeel");
		JLabel descrizione = new JLabel("Clone minimale di un editor per fogli elettronici");
		JLabel creatore = new JLabel("Tommaso Paoli 280873");

		titolo.setFont(new Font("Verdana", Font.PLAIN, 24));
		descrizione.setFont(new Font("Verdana", Font.PLAIN, 18));
		creatore.setFont(new Font("Verdana", Font.PLAIN, 22));
		
		panel.add(titolo);
		panel.add(descrizione);
		panel.add(creatore);
			
		super.add(panel);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		 this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		    	  App.finestra.binfo.setEnabled(true);
		      }
	    });
		
		super.setVisible(true);
		super.setResizable(false);
		super.setBounds(400, 400, 450, 150);
	}
	
}
