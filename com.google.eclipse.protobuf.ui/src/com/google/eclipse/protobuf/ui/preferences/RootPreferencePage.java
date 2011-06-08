/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

/**
 * @author alruiz@google.com (Alex Ruiz)
 */
public class RootPreferencePage extends PreferenceAndPropertyPage {

  private static final String PREFERENCE_PAGE_ID = RootPreferencePage.class.getName();
  
  /** {@inheritDoc} */
  @Override protected Control createContents(Composite parent) {
    // generated by WindowBuilder
    Composite contents = super.contentsComposite(parent);
    Label label = new Label(contents, SWT.NONE);
    label.setText("General Settings.");
    return contents;
  }

  /** {@inheritDoc} */
  @Override protected void onProjectSettingsActivation(boolean active) {}

  /** {@inheritDoc} */
  @Override protected String preferencePageId() {
    return PREFERENCE_PAGE_ID;
  }

  /** {@inheritDoc} */
  @Override protected void savePreferences(IPreferenceStore store) {}

  /** {@inheritDoc} */
  @Override protected void performDefaults(IPreferenceStore store) {}
}
