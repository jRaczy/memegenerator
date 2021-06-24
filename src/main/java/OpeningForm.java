import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningForm {
    private JButton createRandomJokeButton;
    private JButton makeYourOwnJokeButton;
    private JPanel rootPanel;
    JFrame frame = new JFrame();
    public OpeningForm() {
        frame.add(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);

        createRandomJokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DadJokesAPIController dadJokesAPIController = new DadJokesAPIController();
                String value[] = dadJokesAPIController.getRandomJoke();
                String setup = value[0];
                String punch = value[1];
                OwnJokeParametres ownJokeParametres = new OwnJokeParametres(setup,punch);
                frame.dispose();
            }
        });
        makeYourOwnJokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OwnJokeParametres ownJokeParametres = new OwnJokeParametres();
                frame.dispose();
            }
        });
    }
}
