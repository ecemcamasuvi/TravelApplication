package com.basic.business.view;

import org.springframework.stereotype.Component;

import com.basic.business.controller.DestinationController;
import com.basic.business.entities.Destinations;
import com.basic.business.system.IDestinationService;

import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddView  extends javax.swing.JFrame {
	
	public IDestinationService destinationService;
	
	private JTextField txtName;
	private JTextField txtCountry;
	private JTextField txtCity;
	private JTextField txtDescription;
	private JTextField txtImageUrl;
	public AddView() {
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		txtName = new JTextField();
		
		JButton btnAdd = new JButton();
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				txtCity.setBackground(Color.white);
				txtName.setBackground(Color.white);
				txtCountry.setBackground(Color.white);
				txtDescription.setBackground(Color.white);
				txtImageUrl.setBackground(Color.white);
				if(isValidInput()) {
					try {
					Destinations destination=new Destinations();
					destination.setName(txtName.getText());
					destination.setCountry(txtCountry.getText());
					destination.setCity(txtCity.getText());
					destination.setDescription(txtDescription.getText());
					destination.setImageUrl(txtImageUrl.getText());
					destinationService.add(destination);
					}
					catch(Exception e) {
						throw e;
					}
					finally {
						java.awt.Window win[] = java.awt.Window.getWindows();
		        		for(int i=0;i<win.length;i++){
		        		win[i].dispose();
		        		}
						MainView mainView=new MainView();
						mainView.fillTable(destinationService);
				    	mainView.setVisible(true);
				    	mainView.setManager(destinationService);
					}
				}
			}
		});
		btnAdd.setText("Add");
		
		txtCountry = new JTextField();
		
		txtCity = new JTextField();
		
		txtDescription = new JTextField();
		
		txtImageUrl = new JTextField();
		
		JLabel lblName = new JLabel("Name : ");
		
		JLabel lblCountry = new JLabel("Country : ");
		
		JLabel lblCity = new JLabel("City : ");
		
		JLabel lblDescription = new JLabel("Description : ");
		
		JLabel lblImageUrl = new JLabel("Image Url");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblName)
								.addComponent(lblCountry)
								.addComponent(lblCity)
								.addComponent(lblDescription)
								.addComponent(lblImageUrl))
							.addGap(41)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtImageUrl, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(267)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCountry))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCity))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtImageUrl, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblImageUrl))
					.addGap(56)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 740, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 502, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layeredPane.setLayout(gl_layeredPane);
	}
	public void setManager(IDestinationService destinationService) {
		this.destinationService=destinationService;
	}
	public boolean isValidInput() {
		int i=0;
		if(this.txtName.getText().isEmpty()||this.txtName.getText().length()==0) {
			i++;
			this.txtName.setBackground(Color.red);
		}
		if(this.txtCity.getText().isEmpty()||this.txtCity.getText().length()==0) {
			i++;
			this.txtCity.setBackground(Color.red);
		}
		if(this.txtCountry.getText().isEmpty()||this.txtCountry.getText().length()==0) {
			i++;
			this.txtCountry.setBackground(Color.red);
		}
		if(this.txtDescription.getText().isEmpty()||this.txtDescription.getText().length()==0) {
			i++;
			this.txtDescription.setBackground(Color.red);
		}
		if(this.txtImageUrl.getText().isEmpty()||this.txtImageUrl.getText().length()==0) {
			i++;
			this.txtImageUrl.setBackground(Color.red);
		}
		if(i!=0) {
			return false;
		}
		return true;
	}
}
