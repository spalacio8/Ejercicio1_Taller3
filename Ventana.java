import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author josep
 */
public class Ventana extends JFrame {
    private Logic log;
    private Container cont;
    private JTextArea areaOne;
    private JScrollPane scroll;

    
    public Ventana( String answer){
        super("Window");
        
        log = new Logic();
        cont = getContentPane();
        
        areaOne = new JTextArea();
        areaOne.setEditable(false);
        areaOne.setForeground(Color.BLACK);
        areaOne.setText(answer);

        scroll = new JScrollPane(areaOne);
        
        JPanel pane = new JPanel( new GridLayout (1, 1) );
        
        pane.add(scroll);
        
        cont.add(pane);
        setSize(600, 300);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    
    
}
