package com.exigen.ren.common.module.efolder.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.FileUpload;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class AddFileTabMetaData extends MetaData {
    public static final AssetDescriptor<FileUpload> FILE_UPLOAD = declare("File", FileUpload.class, By.id("addDocumentForm:documentUpload_input"));
    public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> FOLDER = declare("Folder", ComboBox.class);
    public static final AssetDescriptor<ComboBox> TYPE = declare("Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> TAGS = declare("Tags", TextBox.class, By.id("addDocumentForm:tags_input"));
    public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
}
