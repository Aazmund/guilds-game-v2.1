package com.company.specCell;

import com.company.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WhiteHarbor {
    private int attempt = 0;
    private boolean resolution = false;
    public WhiteHarbor(Player player){
        JFrame whiteHarborFrame = new JFrame("Порт Белая Гавань");
        whiteHarborFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        whiteHarborFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 400, 300);

        JPanel Top_Panel = new JPanel();
        JPanel Center_Panel = new JPanel();
        JPanel Bottom_Panel = new JPanel(new GridLayout(3,1));

        whiteHarborFrame.setLayout(new GridLayout(4,1));

        JLabel attempts = new JLabel("");
        Top_Panel.add(attempts);

        JButton Start = new JButton("Начать работу");
        JButton end = new JButton("Выйти");
        JButton buyHoursBtn = new JButton("Купить лошадь");
        Center_Panel.add(Start);
        Center_Panel.add(buyHoursBtn);

        JLabel result = new JLabel("Результат:");
        Bottom_Panel.add(result);

        JLabel message = new JLabel("");
        Bottom_Panel.add(message);
        Bottom_Panel.add(end);

        end.addActionListener(e -> {
            whiteHarborFrame.setVisible(false);
            whiteHarborFrame.dispose();
        });

        Start.addActionListener(e -> {
            if (attempt < 3){
                Center_Panel.remove(buyHoursBtn);
                whiteHarborFrame.pack();
                whiteHarborFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 400, 300);
                attempt++;
                String str = "Ваши попытки: " + attempt + "/3";
                attempts.setText(str);
                Random random = new Random();
                if (random.nextInt(6) + 1 == 6){
                    message.setText("Неудача! Вы отправляетесь в цитадель");
                    Center_Panel.remove(Start);

                    //TODO перевод игрока в клетку с цитаделью
                }else{
                    message.setText("Вы получили лошадь!");
                    player.addHorse(1);
                }
            }else{
                message.setText("Закончились попытки");
            }

        });

        buyHoursBtn.addActionListener(e -> {
            if (resolution){
                if (player.getGold() >= 50){
                    player.removeGold(50);
                    player.addHorse(1);
                    message.setText("Вы купили лошадь");
                }else{
                    message.setText("У вас нет денег для покупки!");
                }
            }else{
                if(player.getGold() >= 20){
                    player.removeGold(20);
                    resolution = true;
                    message.setText("Вход оплачен");
                    Center_Panel.remove(Start);
                    whiteHarborFrame.pack();
                    whiteHarborFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 400, 300);
                }else{
                    message.setText("У вас нет денег для оплаты входа!");
                }
            }
        });

        whiteHarborFrame.add(Top_Panel, BorderLayout.NORTH);
        whiteHarborFrame.add(Center_Panel, BorderLayout.CENTER);
        whiteHarborFrame.add(Bottom_Panel, BorderLayout.SOUTH);

        whiteHarborFrame.setVisible(true);
    }
}
