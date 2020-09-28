package classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RunAnimation extends JFrame{
    public RunAnimation(){
        //для задания размера окна
        Image defaultImage=null;
        try {
            defaultImage = ImageIO.read(new File("rsc\\image1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Анимация");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(defaultImage.getWidth(null)+10,defaultImage.getHeight(null)+15);
        setLocationRelativeTo(null);
        add(new Panel());
        setVisible(true);
    }

    public static void main(String[] args){
        new RunAnimation();
    }
}