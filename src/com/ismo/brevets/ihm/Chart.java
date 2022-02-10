package com.ismo.brevets.ihm;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.CardLayout;

public class Chart extends JInternalFrame {
	
	private JPanel contentPane;
	
	
	public Chart() {
		setBounds(100, 100, 485, 321);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		contentPane = new JPanel();
		getContentPane().add(contentPane, "name_1116926675986300");

		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/dbbrevets", "root", "");
			String query = "select count(num_invention) as inventions, (select nom_domaine from domaine d where d.num_domaine = invention.num_domaine) as domaine from invention \r\n"
					+ "GROUP BY num_domaine;";
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery(query);
			DefaultPieDataset dataset = new DefaultPieDataset();
			while (result.next()) {
				dataset.setValue(result.getString(2), result.getLong(1));
			}
			JFreeChart chart = ChartFactory.createPieChart("Invention par Domaine", dataset, true, true, true);
			contentPane.setLayout(new CardLayout(0, 0));
			ChartPanel chartPanel = new ChartPanel(chart);
			contentPane.add(chartPanel, "name_1116732803204600");
			chartPanel.setLayout(new CardLayout(0, 0));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
