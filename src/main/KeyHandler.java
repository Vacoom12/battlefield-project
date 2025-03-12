package src.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener, MouseListener, ActionListener {
    Game game;
    public int mouseX, mouseY;
    int ButtonX, ButtonY, buttonWidth, buttonHeight;
    public boolean mouseClicked = false;
    public boolean canShoot = true;
    public int shootCooldown = 0;

    public KeyHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // int code = e.getKeyCode();

        // System.out.println(code);

        // if (code == KeyEvent.VK_W) {
        // upPressed = true;
        // }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // int code = e.getKeyCode();

        // System.out.println(code);

        // if (code == KeyEvent.VK_W) {
        // upPressed = false;
        // }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseClicked = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (game.gameState == game.titleState) {
            ButtonX = game.screenWidth - 820;
            ButtonY = game.screenHeight - 300;
            buttonWidth = 290;
            buttonHeight = 20;

            if (mouseX >= ButtonX && mouseX <= ButtonX + buttonWidth && mouseY >= ButtonY - game.tileSize
                    && mouseY <= ButtonY + buttonHeight) {
                game.gameState = game.diffState;
            }
            mouseClicked = false;

            ButtonX += 20;
            ButtonY += 100;
            buttonWidth -= 40;
            if (mouseX >= ButtonX && mouseX <= ButtonX + buttonWidth && mouseY >= ButtonY - game.tileSize
                    && mouseY <= ButtonY + buttonHeight) {
                System.exit(0);
            }
            mouseClicked = false;

        } else if (game.gameState == game.diffState) {
            ButtonX = game.screenWidth - 1050;
            ButtonY = (game.screenHeight / 2) + 25;
            buttonWidth = 150;
            buttonHeight = 20;

            if (mouseX >= ButtonX && mouseX <= ButtonX + buttonWidth && mouseY >= ButtonY - game.tileSize
                    && mouseY <= ButtonY + buttonHeight) {
                game.gameState = game.easyState;
                game.aSetter.setObject1();
            }
            mouseClicked = false;

            ButtonX += 300;

            if (mouseX >= ButtonX && mouseX <= ButtonX + buttonWidth && mouseY >= ButtonY - game.tileSize
                    && mouseY <= ButtonY + buttonHeight) {
                game.gameState = game.normalState;
                game.aSetter.setObject2();
            }
            mouseClicked = false;

            ButtonX += 350;
            if (mouseX >= ButtonX && mouseX <= ButtonX + buttonWidth && mouseY >= ButtonY - game.tileSize
                    && mouseY <= ButtonY + buttonHeight) {
                game.gameState = game.hardState;
                game.aSetter.setObject3();
            }
            mouseClicked = false;

        } else if (game.gameState == game.endState) {
            ButtonX = game.screenWidth - 850;
            ButtonY = (game.screenHeight / 2) + (game.tileSize * 3);
            buttonWidth = 350;
            buttonHeight = 20;

            if (mouseX >= ButtonX && mouseX <= ButtonX + buttonWidth && mouseY >= ButtonY - game.tileSize
                    && mouseY <= ButtonY + buttonHeight) {
                game.setupGame();
            }
            mouseClicked = false;
        }

        mouseClicked = false;

        if (!mouseClicked && game.gameState == game.endState) {
            if (game.gameWon && game.endSound)
                game.playSE(4);
                game.endSound = false;
            if (!game.gameWon && game.endSound)
                game.playSE(5);
                game.endSound = false;
        }
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
