import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A Button that deletes a selected item from a list
 */

//Class extends JMenuItem
public class HistoryDelete extends JButton{

	//Constructor for class, takes History List as a parameter to modify some of its private member variables
	public HistoryDelete(final HistoryList history) {
		//Super constructor sets the text to "Delete History"
		super("Delete Entry");
		//Adds an action event listener that fires when clicked
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete(history);
            }
        });
	}
	
	//Delete method deletes the selected value of the JList
	private void delete(HistoryList history) {
		//Remove the selected value from the vector
		history.getVector().remove(history.getHistoryList().getSelectedValue());
		//Update the values in the list
		history.getHistoryList().setListData(history.getVector());
		//Save the new history list in a text file
		history.updateHistory();
	}
	
}
