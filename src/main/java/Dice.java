import java.util.Random;

public class Dice {
    private static final int MIN = 1;
    private static final  int MAX = 6;
    private int value = 1;
    private Random rdm = new Random();

    public Dice(){}

    //Roll an integer between min and max
    public void roll() {
        int v = rdm.nextInt();
        if(v<0) v=-v;
        value = v % MAX + MIN;
    }

    public int getValue() {
        return value;
    }
}
