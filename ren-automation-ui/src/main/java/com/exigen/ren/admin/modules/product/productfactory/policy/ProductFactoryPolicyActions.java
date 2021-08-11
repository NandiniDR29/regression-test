/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.policy;

import com.exigen.ren.admin.modules.product.productfactory.ProductFactoryActions;
import com.exigen.ren.common.Workspace;

public final class ProductFactoryPolicyActions {

    public static class Copy extends ProductFactoryActions.Copy {

        @Override
        public String getName() {
            return "Copy";
        }

        @Override
        public Workspace getWorkspace() {
            return null;
        }
    }

    public static class Update extends ProductFactoryActions.Update {

        @Override
        public String getName() {
            return "Update";
        }

        @Override
        public Workspace getWorkspace() {
            return null;
        }
    }

    public static class Inquiry extends ProductFactoryActions.Inquiry {

        @Override
        public String getName() {
            return "Inquiry";
        }

        @Override
        public Workspace getWorkspace() {
            return null;
        }
    }
}
