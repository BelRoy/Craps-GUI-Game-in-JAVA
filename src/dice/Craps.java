/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UIManager.*;


public class Craps {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
	} catch (Exception e) {
	    // If Nimbus is not available, you can set the GUI to another look and feel.
	}	

	
        CrapsJPanel p = new CrapsJPanel();
        JFrame app = new JFrame();
        app.setResizable(false);
        app.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        app.add(p);
        app.setVisible(true);
        app.setSize(490, 400);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setTitle("Craps Game in Java -By: Boussad Yanis");
         JFrame.setDefaultLookAndFeelDecorated(true);
    }
}
