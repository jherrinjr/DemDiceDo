import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;

public class Die {

    private static final Integer[] dieType = {4,6,8,10,12,20};

    private final JComboBox<Integer> dieTypeComboBox;
    private final JLabel rollResultLabel;
    private final Random rand = new Random();

    public Die(){
        dieTypeComboBox = new JComboBox<>(dieType);
        rollResultLabel = new JLabel("Ready to roll!");
    }

    public void addToPanel(JPanel panel){
        panel.add(dieTypeComboBox);
        panel.add(rollResultLabel);
    }

    public void removeFromPanel(JPanel panel){
        panel.remove(dieTypeComboBox);
        panel.remove(rollResultLabel);
    }

    public void roll(){
        Integer roll = rand.nextInt((Integer) dieTypeComboBox.getSelectedItem()) + 1;
        rollResultLabel.setText(roll.toString());
    }


}
