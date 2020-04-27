package com.company;

import javax.swing.*;

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

}
