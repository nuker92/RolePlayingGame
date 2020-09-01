package com.ochodek.objects.items.medicaments;

public class BigMedkit extends FirstAidKit {

    public BigMedkit() {
        super(5d, FirstAidKitType.BIG_MEDKIT);
    }

    public String getItemName() {
        return kitType.name();
    }
}
