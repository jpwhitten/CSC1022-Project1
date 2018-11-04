import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose:  A JMenuItem that will serve as a button that upon being clicked displays the selected url on the web pane
 */

//Class extends JMenuItem
public class HistoryGo  extends JMenuItem {

	//Constructor for class takes in two parameters, it will get data from the HistoryList and use it to modify the WebBrowserPane
	public HistoryGo(final WebBrowserPane webPane, final HistoryList history) {
		//Super constructor sets the text to "GO >>"
		super("Go >>");
		//Add action listener that fires when this item is clicked
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                go(webPane, history);
            }
        });
	}

	//Go method updates the web pane to display the selected url and updates the history history
	private void go(WebBrowserPane webPane, HistoryList history) {
		webPane.updatePage(history.toURL(history.getHistoryList().getSelectedValue()), true, false);
		history.getHistoryList().setListData(history.getVector());
		history.updateHistory();
	}
	
}
