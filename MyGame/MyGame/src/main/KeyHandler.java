package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    GamePanel gp ;
    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, shotKeyPressed;

    public KeyHandler(GamePanel gp)
    {
        this.gp =gp;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    //verificam starile jocului(play, pause, gameOver) si butoanele apasate
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e. getKeyCode();
        //TITLE STATE
        if(gp.gameState == gp.titleState)
        {
            titleState(code);
        }

        //Play State
        if(gp.gameState == gp.playState)
        {
            playState(code);
        }

        // GAme Over STate
        if(gp.gameState == gp.gameOverState)
        {
            gameOverState(code);
        }

        if (code == KeyEvent.VK_DOWN)
        {
            downPressed =true;
        }

        if(code == KeyEvent.VK_LEFT)
        {
            leftPressed = true;

        }
        if (code == KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_UP)
        {
            upPressed = true;
        }
        if (code == KeyEvent.VK_SPACE)
        {
            spacePressed =true;
        }
        if (code == KeyEvent.VK_P)
        {
            if(gp.gameState == gp.playState)
            {
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState)
            {
                gp.gameState =gp.playState;
            }
        }

        if(code == KeyEvent.VK_S)
        {
            shotKeyPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e)  {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_DOWN)
        {
            downPressed =false;
        }

        if(code == KeyEvent.VK_LEFT)
        {
            leftPressed = false;

        }
        if (code == KeyEvent.VK_RIGHT)
        {
            rightPressed = false;
        }
        if (code == KeyEvent.VK_UP)
        {
            upPressed = false;
        }
        if (code == KeyEvent.VK_SPACE)
        {
            spacePressed =false;
        }
        if(code == KeyEvent.VK_S)
        {
            shotKeyPressed = false;
        }
    }

    // pentru a putea parcurge cele 3 butoane ale meniului principal
    //0 -playState 1-LoadGame 2-Exit
    public void titleState(int code)
    {
        if (code == KeyEvent.VK_DOWN)
        {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 2)
            {
                gp.ui.commandNum =0;
            }
        }
        if (code == KeyEvent.VK_UP)
        {
            gp.ui.commandNum--;
            if(gp.ui.commandNum <0)
            {
                gp.ui.commandNum =2;
            }
        }
        if (code == KeyEvent.VK_ENTER)
        {
            if(gp.ui.commandNum == 0)
            {
                gp.gameState = gp.playState;
            }

            if(gp.ui.commandNum == 1)
            {

                gp.saveload.load();
                gp.gameState = gp.playState;
            }
            if(gp.ui.commandNum == 2)
            {
                System.exit(0);
            }
        }
    }

    //verificam butoanele apasate, cazul in care se deruleaza jocul
    public void playState(int code)
    {
        if (code == KeyEvent.VK_DOWN)
        {
            downPressed =true;
        }

        if(code == KeyEvent.VK_LEFT)
        {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT)
        {
            rightPressed = true;
        }
        if (code == KeyEvent.VK_UP)
        {
            upPressed = true;
        }
        if (code == KeyEvent.VK_SPACE)
        {
            spacePressed =true;
        }
        if (code == KeyEvent.VK_P)
        {
            gp.gameState = gp.pauseState;
        }


    }
    // verificam conditiile necesare pt oprirea jocului
    public void gameOverState(int code)
    {
        if(code == KeyEvent.VK_UP)
        {
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0)
            {
                gp.ui.commandNum = 1;
            }
        }
        if(code == KeyEvent.VK_DOWN)
        {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 1)
            {
                gp.ui.commandNum = 0;
            }
        }
        if (code == KeyEvent.VK_ENTER)
        {
            if(gp.ui.commandNum == 0)
            {
                gp.gameState = gp.playState;
                gp.retry();
            }
            else if(gp.ui.commandNum == 1)
            {
                gp.gameState = gp.titleState;
                gp.restart();
            }
        }

    }


}
