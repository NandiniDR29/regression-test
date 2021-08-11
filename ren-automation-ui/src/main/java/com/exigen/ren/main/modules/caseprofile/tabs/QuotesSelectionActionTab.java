package com.exigen.ren.main.modules.caseprofile.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.JSWaiter;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.caseprofile.metadata.QuotesSelectionActionTabMetaData;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class QuotesSelectionActionTab extends ActionTab {

    public QuotesSelectionActionTab() {
        super(QuotesSelectionActionTabMetaData.class);
    }

    public static final String SELECT_QUOTE_BY_ROW_NUMBER_KEY = "Select Quote by row number";
    public static final String SELECT_QUOTE_BY_QUOTE_NUMBER_KEY = "Select Quote by Quote number";

    public static TextBox textBoxProposalName = new TextBox(By.id("proposalForm:proposalInfoEdit_proposalName"));
    public static RadioGroup radioGroupProposalType = new RadioGroup(By.id("proposalForm:proposalInfoEdit_type"));

    public static Table tableProposalQuotesSelection = new Table(By.xpath("//div[@id='proposalForm:proposalQuotesSelectionTable']//table"));

    protected static final Waiter waiter = new JSWaiter("return document.readyState === 'complete' &&"
            + " ((typeof jQuery == 'undefined') ||"
            + " (!$('#ajaxLoadingModalBox').is(':visible') ||"
            + " $('#ajaxLoadingModalBox').attr('style')=='visibility: hidden;' &&"
            + " ($('#ajaxStatus').text() != 'on') && (jQuery.active == 0)))");

    @Override
    public Tab fillTab(TestData td) {
        if (td.containsKey(assetList.getName())) {
            if (td.getTestData(assetList.getName()).containsKey(SELECT_QUOTE_BY_ROW_NUMBER_KEY)) {
                selectQuote(td.getTestData(assetList.getName()).getList(SELECT_QUOTE_BY_ROW_NUMBER_KEY)
                        .stream().map(Integer::valueOf).collect(Collectors.toList()));
            }
            if (td.getTestData(assetList.getName()).containsKey(SELECT_QUOTE_BY_QUOTE_NUMBER_KEY)) {
                selectQuoteByNumber(td.getTestData(assetList.getName()).getList(SELECT_QUOTE_BY_QUOTE_NUMBER_KEY));
            }
        }
        assetList.fill(td);
        return this;
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }

    public static void selectQuote(List<Integer> rowNumberList) {
        selectQuote(rowNumberList, true);
    }

    public static void selectQuote(List<Integer> rowNumberList, boolean selected) {
        for (int rowNumber : rowNumberList) {
            tableProposalQuotesSelection.getRow(rowNumber).getCell(2).controls.checkBoxes.get(1, waiter).setValue(selected);
        }
    }

    public static void selectQuoteByNumber(List<String> quoteNumbersList) {
        for (String quoteNumber : quoteNumbersList) {
            tableProposalQuotesSelection.getRowContains(3, quoteNumber).getCell(2).controls.checkBoxes.get(1, waiter).setValue(true);
        }
    }
}
