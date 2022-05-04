import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.application.Platform;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import javafx.scene.Group;
import javafx.geometry.Dimension2D;
import javafx.scene.paint.Color;
//
// Additional import statements below this line
//
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * <p>A learning file to practice my JavaFX.</p>
 *
 * hbox.getChildren().addAll(new Label("Name:), new TextBox());
 *-----------------------------------------------
 *
 * JDK 18 Documentation
 * https://docs.oracle.com/en/java/javase/18/
 *
 * Java SE Version 18 API docs
 * https://docs.oracle.com/en/java/javase/18/docs/api/index.html
 *
 * JavaFX API docs
 * https://openjfx.io/javadoc/18/
 *
 * Introduction to FXML
 * This document introduces the FXML markup language and explains
 * how it can be used to simplify development of JavaFX applications.
 * http://docs.oracle.com/javase/8/javafx/api/javafx/fxml/doc-files/introduction_to_fxml.html#attributes
 *
 * Java Platform, Standard Edition (Java SE) 8 (and notes).
 * https://docs.oracle.com/javase/8/javase-clienttechnologies.htm
 *
 * Class Point (module java.desktop)
 * java.awt.Point
 * A point representing a location in (x,y) coordinate space,
 * specified in integer precision.
 *
 * Class Dimension2D (module javafx.graphics)
 * javafx.geometry.Dimension2D
 * A 2D dimension object that contains a width and a height,
 * specified in double precision.
 *
 *-------------------------------------------------
 * Learning:
 * Complete javafx tutorials for beginners
 * http://javafxtuts.com/
 *
 * Getting Started with JavaFX
 * https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
 *
 * Using Built-in Layout Panes
 * This Oracle written topic describes the layout container classes,
 * called panes, that are available with JavaFX.
 * https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
 * and
 * https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
 *-------------------------------------------------
 *
 * @author Ian Molloy September 2018
 * @version (#)coreJavafx.java        1.11 2022-05-04T16:10:47
 * Keywords: javafx java
 */
public class coreJavafx extends Application {
private String closingMsg;
private Dimension2D sceneSize;
   /**
    * Constructor
    */
    public coreJavafx() {
      //As per 'Class Application' javadocs:
      //The Application subclass must be declared public and
      //must have a public no-argument constructor.
    }//end of constructor

    /**
     * Method initUI.
     * Create and setup the main bulk of the user interface
     * (UI) code.
     *
     * @param myStage the primary stage for this application
     * See also method 'start()'.
     */
    private void initUI(Stage myStage) {

    // ------------------------------------
    // User written code to construct the UI
    // user interface goes here
    // ------------------------------------

DatePicker dpick = new DatePicker();
HBox mybox = new HBox(dpick);
Text txt = new Text();
txt.setText("hello world");
txt.setFont(new Font(16));
txt.setX(35.0);
txt.setY(75.0);
    // ------------------------------------
    // Standard application processing for
    // the root and scene nodes.
    // ------------------------------------
    Group root = new Group();

    root.getChildren().add(mybox);
    root.getChildren().add(txt);

    // The JavaFX Scene class is the container for all content in
    // a scene graph. The background of the scene is filled as
    // specified by the fill property.
    Scene sce = new Scene(root, sceneSize.getWidth(), sceneSize.getHeight(), Color.CADETBLUE);
    //Scene sce = new Scene(root, sceneSize.getWidth(), sceneSize.getHeight());
    myStage.setScene(sce);
    // ------------------------------------

    }//end of method initUI

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
     * See also method 'init()' of class javafx.application.Application.
     */
    @Override
    public void init() throws Exception {
       LocalTime tt = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
       closingMsg = String.format("Stage is closing now at %s%n", tt);

       // Preferred size of the Scene. Constructs a Dimension2D object
       // with the specified width and height.
       sceneSize = new Dimension2D(400.0, 200.0);
    }//end of method init

    /**
     * Method start.
     * Do some work here!
     *
     * The main entry point for all JavaFX applications. The start
     * method is called after the init method has returned, and
     * after the system is ready for the application to begin running.
     *
     * The JavaFX Stage class is the top level JavaFX container.
     * The primary Stage is constructed by the platform. Additional
     * Stage objects may be constructed by the application.
     * @param primaryStage the primary stage for this application,
     *        onto which the application scene can be set. Applications
     *        may create other stages, if needed, but they will not be
     *        primary stages
     *
     * See also method 'start(Stage primaryStage)' of class javafx.application.Application.
     */
    @Override
    public void start(Stage primaryStage) {
      primaryStage.setTitle("My first javafx app");
      primaryStage.setOnCloseRequest((event) -> System.out.println("Closing on request"));

      initUI(primaryStage);

      primaryStage.centerOnScreen();
      primaryStage.show();

    }//end of method start

    /**
     * Method stop.
     * This method is called when the application should stop, and
     * provides a convenient place to prepare for application exit
     * and destroy resources.
     *
     * We could have some clean up code here.
     *
     * See also method 'stop()' of class javafx.application.Application.
     */
    @Override
    public void stop() throws Exception {

        System.out.println(closingMsg);
        // Causes the JavaFX application to terminate.
        Platform.exit();
    }//end of method stop

    /**
     * main
     * @param args - the command line arguments passed to the
     * application. An application may get these parameters
     * using the 'Application.getParameters()' method and may
     * be called in the init() method or any time after that.
     */
    public static void main(final String[] args) {
    //public static void main(String[] args) {
        Locale.setDefault(Locale.UK);
        Application.launch(args);
    }//end of main

}//end of class

