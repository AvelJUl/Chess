package view;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * Класс StartMenu обеспечивает создание
 * главного меню.
 *
 * @author Юлия Авельчук
 * @version 1.0
 * @since   2018-03-28
 */
public class MainMenu extends Parent {
    /** Оттенок темного цвета. */
    private final Color darkShade = Color.rgb(75, 20, 15);
    /** Ширина фона. */
    private final int widthOfBackground = 280;
    /** Высота фона. */
    private final int heightOfBackground = 170;
    /** Ширина фона настроек. */
    private final int widthOfBackgroundSettings = 360;
    /** Высота фона настроек. */
    private final int heightOfBackgroundSettings = 200;
    /** Ширина фона статисктики. */
    private final int widthOfBackgroundStatistics = 280;
    /** Высота фона статистики. */
    private final int heightOfBackgroundStatistics = 200;
    /** Семество шрифта.*/
    private String familyFont = "Impact";
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
    /**
     * Цифра 5, используется для описания
     * номера столбца и строки.
     */
    private final int five = 4;
    /** Размер шрифта текста "Welcome". */
    private final int mainMenuSpacing = 5;
    /** Смещение меню по оси X.*/
    private final int offset = 400;
    /** Координаты расположения меню. */
    private final int arragementCoordinates = 50;
    /** Слой, содержащий главное меню.*/
    private VBox mainMenu;
    /** Кнопка "PLAY!", начинающая игру.*/
    private MenuButton playButton;
    /**
     * Кнопка "Statistics", используемая для
     * получения статистической информации
     * о текущем игроке.
     */
    private MenuButton statisticsButton;
    /**
     * Кнопка "Settings", позволяющая
     * изменить настройки игры.
     */
    private MenuButton settingsButton;
    /**
     * Кнопка "Exit", предназначенная для
     * выхода из приложения.
     */
    private MenuButton exitButton;
    /**
     * Слой, содержащий статистическую
     * информацию об игре.
     */
    private GridPane statisticsOfGame;
    /**
     * Слой, позволяющий изменить
     * настройки игры.
     */
    private GridPane settings;
    /**
     * Количество побед текущего
     * пользователя.
     */
    private Label numbersOfWins;
    /**
     * Количество поражений текущего
     * пользователя.
     */
    private Label numbersOfLesions;
    /** КПД текущего пользователя.*/
    private Label efficiency;
    /**
     * Лучшее время выйгрыша
     * текущего пользователя.
     */
    private Label bestTime;
    /**
     * Среднее время выйгрыша
     * текущего пользователя.
     */
    private Label averageTime;
    /**
     * Размер шрифта надписей меню статистики.
     * меню статистики.
     */
    private final int sizeOfLabel = 20;
    /**
     * Кнопка, используемая для взврата
     * в главное меню из статистики.
     */
    private MenuButton backToMainMenuButtonFromStatistics;
    /** Кнопка, включающая музыку.*/
    private CheckBox musicCheckBox;
    /** Кнопка, включающая звуки.*/
    private CheckBox soundCheckBox;
    /**Режим новичка.*/
    private RadioButton begginerRadioButton;
    /**Режим профессионала.*/
    private RadioButton professionalRadioButton;
    /**Управление с помощью мыши.*/
    private RadioButton mouseControlRadioButton;
    /**Управление с помощью клавиатуры.*/
    private RadioButton keyboardControlRadioButton;
    /**
     * Кнопка, используемая для взврата
     * в главное меню из настроек.
     */
    private MenuButton backToMainMenuButtonFromSettings;
    /** Задержка перед смещением 0.25 секунд. */
    private final double timeDelayOne = 0.25;
    /** Задержка перед смещением 0.5 секунд. */
    private final double timeDelayTwo = 0.5;
    /***/
    private final int gap = 5;
    /**
     * Метод для создания игрового меню.
     */
    public MainMenu() {
        this.mainMenu = new VBox(this.mainMenuSpacing);
        this.statisticsOfGame = new GridPane();
        this.settings = new GridPane();
        this.mainMenu.setTranslateX(this.arragementCoordinates);
        this.mainMenu.setTranslateY(this.arragementCoordinates);
        this.statisticsOfGame.setTranslateX(this.arragementCoordinates);
        this.statisticsOfGame.setTranslateY(this.arragementCoordinates);
        this.settings.setTranslateX(this.arragementCoordinates);
        this.settings.setTranslateY(this.arragementCoordinates);
        this.statisticsOfGame.setHgap(this.gap);
        this.statisticsOfGame.setVgap(this.gap);
        this.settings.setHgap(this.gap);
        this.settings.setVgap(this.gap);
        this.statisticsOfGame.setAlignment(Pos.CENTER);
        this.settings.setAlignment(Pos.CENTER);
        this.playButton = new MenuButton(" PLAY!");
        this.statisticsButton =
                new MenuButton("Statistics");
        this.settingsButton = new MenuButton("Settings");
        this.exitButton = new MenuButton("Exit");
        this.mainMenu.getChildren().setAll(this.playButton,
                this.statisticsButton, this.settingsButton, this.exitButton);
        Label numbersOfWinsLabel = new Label("Wins:");
        numbersOfWinsLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        numbersOfWinsLabel.setTextFill(this.darkShade);
        this.numbersOfWins = new Label("");
        Label numbersOfLesionsLabel = new Label("Lesions:");
        numbersOfLesionsLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        numbersOfLesionsLabel.setTextFill(this.darkShade);
        this.numbersOfLesions = new Label("");
        Label efficiencyLabel = new Label("Efficiency:");
        efficiencyLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        efficiencyLabel.setTextFill(this.darkShade);
        this.efficiency = new Label("");
        Label bestTimeLabel = new Label("Best time:");
        bestTimeLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        bestTimeLabel.setTextFill(this.darkShade);
        this.bestTime = new Label("");
        Label averageTimeLabel = new Label("Average time:");
        averageTimeLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        averageTimeLabel.setTextFill(this.darkShade);
        this.averageTime = new Label("");
        this.backToMainMenuButtonFromStatistics = new MenuButton("Back");
        this.statisticsOfGame.add(numbersOfWinsLabel, 0, 0);
        this.statisticsOfGame.add(this.numbersOfWins, this.one, 0);
        this.statisticsOfGame.add(numbersOfLesionsLabel, 0, this.one);
        this.statisticsOfGame.add(this.numbersOfLesions, this.one, this.one);
        this.statisticsOfGame.add(efficiencyLabel, 0, this.two);
        this.statisticsOfGame.add(this.efficiency, this.one, this.two);
        this.statisticsOfGame.add(bestTimeLabel, 0, this.three);
        this.statisticsOfGame.add(this.bestTime, this.one, this.three);
        this.statisticsOfGame.add(averageTimeLabel, 0, this.four);
        this.statisticsOfGame.add(this.averageTime, this.one, this.four);
        this.statisticsOfGame.add(this.backToMainMenuButtonFromStatistics,
                0, this.five + this.one, this.two, this.one);
        Label musicLabel = new Label("Music");
        musicLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        musicLabel.setTextFill(this.darkShade);
        Label soundLabel = new Label("Sound");
        soundLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        soundLabel.setTextFill(this.darkShade);
        Label complexityLabel = new Label("Complexity:");
        complexityLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        complexityLabel.setTextFill(this.darkShade);
        Label beginnerLabel = new Label("Beginner");
        beginnerLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        beginnerLabel.setTextFill(this.darkShade);
        Label professionalLabel = new Label("Professional");
        professionalLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        professionalLabel.setTextFill(this.darkShade);
        Label controlLabel = new Label("Control:");
        controlLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        controlLabel.setTextFill(this.darkShade);
        Label mouseControlLabel = new Label("With the mouse");
        mouseControlLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        mouseControlLabel.setTextFill(this.darkShade);
        Label keyboardControlLabel = new Label("With the keyboard");
        keyboardControlLabel.setFont(Font.font(this.familyFont,
                this.sizeOfLabel));
        keyboardControlLabel.setTextFill(this.darkShade);
        this.musicCheckBox = new CheckBox();
        this.soundCheckBox = new CheckBox();
        final ToggleGroup groupComplexity = new ToggleGroup();
        this.begginerRadioButton = new RadioButton();
        this.begginerRadioButton.setToggleGroup(groupComplexity);
        this.professionalRadioButton = new RadioButton();
        this.professionalRadioButton.setToggleGroup(groupComplexity);
        final ToggleGroup groupControl = new ToggleGroup();
        this.mouseControlRadioButton = new RadioButton();
        this.mouseControlRadioButton.setToggleGroup(groupControl);
        this.keyboardControlRadioButton = new RadioButton();
        this.keyboardControlRadioButton.setToggleGroup(groupControl);
        this.backToMainMenuButtonFromSettings = new MenuButton("Back");
        this.settings.add(musicLabel, 0, 0);
        this.settings.add(this.musicCheckBox, this.one, 0);
        this.settings.add(soundLabel, this.two, 0);
        this.settings.add(this.soundCheckBox, this.three, 0);
        this.settings.add(complexityLabel, 0, this.one, this.three, this.one);
        this.settings.add(beginnerLabel, 0, this.two);
        this.settings.add(this.begginerRadioButton, this.one, this.two);
        this.settings.add(professionalLabel, this.two, this.two);
        this.settings.add(this.professionalRadioButton, this.three, this.two);
        this.settings.add(controlLabel, 0, this.three, this.three, this.one);
        this.settings.add(mouseControlLabel, 0, this.four);
        this.settings.add(this.mouseControlRadioButton, this.one, this.four);
        this.settings.add(keyboardControlLabel, this.two, this.four);
        this.settings.add(this.keyboardControlRadioButton,
                this.three, this.four);
        this.settings.add(this.backToMainMenuButtonFromSettings,
                0, this.five + this.one, this.four, this.one);
        //getChildren().add(this.mainMenu);
    }

    /**
     * Метод добавляет слушателя событий всем
     * кнопкам.
     * @param background фон
     */
    public void addListener(final Rectangle background) {
        this.setVisible(true);
        this.addListenerToMainMenuButton(background);
        this.addListenerToStatisticsBackButton(background);
        this.addListenerToSettingsBackButton(background);
    }

    /**
     * Метод добавляет слушателя событий всем
     * кнопкам главного меню.
     * @param background фон
     */
    private void addListenerToMainMenuButton(final Rectangle background) {
        this.statisticsButton.addListener();
        this.statisticsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                getChildren().add(statisticsOfGame);
                statisticsOfGame.setTranslateX(arragementCoordinates);
                TranslateTransition translateTransitionOfMainMenu =
                        new TranslateTransition(Duration
                                .seconds(timeDelayOne), mainMenu);
                translateTransitionOfMainMenu
                        .setToX(mainMenu.getTranslateX() + offset);

                TranslateTransition translateTransitionOfStatistics =
                        new TranslateTransition(Duration
                                .seconds(timeDelayTwo), statisticsOfGame);
                translateTransitionOfStatistics
                        .setToX(statisticsOfGame.getTranslateX());

                translateTransitionOfMainMenu.play();
                translateTransitionOfStatistics.play();
                background.setWidth(widthOfBackgroundStatistics);
                background.setHeight(heightOfBackgroundStatistics);
                translateTransitionOfMainMenu
                        .setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(final ActionEvent event) {
                                getChildren().remove(mainMenu);
                            }
                        });
            }
        });
        this.settingsButton.addListener();
        this.settingsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                getChildren().add(settings);
                settings.setTranslateX(arragementCoordinates);
                TranslateTransition translateTransitionOfMainMenu =
                        new TranslateTransition(Duration
                                .seconds(timeDelayOne), mainMenu);
                translateTransitionOfMainMenu.setToX(mainMenu
                        .getTranslateX() + offset);
                TranslateTransition translateTransitionOfSettings =
                        new TranslateTransition(Duration
                                .seconds(timeDelayTwo), settings);
                translateTransitionOfSettings.setToX(mainMenu
                        .getTranslateX());
                translateTransitionOfMainMenu.play();
                translateTransitionOfSettings.play();
                background.setWidth(widthOfBackgroundSettings);
                background.setHeight(heightOfBackgroundSettings);
                translateTransitionOfMainMenu
                        .setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(final ActionEvent event) {
                                getChildren().remove(mainMenu);
                            }
                        });
            }
        });
        this.exitButton.addListener();
        this.exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                System.exit(0);
            }
        });
    }

    /**
     * Метод добавляет слушателя событий
     * кнопке возврата в главное меню из
     * статистики.
     * @param background фон
     */
    private void addListenerToStatisticsBackButton(final Rectangle background) {
        this.backToMainMenuButtonFromStatistics.addListener();
        this.backToMainMenuButtonFromStatistics
                .setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                getChildren().add(mainMenu);
                mainMenu.setTranslateX(arragementCoordinates);
                TranslateTransition translateTransitionOfStatisticsOfGame =
                        new TranslateTransition(Duration
                                .seconds(timeDelayOne), statisticsOfGame);
                translateTransitionOfStatisticsOfGame.setToX(statisticsOfGame
                        .getTranslateX() + offset);
                TranslateTransition translateTransitionOfMainMenu =
                        new TranslateTransition(Duration
                                .seconds(timeDelayTwo), mainMenu);
                translateTransitionOfMainMenu.setToX(mainMenu
                        .getTranslateX());
                translateTransitionOfStatisticsOfGame.play();
                translateTransitionOfMainMenu.play();
                background.setWidth(widthOfBackground);
                background.setHeight(heightOfBackground);
                translateTransitionOfStatisticsOfGame
                        .setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(final ActionEvent event) {
                                getChildren().remove(statisticsOfGame);
                            }
                        });
            }
        });
    }

    /**
     * Метод добавляет слушателя событий
     * кнопке возврата в главное меню из
     * настроек.
     * @param background фон
     */
    private void addListenerToSettingsBackButton(final Rectangle background) {
        this.backToMainMenuButtonFromSettings.addListener();
        this.backToMainMenuButtonFromSettings
                .setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                getChildren().add(mainMenu);
                mainMenu.setTranslateX(arragementCoordinates);
                TranslateTransition translateTransitionOfSettings =
                        new TranslateTransition(Duration
                                .seconds(timeDelayOne), settings);
                translateTransitionOfSettings.setToX(settings
                        .getTranslateX() + offset);
                TranslateTransition translateTransitionOfMainMenu =
                        new TranslateTransition(Duration
                                .seconds(timeDelayTwo), mainMenu);
                translateTransitionOfMainMenu.setToX(mainMenu
                        .getTranslateX());
                translateTransitionOfSettings.play();
                translateTransitionOfMainMenu.play();
                background.setWidth(widthOfBackground);
                background.setHeight(heightOfBackground);
                translateTransitionOfSettings
                        .setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(final ActionEvent event) {
                                getChildren().remove(settings);
                            }
                        });
            }
        });
    }
    /**
     * Метод, возвращающий главное меню.
     * @return mainMenu
     */
    public VBox getMainMenu() {
        return this.mainMenu;
    }
    /**
     * @param scene сцена
     * @param pane панель
     */
    public void addListenerToButtonPlay(final Scene scene,
                                         final Pane pane) {
        playButton.addListener();
        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                scene.setRoot(pane);
            }
        });
    }
}
