/*
 * DecathlonGUI.java
 *
 * Created on 02 June 2007, 21:33
 */

package net.azib.java.students.t060401.homework.gui;

import net.azib.java.students.t060401.homework.decathlon.DecathlonInfoVector;
import net.azib.java.students.t060401.homework.util.LanguageUtil;

import javax.swing.GroupLayout;
import javax.swing.JTabbedPane;

/**
 * Graphical user interface for loading decathlon data from CSV file or database
 * or inserting it directly via keyboard. All inserted data is sorted according
 * to the total decathlon score and is shown with the score and places in the
 * results table. Results can be saved to a CSV file.
 * 
 * @author t060401
 */
public class DecathlonGUI extends javax.swing.JFrame {

	/** serialVersionUID */
	private static final long serialVersionUID = 4212268281986395943L;

	/** Creates new form DecathlonGUI */
	public DecathlonGUI() {
		super(LanguageUtil.getString("DecathlonGUI.Title"));
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code
	// ">//GEN-BEGIN:initComponents
	private void initComponents() {
		DecathlonInfoVector decathlonVector = new DecathlonInfoVector();

		tabbedPanel = new javax.swing.JTabbedPane();
		addAthletePanel = new AddAthletePanel(decathlonVector);
		loadAthletesPanel = new LoadAthletesPanel(decathlonVector);
		resultsPanel = new ResultsPanel(decathlonVector);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		tabbedPanel.addTab(LanguageUtil.getString("DecathlonGUI.AddAthlete"), addAthletePanel);

		tabbedPanel.addTab(LanguageUtil.getString("DecathlonGUI.LoadAthletes"), loadAthletesPanel);

		tabbedPanel.addTab(LanguageUtil.getString("DecathlonGUI.Results"), resultsPanel);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(tabbedPanel, GroupLayout.PREFERRED_SIZE, 400,
						Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(tabbedPanel));
		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Main method for running Decathlon GUI
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DecathlonGUI().setVisible(true);
			}
		});
	}



	// Variables declaration
	private AddAthletePanel addAthletePanel;
	private LoadAthletesPanel loadAthletesPanel;
	private ResultsPanel resultsPanel;
	private JTabbedPane tabbedPanel;
	// End of variables declaration

}
