package computergraphics;
/*TASK2(star/paragonal)*/
import java.awt.Color;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

class SimpleGLEventListener implements GLEventListener {

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 10, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-300, 300.0, -150, 150.0, -1.0, 1.0);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POLYGON);
        drawPantagon(gl,50,5,new Color(100,0,0),-200);
        drawCircle(gl, 50,new Color(0,100,0));
        drawStar(gl,50,5,new Color(0,0,100));
        drawPantagon(gl,50,8,new Color(100,0,0),200);
        gl.glPointSize(33.0f);
        gl.glEnd();

    }

    void drawStar(GL gl, int r, int n, Color c) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < (n - 1) * 360; i += 2 * (360 / n)) {
            gl.glVertex2i((int) (r * Math.cos(Math.toRadians(i+90))), (int) (r * Math.sin(Math.toRadians(i+90))));
        }
        gl.glEnd();

    }

    void drawPantagon(GL gl, int r, int n, Color c, int x) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i <  360; i += (360 / n)) {
            gl.glVertex2i((int) (r * Math.cos(Math.toRadians(i+90)))+x, (int) (r * Math.sin(Math.toRadians(i+90))));
        }
        gl.glEnd();
    }

    void drawCircle(GL gl, int r, Color c) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            gl.glVertex2i((int) (r * Math.cos(Math.toRadians(i))), (int) (r * Math.sin(Math.toRadians(i))));
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
