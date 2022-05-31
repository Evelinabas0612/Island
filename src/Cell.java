import Animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cell {

    private int height;
    private int width;
    private Map <String, List<Object>> map;
    private List <Animal> mapOfMove = new ArrayList<>();

    public Map<String, List<Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Object>> map) {
        this.map = map;
    }

    public List<Animal> getMapOfMove() {
        return mapOfMove;
    }

    public void setMapOfMove(List<Animal> mapOfMove) {
        this.mapOfMove = mapOfMove;
    }

    public Cell(int height, int width) {
    }

    public Cell() {

    }



    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
