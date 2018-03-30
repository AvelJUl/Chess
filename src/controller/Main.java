package controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Класс Main обеспечивает сознание
 * приложения.
 *
 * @author Юлия Авельчук
 * @version 1.0
 * @since   2018-03-29
 */
public class Main extends Application {
    /**
     * Управление взаимодействием
     * компонентов приложения.
     */
    private Controller controller;

    /**
     * Создание окна приложения.
     * @param primaryStage первичная сцена
     * @throws Exception исключения
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        this.controller = new Controller();

        primaryStage.setResizable(false);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(this.controller.getScene());
        primaryStage.show();
    }
    /**
     * Запуск приложения.
     * @param args параметры
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
