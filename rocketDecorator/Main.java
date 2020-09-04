package rocketDecorator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main implements ActionListener{
	
	Rocket rocketLight = new Light();
	Rocket rocketMed = new Medium();
	Rocket rocketHeavy = new Heavy();
	
	private int count = 0;
	private int boosterCount = 0;
	private int turboCount = 0;
	private int warpDriveCount = 0;
	private static String rocketType;
	private static String rocketType2="Light";
	private int finalCost;
	private int finalRange=0;
	private String finalDesc;
	private JLabel costLabel;
	private JLabel rangeLabel;
	private JLabel descLabel;
	private JLabel label00;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JPanel panel;
	private JFrame frame;
	private JLabel turboLabel;
	private JLabel warpDriveLabel;
	private JLabel titleLabel;
	
	public Main() {
		titleLabel = new JLabel("Build your Rocket.  Select your rocket type, add boosters, turbos or warp drives and see your rocket's range and cost");
		frame = new JFrame();
		label00 = new JLabel("Rocket Type: ");
		label = new JLabel("# Boosters: ");
		label2 = new JLabel();
		label3 = new JLabel();
		costLabel = new JLabel("TESt");
		costLabel = new JLabel("Cost");
		rangeLabel = new JLabel("Range: ");
		descLabel = new JLabel("Description");
		turboLabel = new JLabel("# Turbo: ");
		warpDriveLabel = new JLabel("#Warp Drives: ");
		
		
		//Buttons----------------------------------------------
		JButton button = new JButton("Add Booster");
		button.addActionListener(new Action1());
		
		
		JButton button2 = new JButton("Add Turbo");
		button2.addActionListener(new Action2());
		
		JButton buttonWarp = new JButton("Add Warp Drive");
		buttonWarp.addActionListener(new ActionWarp());
		//Buttons----------------------------------------------
		
		//Drop down menus 
		String[] test = {"Light", "Medium", "Heavy"};
		JComboBox testList = new JComboBox(test);
		testList.setSelectedIndex(0);
		testList.addActionListener(new Action0());
		
		
		//Add panels to screen 
		panel = new JPanel();
		panel.add(titleLabel);
		panel.add(label00);
		panel.add(testList);
		panel.add(label2);
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30,20,20));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label2);
		panel.add(label);
		panel.add(button);
		panel.add(turboLabel);
		panel.add(button2);
		panel.add(warpDriveLabel);
		panel.add(buttonWarp);
		panel.add(costLabel);
		panel.add(rangeLabel);
		panel.add(descLabel);
		panel.add(costLabel);
		
		
		//Set frame 
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(800,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Rocket");
		frame.setVisible(true);
	}

	private void add(JComboBox testList) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		
	//GUI
	new Main();
	
	//GUI
	
	//Test decorator
	Rocket rocket2 = new Medium();
	
	rocket2 = new Booster(rocket2);
	rocket2 = new WarpDrive(rocket2);
	rocket2 = new Turbo(rocket2);
	System.out.println(rocket2.getDesc() + " $ "+rocket2.cost());
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//count++;
		//label.setText("# Clicks: " + count);	
		
	}
	
	//Method called from drop down menu
	public class Action0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox<String> combo = (JComboBox<String>) e.getSource();
			rocketType = (String) combo.getSelectedItem();
			
			if (rocketType == "Light") {
				//Rocket rocket = new Light();
				descLabel.setText("Description: " + rocketLight.getDesc());
				finalCost+=rocketLight.cost();
				finalRange+=rocketLight.range();
				rangeLabel.setText("Range: " + finalRange);
				System.out.println(rocketLight.getDesc());
				System.out.println(rocketLight.cost());
				
			} else if (rocketType == "Medium") {
				//Rocket rocket = new Medium();
				descLabel.setText("Description: " + rocketMed.getDesc());
				finalCost+=rocketLight.cost();
				finalRange+=rocketMed.range();
				rangeLabel.setText("Range: " + finalRange);
				System.out.println(rocketMed.getDesc());
				System.out.println(rocketMed.cost());
			}else {
				//Rocket rocket = new Heavy();
				descLabel.setText("Description: " + rocketHeavy.getDesc());
				finalCost+=rocketLight.cost();
				finalRange+=rocketHeavy.range();
				rangeLabel.setText("Range: " + finalRange);
				System.out.println(rocketHeavy.getDesc());
				System.out.println(rocketHeavy.cost());
			}
			//label00.setText("Rocket Type: " + rocketType);
			costLabel.setText("Cost: " + finalCost);
		
		}
	}
	
	//Method to update cost, range for adding booster
	public class Action1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if (rocketType == "Light") {
				//Rocket rocket = new Light();
				rocketLight = new Booster(rocketLight);
				finalCost+=rocketLight.cost()-500;
				boosterCount++;
				label.setText("# Boosters: " + boosterCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketLight.range();
				rangeLabel.setText("Range: " + finalRange);

				
			} else if (rocketType == "Medium") {
				rocketMed = new Booster(rocketMed);
				finalCost+=rocketMed.cost()-500;
				boosterCount++;
				label.setText("# Boosters: " + boosterCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketMed.range();
				rangeLabel.setText("Range: " + finalRange);

			}else {
				rocketHeavy = new Booster(rocketHeavy);
				finalCost+=rocketHeavy.cost()-500;
				boosterCount++;
				label.setText("# Boosters: " + boosterCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketHeavy.range();
				rangeLabel.setText("Range: " + finalRange);

			}
				
		}
	}

	//Method to update cost, range for adding Turbo
	public class Action2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (rocketType == "Light") {
				//Rocket rocket = new Light();
				rocketLight = new Turbo(rocketLight);
				finalCost+=rocketLight.cost()-500;
				turboCount++;
				turboLabel.setText("# Turbos: " + turboCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketLight.range();
				rangeLabel.setText("Range: " + finalRange);

				
			} else if (rocketType == "Medium") {
				rocketMed = new Turbo(rocketMed);
				finalCost+=rocketMed.cost()-500;
				turboCount++;
				turboLabel.setText("# Turbos: " + turboCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketMed.range();
				rangeLabel.setText("Range: " + finalRange);

			}else {
				rocketHeavy = new Turbo(rocketHeavy);
				finalCost+=rocketHeavy.cost()-500;
				turboCount++;
				turboLabel.setText("# Turbos: " + turboCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketHeavy.range();
				rangeLabel.setText("Range: " + finalRange);

			}
		}
	}
	
	//Method to update cost, range for adding Warp Drive
	public class ActionWarp implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (rocketType == "Light") {
				//Rocket rocket = new Light();
				rocketLight = new WarpDrive(rocketLight);
				finalCost+=rocketLight.cost()-500;
				warpDriveCount++;
				warpDriveLabel.setText("# Warp Drives: " + warpDriveCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketLight.range();
				rangeLabel.setText("Range: " + finalRange);

				
			} else if (rocketType == "Medium") {
				rocketMed = new WarpDrive(rocketMed);
				finalCost+=rocketMed.cost()-500;
				warpDriveCount++;
				warpDriveLabel.setText("# Warp Drives: " + warpDriveCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketMed.range();
				rangeLabel.setText("Range: " + finalRange);

			}else {
				rocketHeavy = new WarpDrive(rocketHeavy);
				finalCost+=rocketHeavy.cost()-500;
				warpDriveCount++;
				warpDriveLabel.setText("# Warp Drives: " + warpDriveCount);
				costLabel.setText("Cost: " + finalCost);
				finalRange+=rocketHeavy.range();
				rangeLabel.setText("Range: " + finalRange);

			}
		}
	}

}
