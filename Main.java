import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Main {

    static HashMap<String, String> data = new HashMap<>();

    public static void main(String[] args) {

        data.put("Hello", "Hola");
        data.put("Thank You", "Gracias");
        data.put("Goodbye", "Adios");

        JFrame f = new JFrame("Language Learning App");
        f.setSize(400, 300);
        f.setLayout(null);

        JLabel wordLabel = new JLabel("Word:");
        wordLabel.setBounds(30, 30, 100, 25);
        f.add(wordLabel);

        JLabel word = new JLabel("");
        word.setBounds(150, 30, 150, 25);
        f.add(word);

        JButton next = new JButton("Next Word");
        next.setBounds(50, 80, 120, 30);
        f.add(next);

        JButton show = new JButton("Show Meaning");
        show.setBounds(200, 80, 140, 30);
        f.add(show);

        JLabel result = new JLabel("");
        result.setBounds(50, 140, 300, 25);
        f.add(result);

        List<String> keys = new ArrayList<>(data.keySet());
        Random rand = new Random();

        final String[] current = {keys.get(0)};
        word.setText(current[0]);

        next.addActionListener(e -> {
            current[0] = keys.get(rand.nextInt(keys.size()));
            word.setText(current[0]);
            result.setText("");
        });

        show.addActionListener(e -> {
            result.setText("Meaning: " + data.get(current[0]));
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
