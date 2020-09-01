package com.ochodek.objects.items.medicaments;

import com.ochodek.objects.items.Item;
import lombok.Getter;

@Getter
public abstract class FirstAidKit implements Item {

    private final double healingRate;
    protected final FirstAidKitType kitType;

    public FirstAidKit(double healingRate, FirstAidKitType kitType) {
        this.healingRate = healingRate;
        this.kitType = kitType;
    }
}
