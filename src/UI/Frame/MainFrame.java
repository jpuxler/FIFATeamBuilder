package UI.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainFrame extends JFrame{
	
	
	private ArrayList<String> playerPool = new ArrayList<String>();

	
	private String st = "          - STÜRMER";
	private String mi = "          - MITTELFELD";
	private String ve = "          - VERTEIDIGER";
	private String tw = "          - TORWART";
	
	private JPanel panel;
	private Border border;
	private JLabel label;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private DefaultListModel<String> model_list_eins, model_list_zwei;
	private JList list_team_eins, list_team_zwei;
	private JButton generatePlayer1, generatePlayer2;
	
	public MainFrame(int width, int height) {
		super();
		fillPlayerPool();
		configureJFrame(width, height);
		createFrame();
	}
	
	private void createFrame() {
		
		menuBar = new JMenuBar();
		
		setJMenuBar(menuBar);
		
		menu = new JMenu("Spiel");
		
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Neues Spiel");
		menuItem.addActionListener(e -> {
			model_list_eins.clear();
			model_list_zwei.clear();
		});
		menu.add(menuItem);
		
		
		border = BorderFactory.createLineBorder(Color.black);
		setLayout(new GridLayout(1, 2));
		
		// Panel links Player 1
		
		model_list_eins = new DefaultListModel<String>();
		list_team_eins = new JList(model_list_eins);
		list_team_eins.setLayoutOrientation(JList.VERTICAL);
		
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel("Team: 1");
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panel.setBorder(border);
		panel.add(list_team_eins, BorderLayout.CENTER);
		
		generatePlayer1 = new JButton("Neuer Spieler");
		generatePlayer1.addActionListener(e -> {
			addPlayerToList(model_list_eins);
			list_team_eins.validate();
		});
		panel.add(generatePlayer1, BorderLayout.SOUTH);
		
		add(panel);
		
		model_list_zwei = new DefaultListModel<String>();
		list_team_zwei = new JList(model_list_zwei);
		list_team_zwei.setLayoutOrientation(JList.VERTICAL);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		label = new JLabel("Team: 2");
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.NORTH);
		panel.setBorder(border);
		panel.add(list_team_zwei, BorderLayout.CENTER);
		
		generatePlayer2 = new JButton("Neuer Spieler");
		generatePlayer2.addActionListener(e -> {
			addPlayerToList(model_list_zwei);
			list_team_zwei.invalidate();
			
		});
		panel.add(generatePlayer2, BorderLayout.SOUTH);
		add(panel);
		
	}
	
	private void fillPlayerPool() {
		// STÜRMER
		playerPool.add("Messi - Barcelona" + st);
		playerPool.add("C. Ronaldo - Inter Mailand" + st);

		
		//MITTELFELD
		playerPool.add("Pogba - Manchester United" + mi);
		
		// Verteidiger 
		playerPool.add("Van Dijk - Liverpool" + ve);
		
		// TORWART
		playerPool.add("Manuel Neuer - Bayern " + tw);
	}
	
	private void addPlayerToList(DefaultListModel<String> list) {
		if(list.getSize() < 11) {
			
			int index = (int)(Math.random() * playerPool.size());
			list.addElement(playerPool.get(index));			
		}
		
	}
	
	
	private void configureJFrame(int width, int height) {
		setSize(new Dimension(width, height));
		setTitle("FifaTeamBuilder");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
