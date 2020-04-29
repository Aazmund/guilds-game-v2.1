package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MapEvent {

    private Owners owners = new Owners();

    public class CellAction extends JFrame{

        private JPanel Top_Panel = new JPanel();
        private JPanel Center_Panel = new JPanel();
        private JPanel Bottom_Panel = new JPanel();
        private JPanel Info_Panel = new JPanel();
        private JPanel Button_Panel = new JPanel();
        private JLabel str = new JLabel("Основная информация");
        JLabel str1 = new JLabel("Владелец: ");
        JLabel str2 = new JLabel("Текущие производство: ");
        JLabel str3  = new JLabel("Количество акций: ");
        JButton btn1 = new JButton("Поставить мельницу");
        JButton btn2 = new JButton("Поставить ферму");
        JButton btn3 = new JButton("Поставить керамику");
        JButton btn4 = new JButton("Поставить сукно");
        JButton btn5 = new JButton("Поставить виноделие");
        JButton btn6 = new JButton("Поставить оружие");
        JButton btn7 = new JButton("Купить акцию текущего производства");

        private void updateForm(int id){
            String buf = "";
            buf = owners.getOwnerById(id);
            str1.setText("Владелец: " + buf);
            buf = owners.getManufactureById(id);
            str2.setText("Текущее производство: " + buf);
        }

        public CellAction(int id){
            updateForm(id);
            setTitle("Взаимодействие с клеткой");
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            setBounds(dimension.width / 2 - 320, dimension.height / 2 - 90, 640, 180);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            Top_Panel.add(str);
            Info_Panel.setLayout(new GridLayout(3,1));
            Info_Panel.add(str1);
            Info_Panel.add(str2);
            Info_Panel.add(str3);
            Center_Panel.add(Info_Panel);

            Button_Panel.setLayout(new GridLayout(1,6,5,0));
            Button_Panel.add(btn1);
            Button_Panel.add(btn2);
            Button_Panel.add(btn3);
            Button_Panel.add(btn4);
            Button_Panel.add(btn5);
            Button_Panel.add(btn6);
            Button_Panel.add(btn7);
            Bottom_Panel.add(Button_Panel);

            add(Top_Panel, BorderLayout.NORTH);
            add(Center_Panel, BorderLayout.WEST);
            add(Bottom_Panel, BorderLayout.SOUTH);

            btn1.addActionListener(e -> {
                if (owners.getManufactureById(id).equals("null")){
                    owners.setManufactureById(id, "Мельница");
                }else{
                    JOptionPane.showMessageDialog(null, "На этой клетке уже есть производство!");
                }
                updateForm(id);
            });

            btn2.addActionListener(e -> {

            });

            btn3.addActionListener(e -> {

            });

            btn4.addActionListener(e -> {

            });

            btn5.addActionListener(e -> {

            });

            btn6.addActionListener(e -> {

            });

            btn7.addActionListener(e -> {

            });

            setVisible(true);
        }
    }

    public MapEvent(){
        for (int i = 100; i < 136; i++) {
            owners.addNewField(i, "null", "null");
        }
        System.out.println(owners);
    }

    public void checkEvent(String id, Player player, ArrayList<Player> players){

        if(Integer.parseInt(id) >= 100 && Integer.parseInt(id) <= 135){
            if(owners.getOwnerById(Integer.parseInt(id)).equals("null")){
                //TODO метод для покупки клетки и размещение на ней всякого
                int answer = JOptionPane.showConfirmDialog(null, "Хотите приобрести землю?",null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                switch (answer){
                    case(0):
                        if (player.getGold() >= 20){
                            player.removeGold(20);
                            owners.changeFieldOwner(Integer.parseInt(id), player.getName());
                            answer = JOptionPane.showConfirmDialog(null, "Хотите сделать постройку?",null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            switch (answer){
                                case (0):
                                    //TODO рисуем форму с взаимодействием с клеткой
                                    new CellAction(Integer.parseInt(id));
                                    break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "У Вас недостаточно денег!");
                        }
                        break;
                }
            }else if(owners.getOwnerById(Integer.parseInt(id)).equals(player.getName())){
                //TODO рисуем форму с взаимодействием с клеткой
            }else {
                //TODO платим штраф
                JOptionPane.showMessageDialog(null, "Вы попали на чужую клетку. Заплатите штраф!");
                player.removeGold(20);
                String s = owners.getOwnerById(Integer.parseInt(id));
                players.get(Integer.parseInt(s.substring(s.length() - 1)) - 1).addGold(20);
            }
            System.out.println(owners);
        }else{
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

//    public static class WhiteHarbor extends JDialog{
//        public WhiteHarbor(){
//            super(mainFrame, "WhiteHarbor", true);
//            Toolkit toolkit = Toolkit.getDefaultToolkit();
//            Dimension dimension = toolkit.getScreenSize();
//            setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 200, 200);
//
//            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            JPanel Top_Panel = new JPanel();
//            JPanel Center_Panel = new JPanel();
//            JPanel Bottom_Panel = new JPanel();
//
//            setLayout(new GridLayout(3,1));
//
//            JLabel name = new JLabel("Порт Белая Гавань");
//            Top_Panel.add(name);
//
//            JLabel attempts = new JLabel("Ваши попытки");
//            Top_Panel.add(attempts);
//
//            JButton Start = new JButton("Начать работу");
//            Center_Panel.add(Start);
//
//            JLabel result = new JLabel("Результат");
//            Bottom_Panel.add(result);
//
//            JLabel message = new JLabel("Вы получили 20 золота");
//            Bottom_Panel.add(message);
//
//
//            Start.addActionListener(actionEvent -> {
//                setVisible(false);
//                dispose();
//            });
//
//            add(Top_Panel, BorderLayout.NORTH);
//            add(Center_Panel, BorderLayout.CENTER);
//            add(Bottom_Panel, BorderLayout.SOUTH);
//
//            setVisible(true);
//        }
//    }

}
