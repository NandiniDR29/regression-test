package com.exigen.ren.main.modules.caseprofile.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector2;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.FileUpload;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class FileIntakeManagementTabMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> INTAKE_PROFILE_NAME = declare("Intake Profile Name", TextBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector2> PRODUCT = declare("Product", AdvancedSelector2.class);
    public static final AssetDescriptor<ComboBox> FILE_TYPE = declare("File Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> RECORD_TYPE = declare("Record Type", ComboBox.class);
    public static final AssetDescriptor<DialogAssetList> UPLOAD_FILE = declare("Upload File Dialog", DialogAssetList.class, UploadFileDialog.class);
    public static final AssetDescriptor<TextBox> INTAKE_PROFILE_NUMBER = declare("Intake Profile Number", TextBox.class);

    public static class UploadFileDialog extends MetaData {
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("caseForm:fileUploadPopupBtn"));
        public static final AssetDescriptor<Button> DEFAULT_POPUP_SUBMITTER_NAME = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("fileUploadForm:saveFileUploadBtn"));
        public static final AssetDescriptor<TextBox> FILE_NAME = declare("File Name", TextBox.class);
        public static final AssetDescriptor<FileUpload> FILE_UPLOAD = declare("File Upload", FileUpload.class, By.id("censusFile"));
    }
}
