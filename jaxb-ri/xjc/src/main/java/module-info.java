/*
 * Copyright (c) 2017, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

/**
 * JAXB Binding Compiler. Contains source code needed for binding customization files into java sources.
 * In other words: the *tool* to generate java classes for the given xml representation.
 */
module com.sun.tools.xjc {

    requires java.logging;
    requires java.compiler;
    requires jdk.compiler;
    requires java.desktop;

    requires com.sun.tools.rngdatatype;
    requires com.sun.codemodel;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.sun.istack.runtime;
    requires com.sun.istack.tools;
    requires com.sun.xml.xsom;
    requires com.sun.tools.rngom;
    requires com.sun.xml.dtdparser;
    requires com.sun.xml.txw2;

    opens com.sun.tools.xjc.reader.xmlschema.bindinfo to java.xml.bind;
    opens com.sun.tools.xjc.model to com.sun.xml.bind;
    opens com.sun.tools.xjc.generator.bean to com.sun.xml.bind;

    exports com.sun.tools.xjc;
    exports com.sun.tools.xjc.reader;
    exports com.sun.tools.xjc.reader.internalizer;
    exports com.sun.tools.xjc.api;
    exports com.sun.tools.xjc.util;

    uses com.sun.tools.xjc.Plugin;

    provides com.sun.tools.xjc.Plugin with
        com.sun.tools.xjc.addon.accessors.PluginImpl,
        com.sun.tools.xjc.addon.at_generated.PluginImpl,
        com.sun.tools.xjc.addon.code_injector.PluginImpl,
        com.sun.tools.xjc.addon.episode.PluginImpl,
        com.sun.tools.xjc.addon.locator.SourceLocationAddOn,
        com.sun.tools.xjc.addon.sync.SynchronizedMethodAddOn;
}
