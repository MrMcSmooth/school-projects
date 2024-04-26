import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.*;

public class CustomJFrame extends JFrame
{
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel dietaryLabel;
	private JLabel genderLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;
	
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JRadioButton preferRadioButton;
	private ButtonGroup radioButtonGroup;
	
	private JSpinner waterIntakeSpinner;
	
	private JSlider mealSlider;
	
	private JCheckBox wheatCheckBox;
	private JCheckBox sugarCheckBox;
	private JCheckBox dairyCheckBox;
	
	private JComboBox walkComboBox;
	
	private String[] walkOptions = {" Less than 1 Mile", " More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	
	private JFormattedTextField weightFormattedTextField;
	
	private JButton clearButton;
	private JButton submitButton;
	
	private FileHandler fileHandler;
	
	public CustomJFrame()
	{
		
	}
	
	public class InnerActionListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
		}
		
		private void clearForm()
		{
			
		}
	}
}
