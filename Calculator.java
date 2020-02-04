import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class Calculator
{
	static protected JFrame frame;
	static private JTextField txtArea;
	static private JButton btn;
	static private JPanel topPanel, btmPanel;
	static private double total;
	static private int op=0;
	static private boolean newCalc;
	static private boolean first;
	static private boolean dec;	
	
	public static void main(String[] args)
	{
		// New Calc Frame
		frame = new JFrame();
		frame.setTitle("Calculator");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setBounds(400, 400, 200, 190);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		btmPanel = new JPanel();

		txtArea=new JTextField(16);
		Border c = new BevelBorder(1);
		txtArea.setBorder(c);
		topPanel.add(txtArea);
		txtArea.setHorizontalAlignment(JTextField.RIGHT);
		txtArea.setEditable(false);
		newCalc = true;
		first = true;
		
		
		btn = new JButton("7");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				
				txtArea.setText(txtArea.getText()+"7"); 
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("8");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"8"); 			
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("9");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"9"); 
			}
		});
		btmPanel.add(btn);

				btn = new JButton("+");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtArea.getText().equals("")){
					calculate();
					op = 1;
				}				
			}
		});
		btmPanel.add(btn);	
		
		
				btn = new JButton("4");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"4"); 
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("5");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"5"); 
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("6");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"6"); 
			}
		});
		btmPanel.add(btn);
		
						btn = new JButton("- ");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				if (!txtArea.getText().equals("")){
					calculate();
					op = 2;
				}else{
					txtArea.setText("-");
				}
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("1");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				
				txtArea.setText(txtArea.getText()+"1"); 
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("2");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"2"); 
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("3");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"3"); 
			}
		});
		btmPanel.add(btn);
		
						btn = new JButton("* ");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtArea.getText().equals("")){
					calculate();
					op = 3;
				}
			}
		});
		btmPanel.add(btn);

				btn = new JButton("0");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				txtArea.setText(txtArea.getText()+"0");
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton(". ");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first){
					txtArea.setText("");
					first = false;
				}
				if(!dec && !txtArea.getText().equals("")){
					txtArea.setText(txtArea.getText()+".");
					dec=true;
				}else if(!dec && txtArea.getText().equals("")){
					txtArea.setText(".");
					dec=true;
				}
			}
		});
		btmPanel.add(btn);
		
				btn = new JButton("=");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			calculate();
			
			String temp = Double.toString(total);
			String[] ttl = temp.split("\\.");
					
			if(ttl[1].equals("0")){
				txtArea.setText(ttl[0]);
			}else{
				txtArea.setText(Double.toString(total));			
			}
			

			newCalc =true;
			first=true;
			}
		});
		btmPanel.add(btn);
		
						btn = new JButton(" / ");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtArea.getText().equals("")){
					calculate();
					op = 4;
				}
			}
		});
		btmPanel.add(btn);		
		
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		frame.getContentPane().add(btmPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
		frame.toFront();	
	}	
		
	public static void calculate()
	{
		double in;
		if (newCalc)
		{
			total = Double.parseDouble(txtArea.getText());
			txtArea.setText("");
			newCalc=false;
			dec = false;
		}else{
			
			in = Double.parseDouble(txtArea.getText());
			txtArea.setText("");			
			dec = false;
			switch(op)
			{
				
				case 1:
					total += in;
					break;
				case 2:
					total -=in;
					break;
				case 3:
					total = total*in;
					break;
				case 4:
					total = total/in;
					break;
			}
			
			
		}
	}
}