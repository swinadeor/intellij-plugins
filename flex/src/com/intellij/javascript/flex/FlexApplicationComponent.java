package com.intellij.javascript.flex;

import com.intellij.icons.AllIcons;
import com.intellij.javaee.ResourceRegistrar;
import com.intellij.javaee.StandardResourceProvider;
import com.intellij.javascript.flex.mxml.schema.FlexMxmlNSDescriptor;
import com.intellij.lang.Language;
import com.intellij.lang.javascript.JavaScriptSupportLoader;
import com.intellij.lang.javascript.flex.MxmlFileType;
import com.intellij.lang.javascript.psi.ecmal4.impl.JSAttributeImpl;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.filters.position.NamespaceFilter;
import com.intellij.psi.filters.position.RootTagFilter;
import com.intellij.psi.meta.MetaDataRegistrar;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author yole
 */
public class FlexApplicationComponent extends FileTypeFactory implements ApplicationComponent {
  private static final Icon ICON = AllIcons.FileTypes.JavaClass;

  public static final FileType SWF_FILE_TYPE = new FileType() {
    @NotNull
    public String getName() {
      return "SWF";
    }

    @NotNull
    public String getDescription() {
      return "SWF file type";
    }

    @NotNull
    public String getDefaultExtension() {
      return "swf";
    }

    public Icon getIcon() {
      return ICON;
    }

    public boolean isBinary() {
      return true;
    }

    public boolean isReadOnly() {
      return true;
    }

    public String getCharset(@NotNull final VirtualFile file, final byte[] content) {
      return null;
    }
  };

  public static final Language DECOMPILED_SWF = new Language(JavaScriptSupportLoader.ECMA_SCRIPT_L4, "Decompiled SWF") {};

  public static final LanguageFileType MXML = new MxmlFileType();

  @NonNls public static final String HTTP_WWW_ADOBE_COM_2006_FLEX_CONFIG = "http://www.adobe.com/2006/flex-config";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_0 = "http://ns.adobe.com/air/application/1.0";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_1 = "http://ns.adobe.com/air/application/1.1";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5 = "http://ns.adobe.com/air/application/1.5";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5_1 = "http://ns.adobe.com/air/application/1.5.1";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5_2 = "http://ns.adobe.com/air/application/1.5.2";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5_3 = "http://ns.adobe.com/air/application/1.5.3";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_0 = "http://ns.adobe.com/air/application/2.0";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_5 = "http://ns.adobe.com/air/application/2.5";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_6 = "http://ns.adobe.com/air/application/2.6";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_7 = "http://ns.adobe.com/air/application/2.7";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_0 = "http://ns.adobe.com/air/application/3.0";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_1 = "http://ns.adobe.com/air/application/3.1";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_2 = "http://ns.adobe.com/air/application/3.2";
  @NonNls public static final String HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_3 = "http://ns.adobe.com/air/application/3.3";

  @NotNull
  public String getComponentName() {
    return "FlexApplicationComponent";
  }

  public void initComponent() {
    MetaDataRegistrar.getInstance().registerMetaData(
      new RootTagFilter(new NamespaceFilter(JavaScriptSupportLoader.MXML_URIS)),
      FlexMxmlNSDescriptor.class
    );

  }

  public void disposeComponent() {
  }

  public void createFileTypes(final @NotNull FileTypeConsumer consumer) {
    consumer.consume(SWF_FILE_TYPE, "swf");
    consumer.consume(MXML, "mxml;fxg");
  }

  public static class ResourceProvider implements StandardResourceProvider {

    public void registerResources(ResourceRegistrar registrar) {
      registrar.addStdResource(HTTP_WWW_ADOBE_COM_2006_FLEX_CONFIG, "/schemas/FlexCompilerSchema.xsd", FlexApplicationComponent.class);

      registrar.addStdResource(JSAttributeImpl.URN_FLEX_META, "/schemas/KnownMetaData.dtd", FlexApplicationComponent.class);

      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_0, "/schemas/AIR_Descriptor.1.0.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_1, "/schemas/AIR_Descriptor.1.1.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5, "/schemas/AIR_Descriptor.1.5.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5_1, "/schemas/AIR_Descriptor.1.5.1.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5_2, "/schemas/AIR_Descriptor.1.5.2.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_1_5_3, "/schemas/AIR_Descriptor.1.5.3.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_0, "/schemas/AIR_Descriptor.2.0.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_5, "/schemas/AIR_Descriptor.2.5.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_6, "/schemas/AIR_Descriptor.2.6.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_2_7, "/schemas/AIR_Descriptor.2.7.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_0, "/schemas/AIR_Descriptor.3.0.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_1, "/schemas/AIR_Descriptor.3.1.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_2, "/schemas/AIR_Descriptor.3.2.xsd", FlexApplicationComponent.class);
      registrar.addStdResource(HTTP_NS_ADOBE_COM_AIR_APPLICATION_3_3, "/schemas/AIR_Descriptor.3.3.xsd", FlexApplicationComponent.class);
    }
  }
}
