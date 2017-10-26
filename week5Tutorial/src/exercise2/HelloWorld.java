package exercise2;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HelloWorld {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorld window = new HelloWorld();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(116, 95, 59, 14);
		lblUsername.setText("Username:");

		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(116, 140, 59, 14);
		lblPassword.setText("Password:");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(225, 92, 64, 19);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(225, 140, 64, 19);

		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLogin.setBounds(195, 195, 94, 28);
		btnLogin.setText("Login");

	}
}
