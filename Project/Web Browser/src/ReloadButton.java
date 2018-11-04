import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.text.Document;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A reload button that will fetch the url of the page being displayed and display it again
 */

public class ReloadButton extends JButton{

	//Constructor takes a webPane
	public ReloadButton(final WebBrowserPane webPane)
	{
		//Set the text to "Reload"
		super("Reload");
		//Add an action listener that fires when clicked
		this.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	//fetch the current url and update the webPane
		    	URL currentURL = webPane.getPage();
		    	Document doc = webPane.getDocument();
		    	doc.putProperty(Document.StreamDescriptionProperty, null);
		    	webPane.updatePage(currentURL, false, false);
		    }
		});
	}
}
