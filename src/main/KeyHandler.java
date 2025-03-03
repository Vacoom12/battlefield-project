package src.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener, MouseListener, ActionListener {
    Game g;
    public int mouseX, mouseY;
    public boolean mouseClicked = false;

    public KeyHandler(Game g){
        this.g = g;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // int code = e.getKeyCode();

        // System.out.println(code);

        // if (code == KeyEvent.VK_W) {
        //     upPressed = true;
        // }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // int code = e.getKeyCode();

        // System.out.println(code);

        // if (code == KeyEvent.VK_W) {
        //     upPressed = false;
        // }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // mouseX = e.getX();
        // mouseY = e.getY();
        // System.out.println("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
        if(g.gameState == g.titleState){
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseClicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
