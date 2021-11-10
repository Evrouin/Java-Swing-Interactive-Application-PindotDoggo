import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PindotDoggo {

    private JFrame frame;
    private ImageIcon doggoCool, doggoLove, doggoOpenMouth, doggoKindat;
    private ImageIcon doggoGulat, doggoTampo, doggoMedjTampo, doggoSuperCrying, doggoAngy;
    private ImageIcon imgWindowIcon, imgcloseIcon;
    private JButton btnClose;
    private JLabel lblDoggo;
    private JPanel pnlforehead, pnlchin, pnlnose, pnloutside, pnlsuperoutside;
    private Cursor cursor;
    private int count = 0;

    public PindotDoggo() {

        // Create a 500 x 500 frame for the desktop application
        frame = new JFrame("Pindot Doggo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0xFBAF3F));

        // Imports all dog emotes from the img folder
        doggoAngy = new ImageIcon("../img/angy.png");
        doggoCool = new ImageIcon("../img/cool.png");
        doggoLove = new ImageIcon("../img/love.png");
        doggoOpenMouth = new ImageIcon("../img/open mouth.png");
        doggoSuperCrying = new ImageIcon("../img/super crying.png");
        doggoMedjTampo = new ImageIcon("../img/medj_tampo.png");
        doggoTampo = new ImageIcon("../img/tampo.png");
        doggoKindat = new ImageIcon("../img/kindat.png");
        doggoGulat = new ImageIcon("../img/gulat.png");

        // Imports the application frame icon
        imgWindowIcon = new ImageIcon("../img/pindot_doggo_icon.png");
        frame.setIconImage(imgWindowIcon.getImage());

        // Imports the close button icon
        imgcloseIcon = new ImageIcon("../img/close.png");
        btnClose = new JButton();
        btnClose.setIcon(imgcloseIcon);
        btnClose.setBackground(new Color(0xFBAF3F));
        btnClose.setBorder(BorderFactory.createEmptyBorder());
        btnClose.setBounds(430, 15, 32, 32);
        btnClose.addActionListener(new CloseButtonListener());
        btnClose.addMouseListener(new CryListener());

        // Create a hit box for the forehead of the dog
        pnlforehead = new JPanel();
        pnlforehead.setOpaque(false);
        pnlforehead.setBounds(220, 125, 50, 30);
        pnlforehead.addMouseListener(new ForeheadHitbox());

        // Create a hit box for the chin of the dog
        pnlchin = new JPanel();
        pnlchin.setOpaque(false);
        pnlchin.setBounds(210, 260, 70, 30);
        pnlchin.addMouseListener(new ChinHitbox());

        /// Create a hit box for the nose of the dog
        pnlnose = new JPanel();
        pnlnose.setOpaque(false);
        pnlnose.setBounds(228, 188, 25, 20);
        pnlnose.addMouseListener(new BoopHitbox());

        // Create a panel for the outer part around the dog
        pnloutside = new JPanel();
        pnloutside.setOpaque(false);
        pnloutside.setBounds(65, 75, 350, 250);
        pnloutside.addMouseListener(new OutsideHitbox());

        // Create a panel for the outermost part around the dog
        pnlsuperoutside = new JPanel();
        pnlsuperoutside.setOpaque(false);
        pnlsuperoutside.setBounds(0, 0, 500, 500);
        pnlsuperoutside.addMouseListener(new SuperOutsideHitbox());

        // Default emotion of dog when the applicaiton starts
        lblDoggo = new JLabel();
        lblDoggo.setIcon(doggoTampo);
        lblDoggo.setBounds(160, 105, 169, 183);
        lblDoggo.addMouseListener(new DoggoListener());

        // Create a cursor that will act as the user's hand and will handle all of the
        // dog's interactions.
        cursor = new Cursor(Cursor.HAND_CURSOR);
        frame.setCursor(cursor);

        // Adds all components to the frame
        frame.add(btnClose);
        frame.add(pnlforehead);
        frame.add(pnlchin);
        frame.add(pnlnose);
        frame.add(lblDoggo);
        frame.add(pnloutside);
        frame.add(pnlsuperoutside);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    // Created eight (8) classes to handle all of the various interactions of the
    // dog.
    // Also created print functions to determine which class is currently in
    // session.

    private class DoggoListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoOpenMouth);
            System.out.println("opens mouth");
        }

        @Override
        public void mouseExited(MouseEvent e) {}

    }

    private class ForeheadHitbox implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (count >= 0 && count < 5) {
                lblDoggo.setIcon(doggoLove);
            } else if (count == 5) {
                lblDoggo.setIcon(doggoKindat);
                System.out.println("wink");
            } else {
                count = 0;
            }
            count++;
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoOpenMouth);
            System.out.println("opens mouth");

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    private class ChinHitbox implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            lblDoggo.setIcon(doggoAngy);
            count++;
            if (count >= 30) {
                lblDoggo.setIcon(doggoSuperCrying);
            }
            System.out.println("no chin rub");

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoMedjTampo);
            System.out.println("bad spot");

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    private class BoopHitbox implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            lblDoggo.setIcon(doggoCool);
            System.out.println("cool doggo");

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            lblDoggo.setIcon(doggoCool);

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoGulat);
            System.out.println("boop");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
        }

    }

    private class OutsideHitbox implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoMedjTampo);
        }

        @Override
        public void mouseExited(MouseEvent e) {}

    }

    private class SuperOutsideHitbox implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoTampo);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    private class CloseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == btnClose) {
                frame.dispose();
            }
        }
    }

    private class CryListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            lblDoggo.setIcon(doggoSuperCrying);
            System.out.println("no leave");

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    // Runs the PindotDoggo Application
    public static void main(String[] args) {
        new PindotDoggo();
    }

}