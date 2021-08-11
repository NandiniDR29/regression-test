package com.exigen.ren;

public final class RenTestProperties {

    /**
     * Property responsible for saving entities on test failure. (Moved from ISBA for backward compatibility)
     */
    public static final String LISTENER_ON_FAILURE_SAVE = "listener.onfailure.save";

    /**
     * Property responsible for closing browser on test failure. (Moved from ISBA for backward compatibility)
     */
    public static final String LISTENER_ON_FAILURE_CLOSE = "listener.onfailure.close";

    public static final String SALESFORCE_CLIENT_ID = "salesforce.client.id";
    public static final String SALESFORCE_CLIENT_SECRET = "salesforce.client.secret";
    public static final String SALESFORCE_USERNAME = "salesforce.username";
    public static final String SALESFORCE_PASSWORD = "salesforce.password";

    public static final String DATE_US_FEDERAL_HOLIDAYS = "date.usFederalHolidays";

    /**
     * Set this property to false to disable reusing policies by several tests
     */
    public static final String TEST_REUSE_POLICY = "test.reuse.policy";
}
