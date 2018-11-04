import java.awt.event.*;
import java.net.*;

import javax.swing.*;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A menu the will represent a bookmark, its name will be its url
 */

//Class extends JMenu
public class BookmarksMenuItem extends JMenu{
	
	//Constructor for class, takes three parameters that are used in the constructors of the declared objects, passing them down the hierarchy
	public BookmarksMenuItem(final WebBrowserPane webPane, final BookmarksMenu bookmarks,  String name) {
		//Super constructor sets its text to the name parameter
		super(name);
		//Declare the remove and goto menu items that will provide the functionality
		BookmarkRemove bookmarkRemove = new BookmarkRemove(bookmarks, this);
		BookmarkGoTo bookmarkGoTo = new BookmarkGoTo(webPane, name);
		//Add the menu items to this object
		this.add(bookmarkGoTo);
		this.add(bookmarkRemove);
	}
}
