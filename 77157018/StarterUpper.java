/*In order to help learn course concepts, I worked on the homework with[-],
 discussed homework topics and issues with [-],
and/or consulted related material that can be found at
Oracle documentation on JavaFX
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Alert.AlertType;
import java.io.File;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;
import javafx.application.Application;
import java.util.Optional;

/**
 * This represents a JavaFX class
 * @author Surabhi R. Shetty
 * @version 1.0
 */
public class StarterUpper extends Application {
    private ArrayList<StartUpIdea> idealist = new ArrayList<>();
    private ListView<StartUpIdea> listView = new ListView<>();

    // will linkedlist work with add

    /** adds audio whenever a button is clicked
     * @param file audio file
     * @param volume volume of audio
     * @param cycle how many times the audio is repeated
     */

    public static void audio(File file, double volume, int cycle) {
        AudioClip clip = new AudioClip(file.toURI().toString());
        clip.setVolume(volume);
        clip.setCycleCount(cycle);
        clip.play();
    }

    /** main method
    *@param args string array
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        Scene scene = new Scene(new Group());
        stage.setTitle("Problem Ideation Form");

        TextField tf1 = new TextField();
        String prob = tf1.getText();

        TextField tf2 = new TextField();
        String targetcust = tf2.getText();
        TextField tf3 = new TextField();

        TextField tf4 = new TextField();

        TextField tf5 = new TextField();

        TextField tf6 = new TextField();
        String competition = tf6.getText();

        TextField tf7 = new TextField();
        String keyf = tf7.getText();

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("What is the problem?"), 0, 0);
        grid.add(tf1, 1, 0);
        grid.add(new Label("Who is the target customer?"), 0, 1);
        grid.add(tf2, 1, 1);
        grid.add(new Label("How badly does the customer NEED this problem fixed (1-10)?"), 0, 2);
        grid.add(tf3, 1, 2);
        grid.add(new Label("How many people do you know who might experience this problem?"), 0, 3);
        grid.add(tf4, 1, 3);
        grid.add(new Label("How big is the target market?"), 0, 4);
        grid.add(tf5, 1, 4);
        grid.add(new Label("Who are the competitors/existing solutions?"), 0, 5);
        grid.add(tf6, 1, 5);
        grid.add(new Label("What is the key feature of your idea?"), 0, 6);
        grid.add(tf7, 1, 6);

        // add more questions for ec

        Group root = (Group) scene.getRoot();

        Button btn = new Button();
        btn.setText("ADD IDEA TO LIST");

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert");

        btn.setOnAction(event -> {
                File myf = new File("btnpush.mp3");
                audio(myf, 7, 1);

                int needrating;
                int pplwithprob = 0;
                int targetmar = 0;

                if (tf1.getText().trim().isEmpty()) {
                    alert.setContentText("The problem field is empty");
                    alert.showAndWait();
                    return;
                }

                if (tf2.getText().trim().isEmpty()) {
                    alert.setContentText("The target customer field is empty");
                    alert.showAndWait();

                    return;
                }

                if (tf3.getText().trim().isEmpty()) {
                    alert.setContentText("A field is empty");
                    alert.showAndWait();

                    return;
                }

                if (tf4.getText().trim().isEmpty()) {
                    alert.setContentText("The number of people experiencing this problem field is empty");
                    alert.showAndWait();

                    return;
                }

                if (tf5.getText().trim().isEmpty()) {
                    alert.setContentText("The size of target market field is empty");
                    alert.showAndWait();

                    return;
                }

                if (tf6.getText().trim().isEmpty()) {
                    alert.setContentText("The competitors/existing solutions field is empty");
                    alert.showAndWait();

                    return;
                }

                if (tf7.getText().trim().isEmpty()) {
                    alert.setContentText("The key features field is empty");
                    alert.showAndWait();

                    return;
                }

                try {
                    int intproblem = Integer.parseInt(tf1.getText());
                    alert.setContentText("The input in the first text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    double doubleproblem = Double.parseDouble(tf1.getText());
                    alert.setContentText("The input in the first text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    int inttargetcustomer = Integer.parseInt(tf2.getText());
                    alert.setContentText("The input in the second text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    double doubletargetcustomer = Double.parseDouble(tf2.getText());
                    alert.setContentText("The input in the second text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    needrating = Integer.parseInt(tf3.getText());
                } catch (Exception e) {
                    alert.setContentText("The input must be an integer");
                    alert.showAndWait();
                    return;
                }

                try {
                    pplwithprob = Integer.parseInt(tf4.getText());
                } catch (Exception e) {
                    alert.setContentText("The number of people who might experience this\n"
                            + "problem must be an integer");
                    alert.showAndWait();
                    return;
                }

                try {
                    targetmar = Integer.parseInt(tf5.getText());
                } catch (Exception e) {
                    alert.setContentText("The size of the target market must be an integer");
                    alert.showAndWait();
                    return;
                }

                try {
                    int intcomp = Integer.parseInt(tf6.getText());
                    alert.setContentText("The input in the sixth text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    double doublecomp = Double.parseDouble(tf6.getText());
                    alert.setContentText("The input in the sixth text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    int intkf = Integer.parseInt(tf7.getText());
                    alert.setContentText("The input in the key feature text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                try {
                    double doublekf = Double.parseDouble(tf7.getText());
                    alert.setContentText("The input in the key feature text field must be a String");
                    alert.showAndWait();
                    return;
                } catch (Exception e) {
                    int a = 0;
                }

                if (needrating <= 0) {
                    alert.setContentText("The input in the third text field must be an integer between 1 and 10");
                    alert.showAndWait();
                    return;
                }

                if (needrating > 10) {
                    alert.setContentText("The input in the third text field must be an integer between 1 and 10");
                    alert.showAndWait();
                    return;
                }

                if (pplwithprob < 0) {
                    alert.setContentText("The number of people experiencing the problem must be a positive integer");
                    alert.showAndWait();
                    return;
                }

                if (targetmar < 0) {
                    alert.setContentText("The size of the target market must be a positive integer");
                    alert.showAndWait();
                    return;
                }
                StartUpIdea newIdea = new StartUpIdea(tf1.getText(), tf2.getText(), needrating, pplwithprob, targetmar,
                        tf6.getText(), tf7.getText());
                idealist.add(newIdea);
                listView.getItems().add(newIdea);

                tf1.clear();
                tf2.clear();
                tf3.clear();
                tf4.clear();
                tf5.clear();
                tf6.clear();
                tf7.clear();
            });

        Button btn3 = new Button();
        btn3.setText("ADD IDEAS TO FILE");

        btn3.setOnAction(event -> {
                File myf = new File("btnpush.mp3");
                audio(myf, 7, 1);
                File file = new File("Ideas.txt");
                FileUtil a = new FileUtil();
                a.saveIdeasToFile(idealist, file);
                listView.getItems().clear();

            });

        Button btn2 = new Button();
        btn2.setText("SORT IDEAS");

        EventHandler<ActionEvent> handler = new EventHandler<>() {
            public void handle(ActionEvent event) {
                File myf = new File("btnpush.mp3");
                audio(myf, 7, 1);
                Collections.sort(idealist);
            }
        };
        btn2.setOnAction(handler);

        Button btn4 = new Button();
        btn4.setText("RESET FORM");

        btn4.setOnAction(event -> {
                File myf = new File("btnpush.mp3");
                audio(myf, 7, 1);
                Alert alert2 = new Alert(AlertType.WARNING);
                alert2.setTitle("RESET FORM");
                alert2.setContentText("Press OK if you are sure about resetting everything");
                Optional<ButtonType> reply = alert2.showAndWait();

                if (reply.isPresent() && reply.get() == ButtonType.OK) {
                    File myObj = new File("Ideas.txt");
                    if (myObj.exists()) {
                        myObj.delete();
                    }

                    idealist.clear();
                    listView.getItems().clear();
                    tf1.clear();
                    tf2.clear();
                    tf3.clear();
                    tf4.clear();
                    tf5.clear();
                    tf6.clear();
                    tf7.clear();
                } else {
                    return;
                }

            });

        Button btn5 = new Button();
        btn5.setText("REMOVE SELECTED IDEA");

        EventHandler<ActionEvent> handlertoremove = new EventHandler<>() {
            public void handle(ActionEvent event) {
                final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    StartUpIdea itemToRemove = listView.getSelectionModel().getSelectedItem();

                    final int newSelectedIdx = (selectedIdx == listView.getItems().size() - 1) ? selectedIdx - 1
                            : selectedIdx;

                    listView.getItems().remove(selectedIdx);
                    idealist.remove(selectedIdx);
                    listView.getSelectionModel().select(newSelectedIdx);
                }
            }
        };
        btn5.setOnAction(handlertoremove);

        HBox hbox = new HBox(89);

        hbox.getChildren().add(btn);
        hbox.getChildren().add(btn2);
        hbox.getChildren().add(btn3);
        hbox.getChildren().add(btn4);

        grid.add(hbox, 1, 10);

        Image image = new Image(new FileInputStream("bulb.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);

        imageView.setPreserveRatio(true);

        grid.add(imageView, 0, 11);

        HBox hbox2 = new HBox(listView);
        hbox2.setPrefHeight(300);
        listView.setPrefWidth(800);

        hbox2.getStyleClass().add("hbox");
        hbox2.setId("hbox-custom");
        grid.add(hbox2, 1, 11);
        HBox hbox3 = new HBox(btn5);
        btn5.setAlignment(Pos.CENTER);
        grid.add(hbox3, 1, 12);
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(2);
        grid.setHgap(2);

        root.getChildren().add(grid);

        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}