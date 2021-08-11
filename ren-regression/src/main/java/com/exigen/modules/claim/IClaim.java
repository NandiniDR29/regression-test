/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim;

import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.actions.*;
import com.exigen.ren.main.modules.claim.gb_dn.actions.AddPatientHistoryRecordAction;
import com.exigen.ren.main.modules.claim.gb_dn.actions.UpdatePatientHistoryRecordAction;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IClaim extends EntityService {
    Logger LOGGER = LoggerFactory.getLogger(com.exigen.ren.main.modules.claim.IClaim.class);

    @Override
    default TestData defaultTestData() {
        throw new IstfException(String.format("Should be implemented in service class[%1$s] implementation with appropriate test data", this.getClass().getSimpleName()));
    }

    default Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(ClaimInquiryAction.class).getWorkspace();
    }

    default Workspace getInitializationView() {
        return AutomationContext.getAction(InitiateClaimAction.class).getWorkspace();
    }

    default void navigateToClaim() {
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CLAIM);
    }


    default void initiateCreation() {
        navigateToClaim();
        ClaimSummaryPage.buttonCreateNewClaim.click();
    }

    default void initiate(TestData td) {
        initiateCreation();
        getInitializationView().fill(td);

        LOGGER.info("Initialized Claim " + EntityLogger.getEntityHeader(EntityLogger.EntityType.CLAIM));
    }

    default void initiateCreationWithoutPolicy() {
        CustomerSummaryPage.linkCreateNewClaimWithoutPolicy.click();
    }

    default void initiateWithoutPolicy(TestData td) {
        initiateCreationWithoutPolicy();
        getInitializationView().fill(td);
        LOGGER.info("Created Claim " + EntityLogger.getEntityHeader(EntityLogger.EntityType.CLAIM));
    }

    default void create(TestData td) {
        initiate(td);
        getDefaultWorkspace().fill(td);

        LOGGER.info("Created Claim " + EntityLogger.getEntityHeader(EntityLogger.EntityType.CLAIM));
    }

    default void createWithoutPolicy(TestData td) {
        initiateWithoutPolicy(td);
        getDefaultWorkspace().fill(td);

        LOGGER.info("Created Claim " + EntityLogger.getEntityHeader(EntityLogger.EntityType.CLAIM));
    }

    default Action claimClose() {
        return AutomationContext.getAction(ClaimCloseAction.class);
    }

    default ClaimCopyAction claimCopy() {
        return AutomationContext.getAction(ClaimCopyAction.class);
    }

    default Action claimInquiry() {
        return AutomationContext.getAction(ClaimInquiryAction.class);
    }

    default Action claimNotification() {
        return AutomationContext.getAction(ClaimNotificationAction.class);
    }

    default Action claimOpen() {
        return AutomationContext.getAction(ClaimOpenAction.class);
    }

    default Action claimPolicyUpdate() {
        return AutomationContext.getAction(ClaimPolicyUpdateAction.class);
    }

    default Action claimReopen() {
        return AutomationContext.getAction(ClaimReopenAction.class);
    }

    default Action claimSubmit() {
        return AutomationContext.getAction(ClaimSubmitAction.class);
    }

    default Action claimUpdate() {
        return AutomationContext.getAction(ClaimUpdateAction.class);
    }

    default Action clearFraud() {
        return AutomationContext.getAction(ClearFraudAction.class);
    }

    default Action flagFraudPotential() {
        return AutomationContext.getAction(FlagFraudPotentialAction.class);
    }

    default Action policySummaryInquiry() {
        return AutomationContext.getAction(PolicySummaryInquiryAction.class);
    }

    default Action reviewFraud() {
        return AutomationContext.getAction(ReviewFraudAction.class);
    }

    default Action subrogationOpen() {
        return AutomationContext.getAction(SubrogationOpenAction.class);
    }

    default Action secureClaim() {
        return AutomationContext.getAction(SecureClaimAction.class);
    }

    default Action unsecureClaim() {
        return AutomationContext.getAction(UnsecureClaimAction.class);
    }

    default Action updateFraud() {
        return AutomationContext.getAction(UpdateFraudAction.class);
    }

    default CalculateSingleBenefitAmountAction calculateSingleBenefitAmount() {
        return AutomationContext.getAction(CalculateSingleBenefitAmountAction.class);
    }

    default ChangeSingleBenefitCalculationStatusAction changeSingleBenefitCalculationStatus() {
        return AutomationContext.getAction(ChangeSingleBenefitCalculationStatusAction.class);
    }

    default AddBenefitAction addBenefit() {
        return AutomationContext.getAction(AddBenefitAction.class);
    }

    default Action inquiryBenefit() {
        return AutomationContext.getAction(InquiryBenefitAction.class);
    }

    default SingleBenefitCalculationInquiryAction singleBenefitCalculationInquiry() {
        return AutomationContext.getAction(SingleBenefitCalculationInquiryAction.class);
    }

    default UpdateBenefitAction updateBenefit() {
        return AutomationContext.getAction(UpdateBenefitAction.class);
    }

    default RecalculateSingleBenefitAmountAction recalculateSingleBenefitAmount() {
        return AutomationContext.getAction(RecalculateSingleBenefitAmountAction.class);
    }

    default UpdateEliminationQualificationPeriodAction updateEliminationQualificationPeriodAction() {
        return AutomationContext.getAction(UpdateEliminationQualificationPeriodAction.class);
    }

    default UpdateEliminationPeriodAction updateEliminationPeriodAction() {
        return AutomationContext.getAction(UpdateEliminationPeriodAction.class);
    }


    default UpdateBenefitPeriodAction updateBenefitPeriodAction() {
        return AutomationContext.getAction(UpdateBenefitPeriodAction.class);
    }

    default PremiumWaiverApprovalPeriodsAction premiumWaiverApprovalPeriodsAction() {
        return AutomationContext.getAction(PremiumWaiverApprovalPeriodsAction.class);
    }

    default CancelPremiumWaiverApprovalPeriodsAction cancelPremiumWaiverApprovalPeriodsAction() {
        return AutomationContext.getAction(CancelPremiumWaiverApprovalPeriodsAction.class);
    }

    default UpdateMaximumBenefitPeriodAction updateMaximumBenefitPeriodAction() {
        return AutomationContext.getAction(UpdateMaximumBenefitPeriodAction.class);
    }

    default Action viewBenefit() {
        return AutomationContext.getAction(ViewBenefitAction.class);
    }

    default ViewSingleBenefitCalculationAction viewSingleBenefitCalculation() {
        return AutomationContext.getAction(ViewSingleBenefitCalculationAction.class);
    }

    default AddBenefitReservesAction addBenefitReserves() {
        return AutomationContext.getAction(AddBenefitReservesAction.class);
    }

    default Action addPayment() {
        return AutomationContext.getAction(AddPaymentAction.class);
    }

    default Action checkBalance() {
        return AutomationContext.getAction(BalanceAction.class);
    }

    default ApprovePaymentAction approvePayment() {
        return AutomationContext.getAction(ApprovePaymentAction.class);
    }

    default Action cancelPaymentSeries() {
        return AutomationContext.getAction(CancelPaymentSeriesAction.class);
    }

    default ClearPaymentAction clearPayment() {
        return AutomationContext.getAction(ClearPaymentAction.class);
    }

    default Action confirmStopPayment() {
        return AutomationContext.getAction(ConfirmStopPaymentAction.class);
    }

    default Action createPaymentSeries() {
        return AutomationContext.getAction(CreatePaymentSeriesAction.class);
    }

    default ContinuePaymentSeriesAction continuePaymentSeries() {
        return AutomationContext.getAction(ContinuePaymentSeriesAction.class);
    }

    default DeclinePaymentAction declinePayment() {
        return AutomationContext.getAction(DeclinePaymentAction.class);
    }

    default DenyPaymentAction denyPayment() {
        return AutomationContext.getAction(DenyPaymentAction.class);
    }

    default Action declineRecovery() {
        return AutomationContext.getAction(DeclineRecoveryAction.class);
    }

    default InquiryPaymentSeriesAction inquiryPaymentSeries() {
        return AutomationContext.getAction(InquiryPaymentSeriesAction.class);
    }

    default IssuePaymentAction issuePayment() {
        return AutomationContext.getAction(IssuePaymentAction.class);
    }

    default ReissuePaymentAction reissuePayment() {
        return AutomationContext.getAction(ReissuePaymentAction.class);
    }

    default RecalculatePaidPaymentAction recalculatePaidPayment() {
        return AutomationContext.getAction(RecalculatePaidPaymentAction.class);
    }

    default PaymentInquiryAction paymentInquiry() {
        return AutomationContext.getAction(PaymentInquiryAction.class);
    }

    default Action postRecovery() {
        return AutomationContext.getAction(PostRecoveryAction.class);
    }

    default Action rejectPayment() {
        return AutomationContext.getAction(RejectPaymentAction.class);
    }

    default StopPaymentAction stopPayment() {
        return AutomationContext.getAction(StopPaymentAction.class);
    }

    default UpdatePaymentAction updatePayment() {
        return AutomationContext.getAction(UpdatePaymentAction.class);
    }

    default UpdatePaymentSeriesAction updatePaymentSeries() {
        return AutomationContext.getAction(UpdatePaymentSeriesAction.class);
    }

    default UpdateRecoveryAction updateRecovery() {
        return AutomationContext.getAction(UpdateRecoveryAction.class);
    }

    default ViewPaymentAction viewPayment() {
        return AutomationContext.getAction(ViewPaymentAction.class);
    }

    default Action viewPaymentSeries() {
        return AutomationContext.getAction(ViewPaymentSeriesAction.class);
    }

    default Action viewRecovery() {
        return AutomationContext.getAction(ViewRecoveryAction.class);
    }

    default VoidPaymentAction voidPayment() {
        return AutomationContext.getAction(VoidPaymentAction.class);
    }

    default VoidRecoveryAction voidRecovery() {
        return AutomationContext.getAction(VoidRecoveryAction.class);
    }

    default SubrogationAddResponsiblePartyAction subrogationAddResponsibleParty() {
        return AutomationContext.getAction(SubrogationAddResponsiblePartyAction.class);
    }

    default SubrogationUpdateAction subrogationUpdate() {
        return AutomationContext.getAction(SubrogationUpdateAction.class);
    }

    default Action subrogationUpdateResponsibleParty() {
        return AutomationContext.getAction(SubrogationUpdateResponsiblePartyAction.class);
    }

    default Action changeDateOfLossAction() {
        return AutomationContext.getAction(ClaimChangeDateOfLossAction.class);
    }

    default DisapprovePaymentAction disapprovePayment() {
        return AutomationContext.getAction(DisapprovePaymentAction.class);
    }

    default ClaimSuspendAction claimSuspend() {
        return AutomationContext.getAction(ClaimSuspendAction.class);
    }

    default AddPatientHistoryRecordAction addPatientHistoryRecord() {
        return AutomationContext.getAction(AddPatientHistoryRecordAction.class);
    }

    default UpdatePatientHistoryRecordAction updatePatientHistoryRecord() {
        return AutomationContext.getAction(UpdatePatientHistoryRecordAction.class);
    }


    default ClaimContinueAction claimContinue() {
        return AutomationContext.getAction(ClaimContinueAction.class);
    }

    default Action pendClaim(){
        return AutomationContext.getAction(PendClaimAction.class);
    }
}
