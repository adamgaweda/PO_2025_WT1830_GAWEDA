package agh.ics.oop.presenter;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;

    @FXML
    private Label infoLabel;
    @FXML
    private Canvas mapCanvas;


    private GraphicsContext gc;
    @FXML
    private void initialize(){
        if(mapCanvas != null)gc=mapCanvas.getGraphicsContext2D();
    }

    public void setWorldMap(WorldMap map){
        this.worldMap = map;
    }

    public void drawMap(){

    }

    public void resume(){
        if(mapCanvas != null && gc == null)gc=mapCanvas.getGraphicsContext2D();
    }

    public void mapChanged(WorldMap worldMap,String message){
        drawMap();
    }
}
