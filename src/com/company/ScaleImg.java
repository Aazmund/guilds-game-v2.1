package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

public class ScaleImg extends JPanel  {

        private BufferedImage img;
        private Image scaled;

        public ScaleImg(BufferedImage img, int h, int w) {
            this.img = img;
            this.scaled = img;
            addComponentListener(new ComponentAdapter() {

//                @Override
//                public void componentResized(ComponentEvent e) {
//                    Dimension size = getSize();
//                    if (size.width > size.height) {
//////                        size.width = -1;
//                    } else {
//                        size.height = -64;
//                    }
//                    scaled = img.getScaledInstance(size.width, size.height, Image.SCALE_FAST);
//                }

                @Override
                public void componentResized(ComponentEvent e) {
                    Dimension size = getSize();
                    if (size.width > 0) {
                        size.width = w;
                        size.height = h;

                    }
                    scaled = img.getScaledInstance(size.width, size.height, Image.SCALE_FAST);
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return scaled == null ? new Dimension(0, 0) : new Dimension(scaled.getWidth(this), scaled.getHeight(this));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (scaled != null) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.drawImage(scaled, 0, 0, this);
                g2.dispose();
            }
        }
    }
