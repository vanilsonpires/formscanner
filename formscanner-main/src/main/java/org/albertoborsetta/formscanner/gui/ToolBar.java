package org.albertoborsetta.formscanner.gui;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

import org.albertoborsetta.formscanner.commons.FormScannerConstants;
import org.albertoborsetta.formscanner.controller.FormScannerController;
import org.albertoborsetta.formscanner.model.FormScannerModel;


public class ToolBar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static FormScannerModel model;
	private FormScannerController controller;
	
	private JButton openButton;
	private JButton saveButton;
	private JButton renameButton;
	private JButton startButton;
	
	/**
	 * Create the panel.
	 */
	public ToolBar(FormScannerModel formScannerModel) {
		
		model = formScannerModel;
		controller = FormScannerController.getInstance(model);
		
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JToolBar fileToolBar = new FileToolBar();
		add(fileToolBar);
		
		JToolBar editToolBar = new EditToolBar();
		add(editToolBar);
	}
	
	private class FileToolBar extends JToolBar {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public FileToolBar() {
			setAlignmentY(Component.CENTER_ALIGNMENT);
			setAlignmentX(Component.LEFT_ALIGNMENT);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			openButton = new OpenButton();
			saveButton = new SaveButton();
			
			
			add(openButton);			
			add(saveButton);			
		}
	}
	
	private class EditToolBar extends JToolBar {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EditToolBar() {
			setAlignmentY(Component.CENTER_ALIGNMENT);
			setAlignmentX(Component.LEFT_ALIGNMENT);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			renameButton = new RenameButton();
			startButton = new StartButton();
			
			add(renameButton);
			add(startButton);
		}
	}
	
	private class OpenButton extends JButton {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OpenButton() {
			setActionCommand(FormScannerConstants.OPEN_IMAGES);
			addActionListener(controller);
			setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setToolTipText("Open images");
			setIcon(new ImageIcon(FormScanner.class.getClassLoader().getResource("icons/open.png")));
		}
	}
	
	private class SaveButton extends JButton {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SaveButton() {
			setActionCommand(FormScannerConstants.SAVE_RESULTS);
			addActionListener(controller);
			setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setIcon(new ImageIcon(FormScanner.class.getClassLoader().getResource("icons/save.png")));
			setToolTipText("Save results");
			setEnabled(false);
		}
	}
	
	private class RenameButton extends JButton {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public RenameButton() {
			setActionCommand(FormScannerConstants.RENAME_FILE_FIRST);
			addActionListener(controller);
			setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setIcon(new ImageIcon(FormScanner.class.getClassLoader().getResource("icons/rename.png")));
			setToolTipText("Rename image files");
			setEnabled(false);
		}		
	}
	
	private class StartButton extends JButton {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public StartButton() {
			setActionCommand(FormScannerConstants.ANALYZE_FILE_FIRST);
			addActionListener(controller);
			setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			setIcon(new ImageIcon(FormScanner.class.getClassLoader().getResource("icons/start.png")));
			setToolTipText("Start analyze results");
			setEnabled(false);
		}		
	}
	
	public void setRenameControllersEnabled(boolean enable) {
		renameButton.setEnabled(enable);
	}

	public void setScanControllersEnabled(boolean enable) {
		startButton.setEnabled(enable);		
	}
}
