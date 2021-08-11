/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.enums;

import com.exigen.istf.webdriver.controls.Named;

public final class AdminConstants {

    private AdminConstants() {
    }

    public static final class AdminAgenciesTable {
        public static final String AGENCY_NAME = "Agency Name";
        public static final String ACTION = "Action";
        public static final String AGENCY_CODE = "Agency Code";
        public static final String TAX_ID = "Tax Id";
        public static final String STATE = "State";
        public static final String STATUS = "Status";
    }

    public static final class AdminVendorTable {
        public static final String TAX_ID = "Tax ID";
        public static final String STATUS = "Status";
        public static final String VENDOR_NAME = "Vendor Name";
    }

    public static final class AdminSearchFormResultsTable {
        public static final String AGENCY_NAME = "Agency Name";
        public static final String AGENCY_CODE = "Agency Code";
        public static final String ACTION = "Action";
        public static final String ADDRESS = "Address";
    }

    public static final class AdminProfileSearchResultsTable {
        public static final String FIRST_NAME = "First Name";
        public static final String LAST_NAME = "Last Name";
        public static final String ACTION = "Action";
    }

    public static final class AdminSearchResultsTable {
        public static final String NAME = "Name";
        public static final String CODE = "Code";
        public static final String ACTION = "Action";
        public static final String TITLE = "Title";
    }

    public static final class AdminEntityStatus {
        public static final String ACTIVE = "Active";
        public static final String DISABLED = "Disabled";
    }

    public static final class AdminRolesSearchResultTable {
        public static final String ROLE_NAME = "Role Name";
        public static final String FIRST_NAME = "First Name";
        public static final String LAST_NAME = "Last Name";
        public static final String ACTION = "Action";
    }

    public static final class AdminAgencySearchResultTable {
        public static final String ACTION = "Action";
        public static final String AGENCY_NAME = "Agency Name";
        public static final String CODE = "Code";
    }

    public static final class AdminDefaultAuthorityLevelsTable {
        public static final String TYPE = "Type";
    }

    public static final class AdminFilterNoteOrAlertTable {
        public static final String CATEGORY = "Category";
    }

    public static final class AdminAgencyLocationTable {
        public static final String AGENCY_LOCATION_CODE = "Agency/Location Code";
        public static final String AGENCY_LOCATION_NAME = "Agency/Location Name";
        public static final String DEFAULT = "Default";
    }

    public static final class AdminUserAuthorityLevelsTable {
        public static final String ACTION = "Actions";
    }

    public static final class AdminBrandsTable {
        public static final String NAME = "Name";
        public static final String TYPE = "Type";
        public static final String CODE = "Code";
        public static final String ACTION = "Action";
    }

    public static final class AdminBrandsTypeTable {
        public static final String NAME = "Name";
        public static final String ACTION = "Action";
    }

    public static final class AdminAddedSupportTeamTable {
        public static final String ACTION = "Action";
    }

    public static final class AdminAddedChildrenTable {
        public static final String ACTION = "Action";
    }

    public static final class AdminFeeAndTaxResultsTable {
        public static final String ACTION = "Action";
    }

    public static final class AdminTaxRulesTable {
        public static final String ACTION = "Action";
        public static final String REGISTRY_CODE = "Registry Code";
    }

    public static final class AdminFilterResultsTable {
        public static final String TITLE = "Title";
    }

    public static final class AdminVendorProfileTable {
        public static final String ACTION = "Action";
        public static final String TAX_ID = "Tax ID";
    }

    public static final class AdminSecurityProfileAgencyLocationsTable {
        public static final String USER_NAME_UNIQUELY_IDENTIFIES_USER_IN_SYSTEM = "User Name uniquely identifies user in system. "
                + "It is used as reference from domains and cannot be changed after profile creation.";
        public static final String LOGIN_NAME_IS_USED_TO_AUTHENTICATE_USER = "Login Name is used to authenticate user. The login name should "
                + "be provided when user is logging into a system. By default login name matches user name but can be changed.";
    }

    public static final class AdminDBLookupsSearchResultsTable {
        public static final String NAME = "Name";
    }

    public static final class AdminDBLookupValuesTable {
        public static final String CODE = "code";
        public static final String VALUE_DEFAULT = "value (default)";
        public static final String VALUE_EN = "value_EN_US_";
        public static final String ACTIONS = "Actions";
        public static final String DELETE = "Delete";
        public static final String COUNTRY_CD = "countryCd";
        public static final String STATE_PROV_CD = "stateProvCd";
    }

    public enum AdminJobTable implements Named {
        ELIMINATE("Eliminate"), NAME("Name"), JOB("Job"), ACTIONS("Actions");

        private String name;

        AdminJobTable(String label) {
            this.name = label;
        }

        public String getName() {
            return name;
        }
    }

    public static final class AdminCarrier {
        public static final String CODE = "Code";
        public static final String ACCOUNT_HOLDER_NAME = "Account Holder Name";
    }

    public static final class AdminSchemeStatus {
        public static final String APPROVED = "Approved";
        public static final String DATA_GATHERING = "Data Gathering";
        public static final String APPROVAL_REQUESTED = "Approval Requested";
        public static final String CLOSED = "Closed";
        public static final String DISAPPROVED = "Disapproved";
    }

    public static final class AdminGroup {
        public static final String GROUP_NAME = "Group Name";
        public static final String CHANGE = "Change";
        public static final String DELETE = "Delete";
    }

    public static final class AdminSchemeSearchResultsTable {
        public static final String NAME = "Name";
        public static final String ACCOUNTING_SCHEME_CODE = "Accounting Scheme Code";
    }

    public static final class AdminPARTable {
        public static final String CODE = "Code";
        public static final String CHANGE = "Change";
        public static final String DELETE = "Delete";
        public static final String ACTION = "Action";
    }

    public static final class AdminErrorMessages {
        public static final String CLOSE_SCHEME_ERROR = "Cannot close scheme, active policies exist for one of scheme policy";
    }

    public static final class AdminNoteSearchTable {
        public static final String NOTE_CATEGORY = "Note Category";
        public static final String STATUS = "Status";
    }

    public static final class AdminPrintMonitorSearchTable {
        public static final String REQUEST_ID = "Request ID";
        public static final String REQUEST_ID_PRINT_DOCS = "Request Id";
        public static final String CREATION_DATE_TIME = "Creation Date/Time";
        public static final String RESCHEDULED = "Rescheduled";
        public static final String STATUS = "Status";
        public static final String ENTITY_NUMBER = "Entity Number";
    }

    public static final class AdminPrintMonitorStatus {
        public static final String PAUSED = "Paused";
        public static final String CANCELED = "Cancelled";
        public static final String PENDING = "Pending";
        public static final String PRINTED = "Printed";
    }

    public static final class AdminCascadingTransactionStatus {
        public static final String IN_PROGRESS = "In Progress";
        public static final String COMPLETED = "Completed";
    }

    public static final class AdminCatastropheSearchTable {
        public static final String CATASTROPHE_ID = "Catastrophe ID";
        public static final String CATASTROPHE_NAME = "Catastrophe Name";
        public static final String STATUS = "Status";
        public static final String ACTIVE = "Active";
        public static final String EXPIRED = "Expired";
        public static final String ACTIONS = "Actions";
        public static final String IMPACTED_COUNTRIES = "Impacted Countries";
        public static final String IMPACTED_CITIES = "Impacted Cities";
        public static final String IMPACTED_ZIP_CODES = "Impacted Zip Codes";

    }

    public static final class AdminTemplateTable {
        public static final String CATEGORY = "Category";
        public static final String TEMPLATE = "Template";
        public static final String METADATA = "Metadata";
    }

    public static final class AdminTemplateMngtSearchTable {
        public static final String TEMPLATE_ID = "Template Id";
    }

    public static final class AdminWorkGroupTable {
        public static final String CODE = "Code";
        public static final String NAME = "Name";
        public static final String ACTIONS = "Actions";
        public static final String EDIT = "Edit";
        public static final String REMOVE = "Remove";
    }

    public static final class AdminTableFailedTasks {
        public static final String ITEM_ID = "Item Id";
        public static final String ACTIONS = "Actions";
        public static final String REMOVE = "Remove";
        public static final String UNLOCK = "Unlock";
    }

    public static final class AdminBusinessActivitiesTable {
        public static final String GRAPH = "Graph";
        public static final String TREND = "Trend";
    }
}
