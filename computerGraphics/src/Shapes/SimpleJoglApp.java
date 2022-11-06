package computergraphics;
import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
import javax.swing.*;
import javax.media.opengl.*;
public class SimpleJoglApp extends JFrame {
    private GLCanvas glcanvas;
    static FPSAnimator animator = null;
    
    public static void main(String[] args) {
        new SimpleJoglApp();
        animator.start();
    }
    
    public SimpleJoglApp() {
        super("Simple JOGL Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new SimpleGLEventListener());
        animator = new FPSAnimator(glcanvas,60);
        
        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        setLocationRelativeTo(this);
        setVisible(true);
        
    }

    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }

        this.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}
