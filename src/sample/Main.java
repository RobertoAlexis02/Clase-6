package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Main extends Application {
    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2,menCerrar;
    private MenuItem mitCalcu,mitSalir;
    private Scene escena;


    @Override
    public void start(Stage primaryStage) throws Exception{
        CrearMenu();
        primaryStage.setTitle("Proyecto Clase TAP 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void CrearMenu(){
        vBox = new VBox();

        mnbPrincipal = new MenuBar();
        menCompetencia1 = new Menu ("Competencia 1");
        menCompetencia2 = new Menu ("Competencia 2");
        menCerrar       = new Menu("Cerrar");
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2,menCerrar);

        mitCalcu = new MenuItem("Calculadora");
        menCompetencia1.getItems().add(mitCalcu);

        mitSalir = new MenuItem("Salir");
        mitSalir.setOnAction(event -> {System.exit(0);});
        menCerrar.getItems().add(mitSalir);

        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox,300,70);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
