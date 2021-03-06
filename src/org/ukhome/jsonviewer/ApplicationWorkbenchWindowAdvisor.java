package org.ukhome.jsonviewer;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    @Override
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    @Override
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        // 显示菜单区域
        configurer.setShowMenuBar(true);
        // 显示工具条区域
        configurer.setShowCoolBar(true);
        // 显示状态栏区域
        configurer.setShowStatusLine(true);
        // 显示进度条区域
        configurer.setShowProgressIndicator(true);
        configurer.setInitialSize(new Point(800, 600));
        configurer.setTitle("JsonViewer"); //$NON-NLS-1$
    }

    @Override
    public void postWindowOpen() {
        super.postWindowOpen();
        centeredScreen();
    }

    private void centeredScreen() {
        Shell shell = getWindowConfigurer().getWindow().getShell();
        Rectangle screenSize = Display.getDefault().getClientArea();
        Rectangle frameSize = shell.getBounds();
        shell.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }
}
