/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W.Quan
 */

import java.io.File;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javax.management.Notification;

public class main extends Application{

    Boolean selected = false;
    String getpath = "";
    String getname = "";
    int getwidth, getheight = 0;

    @Override
    public void start(Stage stage) throws IOException {
        HBox LhBox1 = new HBox(10);
        HBox LhBox2 = new HBox(10);

        VBox vbox = new VBox();

        VBox vbox01 = new VBox(18);
        VBox vbox02 = new VBox(23);
        VBox vbox03 = new VBox(18);

        HBox hbox01 = new HBox(18);
        HBox hbox02 = new HBox(18);
        HBox hbox03 = new HBox(18);
        HBox hbox04 = new HBox(18);

        VBox vbox11 = new VBox(15);
        VBox vbox12 = new VBox(15);
        VBox vbox13 = new VBox(15);
        VBox vbox14 = new VBox(15);

        vbox.setStyle("-fx-background-color: white;");
        vbox01.setStyle("-fx-background-color: #008080;");
        hbox01.setStyle("-fx-background-color: #008080;");
        hbox02.setStyle("-fx-background-color: #008080;");
        hbox03.setStyle("-fx-background-color: #008080;");
        hbox04.setStyle("-fx-background-color: #008080;");
        vbox03.setStyle("-fx-background-color: #008080;");

        vbox01.setPadding(new Insets(15));
        vbox02.setPadding(new Insets(25));
        hbox01.setPadding(new Insets(15));
        hbox02.setPadding(new Insets(15));
        hbox03.setPadding(new Insets(15));
        hbox04.setPadding(new Insets(15));
        vbox03.setPadding(new Insets(15));

        vbox01.setAlignment(Pos.CENTER);
        vbox03.setAlignment(Pos.CENTER);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("RAW Image", "*.raw"));
        fileChooser.setTitle("Upload File Path");

        Label lbone = new Label("Step 1:");
        Label lbtwo = new Label("Step 2:");
        Label lbthree = new Label("Step 3:");
        Label lbfour = new Label("Step 4:");

        lbone.setFont(new Font("Verdana", 30));
        lbone.setTextFill(Color.web("black"));
        lbone.setStyle("-fx-background-color: yellow;");
        lbone.setPadding(new Insets(10));
        lbtwo.setFont(new Font("Verdana", 30));
        lbtwo.setTextFill(Color.web("black"));
        lbtwo.setStyle("-fx-background-color: yellow;");
        lbtwo.setPadding(new Insets(10));
        lbthree.setFont(new Font("Verdana", 30));
        lbthree.setTextFill(Color.web("black"));
        lbthree.setStyle("-fx-background-color: yellow;");
        lbthree.setPadding(new Insets(10));
        lbfour.setFont(new Font("Verdana", 30));
        lbfour.setTextFill(Color.web("black"));
        lbfour.setStyle("-fx-background-color: yellow;");
        lbfour.setPadding(new Insets(10));

        Label IP = new Label("Image Converting App");
        IP.setFont(new Font("Verdana", 55));
        IP.setTextFill(Color.web("white"));

        Label lbchoose = new Label("Please CHOOSE a RAW. image");
        lbchoose.setFont(new Font("Verdana", 28));
        lbchoose.setTextFill(Color.web("white"));

        Label lbconvert = new Label("RAW file convert to:");
        lbconvert.setFont(new Font("Verdana", 28));
        lbconvert.setTextFill(Color.web("white"));

        Label lbname = new Label("Name :" + getname);
        lbname.setFont(new Font("Verdana", 28));
        lbname.setTextFill(Color.web("white"));

        Label lbpath = new Label("Path :" + getpath);
        lbpath.setFont(new Font("Verdana", 28));
        lbpath.setTextFill(Color.web("white"));

        Label lbwidth = new Label("Width :");
        lbwidth.setFont(new Font("Verdana", 28));
        lbwidth.setTextFill(Color.web("white"));

        Label lbheight = new Label("Height:");
        lbheight.setFont(new Font("Agency FB", 28));
        lbheight.setTextFill(Color.web("white"));

        TextField tf_width = new TextField();
        TextField tf_height = new TextField();

        tf_width.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_width.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        tf_height.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_height.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        ComboBox cb = new ComboBox();
        cb.getItems().addAll(
                "1.Convolution",
                "2.Dithering",
                "3.High pass",
                "4.Lower pass",
                "5.Patterning"
        );

        cb.setValue("Select");

        Button select = new Button("RAW. image");
        Button generate = new Button("Generate");
        convolution convolution = new convolution();
        patterning patterning = new patterning();
        high_lowPass high_lowPass = new high_lowPass();
        dithering dithering = new dithering();
        generate.setDisable(true);

        generate.setFont(new Font("Verdana", 30));
        generate.setTextFill(Color.web("white"));
        generate.setStyle("-fx-background-color: #008080;");
        generate.setPadding(new Insets(15));

        Label label = new Label("Successfully");
        Popup popup = new Popup();
        label.setStyle(" -fx-background-color: white;");
        popup.getContent().add(label);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (!popup.isShowing()) {
                    popup.show(stage);
                } else {
                    popup.hide();
                }
            }
        };

        select.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                getpath = selectedFile.getPath();
                getname = selectedFile.getName();
                System.out.println(getpath);
                System.out.println(getname);
                lbname.setText("Name :" + getname);
                lbpath.setText("Path :" + getpath);

                selected = true;
            }
            if (selected == false) {
                generate.setDisable(true);
            } else {
                generate.setDisable(false);
            }
        });

        generate.setOnAction(e1 -> {
            Stage lineStage = new Stage();
            VBox hb = new VBox(30);
            Label lb = new Label("Successfully Converted!");
            lb.setFont(new Font("Verdana", 20));
            lb.setTextFill(Color.web("black"));
            
            Label lb1 = new Label("Please check your new converted file. ");
            lb1.setFont(new Font("Verdana", 20));
            lb1.setTextFill(Color.web("black"));
            
            hb.setAlignment(Pos.CENTER);
            hb.getChildren().addAll(lb,lb1);

            if (tf_width.equals("") || tf_width.equals("0") || tf_height.equals("") || tf_height.equals("0")) {
                System.out.println("Invalid width or height! Please key in again.");
            } else {
                getwidth = Integer.parseInt(tf_width.getText());
                getheight = Integer.parseInt(tf_height.getText());
                try {
                    String method = cb.getValue().toString();
                    switch (method) {
                        case "Convolution":
                            convolution.convolutionF(getname, getpath, getwidth, getheight);
                            break;
                        case "Dithering":
                            dithering.ditheringF(getname, getpath, getwidth, getheight);
                            break;
                        case "High Low pass":
                            high_lowPass.high_lowPassF(getname, getpath);
                            break;
                        case "Patterning":
                            patterning.patterningF(getname, getpath);
                            break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Scene lineScene = new Scene(hb, 500, 300);
            lineStage.setScene(lineScene);
            lineStage.setTitle("Convertation Status!!!");
            lineStage.show();

        });
        

        LhBox1.getChildren().add(lbwidth);
        LhBox1.getChildren().add(tf_width);
        LhBox2.getChildren().add(lbheight);
        LhBox2.getChildren().add(tf_height);

        vbox11.getChildren().addAll(lbchoose, select);
        vbox13.getChildren().addAll(LhBox1, LhBox2);
        vbox12.getChildren().addAll(lbname, lbpath);
        vbox14.getChildren().addAll(lbconvert, cb);

        vbox01.getChildren().addAll(IP);
        hbox01.getChildren().addAll(lbone, vbox11);
        hbox02.getChildren().addAll(lbtwo, vbox12);
        hbox03.getChildren().addAll(lbthree, vbox13);
        hbox04.getChildren().addAll(lbfour, vbox14);

        vbox02.getChildren().addAll(hbox01, hbox02, hbox03, hbox04);
        vbox03.getChildren().add(generate);
        vbox.getChildren().addAll(vbox01, vbox02, vbox03);

        Scene scene = new Scene(vbox, 800, 830);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
