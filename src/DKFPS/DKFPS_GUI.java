package kevin_project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class DKFPS_GUI {
	private final JFrame jframe;
	private final JPanel playerName;
	private final JTextField player_text;
	private final JPanel fantasyPoint;
	private final JTextField fp_text;
	private final JPanel salary;
	private final JTextField salary_text;
	private final JPanel topPanel;
	private final JPanel result;
	private final JTextField result_text;
	private final JButton resultButton;
	
	private DKFPS_GUI() {
		this.jframe = new JFrame("DraftKing Fantasy Point Calculator");
		

		// Create panels and textFields for each category
		this.playerName = new JPanel();
		JLabel playerLabel = new JLabel("Player Name:");
		this.player_text = new JTextField("", 10);
		this.playerName.add(playerLabel, BorderLayout.LINE_START);
		this.playerName.add(this.player_text, BorderLayout.LINE_END);
		
		this.fantasyPoint = new JPanel();
		this.fp_text = new JTextField("", 10);
		JLabel fpLabel = new JLabel("Fantasy Point:");
		this.fantasyPoint.add(fpLabel, BorderLayout.LINE_START);
		this.fantasyPoint.add(this.fp_text, BorderLayout.LINE_END);
		
		this.salary = new JPanel();
		JLabel salaryLabel = new JLabel("Salary (K):");
		this.salary_text = new JTextField("", 10);
		this.salary.add(salaryLabel, BorderLayout.LINE_START);
		this.salary.add(this.salary_text, BorderLayout.LINE_END);
		
		this.topPanel = new JPanel();
		this.topPanel.add(this.playerName, BorderLayout.WEST);
		this.topPanel.add(this.fantasyPoint, BorderLayout.CENTER);
		this.topPanel.add(this.salary, BorderLayout.EAST);
		
		// Create a textArea for showing history
        JTextArea textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
 	
		// Create a resultButton
		this.result = new JPanel();
		this.result_text = new JTextField("",20);
		this.resultButton = new JButton("Result");
		this.resultButton.addActionListener(new ActionListener() {
			@Override
			// Create the functionality for resultButton
			public void actionPerformed(ActionEvent e) {
				String final_result = String.valueOf(findResult());
				result_text.setText(final_result);
				textArea.append(player_text.getText() + ":   " + final_result + "\n");
			}
		});
		resultButton.setEnabled(true);
		this.result.add(this.resultButton, BorderLayout.LINE_START);
		this.result.add(this.result_text, BorderLayout.LINE_END);
		
		// Add everything to the frame
		Container content = this.jframe.getContentPane();
		content.add(result, BorderLayout.PAGE_END);
		content.add(scrollPane);
		content.add(topPanel, BorderLayout.PAGE_START);

	}
	
	private Double findResult() {
		String name = player_text.getText();
		Double fp = Double.parseDouble(fp_text.getText());
		Double sal = Double.parseDouble(salary_text.getText());
		DraftKing_Fantasy_Calculator dkfps = new DraftKing_Fantasy_Calculator(name, fp, sal);
		return dkfps.result();
	}
	
	private void createAndShowGui() {
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		DKFPS_GUI v = new DKFPS_GUI();
		v.createAndShowGui();
	}
}
