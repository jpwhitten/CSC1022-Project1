import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JMenuItem;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A menu item working as a button, it will serve as a sub menu item to each bookmark and when clicked will cause the web pane to display the url of it parent bookmark
 */

//Class extends JMenuItem
public class BookmarkGoTo extends JMenuItem{

	//Constructor for the class, takes a WebBrowserPane as a parameter so it can manipulate it, and a string (the url of its parent bookmark)
	public BookmarkGoTo(final WebBrowserPane webPane, final String boomkarkURL) {
		//Super constructor sets the text of the menu item to "Go >>"
		super("Go >>"); 
		//Add an action listener that will fire when the menu item is clicked
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Call the private method goTo passing the constructor parameters as the method parameters
                goTo(webPane, boomkarkURL);
            }
        });
	}
	
	//GoTo method will make the passed webPane display the passed string (the url of the bookmark in this case)
	private void goTo(WebBrowserPane webPane, String boomkarkURL) {
		//Create a url from the string
		URL url = webPane.verifyUrl(boomkarkURL);
		//Update the webpane to show the bookmarks url, pass true add previously shown page to the BackPageList stake
		webPane.updatePage(url, true, false);
	}
	
}
