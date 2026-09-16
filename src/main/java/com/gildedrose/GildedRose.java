package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality < 50) { // 이 부분 브랜치 커버리지가 여전히 가능한지?
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            } else if (item.name.equals(SULFURAS)) {
            } else if (item.quality > 0) {
                item.quality = item.quality - 1;
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.name.equals(AGED_BRIE)) {
                if (item.sellIn < 0) { // 이 부분이 커버 안 됨
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.sellIn < 0) {
                    item.quality = item.quality - item.quality;
                }
            } else if (item.sellIn < 0) {
                if (item.quality > 0) {
                    if (item.name.equals(SULFURAS)) {
                    } else {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }
}
