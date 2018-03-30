package controller;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GameSpace;
import view.StartMenu;
import view.MainMenu;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс Controller обеспечивает взаимодейсвие
 * стартовой страницы, меню и игрового поля.
 *
 * @author Юлия Авельчук
 * @version 1.0
 * @since   2018-03-29
 */
public class Controller {
    /** Ширина фона. */
    private final int widthOfBackground = 280;
    /** Высота фона. */
    private final int heightOfBackground = 230;
    /** Оттенок светлого цвета. */
    private final Color lightShade = Color.rgb(225, 190, 95);
    /** */
    private final double opacity = 0.4;
    /** */
    private final double arragementCoordinates = 35;
    /** Параметр ширины.*/
    private final int preWidth = 1100;
    /** Параметр высоты.*/
    private final int preHeight = 750;
    /** Основная панель.*/
    private Pane firstRoot;
    /** Главная сцена.*/
    private Scene mainScene;
    /** Стартовая страница.*/
    private StartMenu startMenu;
    /** Главное меню. */
    private MainMenu gameMenu;
    /** */
    private GameSpace gameSpace;
    /**
     * Метод по созданию стартовой страницы.
     */
    public Controller() {
        this.firstRoot = new Pane();
        this.firstRoot.setPrefSize(this.preWidth, this.preHeight);
        try (InputStream streamToMenuBackground = Files.newInputStream(
                Paths.get("resourses/image/menu background.jpg"))) {
            ImageView menuImageView = new ImageView(
                    new Image(streamToMenuBackground));
            streamToMenuBackground.close();
            menuImageView.setFitWidth(this.preWidth);
            menuImageView.setFitHeight(this.preHeight);
            this.firstRoot.getChildren().add(menuImageView);
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }
        this.startMenu = new StartMenu();
        this.gameMenu = new MainMenu();
        this.gameSpace = new GameSpace(true);
        this.startMenu.setVisible(true);
        this.gameMenu.setVisible(false);
        Rectangle backgroundOfMenu =
                new Rectangle(this.widthOfBackground, this.heightOfBackground);
        backgroundOfMenu.setFill(this.lightShade);
        backgroundOfMenu.setOpacity(this.opacity);
        backgroundOfMenu.setTranslateX(this.arragementCoordinates);
        backgroundOfMenu.setTranslateY(this.arragementCoordinates);
        this.startMenu.addListener(this.gameMenu
                .getMainMenu(), backgroundOfMenu);
        this.gameMenu.addListener(backgroundOfMenu);
        this.firstRoot.getChildren().addAll(backgroundOfMenu,
                this.startMenu, this.gameMenu);
        this.mainScene = new Scene(this.firstRoot);
        this.gameMenu.addListenerToButtonPlay(this.mainScene,
                this.gameSpace.getGameRoot());
    }
    /**
     * Метод, возвращающий главную сцену.
     * @return mainScene
     */
    public Scene getScene() {
        return this.mainScene;
    }
}
