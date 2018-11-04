import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A URL text field that users can use to go to web pages
 */

public class URLTextField extends JTextField {

	public URLTextField(final WebBrowserPane webPane) {
		//Make the text field 50 columns wide
		super(50);
		//Add a property change listener that listes for when a new page has been loaded, and set the text of the url bar to that pages url
		webPane.addPropertyChangeListener("page", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				setText(webPane.getPage().toString());							
			}
		});
		//Add a key listener that fires when enter is entered
		this.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	search(webPane);
		        }
		    }
		});
	}
	
	//Verify the entered url in the text field and update the web pane to that page if it is valid
	private void search(WebBrowserPane webPane) {
    	webPane.updatePage(webPane.verifyUrl(this.getText()), true, false);
	}
}
