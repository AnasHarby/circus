package view.gui.mainmenu;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import plugins.PluginLoader;
import view.gui.app.Main;
import view.gui.app.util.ControlledScenes;
import view.gui.app.util.ScenesNavigator;
import view.gui.levelsdialog.LevelsDialogViewHelper;
import view.gui.mainmenu.util.GameData;
import view.gui.options.OptionsDialogViewHelper;

public class MainMenuController implements Initializable, ControlledScenes {

    @FXML
    private Pane root;

    @FXML
    private Text title;

    @FXML
    private Pane levelsPane;

    @FXML
    private Text LevelsDialogTitle;

    @FXML
    private Pane optionsPane;

    @FXML
    private Text optionsDialogTitle;


    private ScenesNavigator sceneNavigator;
    private FileChooser fileChooser;

    private static final String EASY_LEVEL = "EASY";
    private static final String MEDIUM_LEVEL = "MEDIUM";
    private static final String HARD_LEVEL = "HARD";
    private static final String CHARACTER = "CHARACTER";
    private static final String SHAPE = "SHAPE";

    private GameData gameData;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
            root.setFocusTraversable(true);
            MainMenuViewHelper.getInstance().
            configureTheMainMenu(root, title);
            fileChooser = new FileChooser();
            LevelsDialogViewHelper.
            getInstance().configureTheLevelsDialog(this.levelsPane,
            		this.LevelsDialogTitle);
            OptionsDialogViewHelper.getInstance().
                    configureTheLevelsDialog(this.optionsPane, this.optionsDialogTitle);
            setVisibilityBindingLevelsDialogAndOptionsDialog();
            gameData = new GameData();
            configureNewGameButton();
            configureOptionsButton();
            configureExitButton();
            configureCloseButton();
            configureEasyLevelButton();
            configureMediumLevelButton();
            configureHardLevelButton();
            configureAddCharacterAndShapeButtons();
    }

    @Override
    public void setScreenParent(final ScenesNavigator screenParent) {
    	this.sceneNavigator = screenParent;
    }

    private void setVisibilityBindingLevelsDialogAndOptionsDialog() {
        levelsPane.managedProperty().bind(levelsPane.visibleProperty());
        levelsPane.setVisible(false);
        optionsPane.managedProperty().bind(optionsPane.visibleProperty());
        optionsPane.setVisible(false);

    }



    private void configureNewGameButton() {
        MainMenuViewHelper.getInstance().getNewGameButton().setOnMouseClicked(event -> {
            this.root.lookup("#mainMenu").setDisable(true);
            this.levelsPane.setVisible(true);
            this.levelsPane.toFront();
            this.levelsPane.requestFocus();
        });
    }

    private void configureLoadGameButton() {

    }



    private void configureExitButton() {
        MainMenuViewHelper.getInstance().getExitButton().setOnMouseClicked(event -> System.exit(0));
    }

    private void configureOptionsButton() {
         MainMenuViewHelper.getInstance().getOptionsButton().setOnMouseClicked(event -> {
             this.root.lookup("#mainMenu").setDisable(true);
             this.optionsPane.setVisible(true);
             this.optionsPane.toFront();
             this.optionsPane.requestFocus();
         });
    }

    private void configureAddCharacterAndShapeButtons() {
        OptionsDialogViewHelper.getInstance().getAddCharactersButton().setOnMouseClicked(event -> {
            File filePath = fileChooser.showOpenDialog(null);
            PluginLoader.getInstance().load(CHARACTER,filePath);
        });
        OptionsDialogViewHelper.getInstance().getAddShapesButton().setOnMouseClicked(event -> {
            File filePath = fileChooser.showOpenDialog(null);
            PluginLoader.getInstance().load(SHAPE,filePath);
        });
    }

    private void configureCloseButton() {
        OptionsDialogViewHelper.getInstance().getCloseButton().setOnMouseClicked(event -> {
            this.root.lookup("#mainMenu").setDisable(false);
            this.optionsPane.setVisible(false);
            this.optionsPane.toBack();
            this.root.requestFocus();
        });
    }

    private void configureEasyLevelButton() {
        LevelsDialogViewHelper.getInstance().getEasyLevelButton().setOnMouseClicked(event -> {
            this.gameData.setGameDifficulty(EASY_LEVEL);
            this.sceneNavigator.loadGame(Main.GAMEVIEW_ID,
            		Main.GAMEVIEW_URL, Main.GAMEVIEW_STYLESHEET, this.gameData);
            this.sceneNavigator.setScene(Main.GAMEVIEW_ID);
            manageDialogVisibility();
        });
    }
    private void configureMediumLevelButton() {
        LevelsDialogViewHelper.getInstance().getMediumLevelButton().setOnMouseClicked(event -> {
        	this.gameData.setGameDifficulty(MEDIUM_LEVEL);
        	this.sceneNavigator.loadGame(Main.GAMEVIEW_ID,
            		Main.GAMEVIEW_URL, Main.GAMEVIEW_STYLESHEET, this.gameData);
        	this.sceneNavigator.setScene(Main.GAMEVIEW_ID);
            manageDialogVisibility();
        });
    }
    private void configureHardLevelButton() {
        LevelsDialogViewHelper.getInstance().getHardLevelButton().setOnMouseClicked(event -> {
        	this.gameData.setGameDifficulty(HARD_LEVEL);
        	this.sceneNavigator.loadGame(Main.GAMEVIEW_ID,
            		Main.GAMEVIEW_URL, Main.GAMEVIEW_STYLESHEET, this.gameData);
        	this.sceneNavigator.setScene(Main.GAMEVIEW_ID);
            manageDialogVisibility();
        });
    }
    private void manageDialogVisibility(){
        levelsPane.setVisible(false);
        levelsPane.toBack();
        levelsPane.requestFocus();
    }

    public Node getRootPane() {
        return this.root;
    }
}
