/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.enums;

import com.exigen.istf.webdriver.controls.Named;

public final class DXPConstants {

    private DXPConstants() {
    }

    public enum CertificateCancellationReason implements Named {
        CONFIG_DENTAL("EMPLOYER.CERTIFICATES.TERMINATE.DENTAL"),
        CONFIG_ACCIDENT("EMPLOYER.CERTIFICATES.TERMINATE.ACCIDENT"),
        CONFIG_LIFE("EMPLOYER.CERTIFICATES.TERMINATE.LIFE"),
        CONFIG_LTD("EMPLOYER.CERTIFICATES.TERMINATE.LTD"),
        CONFIG_STD("EMPLOYER.CERTIFICATES.TERMINATE.STD"),
        CONFIG_VISION("EMPLOYER.CERTIFICATES.TERMINATE.VISION");

        private String name;

        CertificateCancellationReason(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum CertificateRescindCancellationReason implements Named {
        RESCIND_CANCELLATION_CONFIG_DENTAL("EMPLOYER.CERTIFICATES.RESCIND.CANCELLATION.DENTAL"),
        RESCIND_CANCELLATION_CONFIG_ACCIDENT("EMPLOYER.CERTIFICATES.RESCIND.CANCELLATION.ACCIDENT"),
        RESCIND_CANCELLATION_CONFIG_LIFE("EMPLOYER.CERTIFICATES.RESCIND.CANCELLATION.LIFE"),
        RESCIND_CANCELLATION_CONFIG_LTD("EMPLOYER.CERTIFICATES.RESCIND.CANCELLATION.LTD"),
        RESCIND_CANCELLATION_CONFIG_STD("EMPLOYER.CERTIFICATES.RESCIND.CANCELLATION.STD"),
        RESCIND_CANCELLATION_CONFIG_VISION("EMPLOYER.CERTIFICATES.RESCIND.CANCELLATION.VISION");

        private String name;

        CertificateRescindCancellationReason(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum EmployerMasterPolicies implements Named {
        CONFIG_DENTAL("EMPLOYER.MASTER.POLICIES.DENTAL"),
        CONFIG_ACCIDENT("EMPLOYER.MASTER.POLICIES.ACCIDENT"),
        CONFIG_LIFE("EMPLOYER.MASTER.POLICIES.LIFE"),
        CONFIG_LTD("EMPLOYER.MASTER.POLICIES.LTD"),
        CONFIG_STD("EMPLOYER.MASTER.POLICIES.STD"),
        CONFIG_VISION("EMPLOYER.MASTER.POLICIES.VISION"),
        CONFIG_STATUTORY("EMPLOYER.MASTER.POLICIES.STATUTORY"),
        CONFIG_PFL("EMPLOYER.MASTER.POLICIES.PFL");

        private String name;

        EmployerMasterPolicies(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum MemberClaimFNOL implements Named {
        CONFIG_ACCIDENT("MEMBER.CLAIMS.ACCIDENT.FNOL"),
        CONFIG_DENTAL("MEMBER.CLAIMS.DENTAL.FNOL"),
        CONFIG_DISABILITY("MEMBER.CLAIMS.DISABILITY.FNOL");

        private String name;

        MemberClaimFNOL(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum EmployerClaimFNOL implements Named {
        CONFIG_ACCIDENT("EMPLOYER.CLAIMS.ACCIDENT.FNOL"),
        CONFIG_TERM_LIFE("EMPLOYER.CLAIMS.TERM.LIFE.FNOL"),
        CONFIG_DISABILITY("EMPLOYER.CLAIMS.DISABILITY.FNOL");

        private String name;

        EmployerClaimFNOL(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum MemberCertificates implements Named {
        CONFIG_LIFE("MEMBER.CERTIFICATES.LIFE"),
        CONFIG_ACCIDENT("MEMBER.CERTIFICATES.ACCIDENT"),
        CONFIG_VISION("MEMBER.CERTIFICATES.VISION"),
        CONFIG_STD("MEMBER.CERTIFICATES.STD"),
        CONFIG_LTD("MEMBER.CERTIFICATES.LTD"),
        CONFIG_DENTAL("MEMBER.CERTIFICATES.DENTAL");;

        private String name;

        MemberCertificates(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum EmployerCertificatesPremium implements Named {
        CONFIG_TERM_LIFE("EMPLOYER.CERTIFICATES.PREMIUM.SUMMARY.LIFE"),
        CONFIG_DENTAL("EMPLOYER.CERTIFICATES.PREMIUM.SUMMARY.DENTAL"),
        CONFIG_ACCIDENT("EMPLOYER.CERTIFICATES.PREMIUM.SUMMARY.ACCIDENT"),
        CONFIG_STD("EMPLOYER.CERTIFICATES.PREMIUM.SUMMARY.STD"),
        CONFIG_LTD("EMPLOYER.CERTIFICATES.PREMIUM.SUMMARY.LTD"),
        CONFIG_VISION("EMPLOYER.CERTIFICATES.PREMIUM.SUMMARY.VISION");

        private String name;

        EmployerCertificatesPremium(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum MemberCertificatesPremium implements Named {
        CONFIG_TERM_LIFE("MEMBER.CERTIFICATES.PREMIUM.SUMMARY.LIFE"),
        CONFIG_DENTAL("MEMBER.CERTIFICATES.PREMIUM.SUMMARY.DENTAL"),
        CONFIG_ACCIDENT("MEMBER.CERTIFICATES.PREMIUM.SUMMARY.ACCIDENT"),
        CONFIG_STD("MEMBER.CERTIFICATES.PREMIUM.SUMMARY.STD"),
        CONFIG_LTD("MEMBER.CERTIFICATES.PREMIUM.SUMMARY.LTD"),
        CONFIG_VISION("MEMBER.CERTIFICATES.PREMIUM.SUMMARY.VISION");

        private String name;

        MemberCertificatesPremium(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum EmployerCertificates implements Named {
        CONFIG_TERM_LIFE("EMPLOYER.CERTIFICATES.SUMMARY.LIFE"),
        CONFIG_DENTAL("EMPLOYER.CERTIFICATES.SUMMARY.DENTAL"),
        CONFIG_ACCIDENT("EMPLOYER.CERTIFICATES.SUMMARY.ACCIDENT"),
        CONFIG_STD("EMPLOYER.CERTIFICATES.SUMMARY.STD"),
        CONFIG_LTD("EMPLOYER.CERTIFICATES.SUMMARY.LTD"),
        CONFIG_VISION("EMPLOYER.CERTIFICATES.SUMMARY.VISION");

        private String name;

        EmployerCertificates(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum ClaimsNotes implements Named {
        MEMBER_CLAIMS_NOTES("MEMBER.CLAIMS.NOTES"),
        EMPLOYER_CLAIMS_NOTES("EMPLOYER.CLAIMS.NOTES");

        private String name;

        ClaimsNotes(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
