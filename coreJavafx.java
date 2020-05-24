import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.application.Platform;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
//
// Additional import statements below this line
//
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.text.Font;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.file.OpenOption;
import java.nio.charset.Charset;
import java.io.IOException;
/**
 * <p>A learning file to practice my JavaFX.</p>
 *
 *-------------------------------------------------
 *
 * JDK 14 Documentation
 * https://docs.oracle.com/en/java/javase/14/
 *
 * JavaFX API docs
 * https://openjfx.io/javadoc/14/
 *
 * Introduction to FXML
 * This document introduces the FXML markup language and explains
 * how it can be used to simplify development of JavaFX applications.
 * http://docs.oracle.com/javase/8/javafx/api/javafx/fxml/doc-files/introduction_to_fxml.html#attributes
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
 * @version (#)coreJavafx.java        1.04 2020-05-23T17:11:02
 * Keywords: javafx java
 */
public class coreJavafx extends Application {
private static String closingMsg;

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
     *
     * See also method 'start(Stage primaryStage)' of class javafx.application.Application.
     */
    @Override
    public void start(Stage primaryStage) {
    primaryStage.setTitle("My first javafx app");
    primaryStage.setOnCloseRequest((event) -> System.out.println("Closing on request"));

    //root - The root node (parent) of the scene graph
    //width - The width of the scene (double)
    //height - The height of the scene (double)
    Scene sce = new Scene(lbl, 400.0, 200.0);

    primaryStage.setScene(sce);
    primaryStage.show();

List<String> fontlist = new ArrayList<String>();
fontlist = Font.getFamilies();
// Create an output file to write the font names to
Path ian = FileSystems.getDefault().getPath("C:\\Gash", "ian.ian");
Charset ascii = StandardCharsets.US_ASCII;
OpenOption[] myoptions =
    new OpenOption[] {StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING};

try (BufferedWriter buffrite = Files.newBufferedWriter(ian, ascii, myoptions);) {

for (String item : fontlist) {
    System.out.println(item);
    buffrite.write(item, 0, item.length());
    buffrite.newLine();
}

} catch (IOException e) {
  e.printStackTrace();
}

    System.out.println("end of script");
    LocalTime tt = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    System.out.printf("%s%n", tt);

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

