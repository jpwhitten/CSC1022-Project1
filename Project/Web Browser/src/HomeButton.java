import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A button that upon being clicked returns the user to their homepage 
 */

public class HomeButton extends JButton {

	//Declare the homepage  string
	private String homePageString;
	private File homepage = new File("HomePage.txt");
	
	//Constructor takes a web pane as a parameter so the class can manipulate it
	public HomeButton(final WebBrowserPane webPane){
		//Set text to "Home"
		super("Home");
		//Set the webpane to the homepage on being loaded
		setHome(webPane);
		//Add an action listener that fires on this button being clicked 
		this.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        goHome(webPane);
		    }
		});
	}
	
	//SetHome method sets the web pane to display the home page upon being loaded, also reads the home page url and stores it
	private void setHome(WebBrowserPane webPane)  {
		try {
			//Create homepage file if it doesn't exist
			if(!homepage.exists()) {
				homepage.createNewFile();
				//Write google url to the homepage file
				FileOutputStream outputStream = new FileOutputStream(homepage);
				//Create a new buffered writer from the output stream
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
				//Loop through the stored History		
				writer.write("http://www.google.com/");
				//Close the writer
				writer.close();
			}
			//Read the homepage url and store it in the private member variable stops reading when it encounters a " " space at the end of the url (urls can not contain " ")
			homePageString = new Scanner(homepage).useDelimiter(" ").next();
			//Update the webpane with this homepage
			webPane.updatePage(webPane.verifyUrl(homePageString), false, false);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "HomePage could not be read", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			
		}
	}
	
	//GoHome method updates the webpane to display the homepage
	private void goHome(WebBrowserPane webPane) {
		webPane.updatePage(webPane.verifyUrl(homePageString), true, false);
	}
	
}
