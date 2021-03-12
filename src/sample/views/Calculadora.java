
package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage implements EventHandler {
    //Toda declaraacion va en esta parte
    private Scene escena;
    private TextField txtOperation;
    private HBox[] hBoxes;
    private Button[] arBotones;
    private VBox vBox;
    private char[] arNumeros = {'7','8','9','/','4','5','6','*','1','2','3','+','0','.','=','-'}; //Char contiene un solo caracter


    public Calculadora() {
        CrearUI();
        this.setTitle("Calculadora");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[4];
        arBotones = new Button[16]; // aqui se instancia
        txtOperation = new TextField();
        txtOperation.setEditable(false);
        txtOperation.setPrefHeight(50); //Para hacer mas grande la caja de texto
        txtOperation.setText("0"); // Agraga texto
        txtOperation.setAlignment(Pos.BASELINE_RIGHT); //Alinea el texto a la derecha


        int pos=0; //Auxiliar
        for (int i = 0; i < hBoxes.length; i++) { //Iterarme sobre arreglo de HBox
            hBoxes[i]= new HBox(); //Instancia anonima
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding(new Insets(5));
            for (int j = 0; j < 4; j++) {//Ciclo para crear y cargar solo 4 botones
                arBotones[pos] = new Button(arNumeros[pos]+"");
                arBotones[pos].addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoCalcu(arNumeros[pos]));
                /*arBotones[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println("Tercer evento");
                    }
                });*/
                arBotones[pos].setPrefSize(50,50);
                hBoxes[i].getChildren().add(arBotones[pos]);//Genera y carga botones
                pos++; //Contador de botones creados
            }
        }
        vBox.getChildren().addAll(txtOperation,hBoxes[0], hBoxes[1],hBoxes[2],hBoxes[3]);
        vBox.setPadding(new Insets(8,5,5,5));//Espaciado
        escena = new Scene(vBox,250,250); //vBox es el elemento padre
    }

    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento :)");

    }
}
class EventoCalcu implements EventHandler{
    char tecla;
    public EventoCalcu(char tecla){
        this.tecla=tecla;
    }
    @Override
    public void handle(Event event) {
        System.out.println(tecla);
    }
}