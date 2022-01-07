package graphic;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableCellRenderer;

import App.App;
import App.GUIApp;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.Pos;
import logging.Info;
import java.awt.event.MouseEvent;

public class Tabella extends JTable {

    private GUIApp app;

    public Tabella(GUIApp app) {

        super(app.COLONNE+1, app.RIGHE+1);
        this.app = app;
        this.setRowHeight(25);

        // Allineamento celle centrato
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < App.COLONNE + 1; i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(r);
        }

        // imposta NUMERI
        for (int i = 1; i < this.getRowCount(); i++) {
            this.setValueAt(i, i, 0);
        }

        // imposta LETTERE
        for (int i = 1; i < this.getColumnCount(); i++) {
            this.setValueAt(Character.toString((char) 64 + i), 0, i);
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
                    // app.scrivi(pos, s);
                }
            }
        });

        super.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                app.finestra.selezionaCella();
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseDragged(MouseEvent e) {}
            @Override
            public void mouseMoved(MouseEvent e) {}
        });
    }

    public void scrivi(Integer x, Integer y, String value) {
        setValueAt(value, y, x);
    }

    public void scrivi(Pos pos, String s) {
        scrivi(pos.getX() + 1, pos.getY() + 1, s);
    }

    public String leggi(Pos pos) {
        return (String) getValueAt(pos.getY(), pos.getX());
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return row != 0 && column != 0;
    }

    Pos getSelectedPos() {
        return new Pos(getSelectedColumn() - 1, getSelectedRow() - 1);
    }

	public void selezionaCella() {
		Pos p = getSelectedPos();
        if (p.intestazione()) {
            app.finestra.clearTf();
        } else {
            //app.finestra.tf.setText(app.leggiSotto(p));
        }

		app.finestra.tf.grabFocus();	
	}
	
}
