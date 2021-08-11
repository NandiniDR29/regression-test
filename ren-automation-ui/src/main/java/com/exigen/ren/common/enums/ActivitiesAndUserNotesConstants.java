/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common.enums;

public final class ActivitiesAndUserNotesConstants {

    private ActivitiesAndUserNotesConstants() {
    }

    public static final class ActivitiesAndUserNotesTable {
        public static final String STATUS = "Status";
        public static final String DESCRIPTION = "Description";
        public static final String PERFORMER = "Performer";
    }

    public static final class ActivitiesAndUserNotesStatus {
        public static final String FINISHED = "Finished";
        public static final String RUNNING = "Running";
        public static final String COMMITTED = "Committed";
        public static final String CANCELLED = "Cancelled";
    }

    public static final class ActivitiesAndUserNotesFilterResultsTable {
        public static final String TITLE = "Title";
        public static final String CATEGORY = "Category";
    }

    public static final class ActivitiesAndUserNotesDescription {
        public static final String QUOTE_DECLINE_BY_COMPANY = "Process Company Decline effective %1$s (%2$s) for Quote %3$s effective %1$s";
    }

}
