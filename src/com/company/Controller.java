package com.company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private String hyperlinkTextProtocol = "http://";

    @FXML
    TextField adressBar;

    String adressLink;

    @FXML
    WebView web;

    WebEngine engine;

    public void go(ActionEvent actionEvent){
        adressLink = adressBar.getText().toString();
        engine.load(hyperlinkTextProtocol + adressLink);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(hyperlinkTextProtocol+"www.google.com");
    }
}
