import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;



public class GUI {
	public GUI() {
		Frame container = new Frame();
		container.setSize(1000,500);
		//container.setLayout(FlowLayout);
		
		
		Button search = new Button("Search");
		search.setSize(75,20);
		search.setLocation(700, 35);
		container.add(search);
		
		TextField searchBar;
		
		
		
		
		
		searchBar = new TextField("http://www.");
		searchBar.setSize(550,20);
		searchBar.setLocation(100, 35);
		container.add(searchBar);
		JEditorPane site = new JEditorPane();
		try {
			site.setPage("http://www.yahoo.com");
			site.setEditable(false);
			site.setSize(950, 400);
			site.setLocation(25, 50);
			site.addHyperlinkListener(new Listener());
			container.add(site);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		container.setLayout(null);
		container.setResizable(true);
		container.setTitle("Java Web Browser - Lightning");
		container.addWindowListener( new WindowListener() {

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ButtonPress bp = new ButtonPress(search, site, searchBar);
		search.addActionListener(bp);
		makeVisible(container);
	}
	public void makeVisible(Frame c) {
		c.setVisible(true);
	}
}

class Listener implements HyperlinkListener{

	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getDescription());
	}
	
}
class ButtonPress implements ActionListener{
	private Button b;
	private JEditorPane ep;
	private TextField tf;
	public ButtonPress(Button b, JEditorPane ep, TextField tf) {
		this.b = b;
		this.ep = ep;
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			ep.setPage(tf.getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
