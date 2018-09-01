import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.geometry.Dimension2D;
import javafx.scene.paint.Color;
/**
 * <p>A learning file to practice my JavaFX.</p>
 *
 *-------------------------------------------------
 *
 * Java API docs
 * http://docs.oracle.com/javase/8/docs/api/index.html
 *
 * JavaFX API docs
 * http://docs.oracle.com/javase/8/javafx/api/toc.htm
 * or
 * http://docs.oracle.com/javafx/2/api/index.html
 *
 * Introduction to FXML
 * This document introduces the FXML markup language and explains
 * how it can be used to simplify development of JavaFX applications.
 * http://docs.oracle.com/javase/8/javafx/api/javafx/fxml/doc-files/introduction_to_fxml.html#attributes
 *
 * JavaFX 2.2 API docs
 * https://docs.oracle.com/javafx/2/api/index.html
 *
 * Java Platform, Standard Edition (Java SE) 8 (and notes).
 * https://docs.oracle.com/javase/8/javase-clienttechnologies.htm
 *-------------------------------------------------
 * Learning:
 * Complete javafx tutorials for beginners
 * http://javafxtuts.com/
 *
 * Getting Started with JavaFX
 * https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
 *-------------------------------------------------
 *
 * @author Ian Molloy September 2018
 * @version (#)TemplateJavafx02.java        1.00 2018-09-01
 * Keywords: javafx java template
 */
public class TemplateJavafx02 extends Application {
private static String closingMsg;
    /**
     * The main entry point for all JavaFX applications. The start method
     * is called after the init method has returned, and after the system
     * is ready for the application to begin running.
     */
    @Override
    public void start(Stage primaryStage) {
        // Constructs a Dimension2D with the specified width
        // and height.
        // width - the width
        // height - the height
        Dimension2D myDim = new Dimension2D(300.0, 250.0);
        Button btn = new Button();
        btn.setText("Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        // The root can be either of type 'javafx.scene.Group'
        // or 'javafx.scene.layout.StackPane'.
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene myscene = new Scene(root, myDim.getWidth(), myDim.getHeight(), Color.YELLOW);

        primaryStage.setTitle("Hello World Title!");
        primaryStage.setScene(myscene);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }//end of start

    /**
     * Method init.
     * The application initialization method. This method is called
     * immediately after the Application class is loaded and constructed.
     * An application may override this method to perform initialization
     * prior to the actual starting of the application.
     *
     * The implementation of this method provided by the Application
     * class does nothing.
     *
     * NOTE: This method is not called on the JavaFX Application
     * Thread. An application must not construct a Scene or a Stage
     * in this method. An application may construct other JavaFX
     * objects in this method.
     *
     * We can leave this method out if we wish to. ie ignore it altogether.
     */
    @Override
    public void init() throws Exception {
       closingMsg = "Stage is closing now";
    }

    /**
     * Method stop.
     * This method is called when the application should stop, and
     * provides a convenient place to prepare for application exit
     * and destroy resources.
     *
     * We could have some clean up code here.
     */
    @Override
    public void stop() throws Exception {

        System.out.println(closingMsg);

        Platform.exit();
    }

    /**
     * main
     * @param args
     */
    public static void main(final String[] args) {
    //public static void main(String[] args) {
        Application.launch(args);
    }//end of main
}//end of class

