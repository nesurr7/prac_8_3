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
    private Timer timer;
    private int counter = 0;//для цикличности
    public static int imageWidth, imageHeight;

    public Panel() {
        loadImages();
        timer = new Timer(250, this);
        timer.start();
        counter = images.toArray().length;
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
        g.drawImage((images.get(counter % 5)), 0, 0, imageWidth, imageHeight, this);
        counter++;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
