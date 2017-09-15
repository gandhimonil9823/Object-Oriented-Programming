import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;
      final JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");
      JButton goodbyeButton = new JButton("Say Goodbye");


      helloButton.addActionListener(event -> {
         textField.setText("Hello, World!"); 
         helloButton.setEnabled(false);
         goodbyeButton.setEnabled(true);
      });


      goodbyeButton.addActionListener(event -> {
         textField.setText("Goodbye, World!");
         goodbyeButton.setEnabled(false);
         helloButton.setEnabled(true);
      });

      frame.setLayout(new FlowLayout());
      
         
      goodbyeButton.setEnabled(false);

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);
      

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
