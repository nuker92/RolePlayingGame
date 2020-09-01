package com.ochodek.objects;

import com.ochodek.exceptions.ItemNotFoundByNameException;
import com.ochodek.objects.items.Item;
import com.ochodek.objects.items.medicaments.BigMedkit;
import com.ochodek.objects.items.medicaments.SmallMedkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Backpack {

    private final List<Item> backpackItems;

    public Backpack() {
        backpackItems = new ArrayList<>();
    }

    public void putIntoBackpack(Item item) {
        backpackItems.add(item);
    }

    public void putIntoBackpack(List<Item> items) {
        backpackItems.addAll(items);
    }

    public Item grabItemFromBackpack(String name) {
        for (Item item : backpackItems) {
            if (item.getItemName().equals(name)) {
                backpackItems.remove(item);
                return item;
            }
        }
        throw new ItemNotFoundByNameException("There is no item with name " + name);
    }

    public List<String> showAllItemsInBackpack() {
        return backpackItems.stream()
                .map(Item::getItemName)
                .collect(Collectors.toList());
    }

    public Map<String, Long> showAllMedkitsInBackpack() {
        return backpackItems.stream()
                .filter(this::isItemMedkit)
                .map(Item::getItemName)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    public Map<String, Long> showAllNotMedkitItemsInBackpack() {
        return backpackItems.stream()
                .filter(Predicate.not(this::isItemMedkit))
                .map(Item::getItemName)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    private boolean isItemMedkit(Item item) {
        return (item instanceof BigMedkit || item instanceof SmallMedkit);
    }

    public Backpack createCopyOfBackpack() {
        Backpack newBackpack = new Backpack();
        newBackpack.putIntoBackpack(backpackItems);
        return newBackpack;
    }
}
