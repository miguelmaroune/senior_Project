package army.calendar;

public abstract interface CalendarPanelSelectionListener {

    public abstract void eventSelected(EventInstance paramEventInstance);

    public abstract void eventUnselected();

    public abstract void eventDoubleClicked(EventInstance paramEventInstance);

    public abstract void dateDoubleClicked(int paramInt1, int paramInt2, int paramInt3);
}
