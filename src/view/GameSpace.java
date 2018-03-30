package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Класс GameSpace используется для
 * создания игрового поля.
 *
 * @author Юлия Авельчук
 * @version 1.0
 * @since   2018-03-29
 */
public class GameSpace {
    /**
     * Цифра 1, используется для описания
     * номера столбца и строки.
     */
    private static final int ONE = 1;
    /**
     * Цифра 2, используется для описания
     * номера столбца и строки.
     */
    private static final int TWO = 2;
    /**
     * Цифра 3, используется для описания
     * номера столбца и строки.
     */
    /**
     * Панель, на которой будет расположено
     * игровое простравнсиво.
     */
    private Pane root;
    /** Оттенок светлого цвета. */
    private final Color lightShade = Color.rgb(225, 190, 95);
    /** Оттенок темного цвета. */
    private static final Color DARK_SHADE = Color.rgb(75, 20, 15);
    /** */
    private final double opacity = 0.4;
    /** Параметр ширины.*/
    private final int preWidth = 1100;
    /** Параметр высоты.*/
    private final int preHeight = 750;
    /** Параметр ширины бумажки.*/
    private final int paperWidth = 350;
    /** Параметр высоты бумажкм.*/
    private final int paperHeight = 350;
    /** Координаты изображения бумаги.*/
    private final int paperCoordinates = -30;
    /**
     * Координата оси X расположения
     * изображения шахматной доски.
     */
    private final int boardXCoordinates = 330;
    /**
     * Координата оси Y расположения
     * изображения шахматной доски.
     */
    private final int boardYCoordinates = -80;
    /**
     * Параметр ширины и высоты изображения
     * шахматной доски.
     */
    private final int boardSize = 800;
    /***/
    private Rectangle backgroundControlPane;
    /***/
    private final int controlPaneXCoordinate = 35;
    /***/
    private final int controlPaneYCoordinate = 480;
    /***/
    private static final int COORDINATE_Y = 490;
    /***/
    private final int controlPaneYAdd = 120;
    /** Ширина кнопки. */
    private final int widthOfControlPane = 285;
    /** Высота кнопки. */
    private final int heightOfControlPane = 50;
    /***/
    private static final int COORDINATE_X = 50;
    /***/
    private final int coordinateYOfButton = 610;
    /***/
    private MenuButton backToMainMenu;
    /***/
    private GridPane controlPane;
    /***/
    private static final int GAP = 10;
    /** Размер шрифта надписей.*/
    private static final int SIZE_OF_LABEL = 20;
    /** Семество шрифта.*/
    private static String familyFont = "Impact";
    /***/
    private static TextField fromTextField;
    /***/
    private static TextField toTextField;
    /**
     * Создание игрового пространства.
     * @param mouseControl управление с помощью мыши.
     */
    public GameSpace(final boolean mouseControl) {
        this.root = new Pane();
        this.root.setPrefSize(this.preWidth, this.preHeight);
        try (InputStream streamToBackground = Files.newInputStream(
                Paths.get("resourses/image/background1.png"))) {
            ImageView spaceImageView = new ImageView(
                    new Image(streamToBackground));
            streamToBackground.close();
            spaceImageView.setFitWidth(this.preWidth);
            spaceImageView.setFitHeight(this.preHeight);
            this.root.getChildren().add(spaceImageView);
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }
        try (InputStream streamToPaper = Files.newInputStream(
                Paths.get("resourses/image/paper.png"))) {
            ImageView paperImageView = new ImageView(
                    new Image(streamToPaper));
            streamToPaper.close();
            paperImageView.setFitWidth(this.paperWidth);
            paperImageView.setFitHeight(this.paperHeight);
            paperImageView.setX(this.paperCoordinates);
            this.root.getChildren().add(paperImageView);
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }
        try (InputStream streamToBoard = Files.newInputStream(
                Paths.get("resourses/image/board.png"))) {
            ImageView boardImageView = new ImageView(
                    new Image(streamToBoard));
            streamToBoard.close();
            boardImageView.setFitWidth(this.boardSize);
            boardImageView.setFitHeight(this.boardSize);
            boardImageView.setX(this.boardXCoordinates);
            boardImageView.setY(this.boardYCoordinates);
            this.root.getChildren().add(boardImageView);
        } catch (IOException e) {
            System.out.println("Couldn't load image");
        }
        if (mouseControl) {
            this.backgroundControlPane = new Rectangle(this.widthOfControlPane,
                    this.heightOfControlPane + this.controlPaneYAdd);
            this.backgroundControlPane.setTranslateY(this.controlPaneYCoordinate);
            this.controlPane = new GridPane();
            this.fromTextField = new TextField();
            this.toTextField = new TextField();
            this.controlPane = createControlPane();
            this.root.getChildren().addAll(this.backgroundControlPane,
                    this.controlPane);
        } else {
            this.backgroundControlPane = new Rectangle(this.widthOfControlPane,
                    this.heightOfControlPane);
            this.backgroundControlPane.setTranslateY(this.controlPaneYCoordinate
                    + this.controlPaneYAdd);
            this.root.getChildren().add(this.backgroundControlPane);
        }
        this.backgroundControlPane.setFill(this.lightShade);
        this.backgroundControlPane.setOpacity(this.opacity);
        this.backgroundControlPane.setTranslateX(this.controlPaneXCoordinate);
        this.backToMainMenu = new MenuButton("BACK");
        this.backToMainMenu.setTranslateX(COORDINATE_X);
        this.backToMainMenu.setTranslateY(this.coordinateYOfButton);
        this.backToMainMenu.addListener();
        this.root.getChildren().add(this.backToMainMenu);
    }

    /**
     * Получение панели, на которой
     * расположены элементы игрового
     * пространства.
     * @return root панель
     */
    public Pane getGameRoot() {
        return this.root;
    }

    /**
     *
     * @return gridPane панель
     */
    private static GridPane createControlPane() {
        GridPane gridPane = new GridPane();
        gridPane.setTranslateX(COORDINATE_X);
        gridPane.setTranslateY(COORDINATE_Y);
        gridPane.setVgap(GAP);
        gridPane.setHgap(GAP);
        Label labelFrom = new Label("FROM");
        labelFrom.setFont(Font.font(familyFont,
                SIZE_OF_LABEL));
        labelFrom.setTextFill(DARK_SHADE);
        Label labelTo = new Label("TO");
        labelTo.setFont(Font.font(familyFont,
                SIZE_OF_LABEL));
        labelTo.setTextFill(DARK_SHADE);
        gridPane.add(labelFrom, 0, 0);
        gridPane.add(labelTo, 0, ONE);
        gridPane.add(fromTextField, ONE, 0);
        gridPane.add(toTextField, ONE, ONE);
        return gridPane;
    }
}
