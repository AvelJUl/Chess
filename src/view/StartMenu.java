package view;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Класс StartMenu обеспечивает создание меню
 * входа или регистрации.
 *
 * @author Юлия Авельчук
 * @version 1.0
 * @since   2018-03-28
 */
public class StartMenu extends Parent {
    /**
     * Цифра 1, используется для описания
     * номера столбца и строки.
     */
    private final int one = 1;
    /**
     * Цифра 2, используется для описания
     * номера столбца и строки.
     */
    private final int two = 2;
    /**
     * Цифра 3, используется для описания
     * номера столбца и строки.
     */
    private final int three = 3;
    /**
     * Цифра 4, используется для описания
     * номера столбца и строки.
     */
    private final int four = 4;
    /** Ширина фона. */
    private final int widthOfBackground = 280;
    /** Высота фона. */
    private final int heightOfBackground = 170;
    /** Оттенок темного цвета. */
    private final Color darkShade = Color.rgb(75, 20, 15);
    /** Семество шрифта.*/
    private String familyFont = "Impact";
    /** Зазор между ячейками сетки. */
    private final int gapBetweenCells = 10;
    /** Координаты расположения сетки. */
    private final int arragementCoordinates = 50;
    /** Размер шрифта текста "Welcome". */
    private final int sizeOfWelcomeLabel = 30;
    /**
     * Размер шрифта текста "User Name"
     * и "Password".
     * */
    private final int sizeOfText = 15;
    /** Задержка перед смещением StartPage. */
    private final double timeDelayOfStartPage = 0.25;
    /** Задержка перед смещением MainMenu. */
    private final double timeDelayOfMainMenu = 0.5;
    /** Кнопка входа в систему. */
    private MenuButton singInButton;
    /** Кнопка регистрации. */
    private MenuButton singUpButton;
    /** Смещение меню по оси X.*/
    private final int offset = 400;
    /**
     * Слой, применяемый для размещения меню
     * входа и регистрации.
     */
    private GridPane startPage;

    /**
     * Метод позволяет создать стартовое меню.
     */
    public StartMenu() {
        this.startPage = new GridPane();
        this.startPage.setAlignment(Pos.CENTER);
        this.startPage.setHgap(this.gapBetweenCells);
        this.startPage.setVgap(this.gapBetweenCells);
        this.startPage.setTranslateX(this.arragementCoordinates);
        this.startPage.setTranslateY(this.arragementCoordinates);
        Text welcomeTitle = new Text("Welcome");
        welcomeTitle.setFont(Font
                .font(this.familyFont, FontWeight.BOLD, sizeOfWelcomeLabel));
        welcomeTitle.setFill(this.darkShade);

        Label loginLabel = new Label("User name:");
        loginLabel.setFont(Font
                .font(this.familyFont, FontWeight.BOLD, this.sizeOfText));
        loginLabel.setTextFill(this.darkShade);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setFont(Font
                .font(this.familyFont, FontWeight.BOLD, this.sizeOfText));
        passwordLabel.setTextFill(this.darkShade);

        TextField loginTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        this.singInButton = new MenuButton(" Sing in");
        this.singInButton.addListener();
        this.singUpButton = new MenuButton(" Sing up");
        this.singUpButton.addListener();

        this.startPage.add(welcomeTitle, 0, 0, this.two, this.one);
        this.startPage.add(loginLabel, 0, this.one);
        this.startPage.add(loginTextField, this.one, this.one);
        this.startPage.add(passwordLabel, 0, this.two);
        this.startPage.add(passwordField, this.one, this.two);
        this.startPage.add(this.singInButton, 0,
                this.three, this.two, this.one);
        this.startPage.add(this.singUpButton, 0, this.four, this.two, this.one);
        this.getChildren().add(this.startPage);
    }

    /**
     * Метод позволяет перейти к главному меню
     * по нажатию на кнопки "Sing in" и
     * "Sing up".
     * @param mainMenu слой, содержащий главное меню
     * @param background фон
     */
    public void addListener(final VBox mainMenu,
                            final Rectangle background) {
        EventHandler transitionToMainMenu = new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                getChildren().add(mainMenu);
                TranslateTransition translateTransitionOfStartPage =
                        new TranslateTransition(Duration
                                .seconds(timeDelayOfStartPage), startPage);
                translateTransitionOfStartPage
                        .setToX(startPage.getTranslateX() + offset);

                TranslateTransition translateTransitionOfMainMenu =
                    new TranslateTransition(Duration
                            .seconds(timeDelayOfMainMenu), mainMenu);
               translateTransitionOfMainMenu
                       .setToX(startPage.getTranslateX());

                translateTransitionOfStartPage.play();
                translateTransitionOfMainMenu.play();

                background.setWidth(widthOfBackground);
                background.setHeight(heightOfBackground);

                translateTransitionOfStartPage
                        .setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent event) {
                        getChildren().remove(startPage);
                    }
                });
            }
        };
        this.singInButton.setOnMouseClicked(transitionToMainMenu);
        this.singUpButton.setOnMouseClicked(transitionToMainMenu);
    }
}
