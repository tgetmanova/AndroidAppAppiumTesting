package com.github.spb.tget.data;

import com.github.spb.tget.utils.RandomUtils;

public class ListItemDisplaySettings {

    private boolean displayUnits;
    private boolean displayPrice;
    private boolean displayComment;

    public boolean getDisplayUnits() {
        return displayUnits;
    }

    public boolean getDisplayPrice() {
        return displayPrice;
    }

    public boolean getDisplayComment() {
        return displayComment;
    }

    public ListItemDisplaySettings withDisplayUnits(boolean displayUnits) {
        this.displayUnits = displayUnits;
        return this;
    }

    public ListItemDisplaySettings withDisplayPrice(boolean displayPrice) {
        this.displayPrice = displayPrice;
        return this;
    }

    public ListItemDisplaySettings withDisplayComment(boolean displayComment) {
        this.displayComment = displayComment;
        return this;
    }

    public static ListItemDisplaySettings randomListDisplaySettings() {
        return new ListItemDisplaySettings()
                .withDisplayUnits(RandomUtils.getRandomBoolean())
                .withDisplayPrice(RandomUtils.getRandomBoolean())
                .withDisplayComment(RandomUtils.getRandomBoolean());
    }
}
