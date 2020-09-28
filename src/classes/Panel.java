package classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Panel extends JPanel implements ActionListener {
    private ArrayList<Image> images = new ArrayList<>();
    private int arrLen;
    private int counter = 0;//для цикличности
    private static int imageWidth, imageHeight;

    public Panel() {
        Timer timer;
        loadImages();
        timer = new Timer(250, this);
        timer.start();
        arrLen = images.toArray().length;
        imageWidth = images.get(0).getWidth(null);
        imageHeight = images.get(0).getHeight(null);

    }

    private void loadImages() {
        File directory = new File("rsc");
        File[] files = directory.listFiles();
        for (File file : files) {
            try {
                images.add(ImageIO.read(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage((images.get(counter % arrLen)), 0, 0, imageWidth, imageHeight, this);
        counter++;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
