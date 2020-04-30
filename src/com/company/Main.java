package com.company;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

public class Main {

    private static String[][] tileMap = {
            {"9", "9", "9", "9", "9", "9", "9", "9", "9", "9", "9"},
            {"9", "*", "*", "9", "9", "9", "9", "9", "*", "*", "9"},
            {"9", "*", "9", "*", "*", "*", "*", "*", "9", "*", "9"},
            {"9", "9", "*", "*", "*", "*", "*", "*", "*", "9", "9"},
            {"9", "9", "*", "*", "*", "*", "*", "*", "*", "9", "9"},
            {"9", "9", "*", "*", "*", "*", "*", "*", "*", "9", "9"},
            {"9", "9", "*", "*", "*", "*", "*", "*", "*", "9", "9"},
            {"9", "9", "*", "*", "*", "*", "*", "*", "*", "9", "9"},
            {"9", "*", "9", "*", "*", "*", "*", "*", "9", "*", "9"},
            {"9", "*", "*", "9", "9", "9", "9", "9", "*", "*", "9"},
            {"9", "9", "9", "9", "9", "9", "9", "9", "9", "9", "9"}
    };
    private static String actionLabelStr = "";
    private static String playerNameStr = ""; // "Игрок 1";
    private static String playerGoldStr = ""; //""Золото: 500";
    private static String playerSheepStr = ""; //""Овцы: 10";
    private static String playerLogStr = ""; //'""Брёвна: 50";

    private static JLabel playerName = (new JLabel(playerNameStr));
    private static JLabel playerGold = (new JLabel(playerGoldStr));
    private static JLabel playerSheep =(new JLabel(playerSheepStr));
    private static JLabel playerLog = (new JLabel(playerLogStr));
    private static  JLabel actionLabel = (new JLabel(actionLabelStr));

    private static JPanel[][] panels = new JPanel[11][11];
    private static JButton end_button = new JButton("Начать игру");

    private static JFrame mainFrame = new JFrame();

    private static JMenuBar menuBar = new JMenuBar();

    private static JMenu menu = new JMenu("Новая игра");

    private static JMenuItem twoPlayers = new JMenuItem("2 Игрока");
    private static JMenuItem threePlayers = new JMenuItem("3 Игрока");
    private static JMenuItem fourPlayers = new JMenuItem("4 Игрока");
    private static JMenuItem fivePlayers = new JMenuItem("5 Игроков");
    private static JMenuItem sixPlayers = new JMenuItem("6 Игроков");

    private static JPanel action = new JPanel();
    private static JPanel playerWindow = new JPanel();
    private static JPanel panel = new JPanel();
    private static JPanel top = new JPanel();
    private static JPanel bottom = new JPanel();
    private static JPanel gameMap = new JPanel();
    private static JPanel buttonAction = new JPanel();

    private static JPanel[][] tabs = new JPanel[11][11];
    private static JPanel[][] panelPlayer0 = new JPanel[11][11];
    private static JPanel[][] panelPlayer1 = new JPanel[11][11];
    private static JPanel[][] panelPlayer2 = new JPanel[11][11];
    private static JPanel[][] panelPlayer3 = new JPanel[11][11];
    private static JPanel[][] panelPlayer4 = new JPanel[11][11];
    private static JPanel[][] panelPlayer5 = new JPanel[11][11];
    private static String fileImg = "graphics/emptyImg.png";

    private static ArrayList<Player> players = new ArrayList<>();

    private static Integer index = 0;

    private static Integer result = 0;

    public static MapEvent mapEvent = new MapEvent();

    public static class CubeDialog extends JDialog{
        public CubeDialog(){
            super(mainFrame, "Начало хода", true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            setBounds(dimension.width / 2 - 75, dimension.height / 2 - 50, 150, 100);

            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            JPanel Top_Panel = new JPanel();
            JPanel Center_Panel = new JPanel();
            add(Top_Panel);
            add(Center_Panel);

            JLabel action = new JLabel("Бросьте кубик");
            Top_Panel.add(action);

            JButton Start = new JButton("Бросить");
            Center_Panel.add(Start);

            Start.addActionListener(actionEvent -> {
                result = (int) (Math.random() * 6 + 1);
                setVisible(false);
                dispose();
            });

            add(Top_Panel, BorderLayout.NORTH);
            add(Center_Panel, BorderLayout.CENTER);

            setVisible(true);
        }
    }

    public static void frameConfigurator(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        menu.add(twoPlayers);
        menu.add(threePlayers);
        menu.add(fourPlayers);
        menu.add(fivePlayers);
        menu.add(sixPlayers);

        menuBar.add(menu);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 300, 800, 600);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setTitle("Guilds game");
        mainFrame.setIconImage(null);
        mainFrame.setJMenuBar(menuBar);

        action.add(actionLabel);

        for (int a = 0; a < 11; a++) {
            for (int b = 0; b < 11; b++) {
                panels[a][b] = new JPanel();
                tabs[a][b] = new JPanel();

                panelPlayer0[a][b] = new JPanel();
                tabs[a][b].add(panelPlayer0[a][b]);

                panelPlayer1[a][b] = new JPanel();
                tabs[a][b].add(panelPlayer1[a][b]);

                panelPlayer2[a][b] = new JPanel();
                tabs[a][b].add(panelPlayer2[a][b]);

                panelPlayer3[a][b] = new JPanel();
                tabs[a][b].add(panelPlayer3[a][b]);

                panelPlayer4[a][b] = new JPanel();
                tabs[a][b].add(panelPlayer4[a][b]);

                panelPlayer5[a][b] = new JPanel();
                tabs[a][b].add(panelPlayer5[a][b]);


                if (!tileMap[a][b].equals("*")) {
                    panels[a][b].setLayout(new BorderLayout());
                    panels[a][b].add(tabs[a][b], BorderLayout.NORTH);
                    try {
                        switch (tileMap[a][b]){
                            case "11":
                                fileImg ="graphics/WhiteHarborPort.png";
                                panels[a][b].setToolTipText("Белая Гавань");
                                break;
                            case "12":
                                fileImg ="graphics/CastleBlackCreek.png";
                                panels[a][b].setToolTipText("Замок Чёрная Заводь");
                                break;
                            case "22":
                                fileImg ="graphics/WinterfellCastle.png";
                                panels[a][b].setToolTipText("Замок Винтерфелл");
                                break;
                            case "21":
                                //возможно это не Волчий Лес, а какая то лесопилка
                                fileImg ="graphics/WolfForest.png";
                                panels[a][b].setToolTipText("Волчий Лес");
                                break;
                            case "31":
                                fileImg ="graphics/CasterlyRock.png";
                                panels[a][b].setToolTipText("Утёс Кастерли");
                                break;
                            case "32":
                                fileImg ="graphics/Lannisport.png";
                                panels[a][b].setToolTipText("Ланниспорт");
                                break;
                            case "41":
                                fileImg ="graphics/IronIslands.png";
                                panels[a][b].setToolTipText("Железные Острова");
                                break;
                            case "42":
                                fileImg ="graphics/Riverran.png";
                                panels[a][b].setToolTipText("Риверран");
                                break;
                            default:
                                fileImg = "graphics/emptyImg.png";
                                break;
                        }
                        BufferedImage myPicture = ImageIO.read(new File(fileImg));
                        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                        picLabel.setBorder(BorderFactory.createLineBorder(Color.black,1));
                        panels[a][b].add(picLabel, BorderLayout.CENTER);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                gameMap.add(panels[a][b]);
            }
        }

        panel.setBorder(new EmptyBorder(5,5,5,5));

        top.setLayout(new BorderLayout(5,5));
        top.add(gameMap, BorderLayout.CENTER);
        top.add(playerWindow, BorderLayout.EAST);

        bottom.setLayout(new BorderLayout(5,5));
        bottom.add(action, BorderLayout.CENTER);
        bottom.add(buttonAction, BorderLayout.EAST);

        panel.setLayout(new BorderLayout(5,5));
        panel.add(top, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        gameMap.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, Color.black));
        gameMap.setLayout(new GridLayout(11, 11, 5, 5));

        buttonAction.add(end_button);

        playerWindow.setLayout(new GridLayout(4, 1, 5, 5));
        playerWindow.add(playerName);
        playerWindow.add(playerGold);
        playerWindow.add(playerSheep);
        playerWindow.add(playerLog);

        mainFrame.add(panel);
        mainFrame.revalidate();
    }

    public static void showPlayerInfo(int index){
        playerNameStr = "Игрок " + (index + 1);
        playerGoldStr = "Золото " + players.get(index).getGold();
        playerSheepStr = "Овцы " + players.get(index).getSheep();
        playerLogStr = "Дерево " + players.get(index).getForest();

        playerName.setText(playerNameStr);
        playerGold.setText(playerGoldStr);
        playerSheep.setText(playerSheepStr);
        playerLog.setText(playerLogStr);

    }

    public static int showCubeGenerator(){

        new CubeDialog();
        System.out.println("Кубик выпал стороной " + result);
        actionLabelStr = "Кубик выпал стороной " + result;
        actionLabel.setText(actionLabelStr);

        return result;
    }

    public static void game(int index){
        end_button.setText("Завершить ход");
        System.out.println("Player " + index);
        showPlayerInfo(index);
        int cubeScore = showCubeGenerator();
        switch (index) {
            case 0:
                panelPlayer0[players.get(index).getX()][players.get(index).getY()].setBackground(null);
                break;
            case 1:
                panelPlayer1[players.get(index).getX()][players.get(index).getY()].setBackground(null);
                break;
            case 2:
                panelPlayer2[players.get(index).getX()][players.get(index).getY()].setBackground(null);
                break;
            case 3:
                panelPlayer3[players.get(index).getX()][players.get(index).getY()].setBackground(null);
                break;
            case 4:
                panelPlayer4[players.get(index).getX()][players.get(index).getY()].setBackground(null);
                break;
            case 5:
                panelPlayer5[players.get(index).getX()][players.get(index).getY()].setBackground(null);
                break;
        }
        players.get(index).move(cubeScore);
        switch (index) {
            case 0:
                panelPlayer0[players.get(index).getX()][players.get(index).getY()].setBackground(Color.red);
                break;
            case 1:
                panelPlayer1[players.get(index).getX()][players.get(index).getY()].setBackground(Color.green);
                break;
            case 2:
                panelPlayer2[players.get(index).getX()][players.get(index).getY()].setBackground(Color.blue);
                break;
            case 3:
                panelPlayer3[players.get(index).getX()][players.get(index).getY()].setBackground(Color.yellow);
                break;
            case 4:
                panelPlayer4[players.get(index).getX()][players.get(index).getY()].setBackground(Color.pink);
                break;
            case 5:
                panelPlayer5[players.get(index).getX()][players.get(index).getY()].setBackground(Color.magenta);
                break;
        }
        //TODO сюда вкорячить метод на проверку клетки на владельца, чтото типа checkCell(player.get(x), player.get(y)
        mapEvent.checkEvent(tileMap[players.get(index).getX()][players.get(index).getY()], players.get(index), players);
        if(mapEvent.getOwnerIndex() != -1){
            switch (mapEvent.getOwnerIndex()) {
                case 0:
                    panels[players.get(index).getX()][players.get(index).getY()].setBackground(Color.red);
                    break;
                case 1:
                    panels[players.get(index).getX()][players.get(index).getY()].setBackground(Color.green);
                    break;
                case 2:
                    panels[players.get(index).getX()][players.get(index).getY()].setBackground(Color.blue);
                    break;
                case 3:
                    panels[players.get(index).getX()][players.get(index).getY()].setBackground(Color.yellow);
                    break;
                case 4:
                    panels[players.get(index).getX()][players.get(index).getY()].setBackground(Color.pink);
                    break;
                case 5:
                    panels[players.get(index).getX()][players.get(index).getY()].setBackground(Color.magenta);
                    break;
            }
        }

    }

    public static void startGame(){
        end_button.addActionListener(e -> {
            if(index == players.size()){
                index = 0;
                game(index);
                index++;
            }else{
                game(index);
                index++;
            }
        });
    }

    static public void main(String[] args) {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");

        MapGenerator mapGenerator = new MapGenerator();
        mapGenerator.generateMap(tileMap);

        frameConfigurator();

        mainFrame.setVisible(true);
        twoPlayers.addActionListener(e -> {

            for (int i = 0; i < 2; i++) {
                Player player = new Player();
                player.setStartPosition();
                player.setName("player" + (i+1));
                player.addGold(100);
                if(i==0)panelPlayer0[player.getX()][player.getY()].setBackground(Color.red);
                if(i==1)panelPlayer1[player.getX()][player.getY()].setBackground(Color.green);
                players.add(player);
            }
            startGame();
        });

        threePlayers.addActionListener(e -> {

            for (int i = 0; i < 3; i++) {
                Player player = new Player();
                player.setStartPosition();
                player.setName("player" + (i+1));
                player.addGold(100);
                if(i==0)panelPlayer0[player.getX()][player.getY()].setBackground(Color.red);
                if(i==1)panelPlayer1[player.getX()][player.getY()].setBackground(Color.green);
                if(i==2)panelPlayer2[player.getX()][player.getY()].setBackground(Color.blue);
                players.add(player);
            }
            startGame();
        });

        fourPlayers.addActionListener(e -> {

            for (int i = 0; i < 4; i++) {
                Player player = new Player();
                player.setStartPosition();
                player.setName("player" + (i+1));
                player.addGold(100);
                if(i==0)panelPlayer0[player.getX()][player.getY()].setBackground(Color.red);
                if(i==1)panelPlayer1[player.getX()][player.getY()].setBackground(Color.green);
                if(i==2)panelPlayer2[player.getX()][player.getY()].setBackground(Color.blue);
                if(i==3)panelPlayer3[player.getX()][player.getY()].setBackground(Color.yellow);
                players.add(player);
            }
            startGame();
        });

        fivePlayers.addActionListener(e -> {

            for (int i = 0; i < 5; i++) {
                Player player = new Player();
                player.setStartPosition();
                player.setName("player" + (i+1));
                player.addGold(100);
                if(i==0)panelPlayer0[player.getX()][player.getY()].setBackground(Color.red);
                if(i==1)panelPlayer1[player.getX()][player.getY()].setBackground(Color.green);
                if(i==2)panelPlayer2[player.getX()][player.getY()].setBackground(Color.blue);
                if(i==3)panelPlayer3[player.getX()][player.getY()].setBackground(Color.yellow);
                if(i==4)panelPlayer4[player.getX()][player.getY()].setBackground(Color.pink);
                players.add(player);
            }
            startGame();
        });

        sixPlayers.addActionListener(e -> {

            for (int i = 0; i < 6; i++) {
                Player player = new Player();
                player.setStartPosition();
                player.setName("player" + (i+1));
                player.addGold(100);
                if(i==0)panelPlayer0[player.getX()][player.getY()].setBackground(Color.red);
                if(i==1)panelPlayer1[player.getX()][player.getY()].setBackground(Color.green);
                if(i==2)panelPlayer2[player.getX()][player.getY()].setBackground(Color.blue);
                if(i==3)panelPlayer3[player.getX()][player.getY()].setBackground(Color.yellow);
                if(i==4)panelPlayer4[player.getX()][player.getY()].setBackground(Color.pink);
                if(i==5)panelPlayer5[player.getX()][player.getY()].setBackground(Color.magenta);
                players.add(player);
            }
            startGame();
        });
    }

}