package Tasks;

import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.media.opengl.*;
import javax.swing.*;

public class KeyListner extends JFrame {

    static GLCanvas glcanvas;
    static FPSAnimator animator = null;

    public static void main(String[] args) {
        final KeyListner app = new KeyListner();
        animator.start();
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() {
                app.setVisible(true);
                glcanvas.requestFocusInWindow();
            }
        }
        );
    }

    public KeyListner() {
        super("KeyListener Task1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyDisplay kd = new KeyDisplay();
        GLCapabilities glcaps = new GLCapabilities();

        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(kd);
        glcanvas.addKeyListener(kd);
        animator = new FPSAnimator(glcanvas, 60);

        add(glcanvas, BorderLayout.CENTER);
        kd.setGLCanvas(glcanvas);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(800, 800);
        centerWindow(this);
        setVisible(true);
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

class KeyDisplay implements GLEventListener, KeyListener {

    ArrayList<Integer> buttonsChar = new ArrayList<Integer>();
    boolean upRight = false, upLeft = false, downRight = false, downLeft = false, up = false, down = false, right = false, left = false;
    boolean directionU = false, directionD = false, directionR = false, directionL = false;
    boolean directionUR = false, directionUL = false, directionDR = false, directionDL = false;
    boolean r1 = false, r2 = false, r3 = false, r4 = false;
    int xPosition = 0;
    int yPosition = 70;
    float red = 0.0f;
    float green = 0.0f;
    float blue = 1.0f;
    int angle = 0;
    GLCanvas glc;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        red = 0.0f;
        green = 0.0f;
        blue = 0.0f;
        gl.glClearColor(red, green, blue, 1.0f);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-800, 800.0, -800, 800.0, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPushMatrix();
//        gl.glTranslated(0, 70, 0);
        System.out.println(up);
        System.out.println(yPosition + " " + xPosition);

        if (up) {
            if (yPosition == 370) {
                directionU = true;
            }

            if (yPosition != 370 && !directionU) {
                gl.glTranslated(xPosition, yPosition, 0);
                yPosition += 5;
            } else if (yPosition != 70 && directionU) {
                gl.glTranslated(xPosition, yPosition, 0);
                yPosition -= 5;
            }
        } else if (down) {
            if (yPosition == -370) {
                directionD = true;
            }

            if (yPosition != -370 && !directionD) {
                gl.glTranslated(xPosition, yPosition, 0);
                yPosition -= 5;
            } else if (yPosition != 70 && directionD) {
                gl.glTranslated(xPosition, yPosition, 0);
                yPosition += 5;
            }
        } else if (right) {
            if (xPosition == 370) {
                directionR = true;
            }
            if (xPosition != 370 && !directionR) {
                gl.glTranslated(xPosition, yPosition, 0);
                xPosition += 5;
            } else if (xPosition != 0 && directionR) {
                gl.glTranslated(xPosition, yPosition, 0);
                xPosition -= 5;
            }
        } else if (left) {
            if (xPosition == -370) {
                directionL = true;
            }
            if (xPosition != -370 && !directionL) {
                gl.glTranslated(xPosition, yPosition, 0);
                xPosition -= 5;
            } else if (xPosition != 0 && directionL) {
                gl.glTranslated(xPosition, yPosition, 0);
                xPosition += 5;
            }
        }
        if (upRight) {
            if (yPosition == 370) {
                directionUR = true;
            }

            if (yPosition != 370 && !directionUR) {
                gl.glTranslated(xPosition, yPosition, 0);
                yPosition += 5;
                xPosition += 3;
            } else if (yPosition != 70 && directionUR) {
                gl.glTranslated(xPosition, yPosition, 0);
                yPosition -= 5;
                xPosition -= 3;
                System.out.println(yPosition + " " + xPosition);
            }
        }

        drawPantagon(gl, 70, 360, Color.YELLOW, 0);
        gl.glPopMatrix();
        drawLine(gl, -800, 0, 800, 0, Color.BLUE);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int i, int i1, int i2, int i3) {
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean bln, boolean bln1) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP
                || e.getKeyCode() == KeyEvent.VK_DOWN
                || e.getKeyCode() == KeyEvent.VK_RIGHT
                || e.getKeyCode() == KeyEvent.VK_LEFT
                || e.getKeyCode() == KeyEvent.VK_UP) {
            buttonsChar.add(e.getKeyCode());
        }
        if (buttonsChar.size() == 1) {
            switch (buttonsChar.get(0)) {
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_ALT:
                    upRight = true;
                    break;
            }
        } else if (buttonsChar.size() == 2) {
            if (buttonsChar.get(0) == KeyEvent.VK_UP && buttonsChar.get(1) == KeyEvent.VK_RIGHT) {
                upRight = true;
            } else if (buttonsChar.get(0) == KeyEvent.VK_UP && buttonsChar.get(1) == KeyEvent.VK_LEFT) {
                upLeft = true;
            } else if (buttonsChar.get(0) == KeyEvent.VK_DOWN && buttonsChar.get(1) == KeyEvent.VK_RIGHT) {
                downRight = true;
            } else if (buttonsChar.get(0) == KeyEvent.VK_DOWN && buttonsChar.get(1) == KeyEvent.VK_LEFT) {
                downLeft = true;
            }
        }
        glc.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                buttonsChar.remove(0);
                break;
            case KeyEvent.VK_DOWN:
                buttonsChar.remove(0);
                break;
            case KeyEvent.VK_RIGHT:
                buttonsChar.remove(0);
                break;
            case KeyEvent.VK_LEFT:
                buttonsChar.remove(0);
                break;
        }
        System.out.println(buttonsChar.size());
        glc.repaint();
    }

    void drawPantagon(GL gl, int r, int n, Color c,
            double ang
    ) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i += (360 / n)) {
            gl.glVertex2i((int) (r * Math.cos(Math.toRadians(i + ang))), (int) (r * Math.sin(Math.toRadians(i + ang))));
        }
        gl.glEnd();
    }

    void drawLine(GL gl, int x1, int y1, int x2, int y2, Color c
    ) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex3f(x1, y1, 0);
        gl.glVertex3f(x2, y2, 0);
        gl.glEnd();
    }

}
