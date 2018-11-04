import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A web browser pane that will handle the loading and storing of pages in a session
 */

public class WebBrowserPane extends JEditorPane implements HyperlinkListener {

	//Stacks to store the back and next pages
	private ArrayDeque<URL> backPageList = new ArrayDeque<URL>();
	private ArrayDeque<URL> nextPageList = new ArrayDeque<URL>();
	
	//Constructor for the class
	public WebBrowserPane() {
		super();
		this.setContentType("text/html");
		this.setEditable(false);
		this.addHyperlinkListener(this);
	}
	
	//Update page method updates the web pane to display the passed url, boolean parameters indicate which stack the current pages url should be passed to 
	public void updatePage(URL page, boolean addToBackList, boolean addToFowardList) {
		URL currentURL = this.getPage();
		try {
			this.setPage(page);
			if(addToBackList){
				this.getBackPageList().push(currentURL);	
			}
			if(addToFowardList) {
				this.getNextPageList().push(currentURL);
			}
		} catch (IOException e) {

		}
	}

	//veryfyURl page creates a url based on a string, returns null if the url is invalid or does not exist
	public URL verifyUrl(String url) {
		URL verifiedUrl = null;

		//Check if url is http or https 
		if(url.startsWith("http://") || url.startsWith("https://")) {
			try {
				//check if web page can be found
				if(this.getResponseCode(url) == 404) {
					throw new Exception();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error 404: Webpage not found", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			try {
				verifiedUrl = new URL(url);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Invalid URL (URL has been entered incorrectly)", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid URL (http or https only)", "Error", JOptionPane.ERROR_MESSAGE);;
			return null;
		}
		return verifiedUrl;
	}
	
	
	//GetResponseCode gets the "GET" response code of the current url
	private static int getResponseCode(String urlString) throws MalformedURLException, IOException {
	    URL currentURL = new URL(urlString); 
	    HttpURLConnection connection =  (HttpURLConnection)  currentURL.openConnection(); 
	    connection.setRequestMethod("GET"); 
	    connection.connect(); 
	    return connection.getResponseCode();
	}
	
	//Process an hyperlink click
	@Override
	public void hyperlinkUpdate(HyperlinkEvent event) {
		HyperlinkEvent.EventType eventType = event.getEventType();
		if (eventType == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				this.updatePage(event.getURL(), true, false);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	//Get the backPageList
	public ArrayDeque<URL> getBackPageList() {
		return backPageList;
	}

	//Get the nextPageList
	public ArrayDeque<URL> getNextPageList() {
		return nextPageList;
	}
}
