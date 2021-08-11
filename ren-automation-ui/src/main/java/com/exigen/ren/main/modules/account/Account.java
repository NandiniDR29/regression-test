/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.account;

import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.account.actions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Account implements IAccount {
    protected static final Logger LOGGER = LoggerFactory.getLogger(Account.class);

    @Override
    public Workspace getDefaultWorkspace() {
        throw new IstfException(String.format("Not defined for current service type [%1$s]", this.getClass().getSimpleName()));
    }

    @Override
    public AddCustomerAction addCustomer() {
        return AutomationContext.getAction(AddCustomerAction.class);
    }

    @Override
    public EliminateCustomerAction eliminateCustomer() {
        return AutomationContext.getAction(EliminateCustomerAction.class);
    }

    @Override
    public MoveCustomerAction moveCustomer() {
        return AutomationContext.getAction(MoveCustomerAction.class);
    }

    @Override
    public MoveCustomerToNewAccountAction moveCustomerToNewAccount() {
        return AutomationContext.getAction(MoveCustomerToNewAccountAction.class);
    }

    @Override
    public AddAffinityGroupAction addAffinityGroup() {
        return AutomationContext.getAction(AddAffinityGroupAction.class);
    }

    @Override
    public EliminateAffinityGroupAction eliminateAffinityGroup() {
        return AutomationContext.getAction(EliminateAffinityGroupAction.class);
    }

    @Override
    public AddCommunicationAction addCommunication() {
        return AutomationContext.getAction(AddCommunicationAction.class);
    }

    @Override
    public RemoveCommunicationAction removeCommunication() {
        return AutomationContext.getAction(RemoveCommunicationAction.class);
    }

    @Override
    public UpdateAction update() {
        return AutomationContext.getAction(UpdateAction.class);
    }

    @Override
    public AddDesignatedContactAction addDesignatedContact() {
        return AutomationContext.getAction(AddDesignatedContactAction.class);
    }

    @Override
    public EliminateDesignatedContactAction eliminateDesignatedContact() {
        return AutomationContext.getAction(EliminateDesignatedContactAction.class);
    }
}
