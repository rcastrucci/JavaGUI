package com.rcastrucci.dev.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import java.awt.Component;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Main {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JButton btnOk;
	
	/**
	 * Launch Application
	 * @param args
	 */
    public static void main (final String args[]) {
        SwingUtilities.invokeLater (
            new Runnable () {
                public void run () {
                	initialize();
                }
            }
        );
    }
	
    /**
     * Create frame with theme
     */
    private static void initialize()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo (null);
        frame.setResizable(false);
        frame.setUndecorated (true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        frame.setTitle("Customized Frame");

        panel = new JPanel();
        panel.setBackground(java.awt.Color.DARK_GRAY);
        frame.setContentPane(panel);
        
        btnOk = new JButton("Ok");
        btnOk.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
        JLabel labelCustomized = new JLabel("This is a customized frame!");
        labelCustomized.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        labelCustomized.setHorizontalAlignment(SwingConstants.CENTER);
        labelCustomized.setForeground(Color.WHITE);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(labelCustomized, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel.createSequentialGroup()
        					.addGap(120)
        					.addComponent(btnOk)))
        			.addContainerGap(0, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(80)
        			.addComponent(labelCustomized, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnOk)
        			.addContainerGap(120, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        DefaultMetalTheme metalTheme = new DefaultMetalTheme() {
        	
            public ColorUIResource getWindowTitleInactiveBackground() { 
                return new ColorUIResource(java.awt.Color.BLACK); 
            }
            public ColorUIResource getWindowTitleBackground() { 
                return new ColorUIResource(java.awt.Color.DARK_GRAY); 
            }
            public ColorUIResource getPrimaryControlHighlight() { 
                return new ColorUIResource(java.awt.Color.DARK_GRAY); 
            }
            public ColorUIResource getPrimaryControlDarkShadow() { 
                return new ColorUIResource(java.awt.Color.DARK_GRAY); 
            }
            public ColorUIResource getPrimaryControl() { 
                return new ColorUIResource(java.awt.Color.DARK_GRAY); 
            }
            public ColorUIResource getControlHighlight () {
                return new ColorUIResource(java.awt.Color.GRAY); 
            }
            public ColorUIResource getControlDarkShadow () {
                return new ColorUIResource(java.awt.Color.BLACK); 
            }
            public ColorUIResource getControl () {
                return new ColorUIResource (java.awt.Color.WHITE); 
            }
            protected ColorUIResource getPrimary1() { 
            	return new ColorUIResource (java.awt.Color.BLACK);
            }
            protected ColorUIResource getPrimary2() { 
            	return new ColorUIResource (java.awt.Color.WHITE);
            }
            protected ColorUIResource getPrimary3() { 
            	return new ColorUIResource (java.awt.Color.RED);
            }
            protected ColorUIResource getSecondary1() { 
            	return new ColorUIResource (java.awt.Color.RED);
            }
            protected ColorUIResource getSecondary2() { 
            	return new ColorUIResource (java.awt.Color.DARK_GRAY);
            }
            protected ColorUIResource getSecondary3() { 
            	return new ColorUIResource (java.awt.Color.GRAY);
            }
        };

        MetalLookAndFeel.setCurrentTheme(metalTheme);

        try {
        	UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace ();
        }   

        SwingUtilities.updateComponentTreeUI(frame);
        frame.setVisible (true);
    }
}