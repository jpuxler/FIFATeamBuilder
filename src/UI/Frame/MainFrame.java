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
		playerPool.add("C. Ronaldo -  Juventus" + st);
		playerPool.add("Gameiro - Valencia" + st);
		playerPool.add("Lukaku - Inter Mailand" + st);
		playerPool.add("Neymar - PSG" + st);
		playerPool.add("Joker" + st);
		playerPool.add("E. Hazard - Real Madrid" + st);
		playerPool.add("Mbappe - PSG" + st);
		playerPool.add("Rebic - AC Mailand" + st);
		playerPool.add("Cavani - PSG" + st);
		playerPool.add("Aubameyang - Arsenal" + st);
		playerPool.add("Ibrah - AC Mailand" + st);
		playerPool.add("Dybala - Juventus" + st);
		playerPool.add("Lewandowski - Bayern" + st);
		playerPool.add("Countiho - Bayern" + st);
		playerPool.add("Sancho - BVB" + st);
		playerPool.add("Haaland - BVB" + st);
		playerPool.add("Werner - RB Leipzig" + st);
		playerPool.add("Volland - Leverkusen" + st);
		playerPool.add("Poulsen - RB Leipzig" + st);
		
		//MITTELFELD
		playerPool.add("Pogba - Manchester United" + mi);
		playerPool.add("Reus - BVB" + mi);
		playerPool.add("KBD - Man City" + mi);
		playerPool.add("Iniesta - Vissel" + mi);
		playerPool.add("Havertz - Leverkusen" + mi);
		playerPool.add("Müller - Bayern" + mi);
		playerPool.add("Casemiro - Real Madrid" + mi);
		playerPool.add("Foden - Man City" + mi);
		playerPool.add("De Jong - Barcelona" + mi);
		playerPool.add("Kante - Chelsea" + mi);
		playerPool.add("Aouar - Lyon" + mi);
		playerPool.add("Gomez - Atlanta B" + mi);
		playerPool.add("Allan - Neapel" + mi);
		playerPool.add("Fabinho - Liverpool" + mi);
		playerPool.add("James Rodriguez - Real Madrid" + mi);
		playerPool.add("Verrati - PSG" + mi);
		playerPool.add("Thiago - Bayern" + mi);
		playerPool.add("Özil - Arsenal" + mi);
		playerPool.add("Joker" + mi);
		playerPool.add("Khedira - Juventus" + mi);
		
		// Verteidiger 
		playerPool.add("Van Dijk - Liverpool" + ve);
		playerPool.add("Joker" + ve);
		playerPool.add("Sergio Ramos - Real Madrid" + ve);
		playerPool.add("Varane - Real Madrid" + ve);
		playerPool.add("Pique - Barcelona" + ve);
		playerPool.add("Hummels - BVB" + ve);
		playerPool.add("Hernandez - Bayern" + ve);
		playerPool.add("Lenglet - Barcelona" + ve);
		playerPool.add("Tah - Lervekusen" + ve);
		playerPool.add("Süle - Bayern" + ve);
		playerPool.add("Stones - Man City" + ve);
		playerPool.add("Maguire" + ve);
		playerPool.add("Marcelo - Real Madrid" + ve);
		playerPool.add("Robertson - Liverpool" + ve);
		playerPool.add("Schulz - BVB" + ve);
		playerPool.add("Bernat - PSG" + ve);
		playerPool.add("Dani Alves - PSG" + ve);
		playerPool.add("Walker - Man City" + ve);
		playerPool.add("Kimmich - Bayern" + ve);
		playerPool.add("Danny Da Costa - Frankfurt" + ve);
		
		
		// TORWART
		playerPool.add("Manuel Neuer - Bayern" + tw);
		playerPool.add("Trapp - Frankfurt" + tw);
		playerPool.add("Lloris - Tottenham" + tw);
		playerPool.add("Courtois - Real Madrid" + tw);
		playerPool.add("Onana - Ajax" + tw);
		playerPool.add("Ter Stegen - Barcerlona" + tw);
		playerPool.add("Ederson - Man City" + tw);
		playerPool.add("Allison - Liverpool" + tw);
		playerPool.add("Joker" + tw);
	}
	
	private void addPlayerToList(DefaultListModel<String> list) {
		
		boolean add = true;
		
		if(list.getSize() < 11) {
			
			int index = (int)(Math.random() * playerPool.size());
			
			String player = playerPool.get(index);
			
			System.out.println(player);

			if(model_list_eins.isEmpty() && model_list_zwei.getSize() == 1 && list == model_list_eins) {
				System.out.println("case 1");

					list.addElement(player);
				
			}else if(model_list_zwei.isEmpty() && model_list_eins.getSize() == 1 && list == model_list_zwei) {

				System.out.println("case 2");
					list.addElement(player);
				
			}else if(model_list_eins.isEmpty() && model_list_zwei.isEmpty()) {

				System.out.println("case 3");
				list.addElement(player);
			}else if(model_list_eins.getSize() > 0 && model_list_zwei.isEmpty()) {

				System.out.println("case 4");
				for(int i = 0; i < model_list_eins.size(); i++) {
					if(player.equals(model_list_eins.get(i)))
						add = false;
				}
				
				System.out.println(add);

				if(add == true)
					list.addElement(player);
			}
			else if(model_list_zwei.getSize() > 0 && model_list_eins.isEmpty()) {

				System.out.println("case 5");
				for(int j = 0; j < model_list_zwei.size(); j++) {
					if(player.equals(model_list_zwei.get(j)))
						add = false;
				}
				
				System.out.println(add);
				
				if(add == true)
					list.addElement(player);
			}
			else{

				System.out.println("case 6");
				for(int i = 0; i < model_list_eins.size(); i++) {
					if(player.equals(model_list_eins.get(i)))
						add = false;
				}
				
				for(int j = 0; j < model_list_zwei.size(); j++) {
					if(player.equals(model_list_zwei.get(j)))
						add = false;
				}
				
				if(add == true)
					list.addElement(player);
				
				
				
				
			}
			
			
			
			
			
			
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
