package org.example.week3_csc311_lecdemo;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TextField num1 = new TextField();
        num1.setLayoutX(20);num1.setLayoutY(20);

        TextField num2 = new TextField();
        num2.setLayoutX(20);num2.setLayoutY(80);

        Button sumBtn = new Button(" SUM ");
        sumBtn.setLayoutX(20);sumBtn.setLayoutY(140);

        Label outputLbl = new Label();
        outputLbl.setLayoutX(100);outputLbl.setLayoutY(140);

        sumBtn.setOnAction(e->{outputLbl.setText(""+(
            Double.parseDouble(num1.getText())+  Double.parseDouble(num2.getText())
        ) );});

        MyGroup mg = new MyGroup();
        mg.setLayoutX(200);mg.setLayoutY(100);
        Transition t=new Transition() {
            {
                setCycleDuration(javafx.util.Duration.seconds(5));
            }
            @Override
            protected void interpolate(double v) {
                mg.setRotate(v*360);
            }
        };
        t.play();

        Scene scene = new Scene(new Group(mg,num1,num2,outputLbl,sumBtn), 450, 300);
        stage.setTitle("CSC311 !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

class MyGroup extends Group{

    public MyGroup(){

        Circle c1 = new Circle(100,100, 60);
        c1.setFill(Color.RED);c1.setStroke(Color.BLACK);c1.setStrokeWidth(3);

        Circle c2 = new Circle(100,60, 30);
        c2.setFill(Color.YELLOW);c2.setStroke(Color.BLACK);c2.setStrokeWidth(3);

        c1.setOnMousePressed(e->{
            c1.setFill(Color.YELLOW);c1.setStroke(Color.BLACK);c1.setStrokeWidth(3);
            c1.setEffect(new DropShadow(3,2,2,Color.BLUE));

        });
        c1.setOnMouseReleased(e->{
            c1.setFill(Color.RED);c1.setStroke(Color.BLACK);c1.setStrokeWidth(3);
            c1.setEffect(null);

        });
        getChildren().addAll(c1,c2);

    }
}