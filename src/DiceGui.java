import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


public class DiceGui {


    private ArrayList<Die> dice = new ArrayList<>();
    private int numberOfDice = 0;

    public DiceGui() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Throw da dice!");
        JLabel typeLabel = new JLabel("Which dice?");
        int[] range = IntStream.range(1, 11).toArray();
        final Integer[] numberOfDice = Arrays.stream(range).boxed().toArray(Integer[]::new);
        JComboBox<Integer> numberOfDiceComboBox = new JComboBox<>(numberOfDice);
        JLabel amountLabel = new JLabel("How many dice?");

        //configure panel and frame
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10 ,30));
        panel.setLayout(new GridLayout(2 ,2));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dem Dice Do!");

        // starts building the panel
        panel.add(amountLabel);
        panel.add(numberOfDiceComboBox);
        panel.add(typeLabel);
        panel.add(button);

        ActionListener diceAmountAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // generates the dice based on how many was selected above
                int diceAmount = (int) numberOfDiceComboBox.getSelectedItem();
                for (Die die : dice){
                    die.removeFromPanel(panel);
                }
                dice = new ArrayList<>();
                for (int i = 0; i < diceAmount; i++) {
                    dice.add(new Die());
                    dice.get(i).addToPanel(panel);
                }
                panel.setLayout(new GridLayout(diceAmount + 2, 2));
                frame.pack();
            }
        };
        numberOfDiceComboBox.addActionListener(diceAmountAction);

        // assigns button press to action handler that rolls dice
        ActionListener rollAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Die die : dice){
                    die.roll();
                }
            }
        };
        button.addActionListener(rollAction);

        // generate and make it goooooo
        frame.pack();
        frame.setVisible(true);
    }

     public static void main(String[] args){
        //Random rand = new Random();
        new DiceGui();
    }
}
