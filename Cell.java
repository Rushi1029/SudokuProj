import java.util.ArrayList;
public class Cell {
    private int cellNum;
    private int value;
    private ArrayList<Integer> pencilMarks;

    public Cell(int cNum, int val) {
        cellNum = cNum;
        value = val;
        pencilMarks = new ArrayList<>();
    }

    public int getValue() {
       return value;
    }
    
    public void setValue(int val) {
        value = val;
    }

    public int getCellNum() {
        return cellNum;
    }
    
    public void addPencilMark(int num) {
        pencilMarks.add(num);
    }

    public ArrayList<Integer> getPencilMarks() {
        return pencilMarks;
    }
    
    public void clearPencilMarks() {
        pencilMarks = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (value == 0) {
            return " ";
        }
        return "" + value;
    }


}
