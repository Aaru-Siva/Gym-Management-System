package GymManagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Table extends Application {
    private TableView tableVi = new TableView();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Gym Management System");

        final Label lb = new Label("Member List");

        tableVi.setEditable(false);

        //table columns

        TableColumn<Integer, DefaultMember> column1 = new TableColumn<>("MemberId");
        column1.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));
        column1.setPrefWidth(100);


        TableColumn<String, DefaultMember> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setPrefWidth(200);

        TableColumn<String, DefaultMember> column3 = new TableColumn<>("Started date");
        column3.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));
        column3.setPrefWidth(150);


        TableColumn<String, DefaultMember> column4 = new TableColumn<>("Contact");
        column4.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        column4.setPrefWidth(150);

        TableColumn<String, StudentMember> column5 = new TableColumn<>("School");
        column5.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        column5.setPrefWidth(150);

        TableColumn<Integer, Over60Member> column6 = new TableColumn<>("Age");
        column6.setCellValueFactory(new PropertyValueFactory<>("age"));
        column6.setPrefWidth(100);

        TableColumn <String, Over60Member>column7 = new TableColumn<>("memberType");
        column7.setCellValueFactory(new PropertyValueFactory<>("memberType"));
        column7.setPrefWidth(100);

        tableVi.getColumns().add(column1);
        tableVi.getColumns().add(column2);
        tableVi.getColumns().add(column3);
        tableVi.getColumns().add(column4);
        tableVi.getColumns().add(column5);
        tableVi.getColumns().add(column6);
        tableVi.getColumns().add(column7);


        File file = new File("saveForSearch.txt");      //file which is having member details
        try {
            Scanner scanner = new Scanner(file);

            DefaultMember member = null;

            //reading data from file
            while (scanner.hasNext()){
                int memberId = scanner.nextInt();
                String name = scanner.next();
                String date = scanner.next();
                String contact = scanner.next();
                String school = scanner.next();
                int memberAge = scanner.nextInt();
                String memberType = scanner.next();


                //inserting data into the table
                if (memberType.equals("student")){
                    tableVi.getItems().add(new StudentMember(memberId, name, date, contact, memberType,school));

                } else if (memberType.equals("over60")) {
                    tableVi.getItems().add(new Over60Member(memberId, name, date, contact,memberType, memberAge));
                }else {
                    tableVi.getItems().add(new DefaultMember(memberId, name, date, contact,memberType));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HBox hBox = new HBox();

        TextField textFieldSearch = new TextField();
        textFieldSearch.setPromptText("Enter member id / name");
        textFieldSearch.setPrefSize(500, 30);
        textFieldSearch.setStyle("-fx-font-size: 18px;");

        Button btnSearch = new Button("Search");
        btnSearch.setPrefHeight(30);
        btnSearch.setStyle("-fx-font-size: 18px;");
        btnSearch.setDefaultButton(true);

        Label lblResult = new Label("Result");
        lblResult.setStyle("-fx-font-size: 18px;");

        textFieldSearch.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnSearch.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        String searchValue = textFieldSearch.getText();
                        MyGymManager manager = new MyGymManager();
                        manager.search(searchValue, lblResult);
                    }
                });
            }
        });

        /*hBox - lays out its children in a single horizontal row from left to right
        * vBox - lays out its children in a single vertical column from top to bottom.*/

        hBox.getChildren().addAll(textFieldSearch,btnSearch);

        tableVi.setPrefSize(1000, 500);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(lb,tableVi,hBox,lblResult);

        ((Group)scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
        stage.setWidth(1200);
        stage.setHeight(700);
    }
}
