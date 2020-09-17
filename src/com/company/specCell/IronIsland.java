package com.company.specCell;

import com.company.Player;

import javax.swing.*;
import java.awt.*;

public class IronIsland {
    //TODO ченить придумать по поводу смерти
    private static String[] items = {
            "Золото",
            "Овцы",
            "Дерево",
            "Ферма",
            "Мельница",
            "Керамика",
            "Одежда",
            "Виноделие",
            "Оружие"
    };

    private static String[] player = {
            "Игрок 1",
            "Игрок 2",
            "Игрок 3",
            "Игрок 4",
            "Игрок 5",
            "Игрок 6",
    };

    private static JComboBox ComboBox1 = new JComboBox(items);
    private static JComboBox ComboBox2 = new JComboBox(items);
    private static JComboBox Player = new JComboBox(player);

    public IronIsland(Player player) {
        JFrame ironIslandFrame = new JFrame("Железные Острова");
        ironIslandFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        ironIslandFrame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 100, 300, 200);

        JPanel Top_Panel = new JPanel();
        JPanel Center_Panel = new JPanel();
        JPanel Bottom_Panel = new JPanel();

        JLabel selectPlayer = new JLabel("Выберите игрока для обмена");
        Top_Panel.add(selectPlayer);
        Top_Panel.add(Player);


        ComboBox1.setEditable(true);
        ComboBox2.setEditable(true);

        Center_Panel.add(ComboBox1);
        Center_Panel.add(ComboBox2);


        JButton change = new JButton("Обменять");
        JButton end = new JButton("Выйти");

        Center_Panel.add(change);

        JLabel message = new JLabel("");
        Bottom_Panel.add(message);
        Bottom_Panel.add(end);

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
