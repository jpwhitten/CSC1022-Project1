import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JScrollPane;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: Create a functional history GUI with a list and buttons
 */

public class HistoryMenu extends JMenu{
	
	//Constructor for the class takes a web pane a s a parameter that is used in the constructors of the objects
	public HistoryMenu(final WebBrowserPane webPane) {
		//Set the text to history
		super("History");
		//Initialize the GUI components
		HistoryList list = new HistoryList(webPane);
		HistoryGo go = new HistoryGo(webPane, list);
		HistoryToolBar toolBar = new HistoryToolBar(list);
		//Add them to this menu
		this.add(go);
		this.add(list);
		this.add(toolBar);
	}
	
}
