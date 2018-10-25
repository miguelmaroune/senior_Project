package army.calendar;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalendarPanel
        extends JPanel
        implements MouseWheelListener {

    private static final long serialVersionUID = 1000L;
    CalendarDataRepository repository;
    JLabel title;
    JPanel drawArea;
    JScrollBar scrollBar;
    Calendar startDate;
    int firstDayOfWeek;
    Color backgroundColor1;
    Color backgroundColor2;
    Color todayBackgroundColor;
    Color gridColor;
    Color selectionColor;
    Color headerForeground;
    Color headerBackground;
    Color hintBackground;
    Color hintForeground;
    Font headerFont = null;
    Font eventFont = null;
    Font hintFont = null;
    int lastWidth = -1;
    int lastHeight = -1;
    double cellWidth = 100.0D;
    double cellHeight = 100.0D;
    int headerHeight = 10;
    int[] columnX;
    int[] rowY;
    static final int NUM_WEEKS_TO_DISPLAY = 5;
    static final String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static final String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    boolean changingScrollbar = false;
    int CELL_MARGIN = 2;
    Vector displayedEvents;
    Vector displayedDates;
    private Timer timer = null;
    private boolean drawDateHint = false;
    private int fadeStep = 0;
    private boolean showTime = true;
    private boolean allowsEventSelection = true;
    private Date selectedDate = null;
    private int selectedItemInd = -1;
    private Vector selectionListeners;
    DisplayedEvent currentMouseOverEvent = null;

    private static int getFirstDayOfWeek() {
        switch (Calendar.getInstance().getFirstDayOfWeek()) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
        }
        return -1;
    }
    Vector<Vector<String>> sch = new Vector<Vector<String>>();

    public CalendarPanel(CalendarDataRepository paramCalendarDataRepository) {
        this.repository = paramCalendarDataRepository;
        this.firstDayOfWeek = getFirstDayOfWeek();
        this.selectionListeners = new Vector();
        this.backgroundColor1 = new Color(232, 232, 232);
        this.backgroundColor2 = new Color(212, 212, 212);
        this.todayBackgroundColor = new Color(255, 255, 212);
        this.headerForeground = Color.BLUE;
        this.headerBackground = Color.WHITE;
        this.gridColor = Color.BLACK;
        this.selectionColor = Color.RED;
        this.hintBackground = Color.DARK_GRAY;
        this.hintForeground = Color.white;
        this.displayedEvents = new Vector();
        this.displayedDates = new Vector();
//        
        UserHandler Uhandler = new UserHandler();
        User user = Uhandler.getCurrUser();
        Connection con = null;
        String username = user.getUsername();
//        for testing 
//        String username = "123456";
        try {
            if (con == null) {
                con = DbManager.getConnection();
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            sch = Uhandler.getSchedule(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }

//        
        createUI();
        setWeekOffset(0);
    }

    protected void createUI() {
        setLayout(new BorderLayout());
        JPanel localJPanel = new JPanel();
        localJPanel.setLayout(new BorderLayout());
        JButton localJButton = new JButton("Today");
        localJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                CalendarPanel.this.setWeekOffset(0);
                CalendarPanel.this.scrollBar.setMinimum(-52);
                CalendarPanel.this.scrollBar.setMaximum(52);
                CalendarPanel.this.scrollBar.setValue(0);
            }
        });
        localJPanel.add(localJButton, "East");
        this.title = new JLabel("Calendar", 0);
        Font localFont = this.title.getFont();
        this.title.setFont(new Font(localFont.getFamily(), 1, localFont.getSize() + 4));
        localJPanel.add(this.title, "Center");
        add(localJPanel, "North");
        this.scrollBar = new JScrollBar(1, 0, 5, -52, 52);
        this.scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent paramAnonymousAdjustmentEvent) {
                if (CalendarPanel.this.changingScrollbar) {
                    return;
                }
                int i = paramAnonymousAdjustmentEvent.getValue();
                CalendarPanel.this.changingScrollbar = true;
                if (i <= CalendarPanel.this.scrollBar.getMinimum()) {
                    CalendarPanel.this.scrollBar.setMinimum(CalendarPanel.this.scrollBar.getMinimum() - 1);
                    CalendarPanel.this.scrollBar.setMaximum(CalendarPanel.this.scrollBar.getMaximum() - 1);
                }
                if (i >= CalendarPanel.this.scrollBar.getMaximum() - 5) {
                    CalendarPanel.this.scrollBar.setMinimum(CalendarPanel.this.scrollBar.getMinimum() + 1);
                    CalendarPanel.this.scrollBar.setMaximum(CalendarPanel.this.scrollBar.getMaximum() + 1);
                }
                CalendarPanel.this.drawDateHint = true;
                CalendarPanel.this.fadeStep = 0;
                ActionListener local1 = new ActionListener() {
                    public void actionPerformed(ActionEvent paramAnonymous2ActionEvent) {
//                        CalendarPanel.access$408(CalendarPanel.this);
                        if (CalendarPanel.this.fadeStep > 9) {
                            CalendarPanel.this.drawDateHint = false;
                        } else {
                            CalendarPanel.this.drawDateHint = true;
                            CalendarPanel.this.timer.setInitialDelay(50);
                            CalendarPanel.this.timer.restart();
                        }
                        CalendarPanel.this.drawArea.repaint();
                    }
                };
                if (CalendarPanel.this.timer != null) {
                    CalendarPanel.this.timer.stop();
                    CalendarPanel.this.timer = null;
                }
                CalendarPanel.this.timer = new Timer(3000, local1);
                CalendarPanel.this.timer.start();
                CalendarPanel.this.changingScrollbar = false;
                CalendarPanel.this.setWeekOffset(i);
            }
        });
        add(this.scrollBar, "East");
        this.drawArea = new MonthPanel();
        add(this.drawArea, "Center");
        addMouseWheelListener(this);
    }

    public void setFont(Font paramFont) {
        if (paramFont != null) {
            super.setFont(paramFont);
            if (this.drawArea != null) {
                this.title.setFont(paramFont);
                this.drawArea.setFont(paramFont);
                this.headerFont = paramFont;
                this.eventFont = new Font(paramFont.getFamily(), paramFont.getStyle(), paramFont.getSize() - 2);
                this.hintFont = new Font(paramFont.getFamily(), paramFont.getStyle(), paramFont.getSize() + 8);
            }
            this.lastWidth = (this.lastHeight = -1);
            repaint();
        }
    }

    public void setWeekOffset(int paramInt) {
        int[] arrayOfInt = {1, 2, 3, 4, 5, 6, 7};
        Calendar localCalendar = Calendar.getInstance();

        localCalendar.setLenient(true);
        this.firstDayOfWeek = getFirstDayOfWeek();
        int i = localCalendar.get(3);
        localCalendar.set(7, arrayOfInt[this.firstDayOfWeek]);
        localCalendar.set(3, i + paramInt);
        this.startDate = Calendar.getInstance();

        this.startDate.setTimeInMillis(localCalendar.getTimeInMillis());
        this.startDate.set(Calendar.DAY_OF_MONTH, 1);
//        String str = monthNames[localCalendar.get(2)] + " " + localCalendar.get(5) + " " + localCalendar.get(1) + " - ";
//        localCalendar.add(6, 34);
//        str = str + monthNames[localCalendar.get(2)] + " " + localCalendar.get(5) + " " + localCalendar.get(1);
        String str = monthNames[localCalendar.get(2)] + " - ";
        localCalendar.add(6, 34);
        str = str + monthNames[localCalendar.get(2)];
        this.title.setText(str);
        repaint();
    }

    public void setBackgroundColors(Color paramColor1, Color paramColor2) {
        this.backgroundColor1 = paramColor1;
        this.backgroundColor2 = paramColor2;
    }

    public void setTodayBackgroundColor(Color paramColor) {
        this.todayBackgroundColor = paramColor;
    }

    public void setHeaderColors(Color paramColor1, Color paramColor2) {
        this.headerForeground = paramColor1;
        this.headerBackground = paramColor2;
    }

    private void handleResize(Graphics paramGraphics) {
        this.lastWidth = this.drawArea.getWidth();
        this.lastHeight = this.drawArea.getHeight();
        this.headerHeight = paramGraphics.getFontMetrics(this.headerFont).getHeight();
        this.cellWidth = (this.lastWidth / 7.0D);
        this.cellHeight = ((this.lastHeight - this.headerHeight) / 5.0D);
        this.columnX = new int[7];
        this.rowY = new int[5];
        double d;
        int i;
        for (i = 0; i < 7; i++) {
            d = this.cellWidth * i;
            this.columnX[i] = ((int) Math.floor(d));
        }
        for (i = 0; i < 5; i++) {
            d = this.cellHeight * i;
            this.rowY[i] = (this.headerHeight + (int) Math.floor(d));
        }
    }

    public static String formattedTime(int paramInt1, int paramInt2) {
        StringBuffer localStringBuffer = new StringBuffer();
        String str = null;
        if (paramInt1 < 12) {
            str = "am";
        } else {
            paramInt1 %= 12;
            str = "pm";
        }
        if (paramInt1 == 0) {
            paramInt1 = 12;
        }
        localStringBuffer.append(paramInt1);
        localStringBuffer.append(':');
        if (paramInt2 < 10) {
            localStringBuffer.append('0');
        }
        localStringBuffer.append(paramInt2);
        localStringBuffer.append(str);
        return localStringBuffer.toString();
    }

    public void paintMonth(Graphics paramGraphics) {

        Color localColor = paramGraphics.getColor();
        this.displayedEvents.clear();
        this.displayedDates.clear();
        Graphics2D localGraphics2D1 = (Graphics2D) paramGraphics;
        localGraphics2D1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (this.headerFont == null) {
            this.headerFont = paramGraphics.getFont();
        }
        if (this.eventFont == null) {
            this.eventFont = new Font(this.headerFont.getFamily(), this.headerFont.getStyle(), this.headerFont.getSize() - 2);
            paramGraphics.setFont(this.eventFont);
        }
        if (this.hintFont == null) {
            this.hintFont = new Font(this.headerFont.getFamily(), this.headerFont.getStyle(), this.headerFont.getSize() + 8);
        }
        if ((this.lastWidth != this.drawArea.getWidth()) || (this.lastHeight != this.drawArea.getHeight())) {
            handleResize(paramGraphics);
        }
        paramGraphics.setFont(this.headerFont);
        for (int i = 0; i < 7; i++) {
            paramGraphics.setColor(this.headerBackground);
            paramGraphics.fillRect(this.columnX[i], 0, i < 6 ? this.columnX[(i + 1)] - this.columnX[i] : (int) this.cellWidth, this.headerHeight);
            String str1 = weekdays[((this.firstDayOfWeek + i) % 7)];
            int k;
            k = (int) Math.floor((this.cellWidth - paramGraphics.getFontMetrics(this.headerFont).stringWidth(str1)) / 2.0D);
            paramGraphics.setColor(this.headerForeground);
            paramGraphics.drawString(str1, this.columnX[i] + k, paramGraphics.getFontMetrics(this.headerFont).getAscent());
        }
        paramGraphics.setColor(this.gridColor);
        int i;
        boolean flag1 = false;
        i = this.columnX[6] + (int) this.cellWidth;
        int j = this.rowY[4] + (int) this.cellHeight;
        paramGraphics.drawRect(0, 0, i, j);
        for (int k = 1; k < 7; k++) {
            paramGraphics.drawLine(this.columnX[k], 0, this.columnX[k], j);
        }
        int k;
        for (k = 0; k < 5; k++) {
            paramGraphics.drawLine(0, this.rowY[k], i, this.rowY[k]);
        }
        paramGraphics.setColor(localColor);
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setLenient(true);
        localCalendar.setTimeInMillis(this.startDate.getTimeInMillis());
        this.startDate.set(Calendar.DAY_OF_MONTH, 1);
//        1
        paramGraphics.setFont(this.eventFont);
        int i1;
        int length = this.sch.size() - 1;
        for (int m = 0; m < 5; m++) {
            for (int n = 0; n < 7; n++) {
                i1 = n < 6 ? this.columnX[(n + 1)] - this.columnX[n] : (int) this.cellWidth;
                int i2 = m < 4 ? this.rowY[(m + 1)] - this.rowY[m] : (int) this.cellHeight;
                boolean bool = (localCalendar.get(5) == 1) || ((m == 0) && (n == 0));
                Date localDate = new Date(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5));
//                System.out.println(localCalendar.get(1)+"\t" +localCalendar.get(2)+"\t" + localCalendar.get(5));
                this.displayedDates.addElement(new DisplayedDate(localDate, new Rectangle(this.columnX[n], this.rowY[m], i1, i2)));

//hone badde zid method ... while l arraylist fi donne yo2ra menno w y3abeh green w gris else ya3mel l method  drawdayofmonth
                if (length >= 0) {
                    flag1 = checkDate(localCalendar, sch, length);
                } else {
                    flag1 = false;
                }
                if (length >= 0 && flag1 == true) {
                    drawDayOfMonthSCH(paramGraphics, localCalendar, bool, this.columnX[n], this.rowY[m], i1, i2, sch, length);
                    length--;
                } else {
                    drawDayOfMonth(paramGraphics, localCalendar, bool, this.columnX[n], this.rowY[m], i1, i2);
                }
                localCalendar.set(6, localCalendar.get(6) + 1);

            }
        }
        if (this.drawDateHint) {
            Font localFont = paramGraphics.getFont();
            StringBuffer localStringBuffer = new StringBuffer();
            if (this.startDate.get(5) == 1) {
                localStringBuffer.append(monthNames[this.startDate.get(2)]);
                localStringBuffer.append(' ');
                localStringBuffer.append(this.startDate.get(1));
            } else {
                i1 = this.startDate.get(2) + 1;
                localStringBuffer.append(monthNames[(i1 % 12)]);
                localStringBuffer.append(' ');
                if (i1 == 12) {
                    localStringBuffer.append(this.startDate.get(1) + 1);
                } else {
                    localStringBuffer.append(this.startDate.get(1));
                }
            }
            String str2 = localStringBuffer.toString();
            paramGraphics.setFont(this.hintFont);
            FontMetrics localFontMetrics = paramGraphics.getFontMetrics();
            int i3 = localFontMetrics.stringWidth(str2) + 10;
            int i4 = localFontMetrics.getHeight() + 10;
            int i5 = (getWidth() - i3) / 2;
            int i6 = (getHeight() - i4) / 2;
            if (this.fadeStep < 10) {
                Graphics2D localGraphics2D2 = (Graphics2D) paramGraphics;
                Composite localComposite = localGraphics2D2.getComposite();
                float f = 0.5F - this.fadeStep * 0.05F;
                AlphaComposite localAlphaComposite = AlphaComposite.getInstance(3, f);
                localGraphics2D2.setComposite(localAlphaComposite);
                paramGraphics.setColor(this.hintBackground);
                paramGraphics.fillRoundRect(i5, i6, i3, i4, 10, 10);
                paramGraphics.setColor(this.hintForeground);
                paramGraphics.drawString(str2, i5 + 5, i6 + 5 + localFontMetrics.getAscent());
                localGraphics2D2.setComposite(localComposite);
            }
            paramGraphics.setFont(localFont);
        }
        drawEventPopup(paramGraphics);
    }

    public void drawEventPopup(Graphics paramGraphics) {
        if (this.currentMouseOverEvent != null) {
            EventInstance localEventInstance = this.currentMouseOverEvent.event;
            Vector localVector = new Vector();
            String str1 = null;
            int i = this.currentMouseOverEvent.rect.y > getHeight() / 2 ? 1 : 0;
            if (localEventInstance.hasTime()) {
                str1 = formattedTime(localEventInstance.getHour(), localEventInstance.getMinute()) + " " + localEventInstance.getTitle();
            } else {
                str1 = localEventInstance.getTitle();
            }
            if (localEventInstance.getLocation() != null) {
                localVector.addElement("Location: " + localEventInstance.getLocation());
            }
            if (localEventInstance.getDescription() != null) {
                localVector.addAll(Utils.wrapLines(localEventInstance.getDescription(), 50));
            }
            FontMetrics localFontMetrics = paramGraphics.getFontMetrics();
            int j = 0;
            int k = 0;
            int m = 0;
            int n = 0;
            j = localFontMetrics.stringWidth(str1);
            for (int i1 = 0; i1 < localVector.size(); i1++) {
                String str2 = (String) localVector.elementAt(i1);
                if (localFontMetrics.stringWidth(str2) > j) {
                    j = localFontMetrics.stringWidth(str2);
                }
            }
            j += 4;
            k = localFontMetrics.getHeight() * (1 + localVector.size()) + 4;
            m = this.currentMouseOverEvent.rect.x + this.currentMouseOverEvent.rect.width / 2 - j / 2;
            int i1;
            i1 = 0;
            if (i != 0) {
                n = this.currentMouseOverEvent.rect.y - k - 15;
                while ((n < 1) && (localVector.size() >= 2)) {
                    localVector.setSize(localVector.size() - 2);
                    localVector.addElement("...");
                    k = localFontMetrics.getHeight() * (1 + localVector.size()) + 4;
                    n = this.currentMouseOverEvent.rect.y - k - 15;
                    i1 = 1;
                }
            }
            n = this.currentMouseOverEvent.rect.y + this.currentMouseOverEvent.rect.height + 15;
            while ((n + k + 8 > getHeight() - 25) && (localVector.size() >= 2)) {
                localVector.setSize(localVector.size() - 2);
                localVector.addElement("...");
                k = localFontMetrics.getHeight() * (1 + localVector.size()) + 4;
                i1 = 1;
            }
            if (i1 != 0) {
                j = localFontMetrics.stringWidth(str1);
                for (int i2 = 0; i2 < localVector.size(); i2++) {
                    String localObject;
                    localObject = (String) localVector.elementAt(i2);

                    if (localFontMetrics.stringWidth((String) localObject) > j) {
                        j = localFontMetrics.stringWidth((String) localObject);
                    }
                }
                j += 4;
            }
            if (m < 5) {
                m = 5;
            } else if (m + j >= this.drawArea.getWidth() - 5) {
                m = this.drawArea.getWidth() - (j + 5);
            }
            Graphics2D localGraphics2D = (Graphics2D) paramGraphics;
            Object localObject = localGraphics2D.getComposite();
            Color localColor1 = Color.BLACK;
            for (int i3 = 0; i3 < 8; i3++) {
                float f = 0.04F;
                AlphaComposite localAlphaComposite = AlphaComposite.getInstance(3, f);
                localGraphics2D.setComposite(localAlphaComposite);
                paramGraphics.setColor(localColor1);
                paramGraphics.fillRoundRect(m + 1 + i3, n + 1 + (8 - i3), j - 2 - 2 * i3, k - 2, 12, 12);
                int i5 = 8 - i3;
                f = 0.01F;
                localAlphaComposite = AlphaComposite.getInstance(3, f);
                localGraphics2D.setComposite(localAlphaComposite);
                paramGraphics.fillRoundRect(m - i5, n - i5, j + 2 * i5, k + 2 * i5, 30, 30);
            }
            localGraphics2D.setComposite((Composite) localObject);
            Color localColor2 = localEventInstance.getBackgroundColor();
            if (255 - localColor2.getRed() + (255 - localColor2.getBlue()) + (255 - localColor2.getGreen()) < 400) {
                localColor2 = new Color(localColor2.getRed() * 2 / 3, localColor2.getGreen() * 2 / 3, localColor2.getBlue() * 2 / 3);
            }
            paramGraphics.setColor(localColor2);
            paramGraphics.fillRoundRect(m, n, j, k, 8, 8);
            paramGraphics.setColor(Color.WHITE);
            paramGraphics.drawString(str1, m + 2, n + localFontMetrics.getHeight());
            Rectangle localRectangle = new Rectangle(m, n + localFontMetrics.getHeight() + localFontMetrics.getDescent(), j, k - localFontMetrics.getHeight());
            paramGraphics.setClip(localRectangle);
            paramGraphics.setColor(Color.WHITE);
            paramGraphics.fillRoundRect(m + 1, n + 1, j - 2, k - 2, 8, 8);
            paramGraphics.setClip(null);
            paramGraphics.setColor(localColor2);
            for (int i4 = 0; i4 < localVector.size(); i4++) {
                String str3 = (String) localVector.elementAt(i4);
                paramGraphics.drawString(str3, m + 2, n + (i4 + 2) * localFontMetrics.getHeight());
            }
        }
    }

    protected void drawDayOfMonth(Graphics paramGraphics, Calendar paramCalendar, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        FontMetrics localFontMetrics = paramGraphics.getFontMetrics();
        Color localColor1 = paramGraphics.getColor();
        Calendar localCalendar = Calendar.getInstance();

        Color localColor2 = null;
//        hone if work akhdar else gris  w eza mafi records bl db byetreka bayda 123
        if ((localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(5) == paramCalendar.get(5))) {
//            hone working days
            localColor2 = this.todayBackgroundColor;
//            localColor2 =  Color.green;
        } else {
//            hone l forsa
            localColor2 = paramCalendar.get(2) % 2 == 0 ? this.backgroundColor1 : this.backgroundColor2;
//            localColor2 = Color.DARK_GRAY;
        }
        drawDayOfMonthBackground(paramGraphics, paramInt1 + 1, paramInt2 + 1, paramInt3 - 1, paramInt4 - 1, localColor2);
        paramGraphics.setColor(localColor1);
        String str;
        if (paramBoolean) {
            str = monthNames[paramCalendar.get(2)] + " " + paramCalendar.get(5);
        } else {
            str = "" + paramCalendar.get(5);
        }
        int i = paramGraphics.getFontMetrics().stringWidth(str);
        paramGraphics.drawString(str, paramInt1 + paramInt3 - i - 1, paramInt2 + localFontMetrics.getAscent());
        if (this.repository != null) {
            Vector localVector = this.repository.getEventInstancesForDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
            if (localVector != null) {
                Collections.sort(localVector);
                int j = (this.selectedDate != null) && (this.selectedDate.year == paramCalendar.get(1)) && (this.selectedDate.month == paramCalendar.get(2) + 1) && (this.selectedDate.day == paramCalendar.get(5)) ? 1 : 0;
                int k = paramInt2 + localFontMetrics.getHeight();
                int m = (paramInt4 - localFontMetrics.getHeight()) / (localFontMetrics.getHeight() + (1 + this.CELL_MARGIN));
                int n;
                for (n = 1; n * m < localVector.size(); n++) {
                }
                int i1 = paramInt3 / n;
                for (int i2 = 0; i2 < localVector.size(); i2++) {
                    int i3 = n == 1 ? 0 : i2 % n;
                    int i4 = n == 1 ? i2 : i2 / n;
                    EventInstance localEventInstance = (EventInstance) localVector.elementAt(i2);
                    Rectangle localRectangle = new Rectangle(paramInt1 + this.CELL_MARGIN + i3 * i1, k + (localFontMetrics.getHeight() + this.CELL_MARGIN) * i4, i1 - 2 * this.CELL_MARGIN, localFontMetrics.getHeight());
                    drawMonthViewEvent(paramGraphics, localRectangle, localEventInstance, (j != 0) && (i2 == this.selectedItemInd));
                    DisplayedEvent localDisplayedEvent = new DisplayedEvent(localEventInstance, localRectangle, i2);
                    this.displayedEvents.addElement(localDisplayedEvent);
                }
            }
        }
        paramGraphics.setColor(localColor1);
    }

    protected void drawDayOfMonthSCH(Graphics paramGraphics, Calendar paramCalendar, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Vector<Vector<String>> sch, int length) {
        FontMetrics localFontMetrics = paramGraphics.getFontMetrics();
        Color localColor1 = paramGraphics.getColor();
        Calendar localCalendar = Calendar.getInstance();

        Color localColor2 = null;
//        hone if work akhdar else gris  w eza mafi records bl db byetreka bayda 123
//localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(5) == paramCalendar.get(5))
//int digits = Integer.toString(theIntValue).trim().length();
        int len = Integer.toString(paramCalendar.get(2)).length();
        String strr = String.valueOf(paramCalendar.get(2));
        if (len == 1) {
            strr = String.format("%02d", paramCalendar.get(2));
        }

        int len2 = Integer.toString(paramCalendar.get(5)).length();
        String strr2 = String.valueOf(paramCalendar.get(5));
        if (len2 == 1) {
            strr2 = String.format("%02d", paramCalendar.get(5));
        }

        String paramCal = String.valueOf(paramCalendar.get(1)) + strr + strr2;
//        System.out.println(paramCal);

//sch.get(length) == 1
        String FULL_DATE = sch.get(length).get(1);

        FULL_DATE = FULL_DATE.replace("-", "");

//        System.out.println(FULL_DATE+"\t"+sch.get(length).get(0));
//if(FULL_DATE.equals(paramCal)){System.out.println("asdasdadadadsadad");}
        if (FULL_DATE.equals(paramCal) && sch.get(length).get(0).equals("1")) {
//            hone working days
//            localColor2 = this.todayBackgroundColor;
            localColor2 = Color.GREEN;
        } else {
//            hone l forsa
//            localColor2 = paramCalendar.get(2) % 2 == 0 ? this.backgroundColor1 : this.backgroundColor2;
            if (FULL_DATE.equals(paramCal) && sch.get(length).get(0).equals("0")) {
                localColor2 = Color.DARK_GRAY;
            }
        }
        drawDayOfMonthBackground(paramGraphics, paramInt1 + 1, paramInt2 + 1, paramInt3 - 1, paramInt4 - 1, localColor2);
        paramGraphics.setColor(localColor1);
        String str;
        if (paramBoolean) {
            str = monthNames[paramCalendar.get(2)] + " " + paramCalendar.get(5);
        } else {
            str = "" + paramCalendar.get(5);
        }
        int i = paramGraphics.getFontMetrics().stringWidth(str);
        paramGraphics.drawString(str, paramInt1 + paramInt3 - i - 1, paramInt2 + localFontMetrics.getAscent());
        if (this.repository != null) {
           
            Vector localVector = this.repository.getEventInstancesForDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
            
            if (localVector != null) {
                Collections.sort(localVector);
                int j = (this.selectedDate != null) && (this.selectedDate.year == paramCalendar.get(1)) && (this.selectedDate.month == paramCalendar.get(2) + 1) && (this.selectedDate.day == paramCalendar.get(5)) ? 1 : 0;
                int k = paramInt2 + localFontMetrics.getHeight();
                int m = (paramInt4 - localFontMetrics.getHeight()) / (localFontMetrics.getHeight() + (1 + this.CELL_MARGIN));
                int n;
                for (n = 1; n * m < localVector.size(); n++) {
                }
                int i1 = paramInt3 / n;
                for (int i2 = 0; i2 < localVector.size(); i2++) {
                    int i3 = n == 1 ? 0 : i2 % n;
                    int i4 = n == 1 ? i2 : i2 / n;
                    EventInstance localEventInstance = (EventInstance) localVector.elementAt(i2);
                    Rectangle localRectangle = new Rectangle(paramInt1 + this.CELL_MARGIN + i3 * i1, k + (localFontMetrics.getHeight() + this.CELL_MARGIN) * i4, i1 - 2 * this.CELL_MARGIN, localFontMetrics.getHeight());
                    drawMonthViewEvent(paramGraphics, localRectangle, localEventInstance, (j != 0) && (i2 == this.selectedItemInd));
                    DisplayedEvent localDisplayedEvent = new DisplayedEvent(localEventInstance, localRectangle, i2);
                    this.displayedEvents.addElement(localDisplayedEvent);
                }
            }
        }
        paramGraphics.setColor(localColor1);
    }

    protected String formatTime(int paramInt1, int paramInt2, int paramInt3) {
        StringBuffer localStringBuffer = new StringBuffer();
        if ((paramInt1 == 0) || (paramInt1 == 12)) {
            localStringBuffer.append("12");
        } else if (paramInt1 > 12) {
            localStringBuffer.append(paramInt1 % 12);
        } else {
            localStringBuffer.append(paramInt1);
        }
        localStringBuffer.append(':');
        if (paramInt2 < 10) {
            localStringBuffer.append('0');
        }
        localStringBuffer.append(paramInt2);
        if (paramInt1 < 12) {
            localStringBuffer.append("am");
        } else {
            localStringBuffer.append("pm");
        }
        return localStringBuffer.toString();
    }

    public void drawDayOfMonthBackground(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Color paramColor) {
        paramGraphics.setColor(paramColor);
        paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    protected void drawMonthViewEvent(Graphics paramGraphics, Rectangle paramRectangle, EventInstance paramEventInstance, boolean paramBoolean) {
        Color localColor = paramGraphics.getColor();
        paramGraphics.setColor(paramEventInstance.getBackgroundColor());
        int i = paramRectangle.height;
        if (paramBoolean) {
            paramGraphics.setColor(this.selectionColor);
            paramGraphics.drawRoundRect(paramRectangle.x - 1, paramRectangle.y - 1, paramRectangle.width + 2, paramRectangle.height + 2, i + 2, i + 2);
        }
        paramGraphics.setColor(paramEventInstance.getBackgroundColor());
        paramGraphics.fillRoundRect(paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height, i, i);
        paramGraphics.setColor(paramEventInstance.getBorderColor());
        paramGraphics.drawRoundRect(paramRectangle.x, paramRectangle.y, paramRectangle.width, paramRectangle.height, i, i);
        paramGraphics.setClip(paramRectangle.x + 1, paramRectangle.y + 1, paramRectangle.width - 2, paramRectangle.height - 3);
        paramGraphics.setColor(paramEventInstance.getForegroundColor());
        String str;
        if ((paramEventInstance.hasTime()) && (this.showTime)) {
            str = formatTime(paramEventInstance.getHour(), paramEventInstance.getMinute(), paramEventInstance.getSecond()) + " " + paramEventInstance.getTitle();
        } else {
            str = paramEventInstance.getTitle();
        }
        paramGraphics.drawString(str, paramRectangle.x + 3, paramRectangle.y + paramGraphics.getFontMetrics().getAscent());
        paramGraphics.setColor(localColor);
        paramGraphics.setClip(null);
    }

    public boolean getShowTime() {
        return this.showTime;
    }

    public void setShowTime(boolean paramBoolean) {
        this.showTime = paramBoolean;
    }

    public boolean getAllowsEventSelection() {
        return this.allowsEventSelection;
    }

    public void setAllowsEventSelection(boolean paramBoolean) {
        this.allowsEventSelection = paramBoolean;
    }

    public void addSelectionListener(CalendarPanelSelectionListener paramCalendarPanelSelectionListener) {
        this.selectionListeners.add(paramCalendarPanelSelectionListener);
    }

    public EventInstance getSelectedEvent() {
        if (this.selectedDate == null) {
            return null;
        }
        Vector localVector = this.repository.getEventInstancesForDate(this.selectedDate.year, this.selectedDate.month, this.selectedDate.day);
        if (localVector != null) {
            Collections.sort(localVector);
        }
        if ((this.selectedItemInd >= 0) && (this.selectedItemInd < localVector.size())) {
            EventInstance localEventInstance = (EventInstance) localVector.elementAt(this.selectedItemInd);
            return localEventInstance;
        }
        return null;
    }

    public void clearSelection() {
        int i = (this.selectedDate != null) && (this.selectedItemInd >= 0) ? 1 : 0;
        this.selectedDate = null;
        this.selectedItemInd = -1;
        if (i != 0) {
            repaint();
        }
    }

    public void mouseWheelMoved(MouseWheelEvent paramMouseWheelEvent) {
        int i = paramMouseWheelEvent.getWheelRotation();
        this.scrollBar.setValue(this.scrollBar.getValue() + i);
    }

    class MonthPanel
            extends JPanel
            implements MouseListener, MouseMotionListener {

        private static final long serialVersionUID = 1000L;
        CalendarPanel.DisplayedEvent lastMouseEvent = null;

        public MonthPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        protected CalendarPanel.DisplayedEvent getEventForPosition(int paramInt1, int paramInt2) {
            for (int i = 0; (CalendarPanel.this.displayedEvents != null) && (i < CalendarPanel.this.displayedEvents.size()); i++) {
                CalendarPanel.DisplayedEvent localDisplayedEvent = (CalendarPanel.DisplayedEvent) CalendarPanel.this.displayedEvents.elementAt(i);
                if ((paramInt1 >= localDisplayedEvent.rect.x) && (paramInt1 <= localDisplayedEvent.rect.x + localDisplayedEvent.rect.width) && (paramInt2 >= localDisplayedEvent.rect.y) && (paramInt2 <= localDisplayedEvent.rect.y + localDisplayedEvent.rect.height)) {
                    return localDisplayedEvent;
                }
            }
            return null;
        }

        public CalendarPanel.DisplayedEvent getMouseOverEvent(MouseEvent paramMouseEvent) {
            return getEventForPosition(paramMouseEvent.getX(), paramMouseEvent.getY());
        }

        public void paint(Graphics paramGraphics) {
            super.paint(paramGraphics);

            CalendarPanel.this.paintMonth(paramGraphics);
        }

        private CalendarPanel.DisplayedEvent getEventForMouseEvent(MouseEvent paramMouseEvent) {
            for (int i = 0; (CalendarPanel.this.displayedEvents != null) && (i < CalendarPanel.this.displayedEvents.size()); i++) {
                CalendarPanel.DisplayedEvent localDisplayedEvent = (CalendarPanel.DisplayedEvent) CalendarPanel.this.displayedEvents.elementAt(i);
                if ((paramMouseEvent.getX() >= localDisplayedEvent.rect.x) && (paramMouseEvent.getX() <= localDisplayedEvent.rect.x + localDisplayedEvent.rect.width) && (paramMouseEvent.getY() >= localDisplayedEvent.rect.y) && (paramMouseEvent.getY() <= localDisplayedEvent.rect.y + localDisplayedEvent.rect.height)) {
                    return localDisplayedEvent;
                }
            }
            return null;
        }

        public void mouseClicked(MouseEvent paramMouseEvent) {
            int i = CalendarPanel.this.selectedDate != null ? 1 : 0;
            int j = 0;
            CalendarPanel.this.selectedDate = null;
            CalendarPanel.this.selectedItemInd = -1;
            Object localObject1 = null;
            if (CalendarPanel.this.currentMouseOverEvent != null) {
                j = 1;
            }
            CalendarPanel.this.currentMouseOverEvent = null;
            Object localObject2;
            for (int k = 0; (CalendarPanel.this.displayedEvents != null) && (k < CalendarPanel.this.displayedEvents.size()); k++) {
                localObject2 = (CalendarPanel.DisplayedEvent) CalendarPanel.this.displayedEvents.elementAt(k);
                if ((paramMouseEvent.getX() >= ((CalendarPanel.DisplayedEvent) localObject2).rect.x) && (paramMouseEvent.getX() <= ((CalendarPanel.DisplayedEvent) localObject2).rect.x + ((CalendarPanel.DisplayedEvent) localObject2).rect.width) && (paramMouseEvent.getY() >= ((CalendarPanel.DisplayedEvent) localObject2).rect.y) && (paramMouseEvent.getY() <= ((CalendarPanel.DisplayedEvent) localObject2).rect.y + ((CalendarPanel.DisplayedEvent) localObject2).rect.height)) {
                    CalendarPanel.this.selectedDate = new CalendarPanel.Date(CalendarPanel.this, ((CalendarPanel.DisplayedEvent) localObject2).event.getYear(), ((CalendarPanel.DisplayedEvent) localObject2).event.getMonth(), ((CalendarPanel.DisplayedEvent) localObject2).event.getDayOfMonth());
                    if (!CalendarPanel.this.getAllowsEventSelection()) {
                        break;
                    }
                    CalendarPanel.this.selectedItemInd = ((CalendarPanel.DisplayedEvent) localObject2).eventNoForDay;
                    localObject1 = localObject2;
                    break;
                }
            }
            if (localObject1 == null) {
                int k;
                for (k = 0; (CalendarPanel.this.displayedDates != null) && (k < CalendarPanel.this.displayedDates.size()); k++) {
                    localObject2 = (CalendarPanel.DisplayedDate) CalendarPanel.this.displayedDates.elementAt(k);
                    if ((paramMouseEvent.getX() >= ((CalendarPanel.DisplayedDate) localObject2).rect.x) && (paramMouseEvent.getX() <= ((CalendarPanel.DisplayedDate) localObject2).rect.x + ((CalendarPanel.DisplayedDate) localObject2).rect.width) && (paramMouseEvent.getY() >= ((CalendarPanel.DisplayedDate) localObject2).rect.y) && (paramMouseEvent.getY() <= ((CalendarPanel.DisplayedDate) localObject2).rect.y + ((CalendarPanel.DisplayedDate) localObject2).rect.height)) {
                        CalendarPanel.this.selectedDate = ((CalendarPanel.DisplayedDate) localObject2).date;
                    }
                }
            }
            if (i != 0) {
                int k;
                for (k = 0; k < CalendarPanel.this.selectionListeners.size(); k++) {
                    localObject2 = (CalendarPanelSelectionListener) CalendarPanel.this.selectionListeners.elementAt(k);
                    ((CalendarPanelSelectionListener) localObject2).eventUnselected();
                }
                j = 1;
            }
            if ((CalendarPanel.this.selectedDate != null) && (localObject1 != null)) {
                int k;
                for (k = 0; k < CalendarPanel.this.selectionListeners.size(); k++) {
                    localObject2 = (CalendarPanelSelectionListener) CalendarPanel.this.selectionListeners.elementAt(k);
                    ((CalendarPanelSelectionListener) localObject2).eventSelected(((CalendarPanel.DisplayedEvent) localObject1).event);
                }
                j = 1;
            }
            if ((paramMouseEvent.getClickCount() == 2) && (CalendarPanel.this.selectedDate != null) && (localObject1 != null)) {
                int k;
                for (k = 0; k < CalendarPanel.this.selectionListeners.size(); k++) {
                    localObject2 = (CalendarPanelSelectionListener) CalendarPanel.this.selectionListeners.elementAt(k);
                    ((CalendarPanelSelectionListener) localObject2).eventDoubleClicked(((CalendarPanel.DisplayedEvent) localObject1).event);
                }
            } else if ((paramMouseEvent.getClickCount() == 2) && (CalendarPanel.this.selectedDate != null) && (localObject1 == null)) {
                int k;
                for (k = 0; k < CalendarPanel.this.selectionListeners.size(); k++) {
                    localObject2 = (CalendarPanelSelectionListener) CalendarPanel.this.selectionListeners.elementAt(k);
                    ((CalendarPanelSelectionListener) localObject2).dateDoubleClicked(CalendarPanel.this.selectedDate.year, CalendarPanel.this.selectedDate.month, CalendarPanel.this.selectedDate.day);
                }
            }
            if (j != 0) {
                repaint();
            }
        }

        public void mouseEntered(MouseEvent paramMouseEvent) {
            this.lastMouseEvent = getEventForMouseEvent(paramMouseEvent);
            CalendarPanel.this.currentMouseOverEvent = getMouseOverEvent(paramMouseEvent);
            if (CalendarPanel.this.currentMouseOverEvent != null) {
                repaint();
            }
        }

        public void mouseExited(MouseEvent paramMouseEvent) {
            this.lastMouseEvent = null;
            if (CalendarPanel.this.currentMouseOverEvent != null) {
                repaint();
            }
            CalendarPanel.this.currentMouseOverEvent = null;
        }

        public void mousePressed(MouseEvent paramMouseEvent) {
            if (CalendarPanel.this.currentMouseOverEvent != null) {
                repaint();
            }
            CalendarPanel.this.currentMouseOverEvent = null;
        }

        public void mouseReleased(MouseEvent paramMouseEvent) {
            if (CalendarPanel.this.currentMouseOverEvent != null) {
                repaint();
            }
            CalendarPanel.this.currentMouseOverEvent = null;
        }

        public void mouseDragged(MouseEvent paramMouseEvent) {
            CalendarPanel.this.currentMouseOverEvent = null;
        }

        public void mouseMoved(MouseEvent paramMouseEvent) {
            this.lastMouseEvent = getEventForMouseEvent(paramMouseEvent);
            CalendarPanel.DisplayedEvent localDisplayedEvent = CalendarPanel.this.currentMouseOverEvent;
            CalendarPanel.this.currentMouseOverEvent = getMouseOverEvent(paramMouseEvent);
            if (((localDisplayedEvent == null) && (CalendarPanel.this.currentMouseOverEvent != null)) || ((localDisplayedEvent != null) && (CalendarPanel.this.currentMouseOverEvent == null))) {
                repaint();
            } else if ((localDisplayedEvent != null) && (CalendarPanel.this.currentMouseOverEvent != null) && (!localDisplayedEvent.isSameEvent(CalendarPanel.this.currentMouseOverEvent))) {
                repaint();
            }
        }

    }

    class DisplayedDate {

        CalendarPanel.Date date;
        Rectangle rect;

        public DisplayedDate(CalendarPanel.Date paramDate, Rectangle paramRectangle) {
            this.date = paramDate;
            this.rect = paramRectangle;
        }
    }

    class DisplayedEvent {

        EventInstance event;
        Rectangle rect;
        int eventNoForDay;

        public DisplayedEvent(EventInstance paramEventInstance, Rectangle paramRectangle, int paramInt) {
            this.event = paramEventInstance;
            this.rect = paramRectangle;
            this.eventNoForDay = paramInt;
        }

        public boolean isSameEvent(Object paramObject) {
            if (!(paramObject instanceof DisplayedEvent)) {
                return false;
            }
            DisplayedEvent localDisplayedEvent = (DisplayedEvent) paramObject;
            return this.rect.equals(localDisplayedEvent.rect);
        }
    }

    public boolean checkDate(Calendar inputDate, Vector<Vector<String>> sch, int length) {

        boolean result = false;

        int len = Integer.toString(inputDate.get(2)).length();
        String strr = String.valueOf(inputDate.get(2));
        if (len == 1) {
            strr = String.format("%02d", inputDate.get(2));
        }

        int len2 = Integer.toString(inputDate.get(5)).length();
        String strr2 = String.valueOf(inputDate.get(5));
        if (len2 == 1) {
            strr2 = String.format("%02d", inputDate.get(5));
        }

        String paramCal = String.valueOf(inputDate.get(1)) + strr + strr2;
//        System.out.println(paramCal);

//sch.get(length) == 1
        String FULL_DATE = sch.get(length).get(1);

        FULL_DATE = FULL_DATE.replace("-", "");
        if (FULL_DATE.equals(paramCal)) {
            result = true;
        }

        return result;

    }

    class Date {

        public int year;
        public int month;
        public int day;

        public Date(int paramInt1, int paramInt2, int paramInt3) {
            this.year = paramInt1;
            this.month = paramInt2;
            this.day = paramInt3;
        }

        public Date(CalendarPanel aThis, int paramInt1, int paramInt2, int paramInt3) {
            this.year = paramInt1;
            this.month = paramInt2;
            this.day = paramInt3;
        }
    }
}
