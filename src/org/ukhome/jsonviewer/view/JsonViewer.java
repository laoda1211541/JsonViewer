package org.ukhome.jsonviewer.view;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;
import org.ukhome.jsonviewer.provider.JsonViewerContentProvider;
import org.ukhome.jsonviewer.provider.JsonViewerLabelProvider;

public class JsonViewer extends ViewPart {
	
	public static final String ID = "org.ukhome.jsonviewer.view.JsonViewer";
	private TreeViewer treeViewer;

	public JsonViewer() {
		
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		treeViewer = new TreeViewer(container, SWT.BORDER);
		final Tree tree = treeViewer.getTree();
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//单击
				super.widgetSelected(e);
				System.err.println(e);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {//双击
				Object element = ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();
				System.err.println(element);
			}
		});
		/* ITreeContentProvider
		 * 1. Object[] getElements	 					入参：下面第5步的input.child，	出参：object[i]节点内容
		 * 2. hasChildren 								入参：下面第5步的input.child，	出参：是否有子节点
		 * 3. Object[] getChildren，第2步返回true时调用，	入参：第1步出参object[i]，	出参：子节点内容
		 */
		treeViewer.setContentProvider(new JsonViewerContentProvider());
		/* ILabelProvider
		 * 4. getImage、getText 							入参：下面第5步的input.child
		 */
		treeViewer.setLabelProvider(new JsonViewerLabelProvider());
		/*
		 * 5. 入参同时也是上面的getElements、getImage、getText入参的parent
		 */
		treeViewer.setInput(getViewSite());
		getSite().setSelectionProvider(treeViewer);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
