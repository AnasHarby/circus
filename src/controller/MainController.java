package controller;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import view.gui.gameplay.GameView;
import view.gui.mainmenu.MainMenu;

/**
 * Acts as the Main Controller for MVC, has references to sub-controllers each
 * is used to control a single task, also acts as a link between model and view.
 */
public final class MainController {
    /**
     * {@link InputController} instance.
     */
    private InputController inputController = null;

    /**
     * {@link PlayersController} instance.
     */
    private PlayersController playersController = null;

    /**
     * {@link ShapesController} instance.
     */
    private ShapesController shapesController = null;

    /**
     * {@link GameUtilController} instance.
     */
    private GameUtilController gameUtilController = null;

    /**
     * Constructs new instances from sub-controllers.
     */
    private GameView gameView = null;

    private MainMenu mainMenu = null;

    public MainController() {
        inputController = new InputController(this);
        playersController = new PlayersController(this);
        shapesController = new ShapesController(this);
        gameUtilController = new GameUtilController(this);
    }

    /**
     * Gets the used instance to {@link InputController} which allows control over
     * input.
     * @return {@link InputController} instance.
     */
    public InputController getInputController() {
        return this.inputController;
    }

    /**
     * Gets the used instance to {@link PlayersController} which allows control
     * over players.
     * @return {@link PlayersController} instance.
     */
    public PlayersController getPlayersController() {
        return this.playersController;
    }

    /**
     * Gets the used instance to {@link ShapesController} which allows control
     * over shapes.
     * @return {@link ShapesController} instance.
     */
    public ShapesController getShapesController() {
        return this.shapesController;
    }

    /**
     * Gets the used instance to {@link GameUtilController} which allows control
     * over all game utilities (Score, Shelves... etc).
     * @return {@link GameUtilController} instance.
     */
    public GameUtilController getGameUtilController() {
        return this.gameUtilController;
    }

    /**
     * Sets {@link GameView} to the main controller of the main MVC.
     * @param gameView GameView for the controller to set nodes on.
     */
    public void setGameView(final GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * Gets {@link GameView} of the main MVC.
     * @return Currently working {@link GameView}.
     */
    public GameView getGameView() {
        return this.gameView;
    }

    /**
     * Sets {@link MainMenu} to the main controller of the main MVC.
     * @param mainMenu MainMenu for the controller
     */
    public void setMainMenu(final MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * Gets {@link MainMenu} of the main MVC.
     * @return the current {@link MainMeny}
     */
    public MainMenu getMainMenu() {
        return this.mainMenu;
    }
    /**
     * Adds a {@link Node} to the root {@link Pane} of a {@link GameView}.
     * @param node Node to be added to root pane.
     */
    public void addToRootPane(final Node node) {
        gameView.getRootPane().getChildren().add(node);
    }

    /**
     * Starts a new game, calls control to run over view (e.g: render players,
     * create shapes and move them.. etc).
     */
    public void startNewGame() {
        gameUtilController.prepareGame();
        playersController.prepareGame();
        shapesController.startGame();
    }
}
