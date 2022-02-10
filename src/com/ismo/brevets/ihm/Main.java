package com.ismo.brevets.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Dimension;

public class Main extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Gestion des brevets");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setResizable(false);
		// setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 442);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnInventeur = new JMenu("Inventeurs");
		menuBar.add(mnInventeur);

		JMenuItem mntmListeDesInventeurs = new JMenuItem("Liste des inventeurs");
		mntmListeDesInventeurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lstInventeur frm = new lstInventeur();
				desktopPane.add(frm);
				frm.setVisible(true);
			}
		});
		mnInventeur.add(mntmListeDesInventeurs);

		JMenu mnInventions = new JMenu("Inventions");
		menuBar.add(mnInventions);

		JMenuItem mntmListeDesInventions = new JMenuItem("Liste des inventions");
		mntmListeDesInventions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lstInvention frm = new lstInvention();
				desktopPane.add(frm);
				frm.setVisible(true);
			}
		});
		mnInventions.add(mntmListeDesInventions);

		JMenu mnEntreprises = new JMenu("Entreprises");
		menuBar.add(mnEntreprises);

		JMenuItem mntmListeDesEntreprises = new JMenuItem("Liste des entreprises");
		mntmListeDesEntreprises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lstEntreprise frm = new lstEntreprise();
				desktopPane.add(frm);
				frm.setVisible(true);
			}
		});
		mnEntreprises.add(mntmListeDesEntreprises);

		JMenu mnBrevets = new JMenu("Brevets");
		menuBar.add(mnBrevets);

		JMenuItem mntmListeDesBrevets = new JMenuItem("Liste des brevets");
		mntmListeDesBrevets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lstBrevets frm = new lstBrevets();
				desktopPane.add(frm);
				frm.setVisible(true);
			}
		});
		mnBrevets.add(mntmListeDesBrevets);

		JMenu mnReporting = new JMenu("Reporting");
		menuBar.add(mnReporting);

		JMenuItem mntmListeDesInventeurs_1 = new JMenuItem("Liste des inventeurs");
		mntmListeDesInventeurs_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getReport("Inventeurs.jasper");
			}
		});
		mnReporting.add(mntmListeDesInventeurs_1);

		JMenuItem mntmListeDesInventions_1 = new JMenuItem("Liste des inventions");
		mntmListeDesInventions_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getReport("Inventions.jasper");
			}
		});
		mnReporting.add(mntmListeDesInventions_1);

		JMenuItem mntmListeDesEntreprises_1 = new JMenuItem("Liste des entreprises");
		mntmListeDesEntreprises_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getReport("Entreprise.jasper");
			}
		});
		mnReporting.add(mntmListeDesEntreprises_1);

		JMenuItem mntmListeDesBrevets_1 = new JMenuItem("Liste des brevets");
		mntmListeDesBrevets_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getReport("Brevets.jasper");
			}
		});
		mnReporting.add(mntmListeDesBrevets_1);

		JMenu mnGraphes = new JMenu("Graphes");
		menuBar.add(mnGraphes);

		JMenuItem mntmInventionParEntreprise = new JMenuItem("Invention par entreprise");
		mntmInventionParEntreprise.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFree frm = new JFree();
				desktopPane.add(frm);
				frm.setVisible(true);
			}
		});
		mnGraphes.add(mntmInventionParEntreprise);

		JMenuItem mntmInventionParDomaine = new JMenuItem("Invention par domaine");
		mntmInventionParDomaine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Chart frm = new Chart();
				desktopPane.add(frm);
				frm.setVisible(true);
				
			}
		});
		mnGraphes.add(mntmInventionParDomaine);

		JMenu mnAPropos = new JMenu("A propos");
		menuBar.add(mnAPropos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new CardLayout(0, 0));
	}

	public void getReport(String name) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets", "root", "");
			JasperPrint print = JasperFillManager.fillReport(name, null, connection);
			JRViewer viewer = new JRViewer(print);
			viewer.setOpaque(true);
			JFrame frame = new JFrame("Jasper Report");
			frame.getContentPane().add(viewer);
			frame.setSize(new Dimension(750, 650));
			frame.setLocationRelativeTo(null);
			// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle finally clause
			}
		}
	}

	public void getChart() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets", "root", "");
			String query = "select count(num_invention) as inventions, (select nom_domaine from domaine d where d.num_domaine = invention.num_domaine) as domaine from invention \r\n"
					+ "GROUP BY num_domaine;";
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery(query);
			DefaultPieDataset dataset = new DefaultPieDataset();
			while(result.next()) {
				dataset.setValue(result.getString("domaine"),result.getLong("inventions"));
			}
			JFreeChart chart = ChartFactory.createPieChart("Chart1", dataset, true, true,true);
			contentPane.add(new ChartPanel(chart));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
