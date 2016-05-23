import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Franziska Kissel
 * @author Daniel Speck
 * @author Fabian Behrendt
 * @author Philipp Liebe
 */
class tempController implements ChangeListener, ActionListener{
    private tempView view;
    private tempModel model;
    private int celsius;
    private int fahrenheit;


    public tempController(){
        view = new tempView(this);
        model = new tempModel();
        model.addObserver(view);
        addListeners();
    }

    private void addListeners(){
        view.addAcListener(e -> {
            switch(e.getActionCommand()){
                case "convert to Celsius":
                    fahrenheit = view.getFahrenheitText();
                    model.changeCelsius(fahrenheit);
                    break;
                case "convert to Fahrenheit":
                    celsius = view.getCelsiusText();
                    model.changeFahrenheit(celsius);
                    break;
            }
        });
        view.addChListener(e -> {
            if(!view.getAdjustFahrenheit()) {
                fahrenheit = view.getFahrenheitSlider();
                model.changeCelsius(fahrenheit);
            }
        }, a -> {
            if(!view.getAdjustCelsius()) {
                celsius = view.getCelsiusSlider();
                model.changeFahrenheit(celsius);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {

    }

    public void stateChanged(ChangeEvent e)
    {

    }
}
