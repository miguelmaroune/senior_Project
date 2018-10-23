package army.calendar;

import java.awt.Color;

public abstract interface EventInstance
        extends Comparable {

    public abstract String getTitle();

    public abstract String getDescription();

    public abstract boolean isAllDay();

    public abstract boolean hasTime();

    public abstract int getYear();

    public abstract int getMonth();

    public abstract int getDayOfMonth();

    public abstract int getHour();

    public abstract int getMinute();

    public abstract int getSecond();

    public abstract boolean hasDuration();

    public abstract String getLocation();

    public abstract int getDurationSeconds();

    public abstract Color getForegroundColor();

    public abstract Color getBackgroundColor();

    public abstract Color getBorderColor();
}
