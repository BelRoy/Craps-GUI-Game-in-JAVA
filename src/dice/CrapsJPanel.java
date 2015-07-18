package dice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author DELL Boussad Yanis
 */

public class CrapsJPanel extends javax.swing.JPanel {
    Random rand = new Random();
    Random rand2 = new Random();
    protected int firstRollPoints = 0;  
    protected int instantRollPoints = 0;
    protected int numberOfRolls = 0;
    public CrapsJPanel() {
    	setToolTipText("Craps Game By Yanis Boussad");
    	setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    	setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        initComponents();
    }                           
    private void initComponents() {

        diceL = new javax.swing.JLabel();
        diceL.setBounds(66, 91, 117, 117);
        rollButton = new javax.swing.JButton();
        rollButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rollButton.setToolTipText("Roll the Dice");
        rollButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        rollButton.setBackground(new Color(250, 235, 215));
        rollButton.setFont(new Font("Rondalo", Font.BOLD, 24));
        rollButton.setBounds(400, 48, 60, 76);
        diceR = new javax.swing.JLabel();
        diceR.setBounds(192, 91, 117, 117);
        newGameButton = new javax.swing.JButton();
        newGameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newGameButton.setToolTipText("Start a New Game");
        newGameButton.setBackground(new Color(128, 128, 128));
        newGameButton.setFont(new Font("Rondalo", Font.PLAIN, 12));
        newGameButton.setBounds(369, 154, 91, 21);

        setBackground(Color.BLACK);

        rollButton.setText("Roll");
        rollButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        diceR.setBackground(new java.awt.Color(255, 51, 51));

        newGameButton.setText("New Game");
        newGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        setLayout(null);
        add(diceL);
        add(diceR);
        
        backgroundLabel = new JLabel("New label");
        backgroundLabel.setToolTipText("Craps Game By Yanis Boussad");
        backgroundLabel.setIcon(new ImageIcon(CrapsJPanel.class.getResource("/dice/backgroud.jpg")));
        backgroundLabel.setBounds(6, 16, 351, 264);
        add(backgroundLabel);
        add(rollButton);
        add(newGameButton);
        
        numberOfRollsTxtFld = new JTextField();
        numberOfRollsTxtFld.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        numberOfRollsTxtFld.setFont(new Font("SansSerif", Font.BOLD, 12));
        numberOfRollsTxtFld.setEditable(false);
        numberOfRollsTxtFld.setToolTipText("0");
        numberOfRollsTxtFld.setText(" 0");
        numberOfRollsTxtFld.setBounds(305, 318, 33, 22);
        add(numberOfRollsTxtFld);
        numberOfRollsTxtFld.setColumns(10);
        
        instantPointsTxtFld = new TextField();
        instantPointsTxtFld.setForeground(new Color(255, 255, 255));
        instantPointsTxtFld.setBackground(new Color(51, 0, 51));
        instantPointsTxtFld.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        instantPointsTxtFld.setFont(new Font("Dialog", Font.BOLD, 22));
        instantPointsTxtFld.setEditable(false);
        instantPointsTxtFld.setText("0");
        instantPointsTxtFld.setBounds(139, 307, 33, 31);
        add(instantPointsTxtFld);
        
        JTextArea txtrNumberOfRolls = new JTextArea();
        txtrNumberOfRolls.setEditable(false);
        txtrNumberOfRolls.setForeground(new Color(255, 250, 250));
        txtrNumberOfRolls.setFont(new Font("SansSerif", Font.BOLD, 10));
        txtrNumberOfRolls.setText("Number of rolls");
        txtrNumberOfRolls.setBackground(new Color(51, 51, 51));
        txtrNumberOfRolls.setBounds(218, 318, 89, 22);
        add(txtrNumberOfRolls);
        
        JTextArea txtrCurrentPoints = new JTextArea();
        txtrCurrentPoints.setEditable(false);
        txtrCurrentPoints.setForeground(new Color(255, 250, 250));
        txtrCurrentPoints.setToolTipText("The current sum of the spots on the two upward faces of the dice");
        txtrCurrentPoints.setFont(new Font("SansSerif", Font.BOLD, 10));
        txtrCurrentPoints.setText("Current Points");
        txtrCurrentPoints.setBackground(new Color(51, 51, 51));
        txtrCurrentPoints.setBounds(50, 318, 89, 22);
        add(txtrCurrentPoints);
        
        JButton HELPbutton = new JButton("Help");
        HELPbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HELPbutton.setToolTipText("Show Help");
        HELPbutton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	    JOptionPane.showMessageDialog(null, "	You roll two dice. Each die has six faces, which contain one,\n"
        	    	                              + "two, three, four, five and six spots, respectively. After the\n"
        	    	                              + "dice have come to rest, the sum of the spots on the two upward\n"
        	    	                              + "faces is calculated. If the sum is 7 or 11 on the first throw,\n"
        	    	                              + "you win. If the sum is 2, 3 or 12 on the first throw (called craps),\n"
        	    	                              + "you lose (i.e., the house wins). If the sum is 4,5,6,8,9 or 10 on the\n"
        	    	                              + "first throw,that sum becomes your point. To win, you must continue\n"
        	    	                              + "rolling the dice until you make your point(i.e., roll that same\n"
        	    	                              + "point value). You lose by rolling a 7 before making your point.\n\n"
        	    	                              + "   ref: Java : how to program / P.J. Deitel, H.M. Deitel. -- 9th ed, page 215.\n"
        	    	                              + "          ISBN-10: 0-13-257566-3. Prentice Hall \n ","Help-Craps Game",3);
        	}
        });
        HELPbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        HELPbutton.setBackground(new Color(47, 79, 79));
        HELPbutton.setBounds(398, 187, 60, 21);
        add(HELPbutton);
        
        JButton AboutButton = new JButton("About");
        AboutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AboutButton.setToolTipText("About");
        AboutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        AboutButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        	    JOptionPane.showMessageDialog(null, "GUI Craps Game Programmed in Java.\n"
        	    					+ "Code, Design and Graphics: YANIS Boussad.\n\n"
        	    					+ "Contact:\n"
        	    					+ "                   boussadyanis@gmail.com.\n\n"
        	    					+ "July 2014",
        	    					"About - Craps Game", 1);
        	}
        });
        AboutButton.setBackground(new Color(85, 107, 47));
        AboutButton.setBounds(398, 212, 60, 21);
        add(AboutButton);
        
        FirstPoint = new TextField();
        FirstPoint.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        FirstPoint.setForeground(new Color(255, 255, 255));
        FirstPoint.setBackground(new Color(0, 0, 51));
        FirstPoint.setFont(new Font("Times New Roman", Font.BOLD, 44));
        FirstPoint.setEditable(false);
        FirstPoint.setBounds(398, 282, 52, 55);
        add(FirstPoint);
        
       
    }// </editor-fold>  
    
    
    
    
    public void setFirstPoints(int x1){
    firstRollPoints = x1;
    JOptionPane.showMessageDialog(null, "Your first points are: "+firstRollPoints);
}

     public void Win(){
    JOptionPane.showMessageDialog(null, "You Win The Game");
}

     public void Lose(){
    JOptionPane.showMessageDialog(null, "You Lose!!. Game Over");
    jButton2MouseClicked(null);
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {  
        // TODO add your handling code here:
	
	instantRollPoints = 0;
        int dice1 = 1+rand.nextInt(6);
        int dice2 = 1+rand2.nextInt(6);
        
        switch(dice1){
            case 1: diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/1.gif")));instantRollPoints+=1;;break; 
            case 2: diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/2.gif")));instantRollPoints+=2;break;
            case 3: diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/3.gif")));instantRollPoints+=3;break;
            case 4: diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/4.gif")));instantRollPoints+=4;break;
            case 5: diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/5.gif")));instantRollPoints+=5;break;
            case 6: diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/6.gif")));instantRollPoints+=6;break;
            default:break;
        }
         switch(dice2){
            case 1: diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/1.gif")));instantRollPoints+=1;break;
            case 2: diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/2.gif")));instantRollPoints+=2;break;
            case 3: diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/3.gif")));instantRollPoints+=3;break;
            case 4: diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/4.gif")));instantRollPoints+=4;break;
            case 5: diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/5.gif")));instantRollPoints+=5;break;
            case 6: diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dice/6.gif")));instantRollPoints+=6;break;
            default:break;
        }
         numberOfRolls++;
         repaint();
         numberOfRollsTxtFld.setText(" "+numberOfRolls);
         instantPointsTxtFld.setText(""+instantRollPoints);

         
         if(numberOfRolls == 1 && (instantRollPoints != 7 && instantRollPoints != 11)){
             setFirstPoints(instantRollPoints);
             FirstPoint.setText(""+instantRollPoints);
         }
         if(numberOfRolls == 1 && (instantRollPoints == 7 || instantRollPoints == 11)){
             Win();
             jButton2MouseClicked(evt);
             
         }
         
         if(numberOfRolls == 1 && (instantRollPoints == 2 || instantRollPoints == 3 || instantRollPoints == 12)){
             Lose();
         }
         if(numberOfRolls > 1 &&  instantRollPoints == 7){
             Lose();
         }
         
         if(numberOfRolls > 1 && (instantRollPoints == firstRollPoints) && instantRollPoints != 7){
             Win();
             jButton2MouseClicked(evt);
         }
        
     

    }                                     

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
	repaint();
        numberOfRolls=0;
        instantRollPoints=0;
        firstRollPoints = 0;
        instantPointsTxtFld.setText(""+instantRollPoints);
        numberOfRollsTxtFld.setText(""+numberOfRolls);
        diceR.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        diceL.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
        FirstPoint.setText("");
        
    }                                     

    // Variables declaration - do not modify                     
    private javax.swing.JButton rollButton;
    private javax.swing.JButton newGameButton;
    private javax.swing.JLabel diceL;
    private javax.swing.JLabel diceR;
    private JLabel backgroundLabel;
    private JTextField numberOfRollsTxtFld;
    private TextField instantPointsTxtFld;
    private TextField FirstPoint;
}
