package computergraphics;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to 
 * reuse this code or modify it.
 */
public class SimpleJoglApp extends JFrame {
public static void main(String[] args) {
    final SimpleJoglApp app = new SimpleJoglApp();

    // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
  }

  public SimpleJoglApp() {
    //set the JFrame title
    super("Simple JOGL Application");

    //kill the process when the JFrame is closed
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //only three JOGL lines of code ... and here they are 
    GLCanvas glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(new SimpleGLEventListener());
    
    // add the GLCanvas just like we would	 any Component
    add(glcanvas, BorderLayout.CENTER);
    setSize(500, 300);

    //center the JFrame on the screen
    centerWindow();
    setVisible(true);
  }
  public void centerWindow() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize  = this.getSize();

    if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
    if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;

    this.setLocation (
      (screenSize.width  - frameSize.width ) >> 1, 
      (screenSize.height - frameSize.height) >> 1
    );
  }
}

