package task_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Task1 extends JFrame implements KeyListener {

    JLabel lable = new JLabel();
    JTextArea outPut = new JTextArea(10, 10);
    JButton Keyboard[] = {new JButton("A"), new JButton("B"), new JButton("C"), new JButton("D"),
        new JButton("E"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("I"),
        new JButton("J"), new JButton("K"), new JButton("L"), new JButton("M"),
        new JButton("N"), new JButton("O"), new JButton("P"), new JButton("Q"), new JButton("R"),
        new JButton("S"), new JButton("T"), new JButton("U"), new JButton("V"), new JButton("W"),
        new JButton("X"), new JButton("Y"), new JButton("Z")};

    JButton key1[] = {new JButton("~"), new JButton("1"), new JButton("2"), new JButton("3"),
        new JButton("4"), new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"),
        new JButton("9"), new JButton("0"), new JButton("-"), new JButton("="),
        new JButton("Backspace")};

    JButton key2[] = {new JButton("Tab"), new JButton("Q"), new JButton("W"), new JButton("E"), new JButton("R"),
        new JButton("T"), new JButton("Y"), new JButton("U"), new JButton("I"), new JButton("O"),
        new JButton("P"), new JButton("["), new JButton("]"), new JButton("\\")};

    JButton key3[] = {new JButton("CapsLk"), new JButton("A"), new JButton("S"), new JButton("D"), new JButton("F"),
        new JButton("G"), new JButton("H"), new JButton("J"), new JButton("K"), new JButton("L"),
        new JButton(";"), new JButton("'"), new JButton("Enter")};

    JButton key4[] = {new JButton("Shift   "), new JButton("Z"), new JButton("X"), new JButton("C"), new JButton("V"),
        new JButton("B"), new JButton("N"), new JButton("M"), new JButton("<"), new JButton(">"),
        new JButton("/"), new JButton(""), new JButton("^")};

    JButton key5[] = {new JButton("Ctrl"), new JButton("Fn"), new JButton("Alt"), new JButton("                         "
        + "                                        "), new JButton("Alt"),
        new JButton("Ctrl"), new JButton("        "), new JButton("<"), new JButton("v"), new JButton(">")};

    JTextArea keywordOutput;

    public static void main(String[] args) {
        Task1 myFrame = new Task1("CS304_Lab1");
    }

    public Task1(String title) {
        //---------------------------------------------------------

        super();
        setTitle(title);
        setVisible(true);
        setSize(800, 700);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //----------------------------------------------------------
        //adding the text area panel
        JPanel keywordOutput = new JPanel();
        keywordOutput.setLayout(new GridLayout(2, 3, 0, 0));
        JScrollPane scroll = new JScrollPane(outPut);
        keywordOutput.add(scroll);
        keywordOutput.setBorder(new EmptyBorder(60, 10, 0, 10));
        add(keywordOutput, BorderLayout.NORTH);

        //-----------------------------------------------------------
        //adding the keyboard panel
        JPanel k1 = new JPanel();
        for (int i = 0; i < key1.length; i++) {
            k1.add(key1[i]);
        }

        JPanel k2 = new JPanel();
        for (int i = 0; i < key2.length; i++) {
            k2.add(key2[i]);
        }

        JPanel k3 = new JPanel();
        for (int i = 0; i < key3.length; i++) {
            k3.add(key3[i]);
        }

        JPanel k4 = new JPanel();
        for (int i = 0; i < key4.length; i++) {
            k4.add(key4[i]);
        }
        JPanel k5 = new JPanel();
        for (int i = 0; i < key5.length; i++) {
            k5.add(key5[i]);
        }
        JPanel total = new JPanel();
        total.add(k1);
        total.add(k2);
        total.add(k3);
        total.add(k4);
        total.add(k5);
        keywordOutput.setLayout(new GridLayout(2, 1, 0, 0));
        add(total, BorderLayout.CENTER);

        //------------------------------------------------------------
        //adding keyListener
        this.addKeyListener(this);
        outPut.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_TAB:
                outPut.setText(outPut.getText());
                key2[0].setBackground(Color.PINK);
                key2[0].setForeground(Color.white);
                break;
            case KeyEvent.VK_Q:
                outPut.setText(outPut.getText());
                key2[1].setBackground(Color.PINK);
                key2[1].setForeground(Color.white);
                break;
            case KeyEvent.VK_W:
                outPut.setText(outPut.getText());
                key2[2].setBackground(Color.PINK);
                key2[2].setForeground(Color.white);
                break;
            case KeyEvent.VK_E:
                outPut.setText(outPut.getText());
                key2[3].setBackground(Color.PINK);
                key2[3].setForeground(Color.white);
                break;
            case KeyEvent.VK_R:
                outPut.setText(outPut.getText());
                key2[4].setBackground(Color.PINK);
                key2[4].setForeground(Color.white);
                break;
            case KeyEvent.VK_T:
                outPut.setText(outPut.getText());
                key2[5].setBackground(Color.PINK);
                key2[5].setForeground(Color.white);
                break;
            case KeyEvent.VK_Y:
                outPut.setText(outPut.getText());
                key2[6].setBackground(Color.PINK);
                key2[6].setForeground(Color.white);
                break;
            case KeyEvent.VK_U:
                outPut.setText(outPut.getText());
                key2[7].setBackground(Color.PINK);
                key2[7].setForeground(Color.white);
                break;
            case KeyEvent.VK_I:
                outPut.setText(outPut.getText());
                key2[8].setBackground(Color.PINK);
                key2[8].setForeground(Color.white);
                break;
            case KeyEvent.VK_O:
                outPut.setText(outPut.getText());
                key2[9].setBackground(Color.PINK);
                key2[9].setForeground(Color.white);
                break;
            case KeyEvent.VK_P:
                outPut.setText(outPut.getText());
                key2[10].setBackground(Color.PINK);
                key2[10].setForeground(Color.white);
                break;
            case KeyEvent.VK_OPEN_BRACKET:
                outPut.setText(outPut.getText());
                key2[11].setBackground(Color.PINK);
                key2[11].setForeground(Color.white);
                break;
            case KeyEvent.VK_CLOSE_BRACKET:
                outPut.setText(outPut.getText());
                key2[12].setBackground(Color.PINK);
                key2[12].setForeground(Color.white);
                break;
            case KeyEvent.VK_BACK_SLASH:
                outPut.setText(outPut.getText());
                key2[13].setBackground(Color.PINK);
                key2[13].setForeground(Color.white);
                break;

            /*-------------------------------------------------------------------------------------------------------*/
            //KEY 1 
            case KeyEvent.VK_DEAD_TILDE:
                outPut.setText(outPut.getText());
                key1[0].setBackground(Color.PINK);
                key1[0].setForeground(Color.white);
                break;
            case KeyEvent.VK_1:
                outPut.setText(outPut.getText());
                key1[1].setBackground(Color.PINK);
                key1[1].setForeground(Color.white);
                break;
            case KeyEvent.VK_2:
                outPut.setText(outPut.getText());
                key1[2].setBackground(Color.PINK);
                key1[2].setForeground(Color.white);
                break;
            case KeyEvent.VK_3:
                outPut.setText(outPut.getText());
                key1[3].setBackground(Color.PINK);
                key1[3].setForeground(Color.white);
                break;
            case KeyEvent.VK_4:
                outPut.setText(outPut.getText());
                key1[4].setBackground(Color.PINK);
                key1[4].setForeground(Color.white);
                break;
            case KeyEvent.VK_5:
                outPut.setText(outPut.getText());
                key1[5].setBackground(Color.PINK);
                key1[5].setForeground(Color.white);
                break;
            case KeyEvent.VK_6:
                outPut.setText(outPut.getText());
                key1[6].setBackground(Color.PINK);
                key1[6].setForeground(Color.white);
                break;
            case KeyEvent.VK_7:
                outPut.setText(outPut.getText());
                key1[7].setBackground(Color.PINK);
                key1[7].setForeground(Color.white);
                break;
            case KeyEvent.VK_8:
                outPut.setText(outPut.getText());
                key1[8].setBackground(Color.PINK);
                key1[8].setForeground(Color.white);
                break;
            case KeyEvent.VK_9:
                outPut.setText(outPut.getText());
                key1[9].setBackground(Color.PINK);
                key1[9].setForeground(Color.white);
                break;
            case KeyEvent.VK_0:
                outPut.setText(outPut.getText());
                key1[10].setBackground(Color.PINK);
                key1[10].setForeground(Color.white);
                break;
            case KeyEvent.VK_MINUS:
                outPut.setText(outPut.getText());
                key1[11].setBackground(Color.PINK);
                key1[11].setForeground(Color.white);
                break;
            case KeyEvent.VK_EQUALS:
                outPut.setText(outPut.getText());
                key1[12].setBackground(Color.PINK);
                key1[12].setForeground(Color.white);
                break;
            case KeyEvent.VK_BACK_SPACE:
                outPut.setText(outPut.getText());
                key1[13].setBackground(Color.PINK);
                key1[13].setForeground(Color.white);
                break;
            /*-------------------------------------------------------------------------------------------------------*/
            //KEY 3
            case KeyEvent.VK_CAPS_LOCK:
                outPut.setText(outPut.getText());
                key3[0].setBackground(Color.PINK);
                key3[0].setForeground(Color.white);
                break;
            case KeyEvent.VK_A:
                outPut.setText(outPut.getText());
                key3[1].setBackground(Color.PINK);
                key3[1].setForeground(Color.white);
                break;
            case KeyEvent.VK_S:
                outPut.setText(outPut.getText());
                key3[2].setBackground(Color.PINK);
                key3[2].setForeground(Color.white);
                break;
            case KeyEvent.VK_D:
                outPut.setText(outPut.getText());
                key3[3].setBackground(Color.PINK);
                key3[3].setForeground(Color.white);
                break;
            case KeyEvent.VK_F:
                outPut.setText(outPut.getText());
                key3[4].setBackground(Color.PINK);
                key3[4].setForeground(Color.white);
                break;
            case KeyEvent.VK_G:
                outPut.setText(outPut.getText());
                key3[5].setBackground(Color.PINK);
                key3[5].setForeground(Color.white);
                break;
            case KeyEvent.VK_H:
                outPut.setText(outPut.getText());
                key3[6].setBackground(Color.PINK);
                key3[6].setForeground(Color.white);
                break;
            case KeyEvent.VK_J:
                outPut.setText(outPut.getText());
                key3[7].setBackground(Color.PINK);
                key3[7].setForeground(Color.white);
                break;
            case KeyEvent.VK_K:
                outPut.setText(outPut.getText());
                key3[8].setBackground(Color.PINK);
                key3[8].setForeground(Color.white);
                break;
            case KeyEvent.VK_L:
                outPut.setText(outPut.getText());
                key3[9].setBackground(Color.PINK);
                key3[9].setForeground(Color.white);
                break;
            case KeyEvent.VK_SEMICOLON:
                outPut.setText(outPut.getText());
                key3[10].setBackground(Color.PINK);
                key3[10].setForeground(Color.white);
                break;
            case KeyEvent.VK_QUOTE:
                outPut.setText(outPut.getText());
                key3[11].setBackground(Color.PINK);
                key3[11].setForeground(Color.white);
                break;
            case KeyEvent.VK_ENTER:
                outPut.setText(outPut.getText());
                key3[12].setBackground(Color.PINK);
                key3[12].setForeground(Color.white);
                break;
            /*-------------------------------------------------------------------------------------------------------*/
            //KEY 4
            case KeyEvent.VK_SHIFT:
                outPut.setText(outPut.getText());
                key4[0].setBackground(Color.PINK);
                key4[0].setForeground(Color.white);
                break;
            case KeyEvent.VK_Z:
                outPut.setText(outPut.getText());
                key4[1].setBackground(Color.PINK);
                key4[1].setForeground(Color.white);
                break;
            case KeyEvent.VK_X:
                outPut.setText(outPut.getText());
                key4[2].setBackground(Color.PINK);
                key4[2].setForeground(Color.white);
                break;
            case KeyEvent.VK_C:
                outPut.setText(outPut.getText());
                key4[3].setBackground(Color.PINK);
                key4[3].setForeground(Color.white);
                break;
            case KeyEvent.VK_V:
                outPut.setText(outPut.getText());
                key4[4].setBackground(Color.PINK);
                key4[4].setForeground(Color.white);
                break;
            case KeyEvent.VK_B:
                outPut.setText(outPut.getText());
                key4[5].setBackground(Color.PINK);
                key4[5].setForeground(Color.white);
                break;
            case KeyEvent.VK_N:
                outPut.setText(outPut.getText());
                key4[6].setBackground(Color.PINK);
                key4[6].setForeground(Color.white);
                break;
            case KeyEvent.VK_M:
                outPut.setText(outPut.getText());
                key4[7].setBackground(Color.PINK);
                key4[7].setForeground(Color.white);
                break;
            case KeyEvent.VK_COMMA:
                outPut.setText(outPut.getText());
                key4[8].setBackground(Color.PINK);
                key4[8].setForeground(Color.white);
                break;
            case KeyEvent.VK_PERIOD:
                outPut.setText(outPut.getText());
                key4[9].setBackground(Color.PINK);
                key4[9].setForeground(Color.white);
                break;
            case KeyEvent.VK_SLASH:
                outPut.setText(outPut.getText());
                key4[10].setBackground(Color.PINK);
                key4[10].setForeground(Color.white);
                break;
//            case KeyEvent.VK_UP:
//                outPut.setText(outPut.getText());
//                key4[12].setBackground(Color.PINK);
//                key4[12].setForeground(Color.white);
//                break;
 /*-------------------------------------------------------------------------------*/
            //KEY 5
            case KeyEvent.VK_CONTROL:
                outPut.setText(outPut.getText());
                key5[0].setBackground(Color.PINK);
                key5[0].setForeground(Color.white);
                break;
            case KeyEvent.VK_F1:
                outPut.setText(outPut.getText());
                key5[1].setBackground(Color.PINK);
                key5[1].setForeground(Color.white);
                break;
            case KeyEvent.VK_ALT:
                outPut.setText(outPut.getText());
                key5[2].setBackground(Color.PINK);
                key5[2].setForeground(Color.white);
                break;
            case KeyEvent.VK_SPACE:
                outPut.setText(outPut.getText());
                key5[3].setBackground(Color.PINK);
                key5[3].setForeground(Color.white);
                break;
//            case KeyEvent.VK_LEFT:
//                outPut.setText(outPut.getText());
//                key5[7].setBackground(Color.PINK);
//                key5[7].setForeground(Color.white);
//                break;
//            case KeyEvent.VK_DOWN:
//                outPut.setText(outPut.getText());
//                key5[8].setBackground(Color.PINK);
//                key5[8].setForeground(Color.white);
//                break;
//            case KeyEvent.VK_RIGHT:
//                outPut.setText(outPut.getText());
//                key5[9].setBackground(Color.PINK);
//                key5[9].setForeground(Color.white);
//                break;
                
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_TAB:
                key2[0].setBackground(null);
                key2[0].setForeground(Color.black);
                break;
            case KeyEvent.VK_Q:
                key2[1].setBackground(null);
                key2[1].setForeground(Color.black);
                break;
            case KeyEvent.VK_W:
                key2[2].setBackground(null);
                key2[2].setForeground(Color.black);
                break;
            case KeyEvent.VK_E:
                key2[3].setBackground(null);
                key2[3].setForeground(Color.black);
                break;
            case KeyEvent.VK_R:
                key2[4].setBackground(null);
                key2[4].setForeground(Color.black);
                break;
            case KeyEvent.VK_T:
                key2[5].setBackground(null);
                key2[5].setForeground(Color.black);
                break;
            case KeyEvent.VK_Y:
                key2[6].setBackground(null);
                key2[6].setForeground(Color.black);
                break;
            case KeyEvent.VK_U:
                key2[7].setBackground(null);
                key2[7].setForeground(Color.black);
                break;
            case KeyEvent.VK_I:
                key2[8].setBackground(null);
                key2[8].setForeground(Color.black);
                break;
            case KeyEvent.VK_O:
                key2[9].setBackground(null);
                key2[9].setForeground(Color.black);
                break;
            case KeyEvent.VK_P:
                key2[10].setBackground(null);
                key2[10].setForeground(Color.black);
                break;
            case KeyEvent.VK_OPEN_BRACKET:
                key2[11].setBackground(null);
                key2[11].setForeground(Color.black);
                break;
            case KeyEvent.VK_CLOSE_BRACKET:
                key2[12].setBackground(null);
                key2[12].setForeground(Color.black);
                break;
            case KeyEvent.VK_BACK_SLASH:
                key2[13].setBackground(null);
                key2[13].setForeground(Color.black);
                break;
            /*-------------------------------------------------------------------------------*/
            //KEY 1

            case KeyEvent.VK_DEAD_TILDE:
                outPut.setText(outPut.getText());
                key1[0].setBackground(null);
                key1[0].setForeground(Color.black);
                break;
            case KeyEvent.VK_1:
                outPut.setText(outPut.getText());
                key1[1].setBackground(null);
                key1[1].setForeground(Color.black);
                break;
            case KeyEvent.VK_2:
                outPut.setText(outPut.getText());
                key1[2].setBackground(null);
                key1[2].setForeground(Color.black);
                break;
            case KeyEvent.VK_3:
                outPut.setText(outPut.getText());
                key1[3].setBackground(null);
                key1[3].setForeground(Color.black);
                break;
            case KeyEvent.VK_4:
                outPut.setText(outPut.getText());
                key1[4].setBackground(null);
                key1[4].setForeground(Color.black);
                break;
            case KeyEvent.VK_5:
                outPut.setText(outPut.getText());
                key1[5].setBackground(null);
                key1[5].setForeground(Color.black);
                break;
            case KeyEvent.VK_6:
                outPut.setText(outPut.getText());
                key1[6].setBackground(null);
                key1[6].setForeground(Color.black);
                break;
            case KeyEvent.VK_7:
                outPut.setText(outPut.getText());
                key1[7].setBackground(null);
                key1[7].setForeground(Color.black);
                break;
            case KeyEvent.VK_8:
                outPut.setText(outPut.getText());
                key1[8].setBackground(null);
                key1[8].setForeground(Color.black);
                break;
            case KeyEvent.VK_9:
                outPut.setText(outPut.getText());
                key1[9].setBackground(null);
                key1[9].setForeground(Color.black);
                break;
            case KeyEvent.VK_0:
                outPut.setText(outPut.getText());
                key1[10].setBackground(null);
                key1[10].setForeground(Color.black);
                break;
            case KeyEvent.VK_MINUS:
                outPut.setText(outPut.getText());
                key1[11].setBackground(null);
                key1[11].setForeground(Color.black);
                break;
            case KeyEvent.VK_EQUALS:
                outPut.setText(outPut.getText());
                key1[12].setBackground(null);
                key1[12].setForeground(Color.black);
                break;
            case KeyEvent.VK_BACK_SPACE:
                outPut.setText(outPut.getText());
                key1[13].setBackground(null);
                key1[13].setForeground(Color.black);
                break;
            /*-------------------------------------------------------------------------------*/
            //KEY3
            case KeyEvent.VK_CAPS_LOCK:
                outPut.setText(outPut.getText());
                key3[0].setBackground(null);
                key3[0].setForeground(Color.black);
                break;
            case KeyEvent.VK_A:
                outPut.setText(outPut.getText());
                key3[1].setBackground(null);
                key3[1].setForeground(Color.black);
                break;
            case KeyEvent.VK_S:
                outPut.setText(outPut.getText());
                key3[2].setBackground(null);
                key3[2].setForeground(Color.black);
                break;
            case KeyEvent.VK_D:
                outPut.setText(outPut.getText());
                key3[3].setBackground(null);
                key3[3].setForeground(Color.black);
                break;
            case KeyEvent.VK_F:
                outPut.setText(outPut.getText());
                key3[4].setBackground(null);
                key3[4].setForeground(Color.black);
                break;
            case KeyEvent.VK_G:
                outPut.setText(outPut.getText());
                key3[5].setBackground(null);
                key3[5].setForeground(Color.black);
                break;
            case KeyEvent.VK_H:
                outPut.setText(outPut.getText());
                key3[6].setBackground(null);
                key3[6].setForeground(Color.black);
                break;
            case KeyEvent.VK_J:
                outPut.setText(outPut.getText());
                key3[7].setBackground(null);
                key3[7].setForeground(Color.black);
                break;
            case KeyEvent.VK_K:
                outPut.setText(outPut.getText());
                key3[8].setBackground(null);
                key3[8].setForeground(Color.black);
                break;
            case KeyEvent.VK_L:
                outPut.setText(outPut.getText());
                key3[9].setBackground(null);
                key3[9].setForeground(Color.black);
                break;
            case KeyEvent.VK_SEMICOLON:
                outPut.setText(outPut.getText());
                key3[10].setBackground(null);
                key3[10].setForeground(Color.black);
                break;
            case KeyEvent.VK_QUOTE:
                outPut.setText(outPut.getText());
                key3[11].setBackground(null);
                key3[11].setForeground(Color.black);
                break;
            case KeyEvent.VK_ENTER:
                outPut.setText(outPut.getText());
                key3[12].setBackground(null);
                key3[12].setForeground(Color.black);
                break;
            /*-------------------------------------------------------------------------------*/
            //KEY4
            case KeyEvent.VK_SHIFT:
                outPut.setText(outPut.getText());
                key4[0].setBackground(null);
                key4[0].setForeground(Color.black);
                break;
            case KeyEvent.VK_Z:
                outPut.setText(outPut.getText());
                key4[1].setBackground(null);
                key4[1].setForeground(Color.black);
                break;
            case KeyEvent.VK_X:
                outPut.setText(outPut.getText());
                key4[2].setBackground(null);
                key4[2].setForeground(Color.black);
                break;
            case KeyEvent.VK_C:
                outPut.setText(outPut.getText());
                key4[3].setBackground(null);
                key4[3].setForeground(Color.black);
                break;
            case KeyEvent.VK_V:
                outPut.setText(outPut.getText());
                key4[4].setBackground(null);
                key4[4].setForeground(Color.black);
                break;
            case KeyEvent.VK_B:
                outPut.setText(outPut.getText());
                key4[5].setBackground(null);
                key4[5].setForeground(Color.black);
                break;
            case KeyEvent.VK_N:
                outPut.setText(outPut.getText());
                key4[6].setBackground(null);
                key4[6].setForeground(Color.black);
                break;
            case KeyEvent.VK_M:
                outPut.setText(outPut.getText());
                key4[7].setBackground(null);
                key4[7].setForeground(Color.black);
                break;
            case KeyEvent.VK_COMMA:
                outPut.setText(outPut.getText());
                key4[8].setBackground(null);
                key4[8].setForeground(Color.black);
                break;
            case KeyEvent.VK_PERIOD:
                outPut.setText(outPut.getText());
                key4[9].setBackground(null);
                key4[9].setForeground(Color.black);
                break;
            case KeyEvent.VK_SLASH:
                outPut.setText(outPut.getText());
                key4[10].setBackground(null);
                key4[10].setForeground(Color.black);
                break;
            case KeyEvent.VK_KP_UP:
                outPut.setText(outPut.getText());
                key4[12].setBackground(null);
                key4[12].setForeground(Color.black);
                break;
            /*-------------------------------------------------------------------------------*/
            //KEY 5
            case KeyEvent.VK_CONTROL:
                outPut.setText(outPut.getText());
                key5[0].setBackground(null);
                key5[0].setForeground(Color.black);
                break;
            case KeyEvent.VK_F1:
                outPut.setText(outPut.getText());
                key5[1].setBackground(null);
                key5[1].setForeground(Color.black);
                break;
            case KeyEvent.VK_ALT:
                outPut.setText(outPut.getText());
                key5[2].setBackground(null);
                key5[2].setForeground(Color.black);
                break;
            case KeyEvent.VK_SPACE:
                outPut.setText(outPut.getText());
                key5[3].setBackground(null);
                key5[3].setForeground(Color.black);
                break;
//            case KeyEvent.VK_LEFT:
//                outPut.setText(outPut.getText());
//                key5[7].setBackground(null);
//                key5[7].setForeground(Color.black);
//                break;
//            case KeyEvent.VK_DOWN:
//                outPut.setText(outPut.getText());
//                key5[8].setBackground(null);
//                key5[8].setForeground(Color.black);
//                break;
//            case KeyEvent.VK_RIGHT:
//                outPut.setText(outPut.getText());
//                key5[9].setBackground(null);
//                key5[9].setForeground(Color.black);
//                break;
            
        }
    }

}
