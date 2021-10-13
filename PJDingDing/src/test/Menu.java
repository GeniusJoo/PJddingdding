package test;
//테스트용
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

// singleton pattern: 하나의  menu 여러 개가 공유
public class Menu extends JMenuBar{
	private JMenu menu;
	private JMenuItem item;
	
	
	public void addMenu(String name) {
		menu = new JMenu(name);
		this.add(menu);
	}
	public JMenu getMenu() { // menu.setMnemonic(KeyEvent.VK_?)
		return menu;
	}

	public void addMenuItem(String name, int keyShortCut, ActionListener l) {
		item = new JMenuItem(name, keyShortCut);
		item.addActionListener(l);
		menu.add(item);
	}
	public void addMenuItem(String name, KeyStroke key, ActionListener l) {
		item = new JMenuItem(name);
		item.setAccelerator(key);
		item.addActionListener(l);
		menu.add(item);
	}
	public JMenuItem getItem() { // item.seAccelerator(KeyStroke)
		return item;
	}
	
	public void finishAddItem() {
		add(menu);
	}
	

}
