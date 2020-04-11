package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    static String[][] tileMap;

    public static void main(String[] args) {

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
        mainFrame.setSize(800, 600);
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

    }
}
