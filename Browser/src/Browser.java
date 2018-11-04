import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.HyperlinkListener;

/*
 * Author Joseph Whitten
 * Date: 22/03/2015
 * Purpose: The browser class initializes all the components to work together 
 */

public class Browser extends JFrame {

	//Initialize the WebBrowserPane, Menu and ToolBar
	private WebBrowserPane webPane = new WebBrowserPane();
	private Menu menu = new Menu(webPane);
	private ToolBar toolBar= new ToolBar(webPane);

	public Browser()
	{
		//Set the title of the window
		super("Web browser");
		//Set the window size
		setSize(960, 720);
		//Set the close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the menu
		setJMenuBar(menu);
		
		//Set the layout of the components
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(toolBar, BorderLayout.PAGE_START);
		getContentPane().add(new JScrollPane(webPane), BorderLayout.CENTER);
	
	}

}
