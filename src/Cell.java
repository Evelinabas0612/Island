import java.util.List;
import java.util.Map;

public class Cell {

    private int height;
    private int width;
    private Map<String, List<Object>> map;

    public Map<String, List<Object>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Object>> map) {
        this.map = map;
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
