package com.exigen.ren.main.modules.mywork.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.FileUpload;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class AddAttachmentForTaskActionTabMetaData extends MetaData {

    public static final AssetDescriptor<FileUpload> FILE_UPLOAD = declare("File", FileUpload.class, Waiters.DEFAULT,false, By.id("addEfDocumentForm:documentUpload_input"));
    public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class, Waiters.DEFAULT,false);
    public static final AssetDescriptor<ComboBox> FOLDER = declare("Folder", ComboBox.class, Waiters.DEFAULT,false);
    public static final AssetDescriptor<ComboBox> TYPE = declare("Type", ComboBox.class, Waiters.DEFAULT,false);
    public static final AssetDescriptor<TextBox> TAGS = declare("Tags", TextBox.class, Waiters.DEFAULT,false);
    public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class, Waiters.DEFAULT,false);

}
