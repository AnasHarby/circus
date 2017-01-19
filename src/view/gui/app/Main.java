package view.gui.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static final String MAINMENU = "/view/gui/mainmenu/MainMenuFxml.fxml";
	public static final String GAMEVIEW = "/view/gui/gameplay/GameViewFxml.fxml";

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        final Pane root = FXMLLoader.load(getClass().getResource(MAINMENU));
    	//root.getStylesheets().add(this.getClass().getResource("/view/gui/gameplay/GameViewStyle.css").toExternalForm());
        primaryStage.setTitle("Circus");
        primaryStage.setScene(new Scene(root, 1280, 1024));
        root.prefWidthProperty().bind(primaryStage.getScene().widthProperty());
        root.prefHeightProperty().bind(primaryStage.getScene().heightProperty());
        primaryStage.show();
        root.requestFocus();
        root.toFront();
    }

 	public static final void main(final String[] args) {
        launch(args);
    }
}
