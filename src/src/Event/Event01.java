package Event;

import Main.GameManager;

public class Event01 {
    GameManager gm;
    public Event01(GameManager gm){
        this.gm = gm;
    }
    public void lookHut(){
        gm.ui.messageText.setText("This is your House.");
    }
    public void talkHut(){
        gm.ui.messageText.setText("Who are you talking to.");
    }
    public void restHut(){
        gm.ui.messageText.setText("You rest at the house.\n(Your life has recovered)");
    }
    public void lookPlayer(){
        gm.ui.messageText.setText("A player is standing in front of you.");
    }
    public void talkPlayer(){
        gm.ui.messageText.setText("Player: Don't go any further without a weapon!\nYou should check the chest over there!");
    }
    public void attackPlayer(){
        gm.ui.messageText.setText("Player: Hey, don't be stupid!");
    }
    public void lookChest(){
        gm.ui.messageText.setText("A chest is on the ground.");
    }
    public void talkChest(){
        gm.ui.messageText.setText("You talk to the chest but it says nothing.");
    }
    public void openChest(){
        gm.ui.messageText.setText("You open the chest and find a sword!");
    }
}
