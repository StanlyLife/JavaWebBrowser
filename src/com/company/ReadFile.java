package com.company;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReadFile extends JFrame {

    private JTextField adressBar;
    private JEditorPane display;

    public ReadFile(){
        super("My Java Browser");
        adressBar = new JTextField("https://www.youtube.com");

        adressBar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent actionEvent){
                        loadWebsite(actionEvent.getActionCommand());
                    }
                }
        );
        add(adressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
                        if(hyperlinkEvent.getEventType() ==  HyperlinkEvent.EventType.ACTIVATED){
                            loadWebsite(hyperlinkEvent.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(), BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);
    }

    private void loadWebsite(String urlInput){
        System.out.println("Started loading");
        try{
            display.setPage(urlInput);
            System.out.println("displaying");
        }catch (IOException e) {
            display.setContentType("text/html");
            display.setText("<html>Could not load</html>");
            System.out.println("Unknown protocol, not loading");
        }
    }
}
