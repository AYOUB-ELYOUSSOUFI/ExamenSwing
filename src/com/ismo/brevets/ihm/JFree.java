package com.ismo.brevets.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.CardLayout;

public class JFree extends JInternalFrame {

	private JPanel contentPane;

	public JFree() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets", "root", "");
			String query = "select count(i.num_invention) as inventions, nom_entreprise from invention i\r\n"
					+ "    inner join brevet b on i.NUM_INVENTION = b.NUM_INVENTION\r\n"
					+ "    inner join inventeur v on b.NUM_INVENTEUR = v.NUM_INVENTEUR\r\n"
					+ "    inner join entreprise e on v.NUM_ENTREPRISE = e.NUM_ENTREPRISE\r\n"
					+ "    group by e.num_entreprise;";
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery(query);
			DefaultPieDataset dataset = new DefaultPieDataset();
			while (result.next()) {
				dataset.setValue(result.getString(2), result.getLong(1));
			}
			JFreeChart chart = ChartFactory.createPieChart("Invention par Entreprise", dataset, true, true, true);
			contentPane.setLayout(new CardLayout(0, 0));
			ChartPanel chartPanel = new ChartPanel(chart);
			contentPane.add(chartPanel, "name_1116732803204600");
			chartPanel.setLayout(new CardLayout(0, 0));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
