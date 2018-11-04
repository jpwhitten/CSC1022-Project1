import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A menu that will contain a list of bookmarks, the class is also responsible for reading and saving the bookmarks to a text file, also contains an add BookMark "button"
 */

public class BookmarksMenu extends JMenu{
	
	//Private variables
	//Declare a new File with the path to the bookmarks text file
	private File bookmarks = new File("Bookmarks.txt");
	//A List of strings to store the bookmarks as they are added and removed
	private List<String> bookmarkList = new ArrayList<String>();
	
	//Constructor for class, takes a WebbrowserPane as a parameter
	public BookmarksMenu(WebBrowserPane webPane) {
		//Super constructor sets the text of theirs menu to "Bookmarks"
		super("Bookmarks");
		//Initialize a new BookmarksAdd object and add it to the menu
		BookmarksAdd addButton = new BookmarksAdd(webPane, this);
		this.add(addButton);
		//Call the readBookmarks method to get the stored bookmarks
		this.readBookmarks(this.getBookmarksFile(), webPane);
	}
	
	//ReadBookmarks gets the stored bookamrks by reading a text file line by line
	private void readBookmarks(File fin, WebBrowserPane webPane) {
		try {
			//Create Bookmarks file if it doesn't exist
			if(!bookmarks.exists()) {
				bookmarks.createNewFile();
			}
			// Construct BufferedReader from FileReader
			BufferedReader writer = new BufferedReader(new FileReader(fin));
			//Initialize a new string
			String line = null;
			//Loop through all the lines with text in them
			while ((line = writer.readLine()) != null) {
				//Add line of text to the bookmarks list
				this.getBookmarkList().add(line);
				//Create a new bookmark using the line as the bookmarURL
				this.add(new BookmarksMenuItem(webPane, this, line));
			}
			//When all the lines have been read close the reader
			writer.close();
		} catch (Exception e) {
			//Unless the user goes into the text files and inputs a invalid url never be called
		}
	}
	
	//UpdateBookmarks saves the bookmarks by looping through the bookmarks list and writing them to a text file line by line
	public void updateBookmarks() {
		try {
			//Create a new Output stream using the bookmarks file 
			FileOutputStream outputStream = new FileOutputStream(bookmarks);
			//Create a new buffered writer from the output stream
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		 	//Loop through the stored bookmarks		
			for (int i = 0; i < this.getBookmarkList().size(); i++) {
				//Save each individual bookamrk url on its own line
				writer.write(this.getBookmarkList().get(i));
				writer.newLine();
			}
		//When all the bookmarks have been saved close the writer
		writer.close();
		} catch (Exception e) {
			//Should never be called
		}
	}

	//Returns the bookmarks file
	public File getBookmarksFile() {
		return bookmarks;
	}
	
	//Returns the bookmarks list
	public List<String> getBookmarkList() {
		return bookmarkList;
	}
	
}
