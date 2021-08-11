/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.mywork;

import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.mywork.actions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IMyWork extends EntityService {

    Logger LOGGER = LoggerFactory.getLogger(IMyWork.class);

    Workspace getDefaultWorkspace();

    default void navigate(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.MY_WORK);
    }

    default CreateTaskAction createTask() {
        return AutomationContext.getAction(CreateTaskAction.class);
    }

    default CompleteTaskAction completeTask() {
        return AutomationContext.getAction(CompleteTaskAction.class);
    }

    default AssignTaskToAction assignTaskTo() {
        return AutomationContext.getAction(AssignTaskToAction.class);
    }

    default UpdateTaskAction updateTask() {
        return AutomationContext.getAction(UpdateTaskAction.class);
    }

    default FilterTaskAction filterTask() {
        return AutomationContext.getAction(FilterTaskAction.class);
    }

    default UpdateMyProfileAction updateMyProfile() {
        return AutomationContext.getAction(UpdateMyProfileAction.class);
    }

    default AddAttachmentForTaskAction addAttachmentForTask() {
        return AutomationContext.getAction(AddAttachmentForTaskAction.class);
    }

    default CompleteTaskDentalAction completeTaskDental() {
        return AutomationContext.getAction(CompleteTaskDentalAction.class);
    }

}
