import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Franziska Kissel
 * @author Daniel Speck
 * @author Fabian Behrendt
 * @author Philipp Liebe
 */
public class tempView extends JFrame implements Observer {
    private JFrame content;
    private Container container;

    private JSlider slider_fahrenheit;
    private JSlider slider_celsius;

    private JButton convert_fahrenheit;
    private JButton convert_celsius;

    private JLabel fahrenheit;
    private JLabel celsius;

    private JTextField input_fahrenheit;
    private JTextField input_celsius;

    public tempView(){
        //Das Hauptfenster erzeugen
        content = new JFrame("Temperature Converter");
        container = getContentPane();

        //Slider erzeugen
        slider_fahrenheit = new JSlider(-40, 212,-40);
        slider_celsius = new JSlider(-40, 100,-40);

        slider_fahrenheit.setOrientation(JSlider.VERTICAL);
        slider_celsius.setOrientation(JSlider.VERTICAL);

        slider_fahrenheit.setMajorTickSpacing(40);
        slider_fahrenheit.setMinorTickSpacing(10);
        slider_celsius.setMajorTickSpacing(20);
        slider_celsius.setMinorTickSpacing(5);

        slider_fahrenheit.setPaintLabels(true);
        slider_celsius.setPaintLabels(true);
        slider_fahrenheit.setPaintTicks(true);
        slider_celsius.setPaintTicks(true);

        //Buttons erzeugen
        convert_fahrenheit = new JButton("convert to Celsius");
        convert_celsius = new JButton("convert to fahrenheit");

        //Label erzeugen
        fahrenheit = new JLabel("Fahrenheit");
        celsius = new JLabel("Celsius");

        //Textfelder erezeugen
        input_fahrenheit = new JTextField("-40");
        input_celsius = new JTextField("-40");


        GridLayout ourLayout = new GridLayout(3,2);
        ourLayout.setHgap(40);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel center = new JPanel(ourLayout);
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        left.add(slider_fahrenheit);
        right.add(slider_celsius);

        center.add(input_fahrenheit);
        center.add(input_celsius);
        center.add(fahrenheit);
        center.add(celsius);
        center.add(convert_fahrenheit);
        center.add(convert_celsius);

        content.setLayout(new BorderLayout(20,20));
        content.add(right, BorderLayout.EAST);
        content.add(left, BorderLayout.WEST);
        content.add(center, BorderLayout.CENTER);
        content.add(top, BorderLayout.NORTH);
        content.add(bottom, BorderLayout.SOUTH);

        center.setBorder(new EmptyBorder(5,0,5,0));

        content.pack();
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setVisible(true);
    }

    public void update(Observable o, Object arg) {

    }
}