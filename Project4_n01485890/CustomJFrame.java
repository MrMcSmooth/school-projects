import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Enumeration;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.text.NumberFormatter;


/**
 * The Class CustomJFrame.
 */
public class CustomJFrame extends JFrame
{
	
	/** The heading label. */
	private JLabel headingLabel;
	
	/** The first name label. */
	private JLabel firstNameLabel;
	
	/** The last name label. */
	private JLabel lastNameLabel;
	
	/** The phone number label. */
	private JLabel phoneNumberLabel;
	
	/** The email label. */
	private JLabel emailLabel;
	
	/** The dietary label. */
	private JLabel dietaryLabel;
	
	/** The gender label. */
	private JLabel genderLabel;
	
	/** The water label. */
	private JLabel waterLabel;
	
	/** The meals label. */
	private JLabel mealsLabel;
	
	/** The check box label. */
	private JLabel checkBoxLabel;
	
	/** The walk label. */
	private JLabel walkLabel;
	
	/** The weight label. */
	private JLabel weightLabel;
	
	/** The first name text field. */
	private JTextField firstNameTextField;
	
	/** The last name text field. */
	private JTextField lastNameTextField;
	
	/** The phone number text field. */
	private JTextField phoneNumberTextField;
	
	/** The email text field. */
	private JTextField emailTextField;
	
	/** The male radio button. */
	private JRadioButton maleRadioButton;
	
	/** The female radio button. */
	private JRadioButton femaleRadioButton;
	
	/** The prefer radio button. */
	private JRadioButton preferRadioButton;
	
	/** The radio button group. */
	private ButtonGroup radioButtonGroup;
	
	/** The water intake spinner. */
	private JSpinner waterIntakeSpinner;
	
	/** The meal slider. */
	private JSlider mealSlider;
	
	/** The wheat check box. */
	private JCheckBox wheatCheckBox;
	
	/** The sugar check box. */
	private JCheckBox sugarCheckBox;
	
	/** The dairy check box. */
	private JCheckBox dairyCheckBox;
	
	/** The walk combo box. */
	private JComboBox walkComboBox;
	
	/** The walk options. */
	private String[] walkOptions = {"Less than 1 Mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	
	/** The weight formatted text field. */
	private JFormattedTextField weightFormattedTextField;
	
	/** The clear button. */
	private JButton clearButton;
	
	/** The submit button. */
	private JButton submitButton;
	
	/** The file handler. */
	private FileHandler fileHandler;
	
	/** The info. */
	private String[] info = new String[12];
	
	/**
	 * Instantiates a new custom J frame.
	 * Starts Dietary Survey
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public CustomJFrame() throws IOException
	{
		
		fileHandler = new FileHandler();
		
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
		firstNameTextField.setName("firstName");
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(firstNameTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		lastNameLabel = new JLabel("Last Name:");
		this.add(lastNameLabel, gbc);
		
		lastNameTextField = new JTextField(15);
		lastNameTextField.setName("lastName");
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(lastNameTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		phoneNumberLabel = new JLabel("Phone Number:");
		this.add(phoneNumberLabel, gbc);
		
		phoneNumberTextField = new JTextField(15);
		phoneNumberTextField.setName("phoneNumber");
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(phoneNumberTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		emailLabel = new JLabel("Email:");
		this.add(emailLabel, gbc);
		
		emailTextField = new JTextField(15);
		emailTextField.setName("email");
		emailTextField.addActionListener(new InnerActionListener());
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(emailTextField, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		
		genderLabel = new JLabel("Sex:");
		this.add(genderLabel, gbc);
		
		
		gbc.insets = new Insets(1, 1, 1, 1);
		radioButtonGroup = new ButtonGroup();
		
		maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setName("Male");
		radioButtonGroup.add(maleRadioButton);
		
		femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setName("Female");
		radioButtonGroup.add(femaleRadioButton);
		
		preferRadioButton = new JRadioButton("Prefer not to say");
		preferRadioButton.setName("Prefer not to say");
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
		waterIntakeSpinner.setName("water");
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(waterIntakeSpinner, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 11;
		
		mealsLabel = new JLabel("How many meals on average do you eat a day?");
		this.add(mealsLabel, gbc);
		
		mealSlider = new JSlider(0, 10, 3);
		mealSlider.setName("meal");
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
		dairyCheckBox.setName("dairy");
		this.add(dairyCheckBox, gbc);
		
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridx = 1;
		gbc.gridy = 14;
		wheatCheckBox = new JCheckBox("Wheat");
		wheatCheckBox.setName("wheat");
		this.add(wheatCheckBox, gbc);
		
		gbc.insets = new Insets(1, 1, 1, 10);
		gbc.gridx = 2;
		gbc.gridy = 14;
		sugarCheckBox = new JCheckBox("Sugar");
		sugarCheckBox.setName("sugar");
		this.add(sugarCheckBox, gbc);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy = 15;
		
		walkLabel = new JLabel("On average how many miles do you walk in a day?");
		this.add(walkLabel, gbc);
		
		walkComboBox = new JComboBox(walkOptions);
		walkComboBox.setName("walk");
		
		gbc.gridx = 0;
		gbc.gridy = 16;
		this.add(walkComboBox, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 17;
		
		weightLabel = new JLabel("How much do you weigh?");
		this.add(weightLabel, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 18;
		
		
		NumberFormatter weightFormat = new NumberFormatter();
		weightFormat.setValueClass(Integer.class);
		weightFormat.setAllowsInvalid(false);
		weightFormat.setMaximum(999);
		weightFormat.setMinimum(1);
		
		weightFormattedTextField = new JFormattedTextField(weightFormat);
		weightFormattedTextField.setName("weight");
		weightFormattedTextField.setColumns(15);
		

		this.add(weightFormattedTextField, gbc);
		
		
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 19;
		
		clearButton = new JButton("Clear");
		clearButton.setName("clear");
		clearButton.addActionListener(new InnerActionListener());
		clearButton.setBackground(Color.YELLOW);
		this.add(clearButton, gbc);
		
		
		gbc.gridx = 2;
		gbc.gridy = 19;
		
		submitButton = new JButton("Submit");
		submitButton.setName("submit");
		submitButton.addActionListener(new InnerActionListener());
		submitButton.setBackground(Color.GREEN);
		this.add(submitButton, gbc);
		
		
		this.setTitle("Dietary Survey");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.validate();
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * The listener interface for receiving innerAction events.
	 * The class that is interested in processing a innerAction
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addInnerActionListener</code> method. When
	 * the innerAction event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see InnerActionEvent
	 */
	public class InnerActionListener implements ActionListener
	{
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();
			
			if (source instanceof JButton)
			{
				JButton clickedButton = (JButton) e.getSource();
				if(clickedButton.getName().equals("submit"))
				{
					//gets all dietary data
					info[0] = firstNameTextField.getText();
					info[1] = lastNameTextField.getText();
					info[2] = phoneNumberTextField.getText();
					info[3] = emailTextField.getText();
					info[4] = getButton(radioButtonGroup);
					info[5] = String.valueOf((Integer) waterIntakeSpinner.getValue());
					info[6] = String.valueOf((Integer) mealSlider.getValue());
					if(dairyCheckBox.isSelected())
					{
						info[7] = "true";
					} else
					{
						info[7] = "false";
					}
					if(wheatCheckBox.isSelected())
					{
						info[8] = "true";
					} else
					{
						info[8] = "false";
					}
					if(sugarCheckBox.isSelected())
					{	
						info[9] = "true";
					} else
					{
						info[9] = "false";
					}
					info[10] = walkComboBox.getSelectedItem().toString();
					info[11] = weightFormattedTextField.getText();
					if(info[11].isEmpty())
							info[11] = null;
					
					
					try {
						fileHandler.writeResults(info[0] + "," + info[1] + "," + info[2] + "," + info[3] + "," + info[4] + "," + info[5] + "," + info[6] + "," + info[7] + "," + info[8] + "," + info[9] + "," + info[10] + "," + info[11]);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
				} else if (clickedButton.getName().equals("clear"))
				{
					clearForm();
				}
			}
		}//end innerActionListener
		
		
		/**
		 * Clears form.
		 */
		private void clearForm()
		{
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			phoneNumberTextField.setText("");
			emailTextField.setText("");
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			dairyCheckBox.setSelected(false);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			walkComboBox.setSelectedIndex(0);
			weightFormattedTextField.setValue(null);;
		}
		
		/**
		 * Gets the button.
		 *
		 * @param buttonGroup the button group
		 * @return the button
		 */
		private String getButton(ButtonGroup buttonGroup)
		{
			for(Enumeration e = buttonGroup.getElements(); e.hasMoreElements();)
			{
				JRadioButton button = (JRadioButton)e.nextElement();
				if(button.isSelected())
				{
					return button.getName();
				}
			}
			return null;
		}


	}
}
