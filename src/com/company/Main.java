package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    private static JButton[][] buttons = new JButton[11][11];


   static public void main(String[] args) {

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");

        JFrame mainFrame = new JFrame();

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Новая игра");
        JMenuItem twoPlayers = new JMenuItem("2 Игрока");
        JMenuItem threePlayers = new JMenuItem("3 Игрока");
        JMenuItem fourPlayers = new JMenuItem("4 Игрока");
        JMenuItem fivePlayers = new JMenuItem("5 Игроков");

        menu.add(twoPlayers);
        menu.add(threePlayers);
        menu.add(fourPlayers);
        menu.add(fivePlayers);

        menuBar.add(menu);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        mainFrame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 300, 800, 600);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setTitle("Guilds game");
        mainFrame.setIconImage(null);


        mainFrame.setJMenuBar(menuBar);

        mainFrame.setVisible(true);

        twoPlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
        });

        threePlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
        });

        fourPlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
        });

        fivePlayers.addActionListener(e -> {
            MapGenerator mapGenerator = new MapGenerator();
            mapGenerator.generateMap(tileMap);
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Player player = new Player();
                player.setStartPosition();
                players.add(player);
            }
        });

        JPanel Panel = new JPanel();
        JPanel Top = new JPanel();
        JPanel Bottom = new JPanel();
        ///
        JPanel Card = new JPanel();

        Card.setLayout(new GridLayout(11, 11, 1, 1));

        for (int a = 0; a < 11; a++) {
           for (int b = 0; b < 11; b++) {
               buttons[a][b] = new JButton();
               buttons[a][b].setBorder(null);
               buttons[a][b].setFocusPainted(false);
               buttons[a][b].setContentAreaFilled(false);
               if (tileMap[a][b]!="*") {
                   buttons[a][b].setIcon(new ImageIcon("graphics/rsz_1.png"));
               }
               Card.add(buttons[a][b]);
           }
        }
        ///
        JPanel Action = new JPanel();
        Action.add(new Label("История действий:") );
        String actionallabel = "";
        Action.add(new JLabel(actionallabel));
        ///
       JPanel PlayerWindow = new JPanel();

       PlayerWindow.setLayout(new GridLayout(4, 1, 1, 1));
       String playerName = "Игрок 1";
       JLabel Player_Name = (new JLabel(playerName));
       String playerGold = "Золото: 500";
       JLabel Player_Gold = (new JLabel(playerGold));
       String playerSheep = "Овцы: 10";
       JLabel Player_Sheep =(new JLabel(playerSheep));
       String playerLog = "Брёвна: 50";
       JLabel Player_Log = (new JLabel(playerLog));
       PlayerWindow.add(Player_Name);
       PlayerWindow.add(Player_Gold);
       PlayerWindow.add(Player_Sheep);
       PlayerWindow.add(Player_Log);
       ///
       JPanel ButtonAction = new JPanel();

       JButton End_button = new JButton("Завершить ход");

       ButtonAction.add(End_button);

       End_button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        ///
        Panel.setBorder(new EmptyBorder(5,5,5,5));

        Top.setLayout(new BorderLayout(5,5));
        Top.add(Card, BorderLayout.CENTER);
        Top.add(PlayerWindow, BorderLayout.EAST);

        Bottom.setLayout(new BorderLayout(5,5));
        Bottom.add(Action, BorderLayout.CENTER);
        Bottom.add(ButtonAction, BorderLayout.EAST);


        Panel.setLayout(new BorderLayout(5,5));
        Panel.add(Top, BorderLayout.CENTER);
        Panel.add(Bottom, BorderLayout.SOUTH);


        Card.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.GRAY));

        mainFrame.add(Panel);

        mainFrame.revalidate();
    }
}
