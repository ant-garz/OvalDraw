/*
Name: Anthony Garza
Project: OvalDraw
Purpose: To complete the OvalDraw Assignment for Sprint 2. Also, to satisfy requirements for homework, I am noting that purple is my favorite color.
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Color;

class Rectangle extends JPanel {
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);

        int panelWidth = getWidth();
        int panelHeight= getHeight();

        Color myColor = new Color(0,0,128);
        graphic.setColor(myColor);
        graphic.fillRect(200,80, 300, 200);
    }
}

//inherits from JPanel to be able to draw ovals
class Oval extends JPanel {
    //override method of JPanel
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Color myColor = new Color(128,0,128);
        graphic.setColor(myColor);
        graphic.fillOval(200,80,275,150);
    }
}

//inherit from JFrame in this class
//used a mainpanel to be able to put both the rectangle and the oval into the frame without issues.
class MainPanel extends JPanel {

    private Rectangle myRectangle;
    private Oval myOval;
    public MainPanel(){
        myRectangle = new Rectangle();
        myOval = new Oval();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        myRectangle.paintComponent(g);
        myOval.paintComponent(g);
    }
}

public class OvalDraw{
    public static void main(String[] args){
        System.out.println("Starting OvalDraw...");
        JFrame myFrame = new JFrame ("OvalDraw");
        myFrame.setTitle("AG - OvalDraw");
        //set bounds for window, 200,500 says start window from upper left corner at 500px over 200px down
        //300 and 400 are px dimensions of window created
        myFrame.setBounds(500,200,700,350);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel myMainPanel = new MainPanel();
        myFrame.add(myMainPanel);
        myFrame.setVisible(true);
    }
}