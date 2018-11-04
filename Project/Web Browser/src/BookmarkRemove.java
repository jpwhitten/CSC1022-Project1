import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A menu item working as a button, it will serve as a sub menu item to each bookmark and when clicked will remove the bookmark from its parent menu
 */

//Class extends JMenuItem
public class BookmarkRemove extends JMenuItem{

	//Constructor for the class, takes a BookmarksMenu (the parent menu of a BookmarksMenuItem) and a BookmarksMenuItem (the parent menu of this) as parameters
	public BookmarkRemove(final BookmarksMenu bookmark, final BookmarksMenuItem item) {
		//Super constructor sets the text for this item to "Delete"
		super("Delete");
		//Adds an action listener that will fire when this menu item is clicked
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//Calls removeBookmark passing the constructor parameters as method parameters
                removeBookmark(bookmark, item);
            }
        });
	}
	
	//RemoveBookmark method removes a BookMarkMenuItemfrom its parent menu
	private void removeBookmark(BookmarksMenu bookmarks, BookmarksMenuItem item) {
		//Removes the item from its parent menu
		bookmarks.remove(item);
		//Removes the item from the list of bookmarks
		bookmarks.getBookmarkList().remove(item.getText());
		//Update and save the list of bookmarks in the text file
		bookmarks.updateBookmarks();
	}
}
