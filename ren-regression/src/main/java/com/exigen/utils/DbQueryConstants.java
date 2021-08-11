package com.exigen.utils;

public class DbQueryConstants {
    public static final String CHECK_CUSTOMIZE_PLAN_QUERY = "SELECT PS.policyNumber, " +
                                                          "       PS.policyDetail_id AS 'Policy Number', " +
                                                          "       PD.id AS 'Policy detail ID', " +
                                                          "       GCD.id AS 'Group Coverage Def. ID', " +
                                                          "       CGCR.id AS 'Coveraga Relationship ID', " +
                                                          "       CGCR.customizeCoverage 'Customize Plan?' " +
                                                          "FROM PolicySummary PS " +
                                                          "LEFT JOIN PolicyDetail PD ON PD.id = PS.policyDetail_id " +
                                                          "LEFT JOIN GroupCoverageDefinition GCD ON GCD.POLICYDETAIL_ID = PD.id " +
                                                          "LEFT JOIN ClassGrpCoverageRelationship CGCR ON CGCR.groupCoverageDefinition_id = GCD.id " +
                                                          "WHERE PS.policyNumber = '%s'";

    public static final String FIND_BILLING_ACCOUNT_NUMBER_BY_MASTER_POLICY_NUMBER =
            "SELECT distinct ba.accountNumber " +
            "FROM BillableBillingGroup bg " +
            "JOIN BillableBillingGroup_Policy bgp on bg.id = bgp.billableBillingGroup_id " +
            "JOIN BillablePolicy mp on mp.id = bgp.billablePolicy_id " +
            "JOIN BillingAccount ba on ba.id = bg.account_id " +
            "WHERE mp.policyNumber = '%s'";


}
