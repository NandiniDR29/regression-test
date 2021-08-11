/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class EventInformationTheftActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> DATE_VEHICLE_WAS_LAST_SEEN_IN_POSSESSION =
            declare("Date Vehicle was Last Seen/In Possession", TextBox.class);
    public static final AssetDescriptor<TextBox> TIME_VEHICLE_WAS_LAST_SEEN_IN_POSSESSION = declare("Time Vehicle was Last Seen/In Possession", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_VEHICLE_WAS_DISCOVERED_MISSING = declare("Date Vehicle was Discovered Missing", TextBox.class);
    public static final AssetDescriptor<TextBox> TIME_VEHICLE_WAS_DISCOVERED_MISSING = declare("Time Vehicle was Discovered Missing", TextBox.class);
    public static final AssetDescriptor<ComboBox> WERE_ALL_THE_VEHICLE_DOORS_LOCKED = declare("Were all the vehicle doors locked?", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WERE_ALL_THE_WINDOWS_COMPLETELY_CLOSED = declare("Were all the windows completely closed?", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WERE_THE_KEYS_IN_THE_IGNITION = declare("Were the keys in the ignition?", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WERE_THE_KEYS_IN_OR_ABOUT_THE_VEHICLE =
            declare("Were the keys in or about the vehicle?", ComboBox.class);
    public static final AssetDescriptor<TextBox> WHERE_WERE_THE_KEYS = declare("Where were the keys?", TextBox.class);
    public static final AssetDescriptor<TextBox> HOW_MANY_SETS_OF_KEYS_ARE_THERE_FOR_THE_VEHICLE =
            declare("How many sets of keys are there for the vehicle?", TextBox.class);
    public static final AssetDescriptor<TextBox> HOW_MANY_SETS_OF_KEYS_ARE_ACCOUNTED_FOR =
            declare("How many sets of keys are accounted for?", TextBox.class);
    public static final AssetDescriptor<TextBox> WHERE_ARE_THE_KEYS = declare("Where are the keys?", TextBox.class);
    public static final AssetDescriptor<ComboBox> HAS_THE_VEHICLE_BEEN_RECOVERED = declare("Has the vehicle been recovered?", ComboBox.class);
    public static final AssetDescriptor<ComboBox> DOES_A_DIFFERENT_INSURER_COVER_ANY_CONTENTS_THAT_WAS_STOLEN_FROM_THE_VEHICLE =
            declare("Does a different insurer cover any contents that was stolen from the vehicle?", ComboBox.class);
}
