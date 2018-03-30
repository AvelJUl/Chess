package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Класс MenuButton обеспечивает создание кнопки
 * меню с визуальными эффектами.
 *
 * @author Юлия Авельчук
 * @version 1.0
 * @since   2018-03-28
 */
public class MenuButton extends StackPane {

    /**
     * Размер шрифта, которым будет выполнен
     * текст кнопки.
     */
    private final int sizeOfText = 20;

    /** Ширина кнопки. */
    private final int widthOfButton = 250;

    /** Высота кнопки. */
    private final int heightOfButton = 30;

    /**
     * Радиус тени, которую отбрасывает
     * кнопка.
     */
    private final int radiusOfDropShadow = 50;

    /**
     * Смещение по осям X и У при наведении
     * на кнопку.
     */
    private final int shiftWhileExited = 10;

    /**
     * Процент непрохравности кноки,
     * выраженный в долях от единицы.
     */
    private final double opacityOfButton = 0.6;

    /** Радиус размытия кнопки. */
    private final double radiusOfGaussianBlur = 3.5;

    /** Оттенок темного цвета. */
    private final Color darkShade = Color.rgb(75, 20, 15);

    /** Оттенок светлого цвета. */
    private final Color lightShade = Color.rgb(225, 190, 95);

    /**
     * Текст, который будет размещён
     * на кнопке.
     */
    private Text textOfButton;

    /**
     * Прямоугольник, используемый как основа
     * кнопки.
     * */
    private Rectangle backgroundOfButton;

    /**
     * Метод создает кнопку без визуальных
     * эффектов при нажатии и наведении
     * на кнопку.
     * @param textOfNewButton текст, который
     *                        будет содержать кнопка
     */
    public MenuButton(final String textOfNewButton) {
        this.textOfButton = new Text(textOfNewButton);
        this.textOfButton
                .setFont(Font.font("Impact", this.sizeOfText));
        this.textOfButton.setFill(this.darkShade);
        this.backgroundOfButton =
                new Rectangle(this.widthOfButton, this.heightOfButton);
        this.backgroundOfButton.setOpacity(this.opacityOfButton);
        this.backgroundOfButton.setFill(this.lightShade);
        this.backgroundOfButton
                .setEffect(new GaussianBlur(this.radiusOfGaussianBlur));

        setAlignment(Pos.CENTER);
        getChildren().addAll(this.backgroundOfButton, this.textOfButton);
    }

    /**
     * Метод добавляет эффект к созданной
     * ранее кнопке.
     */
    public void addListener() {
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                backgroundOfButton.setTranslateX(shiftWhileExited);
                textOfButton.setTranslateX(shiftWhileExited);
                backgroundOfButton.setFill(darkShade);
                textOfButton.setFill(lightShade);
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                backgroundOfButton.setTranslateX(0);
                textOfButton.setTranslateX(0);
                backgroundOfButton.setFill(lightShade);
                textOfButton.setFill(darkShade);
            }
        });

        DropShadow drop = new DropShadow(this.radiusOfDropShadow, lightShade);
        drop.setInput(new Glow());

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                setEffect(drop);
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                setEffect(null);
            }
        });
    }
}
