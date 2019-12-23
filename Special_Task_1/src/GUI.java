import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    JFrame frame;
    MyDrawPanel dr;

    JButton buttonH;
    JButton buttonO;
    JButton buttonC;
    JButton buttonN;
    JButton buttonSq;
    JButton buttonLine;
    Box buttonBox;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(new Dimension(800, 700));


        BorderLayout layout = new BorderLayout();
        dr = new MyDrawPanel(layout);
        dr.setPreferredSize(new Dimension(700, 650));
        frame.getContentPane().add(BorderLayout.CENTER, dr);


        buttonH = new JButton(new ImageIcon("resource\\H.png"));
        buttonO = new JButton(new ImageIcon("resource\\O.png"));
        buttonC = new JButton(new ImageIcon("resource\\C.png"));
        buttonN = new JButton(new ImageIcon("resource\\N.png"));
        buttonSq = new JButton(new ImageIcon("resource\\Sq.png"));
        buttonLine = new JButton(new ImageIcon("resource\\Line.png"));
        JButton buttonDelete = new JButton("Delete");

        buttonH.addActionListener(new HListener());
        buttonO.addActionListener(new OListener());
        buttonC.addActionListener(new CListener());
        buttonN.addActionListener(new NListener());
        buttonSq.addActionListener(new SqListener());
        buttonLine.addActionListener(new NewLineListener());
        buttonDelete.addActionListener(new DeleteListener());

        buttonBox = new Box(BoxLayout.Y_AXIS);
        buttonBox.add(buttonH);
        buttonBox.add(buttonO);
        buttonBox.add(buttonC);
        buttonBox.add(buttonN);
        buttonBox.add(buttonLine);
        buttonBox.add(buttonSq);
        buttonBox.add(buttonDelete);

        frame.add(BorderLayout.EAST, buttonBox);
        frame.pack();
    }

    public class HListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.addH();
        }
    }

    public class OListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.addO();
        }
    }

    public class CListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.addC();
        }
    }

    public class NListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.addN();
        }
    }

    public class SqListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.addSq();
        }
    }

    public class NewLineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.addLine();
        }
    }

    public class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dr.deleteLast();
        }
    }

}
