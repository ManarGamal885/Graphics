package smileFace;

/*TASK2*/
import java.awt.Color;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

class SimpleGLEventListeneFaces implements GLEventListener {

    double t = -80;
    int angle1 = 0;
    int angle2 = 0;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1600, 1000.0, -1600, 1000.0, -1.0, 1.0);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        
        /*FACE 1*/
        gl.glPushMatrix();
        gl.glTranslated(-1000, -350, 0);
        //face 
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);
        drawPantagon(gl, 500, 360, Color.YELLOW, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);
        drawPantagon(gl, 500, 360, Color.BLACK, 0, GL.GL_LINE_LOOP, 0, false);
        gl.glPopMatrix();
        //e1
        gl.glPushMatrix();
        gl.glTranslated(-250, 100, 0);
        drawPantagon(gl, 150, 360, Color.WHITE, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();
        //n1
        gl.glPushMatrix();
        gl.glTranslated(-250, 100, 0);
        gl.glRotated(angle1, 0, 0, 1);
        gl.glTranslated(90, 0, 0);

        drawPantagon(gl, 60, 360, Color.BLACK, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();
        angle1++;

        gl.glPushMatrix();
        gl.glTranslated(-250, 100, 0);
        drawPantagon(gl, 150, 360, Color.BLACK, 0, GL.GL_LINE_LOOP, 0, false);
        gl.glPopMatrix();
        //e2
        gl.glPushMatrix();
        gl.glTranslated(250, 100, 0);
        drawPantagon(gl, 150, 360, Color.WHITE, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(250, 100, 0);
        drawPantagon(gl, 150, 360, Color.BLACK, 0, GL.GL_LINE_LOOP, 0, false);
        gl.glPopMatrix();
        //n2
        gl.glPushMatrix();
        gl.glTranslated(250, 100, 0);
        gl.glRotated(angle2, 0, 0, 1);
        gl.glTranslated(-90, 0, 0);

        drawPantagon(gl, 60, 360, Color.BLACK, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();
        angle2--;
        //mouth
        gl.glPushMatrix();
        gl.glTranslated(0, -200, 0);
        drawPantagon(gl, 160, 360, Color.BLACK, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();
        //tong
        gl.glPushMatrix();
        gl.glTranslated(0, -200, 0);
        drawPantagon(gl, 160, 180, Color.PINK, 0, GL.GL_POLYGON, 180, false);
        gl.glPopMatrix();

        gl.glPopMatrix();

        /*FACE 2*/
        gl.glPushMatrix();
        gl.glTranslated(400, -350, 0);
        //face 
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);
        drawPantagon(gl, 500, 360, Color.YELLOW, 0, GL.GL_POLYGON, 0, false);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);
        drawPantagon(gl, 500, 360, Color.BLACK, 0, GL.GL_LINE_LOOP, 0, false);
        gl.glPopMatrix();
        
        //e1
        gl.glPushMatrix();
        gl.glTranslated(-250, 130, 0);
        gl.glRotated(angle1, 0, 0, 1);
        for (int i = 0; i <= 250; i++) {
            drawStar(gl, i, new Color(1f, 0f, 0f, 1f), 5, 0, 2);
        }
        gl.glPopMatrix();
        angle1++;
        //e2
        gl.glPushMatrix();
        gl.glTranslated(250, 130, 0);
        gl.glRotated(angle2, 0, 0, 1);
        for (int i = 0; i <= 250; i++) {
            drawStar(gl, i, new Color(1f, 0f, 0f, 1f), 5, 0, 2);
        }
        gl.glPopMatrix();
        angle2--;
        //mouth
        gl.glPushMatrix();
        gl.glTranslated(0, -150, 0);
        drawPantagon(gl, 250, 360, Color.BLACK, 0, GL.GL_POLYGON, 180, false);
        gl.glPopMatrix();

        gl.glPopMatrix();
    }

    void drawStar(GL gl, int r, Color c, double sides, double startAngle, int step) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (double i = startAngle; i < 360 * step + startAngle; i += step * 360.0 / sides) {
            gl.glVertex2d(r * Math.cos(Math.toRadians(i)), r * Math.sin(Math.toRadians(i)));
        }
        gl.glEnd();
    }

    void drawPantagon(GL gl, int r, int n, Color c, double ang, int filled, int start, boolean flag) {
        gl.glColor3fv(c.getColorComponents(null), 0);
        gl.glBegin(filled);
        for (int i = start; i < 360; i += (360 / n)) {
            gl.glVertex2i((int) (r * Math.cos(Math.toRadians(i + ang))), (int) (r * Math.sin(Math.toRadians(i + ang))));
            if (flag) {
                gl.glColor3f(0, 0, 1);
            }
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
