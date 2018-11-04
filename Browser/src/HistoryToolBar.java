import javax.swing.JPanel;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A toolBar that will contain the delete and clear buttons
 */

public class HistoryToolBar extends JPanel {

	//Constructor takes HistoryList as a parameter to pass to its components parameters
	public HistoryToolBar(HistoryList list) {
		//Initialize the components
		HistoryDelete delete = new HistoryDelete(list);
		HistoryClear clear = new HistoryClear(list);
		//Add them to this panel
		this.add(delete);
		this.add(clear);
	}
	
}
