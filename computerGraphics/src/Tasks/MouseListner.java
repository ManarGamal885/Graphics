package Tasks;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.media.opengl.*;
import javax.swing.*;

public class MouseListner extends JFrame {

    static GLCanvas glcanvas = null;

    public static void main(String[] args) {
        final MouseListner app = new MouseListner();
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                app.setVisible(true);
            }
        }
        );
    }

    public MouseListner() {
        super("KeyListener Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MouseDisplay md = new MouseDisplay();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(md);
        glcanvas.addMouseListener(md);
        md.setGLCanvas(glcanvas);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
        centerWindow(this);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}

class MouseDisplay implements GLEventListener, MouseListener {

    ArrayList<Integer> xAxis = new ArrayList<Integer>();
    ArrayList<Integer> yAxis = new ArrayList<Integer>();
    int xPosition = 50;
    int yPosition = 50;
    float red = 0.0f;
    float green = 0.5f;
    float blue = 0.5f;
    GLCanvas glc;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(1, 1, 1, 1);
        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 100, 0, 100, -1, 1);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(10.0f);
        gl.glColor3f(0, 0, 0);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2i(xPosition, yPosition);
        gl.glEnd();
        for (int i = 0; i < yAxis.size() - 1; i += 2) {
            gl.glColor3f(0, 0, 1);
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2i(xAxis.get(i), yAxis.get(i));
            gl.glVertex2i(xAxis.get(i + 1), yAxis.get(i + 1));
            gl.glEnd();
            gl.glColor3i(0, 0, 0);
            gl.glBegin(GL.GL_LINES);
            gl.glVertex3d(xAxis.get(i), yAxis.get(i), 0);
            gl.glVertex3d(xAxis.get(i + 1), yAxis.get(i + 1), 0);
            gl.glEnd();
        }

    }

    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        System.out.println(x + " " + y);
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        System.out.println(width + " " + height);
        xPosition = (int) ((x / width) * 100);
        yPosition = ((int) ((y / height) * 100));
        yPosition = 100 - yPosition;
        xAxis.add(xPosition);
        yAxis.add(yPosition);
        glc.repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}
