import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import javax.swing.JButton;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A back button class that when clicked will make a web pane display the previously visited page
 */

//Class extends JButton
public class BackButton extends JButton{
	
	//Constructor for the class, takes a WebBrowserPane as a parameter so it can manipulate it
	public BackButton(final WebBrowserPane webPane){
		//Call to super constructor sets the buttons text to read the string passed as a parameter (in this case it will read "<<")
		super("<<"); 
		//Initially have the button be disabled (as there are no pages to go back to)
		this.setEnabled(false);
		//Add an action listener that will fire when the button is clicked 
		this.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//call the private back method
		        back(webPane);
		    }
		});
		//Add a property change listener that will check it the web pane has  loaded a new page
		webPane.addPropertyChangeListener("page", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				//call the private update method
				update(webPane);							
			}
		});
	}

	//Back method, when called will cause the web pane passed as a parameter to show the previously visited page
	private void back(WebBrowserPane webPane) {
		//Check to see if the web pane has visited any pages before the current one
		if(!webPane.getBackPageList().isEmpty()) 
		//If so then update the pane to show the previous page by calling the updatePage method, pop the previous page from the BackPageList stack, pass true to add the current page to the NextPageList stack
		webPane.updatePage(webPane.getBackPageList().pop(), false, true);
	}
	
	//Update method will update the setEnabled state of the button
	private void update(WebBrowserPane webPane) {
		//Sets the button to enabled (true) if there are pages to go back to and disabled (false) if there are no pages to go back to
		this.setEnabled(!webPane.getBackPageList().isEmpty());
	}
	
}
