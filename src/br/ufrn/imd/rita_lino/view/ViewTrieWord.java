package br.ufrn.imd.rita_lino.view;

import br.ufrn.imd.rita_lino.tree.TrieTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewTrieWord extends JFrame {
    TrieTree tree;
    JLabel saida = new JLabel();
    JTextField entrada = new JTextField();
    String prefix = "";

    public ViewTrieWord(TrieTree tree){
        this.tree = tree;
        this.setSize(500,500);
        this.setTitle("TRIEWORD");


        KeyListener keyListener = new KeyListener() {
            public void keyReleased(KeyEvent keyEvent) {
                prefix = entrada.getText();
                if (prefix.length()>0){
                    saida.setText("<html><br/>");
                    for (String s : tree.suggestWord(prefix)) {
                        saida.setText(saida.getText() + "<br/>" + s);
                    }
                    saida.setText(saida.getText() + "</html>");
                }else {
                    saida.setText(" ");
                }

            }

            public void keyTyped(KeyEvent keyEvent) {
            }

            public void keyPressed(KeyEvent keyEvent) {
            }

        };

        JPanel panel = new JPanel();
        panel.setSize(500, 400);
        panel.setBackground(Color.ORANGE);
        panel.setLayout(new GridLayout(4,1));
        entrada.setColumns(20);
        entrada.setSize(500, 10);
        entrada.setVisible(true);

        entrada.addKeyListener(keyListener);

        panel.add(entrada, 0);
        saida.setLocation( 5,100);
        panel.add(saida, 1);

        this.add(panel);

        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

