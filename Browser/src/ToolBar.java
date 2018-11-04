import javax.swing.JPanel;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: A toolBar that will contain the back, next, reload and home buttons and the url text field
 */

public class ToolBar extends JPanel{
	
	//Constructor parameter is passed into the components
	public ToolBar(WebBrowserPane webPane) {
		
		//Initialize
		URLTextField urlTextField = new URLTextField(webPane);
		NextButton nextButton = new NextButton(webPane);
		BackButton backButton = new BackButton(webPane);
		HomeButton homeButton = new HomeButton(webPane);
		ReloadButton reloadButton = new ReloadButton(webPane);
		
		//Add
		this.add(backButton);
		this.add(nextButton);
		this.add(reloadButton);
		this.add(homeButton);
		this.add(urlTextField);
	}
	
}
