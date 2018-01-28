package com.github.spb.tget.data;

import com.github.spb.tget.utils.RandomUtils;

/**
 * This class represents solution for correct drag & drop functionality (particularly on the Edit Categories page)
 * In general case, drag & drop works the following way:
 * Element is being moved from [fromPosition] and dropped AFTER [afterPosition]. E.g., if element is moving from [3]
 * to [7], the following positions are left behind: [0, 1, 2, 3, 4, 5, 6, 7] but since while dragging current [3] item,
 * item [7] is shifting up to [6], pushing other preceding items to the top. [7] position is now assigned to item
 * previously placed at [8] position, and target item being dragged now dropped just right after it. So:
 * [7] -> [6]
 * [8] -> [7]
 * [3] -> [8]
 * - target position for dropped item is [8] that is equal to (afterPosition + 1)
 * But! In some specific cases (described in getExpectedPositionAfterReordering()) item being dropped IN PLACE OF
 * afterPosition
 */
public class CategoryReOrderInfo {

    private int fromPosition;
    private int afterPosition;
    private int reOrderingScopeSize;

    private static final int blocksDivisionBy = 3;

    public int getFromPosition() {
        return fromPosition;
    }

    public int getAfterPosition() {
        return afterPosition;
    }

    public CategoryReOrderInfo(int reOrderingScopeSize) {
        if (reOrderingScopeSize < blocksDivisionBy) {
            throw new AssertionError("Precondition failed: cannot setup test" +
                    " data as we don't have enough categories");
        }
        this.reOrderingScopeSize = reOrderingScopeSize;
        fromPosition = RandomUtils.getRandomInt(0, getReOrderingBlockSize());
        afterPosition = RandomUtils.getRandomInt(fromPosition + 1, getReOrderingBlockSize() * 2);
    }

    public int getExpectedPositionAfterReordering() {
        return (afterPosition - fromPosition) <= 2 && fromPosition < 2 ? afterPosition : afterPosition + 1;
    }

    private int getReOrderingBlockSize() {
        return (int) Math.floor(reOrderingScopeSize / blocksDivisionBy);
    }
}
