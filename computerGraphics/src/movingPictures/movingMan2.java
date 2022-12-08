package movingPictures;

import Textures.AnimListener;
import Textures.TextureReader;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.*;

import java.util.BitSet;
import javax.media.opengl.glu.GLU;

public class movingMan2 extends AnimListener {

    int animationIndex = 0, animationIndexBullet = 0;
    int maxWidth = 100;
    int maxHeight = 100;
    int x = maxWidth / 2, y = maxHeight / 2, xBullet = 0, yBullet = 0;

    boolean up = false, down = false, right = false, left = false, upR = false, upL = false, downR = false, downL = false,
            fired = false;
    ArrayList<Integer> clicked = new ArrayList<Integer>();
    String textureNames[] = {"Man1.png", "Man2.png", "Man3.png", "Man4.png",
        "Man1_down.png", "Man2_down.png", "Man3_down.png", "Man4_down.png",
        "Man1_right.png", "Man2_right.png", "Man3_right.png", "Man4_right.png",
        "Man1_left.png", "Man2_left.png", "Man3_left.png", "Man4_left.png",
        "Man1_topleft.png", "Man2_topleft.png", "Man3_topleft.png", "Man4_topleft.png",
        "Man1_topright.png", "Man2_topright.png", "Man3_topright.png", "Man4_topright.png",
        "Man1_downleft.png", "Man2_downleft.png", "Man3_downleft.png", "Man4_downleft.png",
        "Man1_downright.png", "Man2_downright.png", "Man3_downright.png", "Man4_downright.png",
        "Back.png"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
    String bullet = "bullet.png";
    TextureReader.Texture textureBullet;
    int textureIndex[] = new int[1];

    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        gl.glGenTextures(textureNames.length, textures, 0);
        gl.glGenTextures(1, textureIndex, 0);

        try {
            textureBullet = TextureReader.readTexture(assetsFolderName + "//" + bullet, true);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);

//          mipmapsFromPNG(gl, new GLU(), texture[i]);
            new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, // Internal Texel Format,
                    textureBullet.getWidth(), textureBullet.getHeight(),
                    GL.GL_RGBA, // External format from image,
                    GL.GL_UNSIGNED_BYTE,
                    textureBullet.getPixels() // Imagedata
            );
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels()
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        DrawBackground(gl);
        handleKeyPress();

        if (up) {
            animationIndex = animationIndex % 4;

        } else if (down) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 4;

        } else if (right) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 8;
        } else if (left) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 12;
        } else if (upL) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 16;
        } else if (upR) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 20;
        }
        else if (downL) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 24;
        }
        else if (downR) {
            animationIndex = animationIndex % 4;
            animationIndex = animationIndex + 28;
        }
        DrawSprite(gl, x, y, animationIndex, 1);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void DrawSprite(GL gl, int x, int y, int index, float scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);

        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.1 * scale, 0.1 * scale, 1);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void DrawBullet(GL gl, int x, int y, int index, float scale) {
        gl.glEnable(GL.GL_BLEND);	// Turn Blending On
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);

        //gl.glColor3f(0, 0, 0);
        gl.glPushMatrix();

        gl.glScaled(0.02 * scale, 0.02 * scale, 1);
        //System.out.println(x +" " + y);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void DrawBackground(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[textureNames.length - 1]);

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void handleKeyPress() {
        if (isKeyPressed(KeyEvent.VK_UP) && isKeyPressed(KeyEvent.VK_LEFT)) {
            if (x > 0) {
                x--;
            }
            if (y < maxHeight - 10) {
                y++;
            }
            animationIndex++;
            upL = true;
            upR = false;
            downL = false;
            downR = false;
            left = false;
            right = false;
            up = false;
            down = false;

        } else if (isKeyPressed(KeyEvent.VK_UP) && isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (x < maxWidth - 10) {
                x++;
            }
            if (y < maxHeight - 10) {
                y++;
            }
            animationIndex++;
            upR = true;
            upL = false;
            downL = false;
            downR = false;
            left = false;
            right = false;
            up = false;
            down = false;
        } else if (isKeyPressed(KeyEvent.VK_DOWN) && isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (y > 0) {
                y--;
            }
            if (x < maxWidth - 10) {
                x++;
            }
            animationIndex++;
            upR = false;
            upL = false;
            downL = false;
            downR = true;
            left = false;
            right = false;
            up = false;
            down = false;
        } else if (isKeyPressed(KeyEvent.VK_DOWN) && isKeyPressed(KeyEvent.VK_LEFT)) {
            if (y > 0) {
                y--;
            }
            if (x > 0) {
                x--;
            }
            animationIndex++;
            upR = false;
            upL = false;
            downL = true;
            downR = false;
            left = false;
            right = false;
            up = false;
            down = false;
        } else {
            if (isKeyPressed(KeyEvent.VK_LEFT)) {
                if (x > 0) {
                    x--;
                }
                animationIndex++;
                left = true;
                right = false;
                up = false;
                down = false;
            }
            if (isKeyPressed(KeyEvent.VK_RIGHT)) {
                if (x < maxWidth - 10) {
                    x++;
                }

                animationIndex++;
                right = true;
                up = false;
                down = false;
                left = false;
            }
            if (isKeyPressed(KeyEvent.VK_DOWN)) {
                if (y > 0) {
                    y--;
                }
                animationIndex++;
                down = true;
                up = false;
                right = false;
                left = false;

            }
            if (isKeyPressed(KeyEvent.VK_UP)) {
                if (y < maxHeight - 10) {
                    y++;
                }
                animationIndex++;
                up = true;
                down = false;
                right = false;
                left = false;
            }
            if (isKeyPressed(KeyEvent.VK_SPACE)) {
                fired = true;
            }

        }

    }

    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
        if (event.getKeyCode() == KeyEvent.VK_UP
                || event.getKeyCode() == KeyEvent.VK_DOWN
                || event.getKeyCode() == KeyEvent.VK_RIGHT
                || event.getKeyCode() == KeyEvent.VK_LEFT
                || event.getKeyCode() == KeyEvent.VK_UP) {
            clicked.add(event.getKeyCode());
        }
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
        switch (event.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                clicked.remove(0);
                break;
            case KeyEvent.VK_DOWN:
                clicked.remove(0);
                break;
            case KeyEvent.VK_UP:
                clicked.remove(0);
                break;
            case KeyEvent.VK_LEFT:
                clicked.remove(0);
                break;
        }
    }

    @Override
    public void keyTyped(final KeyEvent event) {

    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

    public static void main(String[] args) {
        new Anim(new movingMan2());
    }
}
