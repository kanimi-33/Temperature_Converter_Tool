package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));

        VBox rootNode = loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Temperature Converter Tool");


        primaryStage.show();

    }

    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File") ;
        MenuItem newMenuItem=new MenuItem("New");

        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem =new SeparatorMenuItem();

        MenuItem quitMenuItem=new MenuItem("quit");

        quitMenuItem.setOnAction(event ->{
            System.exit(0);
        } );

        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem,quitMenuItem);



        Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");

        aboutApp.setOnAction(actionEvent -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog =new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("my first desktop app");
        alertDialog.setHeaderText("learning javafx");
        alertDialog.setContentText("I am learning javafx from beginner level to advanced level");

        ButtonType yesbtn =new ButtonType("yes");
        ButtonType nobtn = new ButtonType("no");

        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

        Optional<ButtonType> clickedbtn= alertDialog.showAndWait();

        if(clickedbtn.isPresent() && clickedbtn.get()==yesbtn){
            System.out.println("yes is click");
        }else{
            System.out.println("no is click");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
