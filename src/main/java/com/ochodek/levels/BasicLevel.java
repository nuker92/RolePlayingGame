package com.ochodek.levels;

import com.ochodek.objects.enemies.Enemy;
import com.ochodek.objects.items.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BasicLevel {

    @Getter
    @Setter
    protected Enemy enemy;
    @Getter
    @Setter
    protected List<Item> itemsInArea = new ArrayList<>();
    @Getter
    protected String arriveAreaDescription;
    @Getter
    protected String enemyDescription;
    @Getter
    protected String exitAreaDescription;
    @Getter
    @Setter
    protected int levelNumber;

    public List<Item> searchAreaForItems() {
        List<Item> itemsToReturn = this.itemsInArea;
        itemsInArea = Collections.emptyList();
        return itemsToReturn;
    }




}
