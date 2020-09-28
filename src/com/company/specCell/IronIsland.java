package com.company.specCell;

import com.company.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class IronIsland {

    private int trade_counter = 0;
    private boolean resolution = false;
    //TODO ченить придумать по поводу смерти
    private static String[] items = {
            "Овца",
            "Лошадь",
            "Дерево",
            "Руда",
            "Керамика",
            "Одежда",
            "Виноделие",
            "Оружие"
    };

    private JComboBox ComboBox1 = new JComboBox(items);
    private JComboBox ComboBox2 = new JComboBox(items);

    private int findChangeItem(String param){
        switch (param){
            case("Овца"):
                return 1;

            case("Лошадь"):
                return 2;

            case("Руда"):
                return 3;

            case("Керамика"):
                return 4;

            case("Одежда"):
                return 5;

            case("Виноделие"):
                return 6;

            case("Оружие"):
                return 7;

            default:
                return -1;
        }
    }

    public IronIsland(Player player) {
        JFrame ironIslandFrame = new JFrame("Железные Острова");
        ironIslandFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        ironIslandFrame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);

        JPanel Top_Panel = new JPanel();
        JPanel Center_Panel = new JPanel();
        JPanel Bottom_Panel = new JPanel();

        ComboBox1.setEditable(true);
        ComboBox2.setEditable(true);

        JLabel attempts = new JLabel("");
        JLabel playerName = new JLabel("На клетке: " + player.getName());

        Top_Panel.add(playerName);
        Top_Panel.add(attempts);

        Center_Panel.add(ComboBox1);
        Center_Panel.add(ComboBox2);


        JButton change = new JButton("Обменять");
        JButton start = new JButton("Начать работать");
        JButton end = new JButton("Выйти");

        Center_Panel.add(change);
        Center_Panel.add(start);

        JLabel message = new JLabel("");
        Bottom_Panel.add(message);
        Bottom_Panel.add(end);

        start.addActionListener(e -> {
            if (player.getAttempt() < 3){
                Center_Panel.remove(change);
                ironIslandFrame.pack();
                ironIslandFrame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
                player.addAttempt();
                String str = "Ваши попытки: " + player.getAttempt() + "/3";
                attempts.setText(str);
                Random random = new Random();
                if (random.nextInt(6) + 1 == 6){
                    message.setText("Неудача! Для Вас игра окончена!");
                    Center_Panel.remove(start);
                    player.setDead(true);

                    //TODO перевод игрока в клетку с цитаделью
                }else{
                    message.setText("Вы получили Золото!");
                    player.addGold(100);
                    int answer = JOptionPane.showConfirmDialog(null, "Вы будете продолжать работать?",null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (answer == 0){
                        player.setMobile(false);
                        ironIslandFrame.dispose();
                    }else{
                        ironIslandFrame.dispose();
                        player.resetAttempt();
                        player.setMobile(true);
                    }
                }
            }else{
                message.setText("Закончились попытки");
            }

        });

        change.addActionListener(e -> {
            if (resolution){

                if (trade_counter < 4){
                    String item = (String)ComboBox1.getSelectedItem();
                    String new_item = (String)ComboBox2.getSelectedItem();
                    if(item.equals(new_item)){
                        JOptionPane.showMessageDialog(null, "Обмен не возможен!");
                    }else{
                        int id = findChangeItem(item);
                        if(id == 1 && player.getSheep() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeSheep(1);
                            switch (new_id){
                                case(2):
                                    player.addForest(1);
                                    break;
                                case (3):
                                    player.addOre(1);
                                    break;
                                case(4):
                                    player.addCeramic(1);
                                    break;
                                case(5):
                                    player.addCloth(1);
                                    break;
                                case(6):
                                    player.addWinemaking(1);
                                    break;
                                case(7):
                                    player.addGun(1);
                                    break;
                            }
                            trade_counter++;
                        } else if( id == 2 && player.getForest() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeForest(1);
                            switch (new_id){
                                case(1):
                                    player.addSheep(1);
                                    break;
                                case (3):
                                    player.addOre(1);
                                    break;
                                case(4):
                                    player.addCeramic(1);
                                    break;
                                case(5):
                                    player.addCloth(1);
                                    break;
                                case(6):
                                    player.addWinemaking(1);
                                    break;
                                case(7):
                                    player.addGun(1);
                                    break;
                            }
                            trade_counter++;
                        } else if (id == 3 && player.getOre() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeOre(1);
                            switch (new_id){
                                case(2):
                                    player.addForest(1);
                                    break;
                                case (1):
                                    player.addSheep(1);
                                    break;
                                case(4):
                                    player.addCeramic(1);
                                    break;
                                case(5):
                                    player.addCloth(1);
                                    break;
                                case(6):
                                    player.addWinemaking(1);
                                    break;
                                case(7):
                                    player.addGun(1);
                                    break;
                            }
                            trade_counter++;
                        } else if (id == 4 && player.getCeramic() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeCeramic(1);
                            switch (new_id){
                                case(2):
                                    player.addForest(1);
                                    break;
                                case (3):
                                    player.addOre(1);
                                    break;
                                case(1):
                                    player.addSheep(1);
                                    break;
                                case(5):
                                    player.addCloth(1);
                                    break;
                                case(6):
                                    player.addWinemaking(1);
                                    break;
                                case(7):
                                    player.addGun(1);
                                    break;
                            }
                            trade_counter++;
                        } else if (id == 5 && player.getCloth() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeCloth(1);
                            switch (new_id){
                                case(2):
                                    player.addForest(1);
                                    break;
                                case (3):
                                    player.addOre(1);
                                    break;
                                case(4):
                                    player.addCeramic(1);
                                    break;
                                case(1):
                                    player.addSheep(1);
                                    break;
                                case(6):
                                    player.addWinemaking(1);
                                    break;
                                case(7):
                                    player.addGun(1);
                                    break;
                            }
                            trade_counter++;
                        } else if (id == 6 && player.getWinemaking() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeWinemaking(1);
                            switch (new_id){
                                case(2):
                                    player.addForest(1);
                                    break;
                                case (3):
                                    player.addOre(1);
                                    break;
                                case(4):
                                    player.addCeramic(1);
                                    break;
                                case(5):
                                    player.addCloth(1);
                                    break;
                                case(1):
                                    player.addSheep(1);
                                    break;
                                case(7):
                                    player.addGun(1);
                                    break;
                            }
                            trade_counter++;
                        } else if (id == 7 && player.getGun() >= 1){
                            int new_id = findChangeItem(new_item);
                            player.removeGun(1);
                            switch (new_id){
                                case(2):
                                    player.addForest(1);
                                    break;
                                case (3):
                                    player.addOre(1);
                                    break;
                                case(4):
                                    player.addCeramic(1);
                                    break;
                                case(5):
                                    player.addCloth(1);
                                    break;
                                case(6):
                                    player.addWinemaking(1);
                                    break;
                                case(1):
                                    player.addSheep(1);
                                    break;
                            }
                            trade_counter++;
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "У Вас больше нет обменов!");
                    Center_Panel.remove(change);
                }
            }else{
                if(player.getGold() >= 20){
                    player.removeGold(20);
                    resolution = true;
                    message.setText("Вход оплачен");
                    Center_Panel.remove(start);
                    ironIslandFrame.pack();
                    ironIslandFrame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);
                }else{
                    message.setText("У вас нет денег для оплаты входа!");
                }
            }
        });

        end.addActionListener(e -> {
            ironIslandFrame.setVisible(false);
            ironIslandFrame.dispose();
        });


        ironIslandFrame.add(Top_Panel, BorderLayout.NORTH);
        ironIslandFrame.add(Center_Panel, BorderLayout.CENTER);
        ironIslandFrame.add(Bottom_Panel, BorderLayout.SOUTH);

        ironIslandFrame.setVisible(true);
    }
}
