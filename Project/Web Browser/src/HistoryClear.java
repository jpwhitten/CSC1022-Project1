import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A Button, upon being pressed will clear the stored history
 */

//Class extends JMenuItem
public class HistoryClear extends JButton{
	
	//Constructor for class, takes History List as a parameter to modify some of its private member variables
	public HistoryClear(final HistoryList history) {
		//Super constructor sets the text to "Clear History"
		super("Clear History");
		//Adds an action listener that fires when this button is clicked
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear(history);
            }
        });
	}
	
	//clear method removes all elements from the vector that stores the visited urls and then updates the list with the empty vector
	private void clear(HistoryList history) {
		//remove all elements in the vector
		history.getVector().removeAllElements();
		//Update the list with the empty vector
		history.getHistoryList().setListData(history.getVector());
		//Clear the history text file
		history.updateHistory();
		
	}
	
}
