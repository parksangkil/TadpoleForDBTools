/*******************************************************************************
 * Copyright (c) 2013 hangum.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     hangum - initial API and implementation
 ******************************************************************************/
package com.hangum.tadpole.application.start;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.hamgum.tadpole.help.core.views.HelpViewPart;
import com.hangum.tadpole.notes.core.views.list.NoteListViewPart;
import com.hangum.tadpole.rdb.core.viewers.connections.ManagerViewer;
import com.hangum.tadpole.rdb.core.viewers.object.ExplorerViewer;

/**
 * Configures the perspective layout. This class is contributed 
 * through the plugin.xml.
 */
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		
		IFolderLayout leftFolder = layout.createFolder("id"+ManagerViewer.ID, IPageLayout.LEFT, 0.30f, editorArea);
		leftFolder.addView(ManagerViewer.ID);
		leftFolder.addView(HelpViewPart.ID);
//		layout.addView(HelpViewPart.ID, IPageLayout.RIGHT, 0.65f, IPageLayout.ID_EDITOR_AREA);
		
		IFolderLayout leftUnderFolder = layout.createFolder("id"+ExplorerViewer.ID, IPageLayout.BOTTOM, 0.30f, "id"+ManagerViewer.ID);		
		leftUnderFolder.addView(ExplorerViewer.ID);
		
		leftUnderFolder.addView(NoteListViewPart.ID);
		
		// viewer closealbe false
		layout.getViewLayout(HelpViewPart.ID).setCloseable(false);
		layout.getViewLayout(ManagerViewer.ID).setCloseable(false);
		layout.getViewLayout(ExplorerViewer.ID).setCloseable(false);
		layout.getViewLayout(NoteListViewPart.ID).setCloseable(false);
		
	}
}
