import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnJokeParametres {
    private JTextField textFieldSetup;
    private JTextField textFieldPunchline;
    private JTextField textFieldPheaseSearch;
    private JButton cancelButton;
    private JButton createJokeButton;
    private JPanel rootPanel;
    JFrame frame = new JFrame();

   public  OwnJokeParametres(){
       frame.add(rootPanel);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setSize(600, 150);
       frame.setVisible(true);


       cancelButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
               OpeningForm openingForm = new OpeningForm();
           }
       });
       createJokeButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if (textFieldPheaseSearch.getText().isEmpty()||textFieldPunchline.getText().isEmpty()||textFieldSetup.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null,"Fill all fields");
               }
               else {
                   String value[]= ReadValues();
                   GoogleSearchApiController googleSearchApiController = new GoogleSearchApiController();
                   String [] picutreValue =  googleSearchApiController.getPictures(value[2]);
                   ChoosePicture choosePicture = new ChoosePicture(picutreValue,value);
                   frame.dispose();
               }
           }
       });
   }
    public OwnJokeParametres(String setup, String punchline){
        textFieldSetup.setText(setup);
        textFieldPunchline.setText(punchline);
        frame.add(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 150);
        frame.setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                OpeningForm openingForm = new OpeningForm();
            }
        });
        createJokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldPheaseSearch.getText().isEmpty()||textFieldPunchline.getText().isEmpty()||textFieldSetup.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill all fields");
                }
                else {
                    String value[]= ReadValues();
                    GoogleSearchApiController googleSearchApiController = new GoogleSearchApiController();
                    String [] picutreValue =  googleSearchApiController.getPictures(value[2]);
                    ChoosePicture choosePicture = new ChoosePicture(picutreValue,value);
                    frame.dispose();

                }
            }
        });
    }
    public String []ReadValues(){
       String[] ans = new String[3];
       ans [0]=textFieldSetup.getText();
       ans [1] = textFieldPunchline.getText();
       ans [2] = textFieldPheaseSearch.getText();
       return ans;
    }
}
