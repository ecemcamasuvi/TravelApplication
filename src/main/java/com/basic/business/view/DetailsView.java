package com.basic.business.view;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.basic.business.entities.Destinations;
import com.basic.business.system.IDestinationService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DetailsView  extends javax.swing.JFrame {
	public IDestinationService destinationService;
	public Destinations destination;

	
	private JTextField txtImageUrl;
	private JTextField txtDescription;
	private JTextField txtCity;
	private JTextField txtCountry;
	private JTextField txtName;
	
	
	
	public void init() {
		txtName.setText(destination.getName());
		txtCity.setText(destination.getCity());
		txtCountry.setText(destination.getCountry());
		txtDescription.setText(destination.getDescription());
		txtImageUrl.setText(destination.getImageUrl());
	}
	public DetailsView(IDestinationService destinationService,int id) {
		this.destinationService=destinationService;
		this.destination=destinationService.getById(id);
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblSuccess = new JLabel("Updated successfully.");
		lblSuccess.setForeground(Color.GREEN);
		lblSuccess.setVisible(false);
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Name : ");
		
		JLabel label_1 = new JLabel("Country : ");
		
		JLabel label_2 = new JLabel("City : ");
		
		JLabel label_3 = new JLabel("Description : ");
		
		JLabel label_4 = new JLabel("Image Url");
		
		txtImageUrl = new JTextField();
		
		txtDescription = new JTextField();
		
		txtCity = new JTextField();
		
		txtCountry = new JTextField();
		
		txtName = new JTextField();
		
		JLabel label_5 = new JLabel("");
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Window win[] = java.awt.Window.getWindows();
        		for(int i=0;i<win.length;i++){
        		win[i].dispose();
        		}
				MainView mainView=new MainView();
				mainView.fillTable(destinationService);
		    	mainView.setVisible(true);
		    	mainView.setManager(destinationService);
			}
		});
		button.setText("Back");
		
		JButton btnUpdate = new JButton();
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCity.setBackground(Color.white);
				txtName.setBackground(Color.white);
				txtCountry.setBackground(Color.white);
				txtDescription.setBackground(Color.white);
				txtImageUrl.setBackground(Color.white);
				if(isValidInput()) {
					try {
					Destinations destination=new Destinations();
					destination.setId(id);
					destination.setName(txtName.getText());
					destination.setCountry(txtCountry.getText());
					destination.setCity(txtCity.getText());
					destination.setDescription(txtDescription.getText());
					destination.setImageUrl(txtImageUrl.getText());
					destinationService.update(destination);
					lblSuccess.setVisible(true);
					}
					catch(Exception ex) {
						throw ex;
					}
				}
			}
			
		});
		btnUpdate.setText("Update");
		
		JButton btnDelete = new JButton();
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				destinationService.delete(destination);
				java.awt.Window win[] = java.awt.Window.getWindows();
        		for(int i=0;i<win.length;i++){
        		win[i].dispose();
        		}
				MainView mainView=new MainView();
				mainView.fillTable(destinationService);
		    	mainView.setVisible(true);
		    	mainView.setManager(destinationService);
			}
		});
		btnDelete.setText("Delete");
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label_4))
							.addGap(41)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtImageUrl, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(326)
							.addComponent(label_5))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(312)
							.addComponent(lblSuccess))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(113)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtImageUrl, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(20)
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSuccess)
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_layeredPane = new GroupLayout(layeredPane);
		gl_layeredPane.setHorizontalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 744, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		gl_layeredPane.setVerticalGroup(
			gl_layeredPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 502, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layeredPane.setLayout(gl_layeredPane);
		init();
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
