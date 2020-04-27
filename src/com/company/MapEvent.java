package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MapEvent {

    public void checkEvent(String id, Player player){
        switch (id){
            case("11"):
                whiteHarbor(player);
                break;

            case("21"):
                break;

            case("31"):
                break;

            case("41"):
                break;

            case("12"):
                break;

            case("22"):
                break;

            case("32"):
                break;

            case("42"):
                break;
        }
    }

    private void whiteHarbor(Player player){
        int answer = JOptionPane.showConfirmDialog(null, "Зайти в Порт Белая Гавань?",null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (answer == 0){
            JDialog dialog = new JDialog();
        }
    }
//    buy_button.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//            new messageActionDiaolog();
//        }
//    });
    //buttonAction.add(buy_button);
    //    private static JButton buy_button = new JButton("Покупка");
//    public static class messageActionDiaolog extends JDialog{
//        public messageActionDiaolog(){
//            super(mainFrame, "", true);
//            Toolkit toolkit = Toolkit.getDefaultToolkit();
//            Dimension dimension = toolkit.getScreenSize();
//            setBounds(dimension.width / 2 - 75, dimension.height / 2 - 75, 150, 150);
//
//            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            JPanel Top_Panel = new JPanel();
//            JPanel Center_Panel = new JPanel();
//            JPanel Bottom_Panel = new JPanel();
//            add(Top_Panel);
//            add(Center_Panel);
//            add(Bottom_Panel);
//
//            JLabel actionMessage = new JLabel("Место");
//            Top_Panel.add(actionMessage);
//
//            JLabel str = new JLabel("Ваше золото: "+ players.get(index).getGold());
//            Center_Panel.add(str);
//
//            JLabel str1 = new JLabel("Ваши лошади: "+ players.get(index).getHorse());
//            Center_Panel.add(str1);
//
//
//            JButton Buy = new JButton("Купить");
//            Bottom_Panel.add(Buy);
//
//            Buy.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent actionEvent) {
//                    setVisible(false);
//                    dispose();
//                }
//            });
//
//            add(Top_Panel, BorderLayout.NORTH);
//            add(Center_Panel, BorderLayout.CENTER);
//            add(Bottom_Panel, BorderLayout.SOUTH);
//
//            setVisible(true);
//
//        }
//    }

}
