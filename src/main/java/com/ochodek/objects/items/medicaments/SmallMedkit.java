package com.ochodek.objects.items.medicaments;

public class SmallMedkit extends FirstAidKit {

    public SmallMedkit() {
        super(2d, FirstAidKitType.SMALL_MEDKIT);
    }

    public String getItemName() {
        return kitType.name();
    }
}
