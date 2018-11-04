import javax.swing.JMenuBar;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: Main menu that contains the history and bookmark menus
 */

public class Menu extends JMenuBar{
	
	//Constructor passes the webpane parameter into the components
	public Menu(WebBrowserPane webPane) {
		BookmarksMenu bookmarks = new BookmarksMenu(webPane);
		HistoryMenu history = new HistoryMenu(webPane);
		this.add(bookmarks);
		this.add(history);
		
	}
	
}