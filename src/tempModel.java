import java.util.Observable;

/**
 * @author Franziska Kissel
 * @author Daniel Speck
 * @author Fabian Behrendt
 * @author Philipp Liebe
 */
public class tempModel extends Observable{
    private int celsius;
    private int fahrenheit;

    public tempModel(){
        celsius = -40;
        fahrenheit = -40;
    }

    public void changeCelsius(int f){
        fahrenheit = f;
        celsius = (int) Math.round((fahrenheit - 32) * 5/9);
        setChanged();
        notifyObservers();
    }

    public void changeFahrenheit(int c){
        celsius = c;
        fahrenheit = (int) Math.round((celsius * 1.8 + 32));
        setChanged();
        notifyObservers();
    }

    public int getCelsius(){
        return celsius;
    }

    public int getFahrenheit(){
        return fahrenheit;
    }

}
