package computergraphics;

/*TASK2*/
import java.awt.Color;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

class SimpleGLEventListener implements GLEventListener {

    double t = -80;
    int angle = 0;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-300, 300.0, -150, 150.0, -1.0, 1.0);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        /*star rotating in the middle*/
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);
        gl.glRotated(angle, 0, 0, 1);
        drawStar(gl, 70, new Color(1f, 0f, 0f, 1f), 5, 0, 2);
        gl.glPopMatrix();
        angle += 5;

        /*ball scalling */
        gl.glPushMatrix();
        gl.glTranslated(-210, 0, 0);
        gl.glRotated(angle, 0, 0, 0);
        drawPantagon(gl, 70, 360, new Color(0f, 1f, 0f, 1f), 0);
        gl.glPopMatrix();
        angle += 5;

        /*moving Pantagon*/
        if (t >= 80) {
            t=-1.1*t;
            gl.glPushMatrix();
            gl.glTranslated(210, t, 0);
            drawPantagon(gl, 70, 5, new Color(0f, 0f, 1f, 1f), 90);
            gl.glPopMatrix();
            
             
        } else {
            gl.glPushMatrix();
            gl.glTranslated(210, t, 0);
            drawPantagon(gl, 70, 5, new Color(0f, 0f, 1f, 1f), 90);
            gl.glPopMatrix();
            t++;
        }

    }

    void drawStar(GL gl, int r, Color c, double sides, double startAngle, int step) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (double i = startAngle; i < 360 * step + startAngle; i += step * 360.0 / sides) {
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        }
        gl.glEnd();
    }

    void drawPantagon(GL gl, int r, int n, Color c, double ang) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < 360; i += (360 / n)) {
            gl.glVertex2i((int) (r * Math.cos(Math.toRadians(i + ang))), (int) (r * Math.sin(Math.toRadians(i + ang))));
        }
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

    }

    public void dispose(GLAutoDrawable arg0) {
    }

}
