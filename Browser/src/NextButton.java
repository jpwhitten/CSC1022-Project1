import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;

import javax.swing.JButton;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A next button that takes users back through the more recent web pages after they have gone back
 */

public class NextButton extends JButton {

	//Constructor takes a webPane for manipulation in the class
	public NextButton(final WebBrowserPane webPane) {
		//Set the text to ">>"
		super(">>");
		//Initially disable the button
		this.setEnabled(false);
		//Add an action listener that fires when clicked
		this.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        next(webPane);
		    }
		});
		//Add a property change listener that fires when a new page is loaded by the web pane
		webPane.addPropertyChangeListener("page", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				update(webPane);							
			}
		});
	}
	
	//Next method updates the web pane to show the next page if there is one
	public void next(WebBrowserPane webPane) {
		if(!webPane.getNextPageList().isEmpty()) 
		webPane.updatePage(webPane.getNextPageList().pop(), true, false);
	}
	
	//Update the button to be enabled if it has more pages to show and disabled if it doesn't
	private void update(WebBrowserPane webPane) {
		this.setEnabled(!webPane.getNextPageList().isEmpty());
	}
	
}