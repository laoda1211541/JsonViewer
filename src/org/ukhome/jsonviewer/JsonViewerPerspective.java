package org.ukhome.jsonviewer;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.ukhome.jsonviewer.view.JsonViewer;

public class JsonViewerPerspective implements IPerspectiveFactory {

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		String area = layout.getEditorArea();
		layout.addStandaloneView(JsonViewer.ID, true, IPageLayout.LEFT, 0.25f, area);
	}
}