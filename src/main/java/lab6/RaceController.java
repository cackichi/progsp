package lab6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class RaceController extends Application {

    @FXML
    private Pane trackPane;

    private CircleTrack athlete1, athlete2, athlete3;
    private Thread athleteThread1, athleteThread2, athleteThread3;

    @FXML
    private Button startButton,stopButton;
    private boolean running = false;

    private static final double RADIUS_LARGE = 200;
    private static final double RADIUS_MEDIUM = 150;
    private static final double RADIUS_SMALL = 100;
    protected static final double START_ANGLE = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab6/race.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Беговые дорожки");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            stopRace();
            Platform.exit();
            System.exit(0);
        });
    }

    @FXML
    public void initialize() {
        Circle outerTrack = new Circle(300, 300, RADIUS_LARGE, null);
        outerTrack.setStroke(Color.GRAY);

        Circle middleTrack = new Circle(300, 300, RADIUS_MEDIUM, null);
        middleTrack.setStroke(Color.GRAY);

        Circle innerTrack = new Circle(300, 300, RADIUS_SMALL, null);
        innerTrack.setStroke(Color.GRAY);

        trackPane.getChildren().addAll(outerTrack, middleTrack, innerTrack);

        athlete1 = new CircleTrack(new Rectangle(20, 20, Color.RED), RADIUS_LARGE);
        athlete2 = new CircleTrack(new Rectangle(20, 20, Color.BLUE), RADIUS_MEDIUM);
        athlete3 = new CircleTrack(new Rectangle(20, 20, Color.GREEN), RADIUS_SMALL);

        trackPane.getChildren().addAll(athlete1.getShape(), athlete2.getShape(), athlete3.getShape());
    }

    @FXML
    private void startRace() {
        if (!running) {
            running = true;

            athleteThread1 = new Thread(() -> runAthlete(athlete1));
            athleteThread2 = new Thread(() -> runAthlete(athlete2));
            athleteThread3 = new Thread(() -> runAthlete(athlete3));

            athleteThread1.start();
            athleteThread2.start();
            athleteThread3.start();
        }
    }

    @FXML
    private void stopRace() {
        running = false;
        if (athleteThread1 != null) athleteThread1.interrupt();
        if (athleteThread2 != null) athleteThread2.interrupt();
        if (athleteThread3 != null) athleteThread3.interrupt();
    }

    private void runAthlete(CircleTrack athlete) {
        Random random = new Random();
        while (running) {
            Platform.runLater(athlete::updatePosition);
            try {
                Thread.sleep(50 + random.nextInt(50));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
