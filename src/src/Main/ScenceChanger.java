package Main;

public class ScenceChanger {
    GameManager gm;
    public ScenceChanger(GameManager gm){
        this.gm = gm;
    }
    public void changeScence(int scenceNum){
        switch(scenceNum){
            case 1:
                gm.ui.bgPanel[1].setVisible(true);
                gm.ui.bgPanel[2].setVisible(false);
                break;
            case 2:
                gm.ui.bgPanel[1].setVisible(false);
                gm.ui.bgPanel[2].setVisible(true);
                break;
        }

    }
}
