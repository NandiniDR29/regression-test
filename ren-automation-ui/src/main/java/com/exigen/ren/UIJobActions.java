/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren;

import com.exigen.ren.admin.modules.general.scheduler.JobContext;
import com.exigen.ren.admin.modules.general.scheduler.pages.GeneralSchedulerPage;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ipb.eisa.utils.batchjob.JobActions;
import com.exigen.ipb.eisa.utils.batchjob.JobGroup;
import com.exigen.istf.data.TestData;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UIJobActions implements JobActions, JobContext {
    private TestData tdJobCreate = job.getDefaultTestData().getTestData("DataGather", "TestData_Single");
    private static UIJobListener listener = new UIJobListener();

    @Override
    public void createJob(JobGroup jobGroup) {
        Map <String, String> parametersMap = jobGroup.getJobs().get(0).getJobParameters();
        if (!Objects.isNull(parametersMap)) {
            String paramsString = parametersMap.get("JOB_UI_PARAMS");
            if (Objects.isNull(paramsString)){
                paramsString = parametersMap.keySet().stream().map(key-> key + " " + parametersMap.get(key)).collect(Collectors.joining(" "));
            }

            job.create(tdJobCreate.adjust(TestData.makeKeyPath("CreateJobTab", "Name"), jobGroup.getGroupName())
                    .adjust(TestData.makeKeyPath("CreateJobTab", "AdditionalJobs", "1."), jobGroup.getGroupName())
                    .adjust(TestData.makeKeyPath("CreateJobTab", "AdditionalJobs", "Job Parameters"), paramsString));
        } else {
            job.create(tdJobCreate.adjust(TestData.makeKeyPath("CreateJobTab", "Name"), jobGroup.getGroupName())
                    .adjust(TestData.makeKeyPath("CreateJobTab", "AdditionalJobs", "1."), jobGroup.getGroupName()));
        }
    }

    @Override
    public String getJobState(JobGroup jobGroup) {
        return GeneralSchedulerPage.getJobStatus(jobGroup);
    }

    @Override
    public void startJob(JobGroup jobGroup) {
        GeneralSchedulerPage.runJob(jobGroup);
    }

    @Override
    public void stopJob(JobGroup jobGroup) {
        GeneralSchedulerPage.eliminateJob(jobGroup);
    }

    @Override
    public boolean isJobExist(JobGroup jobGroup) {
        ApplicationFactory.getInstance().getAdminApplication().open();
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
        return GeneralSchedulerPage.isJobExist(jobGroup);
    }
}
