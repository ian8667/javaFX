package javafx;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Dimension2D;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

/**
 * <p>This can be used a template for JavaFX files.</p>
 *
 *-------------------------------------------------
 *
 * o Node is one of the most important classes in JavaFX.
 * o Every control or layout pane is a kind of node. This
 *   means a Stage has a single node known as Scene.
 * o main() method is not necessary for javafx applications.
 *-------------------------------------------------
 *
 * Java API docs
 * http://docs.oracle.com/javase/8/docs/api/index.html
 *
 * JavaFX API docs
 * http://docs.oracle.com/javase/8/javafx/api/toc.htm
 *
 * JavaFX: how to easily implement an application preloader
 * https://blog.codecentric.de/en/2015/09/javafx-how-to-easily-implement-application-preloader-2/
 *
 * JavaFX: Sample Applications for Tutorials
 * http://docs.oracle.com/javase/8/javafx/sample-apps/
 *
 * JavaFX CSS Reference Guide
 * https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
 *
 * How to Write Doc Comments for the Javadoc Tool
 * http://www.oracle.com/technetwork/articles/java/index-137868.html
 * and
 * Javadoc Tool
 * http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html
 *-------------------------------------------------
 *
 * getParameters()
 * Retrieves the parameters for this Application, including any arguments
 * passed on the command line and any parameters specified in a JNLP file
 * for an applet or WebStart application.
 *
 * NOTE: this method should not be called from the Application constructor,
 * as it will return null. It may be called in the init() method or any time
 * after that.
 *-------------------------------------------------
 *
 * Learning:
 * Complete javafx tutorials for beginners
 * http://javafxtuts.com/
 *-------------------------------------------------
 *
 * @author Ian Molloy December 2016
 * @version (#)TemplateJavafx.java        1.03 2016-12-15
 */
public class TemplateJavafx extends Application {
private static Dimension2D windowSize;
private static Button btn;
private static String closingMsg;
private static String windowTitle;
    /**
     * Demonstrates the use of 'javafx.scene.Group' as a node
     * on which to place our GUI objects.
     *
     * @return the scene created which will be mounted on the stage
     */
    private Scene demonstrateGroup() {

      Group root = new Group();
      Scene myscene = new Scene(root, windowSize.getWidth(), windowSize.getHeight(), Color.CORNFLOWERBLUE);
      root.getChildren().add(btn);

      return myscene;
    }

    /**
     * Demonstrates the use of 'javafx.scene.layout.StackPane' as a node
     * on which to place our GUI objects.
     *
     * @return the scene created which will be mounted on the stage
     */
    private Scene demonstrateStackpane() {

      StackPane root = new StackPane();
      Scene myscene = new Scene(root, windowSize.getWidth(), windowSize.getHeight(), Color.CYAN);
      root.getChildren().add(btn);

      return myscene;
    }

    /**
     * Create a button to place on our form.
     *
     * @return a javafx.scene.control.Button
     */
    private Button createButton() {

      // Create the button.
      Button btn = new Button("button99");
      Tooltip btntip = new Tooltip("My sample button");
      btn.setLayoutX(40.0d);
      btn.setLayoutY(110.0d);
      btn.setText("hello world");
      btn.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              System.out.println("Hello World, this is coreJavafx");
          }
      });
      btn.setTooltip(btntip);

      return btn;
    }

    /**
     * The main entry point for all JavaFX applications. The start method
     * is called after the init method has returned, and after the system
     * is ready for the application to begin running.
     *
     * @param Stage the primary 'javafx.stage.Stage' object for the application
     */
    @Override
    public void start(Stage primaryStage) {

        System.out.printf("method start() called on thread %s%n", Thread.currentThread());

        byte val = 0;
        Scene myscene;
        if (val == 0) {
            myscene = demonstrateGroup();
            windowTitle = "root node of group";
        } else {
            myscene = demonstrateStackpane();
            windowTitle = "root node of stackpane";
        }

        primaryStage.setTitle(windowTitle);
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
     *
     * @throws Exception (exact reasons unknown)
     */
    public void init() throws Exception {

       System.out.printf("method init() called on thread %s%n",Thread.currentThread());
       closingMsg = "Stage is closing now";
       System.out.println("Hello World, this is method init but I dont really do anthing");

       windowSize = new Dimension2D(350.0, 216.0);  // width, height
       btn = this.createButton();
    }

    /**
     * Method stop.
     * This method is called when the application should stop, and
     * provides a convenient place to prepare for application exit
     * and destroy resources.
     *
     * We could have some clean up code here.
     *
     * @throws Exception (exact reasons unknown)
     */
    @Override
    public void stop() throws Exception {
        System.out.printf("method stop() called on thread %s%n",Thread.currentThread());
        System.out.println(closingMsg);
        Platform.exit();
    }//end of stop

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }//end of main
}//end of class

