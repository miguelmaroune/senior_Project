package army.calendar;

import java.util.Vector;

public abstract interface CalendarDataRepository {

    public abstract Vector getEventInstancesForDate(int paramInt1, int paramInt2, int paramInt3);
}
