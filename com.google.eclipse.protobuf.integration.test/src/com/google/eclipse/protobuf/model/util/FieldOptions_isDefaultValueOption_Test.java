/*
 * Copyright (c) 2011 Google Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.google.eclipse.protobuf.model.util;

import static com.google.eclipse.protobuf.junit.core.Setups.integrationTestSetup;
import static com.google.eclipse.protobuf.junit.core.XtextRule.createWith;
import static com.google.eclipse.protobuf.junit.model.find.FieldOptionFinder.findFieldOption;
import static com.google.eclipse.protobuf.junit.model.find.Name.name;
import static com.google.eclipse.protobuf.junit.model.find.Root.in;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import com.google.eclipse.protobuf.junit.core.XtextRule;
import com.google.eclipse.protobuf.protobuf.*;

import org.junit.*;

/**
 * Tests for <code>{@link FieldOptions#isDefaultValueOption(FieldOption)}</code>.
 *
 * @author alruiz@google.com (Alex Ruiz)
 */
public class FieldOptions_isDefaultValueOption_Test {

  @Rule public XtextRule xtext = createWith(integrationTestSetup());

  private Protobuf root;
  private FieldOptions fieldOptions;

  @Before public void setUp() {
    root = xtext.root();
    fieldOptions = xtext.getInstanceOf(FieldOptions.class);
  }

  // message Person {
  //   optional boolean active = 1 [default = true, deprecated = false];
  // }
  @Test public void should_return_true_if_FieldOption_is_default_value_one() {
    FieldOption option = findFieldOption(name("default"), in(root));
    boolean result = fieldOptions.isDefaultValueOption(option);
    assertThat(result, equalTo(true));
  }

  // message Person {
  //   optional boolean active = 1 [default = true, deprecated = false];
  // }
  @Test public void should_return_false_if_FieldOption_is_not_default_value_one() {
    FieldOption option = findFieldOption(name("deprecated"), in(root));
    boolean result = fieldOptions.isDefaultValueOption(option);
    assertThat(result, equalTo(false));
  }
}