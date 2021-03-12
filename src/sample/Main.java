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
import sample.views.Calculadora;
import sample.views.Rompecabezas;


public class Main extends Application {
    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2,menCerrar;
    private MenuItem mitCalcu,mitSalir,mitRompecabezas;
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
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        mitRompecabezas = new MenuItem("Rompecabezas");
        mitRompecabezas.setOnAction(event -> opcionesMenu(2));
        menCompetencia1.getItems().addAll(mitCalcu,mitRompecabezas);

        mitSalir = new MenuItem("Salir");
        mitSalir.setOnAction(event -> {System.exit(0);});
        menCerrar.getItems().add(mitSalir);

        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox,300,70);
    }

    private void opcionesMenu(int opc) {
        switch(opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
