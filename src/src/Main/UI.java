package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];

    public UI(GameManager gm){
        this.gm = gm;
        CreateMainField();
        generateScreen();
        window.setVisible(true);
    }
    public void CreateMainField(){
        window = new JFrame();
        window.setSize(1344,768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("Start");
        messageText.setBounds(570, 500, 65, 30);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN,26));
        window.add(messageText);
    }
    public void  createBackground(int bgNum, String bgFileName){
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(0,0,1344,768);
        bgPanel[bgNum].setBackground(Color.gray);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,700,350);
        
        ImageIcon bg = new ImageIcon(bgFileName);
        bgLabel[bgNum].setIcon(bg);
        
        
    }
    public void createObjct(int bgNum, int objx, int objy, int objwidth, int objheight, String objfileName, String choice1Name, String choice2Name, String choice3Name,
                            String Choice1Command, String Choice2Command, String Choice3Command){
        JPopupMenu popMenu = new JPopupMenu();

        JMenuItem menuItem[] = new JMenuItem[4];
        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(Choice1Command);
        popMenu.add(menuItem[1]);
        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(Choice2Command);
        popMenu.add(menuItem[2]);
        menuItem[3] = new JMenuItem(choice3Name);
        menuItem[3].addActionListener(gm.aHandler);
        menuItem[3].setActionCommand(Choice3Command);
        popMenu.add(menuItem[3]);

        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx,objy,objwidth,objheight);
        
        ImageIcon objIcon = new ImageIcon(objfileName);
        objectLabel.setIcon(objIcon);

        objectLabel.addMouseListener(new MouseListener() {
            public void mouseClicked(java.awt.event.MouseEvent e) {

            }
            public void mousePressed(java.awt.event.MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }
            public void mouseReleased(java.awt.event.MouseEvent e) {

            }
            public void mouseEntered(java.awt.event.MouseEvent e) {

            }
            public void mouseExited(java.awt.event.MouseEvent e) {

            }
        });

        bgPanel[bgNum].add(objectLabel);
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }
    public void generateScreen(){
        String path = Paths.get(".").toAbsolutePath().normalize().toString();
        createBackground(1,path+"/asset/res/bg700x350.jpg");
        createObjct(1,450,100,200,200,path+"/asset/res/hut200x200.png","Look","Talk","Rest","lookHut","talkHut","restHut");
        createObjct(1,70,140,150,150,path+"/asset/res/player150x150.png","Look","Talk","Attack","lookPlayer","talkPlayer","attackPlayer");
        createObjct(1,300,230,100,67,path+"/asset/res/chest100x67.png","Look","Talk","Open","lookChest","talkChest","openChest");

    }
}
