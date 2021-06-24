import com.sun.jdi.Value;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChoosePicture {
    private JComboBox comboBoxPicureSelected;
    private JButton chooseButton;
    private JPanel rootPanel;
    private JLabel left;
    private JLabel center;
    private JLabel right;
    JFrame frame = new JFrame();

    ChoosePicture(String pictures[],String text[]){
        comboBoxPicureSelected.addItem("Pick left");
        comboBoxPicureSelected.addItem("Pick center");
        comboBoxPicureSelected.addItem("Pick right");

        Image imageleft = null;
        Image imageCenter = null;
        Image imageRight = null;
        try {
            URL urlLeft = new URL(pictures[0]);
            URL urlCenter = new URL(pictures[1]);
            URL urlRight = new URL(pictures[2]);
            imageleft = ImageIO.read(urlLeft);
            imageCenter = ImageIO.read(urlCenter);
            imageRight = ImageIO.read(urlRight);
            imageleft.getScaledInstance(220,220, Image.SCALE_SMOOTH);
            ImageIcon iconleft = new ImageIcon(imageleft);
            ImageIcon iconCenter = new ImageIcon(imageCenter);
            ImageIcon iconRight = new ImageIcon(imageRight);

            left.setIcon(iconleft);
            right.setIcon(iconRight);
            center.setIcon(iconCenter);
            rootPanel.setVisible(true);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        frame.add(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pictureChoosen;
                if(ReadValue()==0){
                    pictureChoosen = pictures[0];
                }
                else if (ReadValue()==1){
                    pictureChoosen=pictures[1];
                }
                else {
                    pictureChoosen = pictures[2];
                }
                ImageIO.scanForPlugins();
                URL urlLeft = null;
                try {
                    urlLeft = new URL(pictureChoosen);
                } catch (MalformedURLException malformedURLException) {
                    malformedURLException.printStackTrace();
                }
                try {
                    BufferedImage inputimage = ImageIO.read(urlLeft);
                    File file = new File(".");
                    for(String fileNames : file.list()) System.out.println(fileNames);
                    BufferedImage outputImage = new BufferedImage(1024,
                            768, inputimage.getType());
                    Graphics2D g2d = outputImage.createGraphics();
                    g2d.drawImage(inputimage, 0, 0, 1024, 768, null);
                    g2d.dispose();
                    String outputImagePath = "ImageMemeGenerator.png";
                    String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
                    Graphics g = outputImage.getGraphics();
                    g.setFont(g.getFont().deriveFont(30f));

                    g.drawString(text[0], 100, 100);
                    g.drawString(text[1],100,700);
                    g.dispose();
                    ImageIO.write(outputImage, formatName, new File(outputImagePath));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Image of meme generated in files.");
                System.out.println("Image Created");
                frame.dispose();

            }
        });
    }
    public int  ReadValue(){
        int value = comboBoxPicureSelected.getSelectedIndex();
        System.out.println(value);
        return value;

    }

}
