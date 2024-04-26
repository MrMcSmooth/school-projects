import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
	private String[] walkOptions = {"Less than 1 Mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	
	private JFormattedTextField weightFormattedTextField;
	
	private JButton clearButton;
	private JButton submitButton;
	
	private FileHandler fileHandler;
	
	public CustomJFrame()
	{
		
		this.setLayout(new GridBagLayout());
		this.setSize(300,400);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		headingLabel = new JLabel("Personal Information");
		this.add(headingLabel, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		firstNameLabel = new JLabel("First Name:");
		this.add(firstNameLabel, gbc);
		
		firstNameTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(firstNameTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		lastNameLabel = new JLabel("Last Name:");
		this.add(lastNameLabel, gbc);
		
		lastNameTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(lastNameTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		phoneNumberLabel = new JLabel("Phone Number:");
		this.add(phoneNumberLabel, gbc);
		
		phoneNumberTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(phoneNumberTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		emailLabel = new JLabel("Email:");
		this.add(emailLabel, gbc);
		
		emailTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(emailTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		
		genderLabel = new JLabel("Sex:");
		this.add(genderLabel, gbc);
		
		gbc.insets = new Insets(1, 1, 1, 1);
		maleRadioButton = new JRadioButton("Male");
		femaleRadioButton = new JRadioButton("Female");
		preferRadioButton= new JRadioButton("Prefer not to say");
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		

		gbc.gridx = 1;
		gbc.gridy = 5;
		this.add(maleRadioButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(femaleRadioButton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.add(preferRadioButton, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 8;
		
		dietaryLabel = new JLabel("Dietary Questions");
		this.add(dietaryLabel, gbc);
		
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 9;
		
		waterLabel = new JLabel("How many cups of water on average do you drink a day?");
		this.add(waterLabel, gbc);
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(15, 0, 50, 1);
		waterIntakeSpinner = new JSpinner(spinnerModel);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(waterIntakeSpinner, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 11;
		
		mealsLabel = new JLabel("How many meals on average do you eat a day?");
		this.add(mealsLabel, gbc);
		
		mealSlider = new JSlider(0, 10, 3);
		mealSlider.setMajorTickSpacing(1);
		mealSlider.setPaintTicks(true);
		mealSlider.setPaintLabels(true);
		gbc.gridx = 0;
		gbc.gridy = 12;
		this.add(mealSlider, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 13;
		
		checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
		this.add(checkBoxLabel, gbc);
		
		gbc.insets = new Insets(1, 10, 1, 1);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 14;
		dairyCheckBox = new JCheckBox("Dairy");
		this.add(dairyCheckBox, gbc);
		
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 14;
		wheatCheckBox = new JCheckBox("Wheat");
		this.add(wheatCheckBox, gbc);
		
		gbc.insets = new Insets(1, 1, 1, 10);
		gbc.gridx = 2;
		gbc.gridy = 14;
		sugarCheckBox = new JCheckBox("Sugar");
		this.add(sugarCheckBox, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 15;
		
		walkLabel = new JLabel("On average how many miles do you walk in a day?");
		this.add(walkLabel, gbc);
		
		walkComboBox = new JComboBox(walkOptions);
		
		gbc.gridx = 0;
		gbc.gridy = 16;
		this.add(walkComboBox, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 17;
		
		weightLabel = new JLabel("How much do you weigh?");
		this.add(weightLabel, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 18;
		
		weightFormattedTextField = new JFormattedTextField();
		//weightFormattedTextField.setL
		weightFormattedTextField.setName("Weight");

		this.add(weightFormattedTextField, gbc);
		
		
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 19;
		
		clearButton = new JButton("Clear");
		this.add(clearButton, gbc);
		
		
		gbc.gridx = 2;
		gbc.gridy = 19;
		
		submitButton = new JButton("Submit");
		this.add(submitButton, gbc);
		
		
		this.setTitle("Dietary Survey");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.validate();
		this.pack();
		this.setVisible(true);
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
