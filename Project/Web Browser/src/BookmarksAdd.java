import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A menu item working as a button, when clicked it will create a new BookmarksMenuItem of the web page currently being
 */

//Class extends JMenuItem
public class BookmarksAdd extends JMenuItem{

	//Constructor for class, takes a WebBrowserPane and a BookmarksMenu as parameters
	public BookmarksAdd(final WebBrowserPane webPane, final BookmarksMenu menu) {
		//Super constructor sets the text of this item to "Add To Bookmarks"
		super("Add To Bookmarks");
		//Adds an action listener that will fire when the menu item is clicked
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Call addBookmark passing the constructor parameters as method parameters
                addBookmark(webPane, menu);
            }
        });
	}
	
	//AddBookmark method adds a new BookmarksMenuItem to the BookmarksMenu with the value of the url currently being displayed by the web pane
	private void addBookmark(WebBrowserPane webPane, BookmarksMenu menu) {
		//Add the new Bookmark to the menu
		menu.add(new BookmarksMenuItem(webPane, menu, webPane.getPage().toString()));
		//Add the bookmarks to the list
		menu.getBookmarkList().add(webPane.getPage().toString());
		//Update and save the list in a text file
		menu.updateBookmarks();
	}
	
}
