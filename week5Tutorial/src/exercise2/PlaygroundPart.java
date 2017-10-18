//package exercise2;
//
//import javax.annotation.PostConstruct;
//
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Text;
//import org.eclipse.swt.layout.GridData;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
//
//public class PlaygroundPart {
//	private Text txtTextBox;
//
//	@PostConstruct
//	public void createControls(Composite parent) {
//		parent.setLayout(new GridLayout(2, false));
//
//		Button btnNewButton = new Button(parent, SWT.NONE);
//		btnNewButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//			}
//		});
//		btnNewButton.setText("New Button");
//		new Label(parent, SWT.NONE);
//
//		Button btnNewButton_1 = new Button(parent, SWT.NONE);
//		btnNewButton_1.setText("New Button");
//		new Label(parent, SWT.NONE);
//
//		Label lblLabel = new Label(parent, SWT.NONE);
//		lblLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
//		lblLabel.setText("Label");
//
//		txtTextBox = new Text(parent, SWT.BORDER);
//		txtTextBox.setText("Text Box");
//		txtTextBox.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		System.out.println("createControls method called");
//	}
//
//}
