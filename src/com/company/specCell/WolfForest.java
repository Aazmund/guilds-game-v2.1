package com.company.specCell;

import com.company.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WolfForest {
    private boolean resolution = false;
    public WolfForest(Player player){
        JFrame wolfForestFrame = new JFrame("Волчий Лес");
        wolfForestFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        wolfForestFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 400, 300);

        JPanel Top_Panel = new JPanel();
        JPanel Center_Panel = new JPanel();
        JPanel Bottom_Panel = new JPanel(new GridLayout(3,1));

        wolfForestFrame.setLayout(new GridLayout(4,1));

        JLabel attempts = new JLabel("");
        JLabel playerName = new JLabel("На клетке: " + player.getName());
        Top_Panel.add(playerName);
        Top_Panel.add(attempts);

        JButton Start = new JButton("Начать работу");
        JButton end = new JButton("Выйти");
        JButton buyForestBtn = new JButton("Купить лес");
        Center_Panel.add(Start);
        Center_Panel.add(buyForestBtn);

        JLabel result = new JLabel("Результат:");
        Bottom_Panel.add(result);

        JLabel message = new JLabel("");
        Bottom_Panel.add(message);
        Bottom_Panel.add(end);

        end.addActionListener(e -> {
            wolfForestFrame.setVisible(false);
            wolfForestFrame.dispose();
        });

        Start.addActionListener(e -> {
            if (player.getAttempt() < 3){
                Center_Panel.remove(buyForestBtn);
                wolfForestFrame.pack();
                wolfForestFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 400, 300);
                player.addAttempt();
                String str = "Ваши попытки: " + player.getAttempt() + "/3";
                attempts.setText(str);
                Random random = new Random();
                if (random.nextInt(6) + 1 == 6){
                    message.setText("Неудача! Вы отправляетесь в цитадель");
                    Center_Panel.remove(Start);

                    //TODO перевод игрока в клетку с цитаделью
                }else{
                    message.setText("Вы получили лес!");
                    player.addForest(1);
                    int answer = JOptionPane.showConfirmDialog(null, "Вы будете продолжать работать?",null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (answer == 0){
                        player.setMobile(false);
                        wolfForestFrame.dispose();
                    }else{
                        wolfForestFrame.dispose();
                        player.resetAttempt();
                        player.setMobile(true);
                    }
                }
            }else{
                message.setText("Закончились попытки");
            }

        });

        buyForestBtn.addActionListener(e -> {
            if (resolution){
                if (player.getGold() >= 50){
                    player.removeGold(50);
                    player.addForest(1);
                    message.setText("Вы купили лес");
                }else{
                    message.setText("У вас нет денег для покупки!");
                }
            }else{
                if(player.getGold() >= 20){
                    player.removeGold(20);
                    resolution = true;
                    message.setText("Вход оплачен");
                    Center_Panel.remove(Start);
                    wolfForestFrame.pack();
                    wolfForestFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 400, 300);
                }else{
                    message.setText("У вас нет денег для оплаты входа!");
                }
            }
        });

        wolfForestFrame.add(Top_Panel, BorderLayout.NORTH);
        wolfForestFrame.add(Center_Panel, BorderLayout.CENTER);
        wolfForestFrame.add(Bottom_Panel, BorderLayout.SOUTH);

        wolfForestFrame.setVisible(true);
    }
}
