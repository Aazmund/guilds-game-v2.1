package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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

    private static JButton[][] buttons = new JButton[11][11];
    private static JButton end_button = new JButton("Начать игру");

    private static JFrame mainFrame = new JFrame();

    private static JMenuBar menuBar = new JMenuBar();

    private static JMenu menu = new JMenu("Новая игра");

    private static JMenuItem twoPlayers = new JMenuItem("2 Игрока");
    private static JMenuItem threePlayers = new JMenuItem("3 Игрока");
    private static JMenuItem fourPlayers = new JMenuItem("4 Игрока");
    private static JMenuItem fivePlayers = new JMenuItem("5 Игроков");

    private static JPanel action = new JPanel();
    private static JPanel playerWindow = new JPanel();
    private static JPanel panel = new JPanel();
    private static JPanel top = new JPanel();
    private static JPanel bottom = new JPanel();
    private static JPanel gameMap = new JPanel();
    private static JPanel buttonAction = new JPanel();

    private static ArrayList<Player> players = new ArrayList<>();

    private static Integer index = 0;

    public static void frameConfigurator(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        menu.add(twoPlayers);
        menu.add(threePlayers);
        menu.add(fourPlayers);
        menu.add(fivePlayers);

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
                buttons[a][b] = new JButton();
                buttons[a][b].setBorder(null);
                buttons[a][b].setFocusPainted(false);
                buttons[a][b].setContentAreaFilled(false);
                if (!tileMap[a][b].equals("*")) {
                    buttons[a][b].setIcon(new ImageIcon("graphics/rsz_1.png"));
                }
                gameMap.add(buttons[a][b]);
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

        gameMap.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));
        gameMap.setLayout(new GridLayout(11, 11, 1, 1));

        buttonAction.add(end_button);

        playerWindow.setLayout(new GridLayout(4, 1, 1, 1));
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
        //TODO сделать метод по отрисовке окна с кнопочкой для генераии броска кубика
        int result = (int) (Math.random() * 6 + 1);
        actionLabelStr = "Кубик выпал стороной " + result;
        actionLabel.setText(actionLabelStr);

        return result;
    }

    public static void game(int index){
        end_button.setText("Завершить ход");
        System.out.println("Player " + index);
        showPlayerInfo(index);
        int cubeScore = showCubeGenerator();
        players.get(index).move(cubeScore);
        //TODO сюда вкорячить метод на проверку клетки на владельца, чтото типа checkCell(player.get(x), player.get(y))
    }

    public static void startGame(){
        end_button.addActionListener(e -> {
            if (index == players.size()){
                index = 0;
                game(index);
            }else{
                game(index);
                index++;
            }
        });
    }

    static public void main(String[] args) {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");

        frameConfigurator();

        mainFrame.setVisible(true);

        twoPlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            for (int i = 0; i < 2; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
            startGame();
        });

        threePlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            for (int i = 0; i < 3; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
            startGame();
        });

        fourPlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            for (int i = 0; i < 4; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
            startGame();
        });

        fivePlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            for (int i = 0; i < 5; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
            startGame();
        });
    }
}
