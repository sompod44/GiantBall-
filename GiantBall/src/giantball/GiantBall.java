package giantball;

import javax.swing.JFrame;

/**
 *
 * @author Sompod_Programmer
 */
public class GiantBall extends JFrame{  

    public static int Width = 800;
    public static int Height = 600;
    
    public GiantBall() { // this is constractor of GiantBall class
        setContentPane(new PaintBallPanel()); // here set the PaintBallpanel into Jframe 
        setTitle("GiantBall by sompod"); // here we set tile of our jframe 
        setSize(Width, Height); // here we set our Jframe size
        setVisible(true); // for this method we can see our jframe
        setResizable(false); // for this method we cann't resize our jframe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // for this method we turminated our program. When we click into cross button
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // this is main method that call when program run in first time
        new GiantBall(); // Here creating object of GiantBall
    }
    
}
