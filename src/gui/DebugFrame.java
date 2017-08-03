package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import lang.Lang;

@SuppressWarnings("serial")
public class DebugFrame extends JDialog{

	private DebugTabPane debugTabPane;
	
	public DebugFrame() 
	{
		//CREATE FRAME
		setTitle(Lang.getInstance().translate("Erachain.org") + " - " + Lang.getInstance().translate("Debug"));
		setModal(true);
		
		//ICON
		List<Image> icons = new ArrayList<Image>();
		icons.add(Toolkit.getDefaultToolkit().getImage("images/icons/icon16.png"));
		icons.add(Toolkit.getDefaultToolkit().getImage("images/icons/icon32.png"));
		icons.add(Toolkit.getDefaultToolkit().getImage("images/icons/icon64.png"));
		icons.add(Toolkit.getDefaultToolkit().getImage("images/icons/icon128.png"));
		this.setIconImages(icons);
		
		//DEBUG TABPANE
        this.debugTabPane = new DebugTabPane();
		
		//ON CLOSE
		this.addWindowListener(new WindowAdapter()
		{
            public void windowClosing(WindowEvent e)
            {
            	//CLOSE DEBUG
                debugTabPane.close();
                
                //DISPOSE
                setVisible(false);
                dispose();
            }
        });
		       
		 //ADD GENERAL TABPANE TO FRAME
        this.add(this.debugTabPane);
        
        //PACK
		this.pack();
		this.setSize(800, this.getHeight());
		setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}	
}
