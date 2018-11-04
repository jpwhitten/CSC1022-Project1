import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.Vector;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: to dynamically store a persistent history across multiple sessions and present that to the user 
 */

//Class extends JPanel
public class HistoryList extends JPanel {

	//Declare and Initialize some components and the history text file
	private Vector<String> vector =new Vector<String>();
	private JList<String> historyList = new JList<String>(vector);
	private JScrollPane scrollPane = new JScrollPane(historyList);
	private File history = new File("History.txt");
	private WebBrowserPane webPane;
	
	public HistoryList(final WebBrowserPane webPane) {
		//Set the private member variable webPane to be the the one passed in this constructor
		setWebPane(webPane);
		//Add a property change listener to check when the web pane has loaded a new web page
		webPane.addPropertyChangeListener("page", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				record(webPane);							
			}
		});
		//Set the size of the list
		historyList.setSize(new Dimension(500,400));
		//Place the list in a scroll pane
		this.add(scrollPane);
		//read the history from previous sessions
		readHistory(this.getHistory());
	}
	
	//ReadHistory method reads in a history of urls line by line from a text file
	private void readHistory(File file) {
		try {
			//Create History file if it doesn't exist
			if(!history.exists()) {
				history.createNewFile();
			}
			// Construct BufferedReader from FileReader
			BufferedReader reader = new BufferedReader(new FileReader(file));
			//Set the line to be null
			String line = null;
			//Read the file line by line until a null line is met
			while ((line = reader.readLine()) != null) {
				//Add this line to the vector
				this.getVector().add(line);
			}
			//close the reader
			reader.close();
			//Update the list with the updated vector
			this.getHistoryList().setListData(vector);
		} catch (IOException e) {
			//Should never get called
		}
	}
	
	//UpdateHistory method writes the history to a text file where it is stored
	public void updateHistory() {
		try {
			//Create a new Output stream using the history file 
			FileOutputStream outputStream = new FileOutputStream(this.getHistory());
			//Create a new buffered writer from the output stream
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			//Loop through the stored History		
			for (int i = 0; i < this.getVector().size(); i++) {
				//Write the history of urls line by line
				writer.write(this.getVector().get(i));
				writer.newLine();
			}
			//Close the writer
			writer.close();
		} catch (IOException e) {
			//Should never get called
		}
	}
	
	//Record methods stores the url of the current page in the history and dynamically updates the history list
	private void record(WebBrowserPane webPane) {
		//Add the current url to the vector
		vector.addElement(webPane.getPage().toString());
		//Update the list to show the new url
		historyList.setListData(vector);
		//save the history
		updateHistory();
	}
	
	//Convert a string into a URL
	URL toURL(String string) {
		URL url = null;
		try {
			url = new URL(string);
		} catch (MalformedURLException e) {
			
		}
		return url;
	}

	//Get the history List object
	public JList<String> getHistoryList() {
		return historyList;
	}

	//Get the Vector storing the urls
	public Vector<String> getVector() {
		return vector;
	}
	
	//Get the history file
	public File getHistory() {
		return history;
	}
	
	//Set the private member variable
	private void setWebPane(WebBrowserPane webPane) {
		this.webPane = webPane;
	}
}
