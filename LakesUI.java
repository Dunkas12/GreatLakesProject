package LakesPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LakesUI extends JFrame{

	private Container myCP;
	private JTextField[] RiverLables;
	private JTextField[] RiverPercentLables;
	private JTextField[] RiverField;
	private JTextField[] LakeLables;
	private JTextField[] LakePercentLables; 
	private JTextField[] LakeField;
	private JTextField timeField;
	private boolean solvingForPollution = true;
	JTextField[] PollutionValue;
	JTextField[] PollutionPercent;
	
	private final Color MASTER_COLOR = Color.lightGray;
	private final int x = 1000;
	private final int y = 600;
	private final int textHeight = 25;
	private final Dimension WindowSize = new Dimension(x, y);
	private final Dimension MASTER_LABEL_SIZE = new Dimension( ( (int) (0.06*x) ), textHeight);
	private final Dimension MASTER_FIELD_SIZE = new Dimension(( (int) (0.08*x) ), textHeight);
	private final Dimension MASTER_PANEL_SIZE = new Dimension(( (int) (0.3*x) ), 600);

	
	public static void main(String[] args)
	{
		LakesUI UI1 = new LakesUI();
		UI1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		UI1.repaint();
	}
	
	public LakesUI()
	{
		super("Great Lakes Pollution Concentration Calculator");
		setSize(WindowSize);
		myCP = getContentPane();
		myCP.setLayout(new BorderLayout());
		myCP.setBackground(Color.WHITE);
		
	//LEFT PANEL(WEST):
		JPanel North = new JPanel();
		JPanel South = new JPanel();
		JPanel East = new JPanel();
		JPanel West = new JPanel();
		JPanel Central = new JPanel();
		myCP.add(North, BorderLayout.NORTH);
		myCP.add(South, BorderLayout.SOUTH);
		myCP.add(East, BorderLayout.EAST);
		myCP.add(West, BorderLayout.WEST);
		myCP.add(Central, BorderLayout.CENTER);
		North.setBackground(MASTER_COLOR);
		South.setBackground(MASTER_COLOR);
		East.setBackground(MASTER_COLOR);
		West.setBackground(MASTER_COLOR);
		Central.setBackground(MASTER_COLOR);
		
		RiverLables = new JTextField[5];
		RiverPercentLables = new JTextField[5];
		RiverField = new JTextField[5];
		JPanel[] sections = new JPanel[5];
		
		JTextField InputLable = new JTextField("Inputs:");
		InputLable.setEditable(false);
		InputLable.setBackground( MASTER_COLOR );
		InputLable.setBorder(null);
		Font fminus1 = new Font("Arial", Font.BOLD, 32);
		InputLable.setFont(fminus1);
		InputLable.setForeground( Color.black );
		West.add(InputLable);
		
		JTextField OutputLable = new JTextField("Outputs:");
		OutputLable.setEditable(false);
		OutputLable.setBackground( MASTER_COLOR );
		OutputLable.setBorder(null);
		Font f0 = new Font("Arial", Font.BOLD, 32);
		OutputLable.setFont(f0);
		OutputLable.setForeground( Color.black );
		East.add(OutputLable);
		
		JTextField RiverLable = new JTextField("Initial River Pollutions:");
		RiverLable.setEditable(false);
		RiverLable.setBackground( MASTER_COLOR );
		RiverLable.setBorder(null);
		Font f1 = new Font("Arial", Font.BOLD, 20);
		RiverLable.setFont(f1);
		RiverLable.setForeground( Color.black );
		West.add(RiverLable);
		
		for(int i = 0; i < RiverLables.length; i++)
		{
			sections[i] = new JPanel(new GridBagLayout());
			sections[i].setBackground(MASTER_COLOR);
			
			RiverLables[i] = new JTextField();
			RiverLables[i].setText("River " + (i+1) + ":");
			RiverLables[i].setEditable(false);
			RiverLables[i].setBackground(MASTER_COLOR);
			RiverLables[i].setBorder(null); // null = default look and feel
			RiverLables[i].setPreferredSize(MASTER_LABEL_SIZE);
			
			RiverPercentLables[i] = new JTextField();
			RiverPercentLables[i].setText(" %");
			RiverPercentLables[i].setEditable(false);
			RiverPercentLables[i].setBackground(MASTER_COLOR);
			RiverPercentLables[i].setBorder(null); // null = default look and feel
			
			RiverField[i] = new JTextField();
			RiverField[i].setPreferredSize(MASTER_FIELD_SIZE);
		
			sections[i].add(RiverLables[i]);
			sections[i].add(RiverField[i]);
			sections[i].add(RiverPercentLables[i]);
			
			West.add(sections[i]);
		}
		
		JTextField LakesLable = new JTextField("Initial Lake Pollutions:");
		LakesLable.setEditable(false);
		LakesLable.setBackground( MASTER_COLOR );
		LakesLable.setBorder(null);
		LakesLable.setFont(f1);
		LakesLable.setForeground( Color.black );
		West.add(LakesLable);
		
		JPanel[] sections2 = new JPanel[5];
		LakeLables = new JTextField[5];
		LakePercentLables = new JTextField[5];
		LakeField = new JTextField[5];
		LakeLables[0] = new JTextField("Superior: ");
		LakeLables[1] = new JTextField("Michigan: ");
		LakeLables[2] = new JTextField("Huron: ");
		LakeLables[3] = new JTextField("Erie: ");
		LakeLables[4] = new JTextField("Ontario: ");
		
		for(int i = 0; i < LakeLables.length; i++)
		{
			sections2[i] = new JPanel(new GridBagLayout());
			sections2[i].setBackground(MASTER_COLOR);
			
			LakeLables[i].setEditable(false);
			LakeLables[i].setBackground(MASTER_COLOR);
			LakeLables[i].setBorder(null); // null = default look and feel
			LakeLables[i].setPreferredSize(MASTER_LABEL_SIZE);
			
			LakePercentLables[i] = new JTextField();
			LakePercentLables[i].setText(" %");
			LakePercentLables[i].setEditable(false);
			LakePercentLables[i].setBackground(MASTER_COLOR);
			LakePercentLables[i].setBorder(null); // null = default look and feel
			LakePercentLables[i].setBackground(MASTER_COLOR);
			
			LakeField[i] = new JTextField();
			LakeField[i].setPreferredSize(MASTER_FIELD_SIZE);
		
			sections2[i].add(LakeLables[i]);
			sections2[i].add(LakeField[i]);
			sections2[i].add(LakePercentLables[i]);
			
			West.add(sections2[i]);
		}
		
		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(( (int) (0.2*x) ), 25));
		spacer.setBackground(MASTER_COLOR);
		
		West.add(spacer);
		
		//THE OPTION TO SWITCH TO POLLUTION
		ButtonGroup SolveForGroup = new ButtonGroup();
		
		JTextField SolveForLable = new JTextField("Solve For:");
		SolveForLable.setEditable(false);
		SolveForLable.setPreferredSize(MASTER_LABEL_SIZE);
		SolveForLable.setBackground(MASTER_COLOR);
		SolveForLable.setBorder(null); // null = default look and feel
		SolveForLable = new JTextField();
		SolveForLable.setPreferredSize(MASTER_FIELD_SIZE);
		
		JTextField timeFieldLable = new JTextField("Time:");
		timeFieldLable.setEditable(false);
		timeFieldLable.setPreferredSize(MASTER_LABEL_SIZE);
		timeFieldLable.setBackground(MASTER_COLOR);
		timeFieldLable.setBorder(null); // null = default look and feel
		timeField = new JTextField();
		timeField.setPreferredSize(MASTER_FIELD_SIZE);
		
		West.add(timeFieldLable);
		West.add(timeField);
		
		
		JButton submitButton = new JButton();
		submitButton.setText("Submit");
		submitButton.addActionListener( new SubmitButtonListener() );
		
		West.add(submitButton);
		
		West.setPreferredSize(MASTER_PANEL_SIZE);
	//END LEFT(WEST) PANEL
	//RIGHT PANEL (EAST):
		East.setPreferredSize(MASTER_PANEL_SIZE);
		JTextField[] PollutionLables = new JTextField[5];
		PollutionLables[0] = new JTextField("Superior: ");
		PollutionLables[1] = new JTextField("Michigan: ");
		PollutionLables[2] = new JTextField("Huron: ");
		PollutionLables[3] = new JTextField("Erie: ");
		PollutionLables[4] = new JTextField("Ontario: ");
		
		JPanel[] sections3 = new JPanel[5];
		
		JTextField[] PollutionUnitLables = new JTextField[5];
		PollutionValue = new JTextField[5];		
		
		for(int i = 0; i < PollutionLables.length; i++)
		{
			PollutionLables[i].setEditable(false);
			PollutionLables[i].setBackground(MASTER_COLOR);
			PollutionLables[i].setBorder(null); // null = default look and feel
			PollutionLables[i].setPreferredSize(MASTER_LABEL_SIZE);
			
			PollutionUnitLables[i] = new JTextField();
			PollutionUnitLables[i].setText(" Units");
			PollutionUnitLables[i].setEditable(false);
			PollutionUnitLables[i].setBackground(MASTER_COLOR);
			PollutionUnitLables[i].setBorder(null); // null = default look and feel
			
			PollutionValue[i] = new JTextField();
			PollutionValue[i].setText("0");
			PollutionValue[i].setPreferredSize(MASTER_FIELD_SIZE);
		
			sections3[i] = new JPanel(new GridBagLayout());
			sections3[i].setBackground(MASTER_COLOR);
			Dimension d1 = new Dimension( ((int) MASTER_PANEL_SIZE.getWidth()), 25);
			sections3[i].setPreferredSize(d1);
			
			sections3[i].add(PollutionLables[i]);
			sections3[i].add(PollutionValue[i]);
			sections3[i].add(PollutionUnitLables[i]);
			
			East.add(sections3[i]);
		}
		
		JPanel[] sections4 = new JPanel[5];
		
		JTextField[] PollutionPercentLables = new JTextField[5];
		PollutionPercent = new JTextField[5];
		JTextField[] PollutionLablesCopy = new JTextField[5];
		
		for(int i = 0; i < PollutionLables.length; i++)
		{
			PollutionLablesCopy[i] = new JTextField();
			PollutionLablesCopy[i].setText( PollutionLables[i].getText() );
			PollutionLablesCopy[i].setEditable(false);
			PollutionLablesCopy[i].setBackground(MASTER_COLOR);
			PollutionLablesCopy[i].setBorder(null); // null = default look and feel
			PollutionLablesCopy[i].setPreferredSize(MASTER_LABEL_SIZE);
			
			PollutionPercentLables[i] = new JTextField();
			PollutionPercentLables[i].setText(" %");
			PollutionPercentLables[i].setEditable(false);
			PollutionPercentLables[i].setBackground(MASTER_COLOR);
			PollutionPercentLables[i].setBorder(null); // null = default look and feel
			
			PollutionPercent[i] = new JTextField();
			PollutionPercent[i].setText("0.00");
			PollutionPercent[i].setPreferredSize(MASTER_FIELD_SIZE);
		
			sections4[i] = new JPanel(new GridBagLayout());
			sections4[i].setBackground(MASTER_COLOR);
			Dimension d1 = new Dimension( ((int) MASTER_PANEL_SIZE.getWidth()), 25);
			sections4[i].setPreferredSize(d1);
			
			sections4[i].add(PollutionLablesCopy[i]);
			sections4[i].add(PollutionPercent[i]);
			sections4[i].add(PollutionPercentLables[i]);
			
			East.add(sections4[i]);
		}
		
		myCP.setVisible(true);
		setVisible(true);
	}
	
	public double[] getRiverFieldData() throws IllegalArgumentException
	{
		double[] fieldData = new double[RiverField.length];
		
		for(int i = 0; i < RiverField.length; i++)
		{
				fieldData[i] = (Double.parseDouble( RiverField[i].getText() )*0.01); //*0.01 to convert % to absolute value
				
				if(fieldData[i] > 1 || fieldData[i] < 0) // for absolute values
					throw new IllegalArgumentException();
		}
		
		return fieldData;
	}
	
	public double[] getLakeFieldData() throws IllegalArgumentException
	{
		double[] fieldData = new double[RiverField.length];
		
		for(int i = 0; i < RiverField.length; i++)
		{
				fieldData[i] = (Double.parseDouble( LakeField[i].getText() )*0.01); //*0.01 to convert % to absolute value
				
				if(fieldData[i] > 1 || fieldData[i] < 0) // for absolute values
					throw new IllegalArgumentException();
		}
		
		return fieldData;
	}
	
	public double getTime() throws timeIsNegativeException
	{
		double out;
		
		if( (out = Double.parseDouble( timeField.getText())) >= 0 )
			return out;
		else
			throw new timeIsNegativeException();
				
	}
	
	public class SubmitButtonListener implements ActionListener {	
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
			DecimalFormat df = new DecimalFormat("#0.00");	
				
			double[] pollution = LakesProgram.getPollution(getRiverFieldData(), getLakeFieldData(), getTime());
			
			for(int i = 0; i < 5; i++)
			{
				PollutionValue[i].setText( df.format( pollution[i] ) );
				PollutionPercent[i].setText( df.format( pollution[i+5] ) );
				System.out.println(pollution[i]);
			}
			
			}
			catch(NumberFormatException e1)
			{
				JOptionPane.showInternalMessageDialog(myCP, "That input is not valid.");
			}
			catch(IllegalArgumentException e1)
			{
				JOptionPane.showInternalMessageDialog(myCP, "Concentrations must be a percent (bettween 0 and 100).");
			}
			catch(timeIsNegativeException e1)
			{
				JOptionPane.showInternalMessageDialog(myCP, e1.getMessage());
			}
		}
	}
	
}


