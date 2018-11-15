package army.calendar;

import java.util.*;
import army.controller.DbManager;
import army.handler.UserHandler;
import army.model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import static java.util.Spliterators.iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalendarPanelTest
        extends JFrame
        implements CalendarDataRepository {

    private static final long serialVersionUID = 1000L;
    CalendarPanel cpanel;
    HashMap<String, Vector<Vector<String>>> tasks = new HashMap<>();

    public CalendarPanelTest() {
        super("Calendar ");
        setSize(600, 600);
        Container localContainer = getContentPane();
        localContainer.setLayout(new BorderLayout());
        JPanel localJPanel = new JPanel(new FlowLayout());
        JButton localJButton1 = new JButton("+");
        localJButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                CalendarPanelTest.this.larger();
            }
        });
        localJPanel.add(localJButton1);
        JButton localJButton2 = new JButton("-");
        localJButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
                CalendarPanelTest.this.smaller();
            }
        });

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
            tasks = Uhandler.getTask(con, username);
        } catch (SQLException ex) {
            Logger.getLogger(CalendarPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbManager.CloseConnection();
        }
//        
        localJPanel.add(localJButton2);
        localContainer.add(localJPanel, "North");
        this.cpanel = new CalendarPanel(this);
        localContainer.add(this.cpanel, "Center");
        setVisible(true);
    }

    void larger() {
        Font localFont1 = this.cpanel.getFont();
        Font localFont2 = new Font(localFont1.getFamily(), localFont1.getStyle(), localFont1.getSize() + 2);
        this.cpanel.setFont(localFont2);
    }

    void smaller() {
        Font localFont1 = this.cpanel.getFont();
        if (localFont1.getSize() > 4) {
            Font localFont2 = new Font(localFont1.getFamily(), localFont1.getStyle(), localFont1.getSize() - 2);
            this.cpanel.setFont(localFont2);
        }
    }

    public Vector getEventInstancesForDate(int paramInt1, int paramInt2, int paramInt3) {
        int len = Integer.toString(paramInt2).length();
        String strr = String.valueOf(paramInt2);
        if (len == 1) {
            strr = String.format("%02d", paramInt2);
        }

        int len2 = Integer.toString(paramInt3).length();
        String strr2 = String.valueOf(paramInt3);
        if (len2 == 1) {
            strr2 = String.format("%02d", paramInt3);
        }

        String paramCal = String.valueOf(paramInt1) + strr + strr2;

//        
        Vector localVector = new Vector();
        if (tasks.containsKey(paramCal)) {
            Vector<Vector<String>> dataAll = new Vector<Vector<String>>();
            
            dataAll = tasks.get(paramCal);
//            lezem hon zabbit l dataAll b alb l for khalliya ta3mel iterate b alba
//            int duration = Integer.parseInt(data.get(0));
//            String description = data.get(1);
//            String status = data.get(2);
            for (Vector<String> v : dataAll) {
                localVector.addElement(new Event(v.get(2), v.get(1), paramInt1, paramInt2, paramInt3));
            }

//            tasks.values();
//                localVector.addElement(new Event("Test event", "This is a test event.\nTest description", paramInt1, paramInt2, paramInt3));
        } else {

            localVector.addElement(new Event("No Task", "Free", paramInt1, paramInt2, paramInt3));
//        }if (paramInt3 % 3 == 0) {
//            localVector.addElement(new Event("Test 9:15", "This is a test event.\nTest description", paramInt1, paramInt2, paramInt3, 9, 15, 0));
//        } else if (paramInt3 % 3 == 2) {
//            localVector.addElement(new Event("Test 12:30", "This is a test event.\nTest description", paramInt1, paramInt2, paramInt3, 0, 30, 0));
//            localVector.addElement(new Event("Test 3:30pm", "This is a test event.\nTest description", paramInt1, paramInt2, paramInt3, 15, 15, 0));
//        }
//        if (paramInt3 % 5 == 0) {
//            localVector.addElement(new Event("Long Description Event", "Mary had a little lamb,\nLittle lamb, little lamb,\nMary had a little lamb,\nIts fleece was white as snow\nAnd everywhere that Mary went\nMary went, Mary went,\nEverywhere that Mary went\nThe lamb was sure to go\nIt followed her to school one day\nSchool one day, school one day\nIt followed her to school one day\nWhich was against the rules.\nIt made the children laugh and play,\nLaugh and play, laugh and play,\nIt made the children laugh and play\nTo see a lamb at school\nAnd so the teacher turned it out,\nTurned it out, turned it out,\nAnd so the teacher turned it out,\nBut still it lingered near\nAnd waited patiently about,\nPatiently about, patiently about,\nAnd waited patiently about\nTill Mary did appear\n\"Why does the lamb love Mary so?\"\nLove Mary so? Love Mary so?\n\"Why does the lamb love Mary so?\"\nThe eager children cry\n\"Why, Mary loves the lamb, you know.\"\nLoves the lamb, you know, loves the lamb, you know\n\"Why, Mary loves the lamb, you know.\"\nThe teacher did reply.", paramInt1, paramInt2, paramInt3));
//        }
//        if (paramInt3 % 4 == 0) {
//            localVector.addElement(new Event("Word Wrap Test", "We the People of the United States, in Order to form a more perfect Union,  establish Justice, insure domestic Tranquility, provide for the common defence, promote the general Welfare, and secure the Blessings of Liberty to ourselves and our Posterity, do ordain and establish this Constitution for the United States of America.", paramInt1, paramInt2, paramInt3));
//        }
//        if (paramInt3 == 15) {
//            for (int i = 0; i < 10; i++) {
//                localVector.addElement(new Event("Event#" + (i + 1), "This is a test event.\nWe're checking to see how the calendar renders when you put a whole bunch of events on the same day.", paramInt1, paramInt2, paramInt3));
//            }
//        }
        }
        return localVector;
    }
//test
    public static void main(String[] paramArrayOfString) {
        new CalendarPanelTest();
    }

    class Event
            implements EventInstance {

        String title;
        String description;
        int Y;
        int M;
        int D;
        int h;
        int m;
        int s;
        boolean hasTime;
        boolean allDay;
        Color fg;
        Color bg;
        Color border;
        Color[] colors = {Color.blue, Color.red, Color.orange, Color.pink, Color.gray, Color.green, Color.yellow, Color.cyan, Color.magenta};

        public Event(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
            this(paramString1, paramString2, paramInt1, paramInt2, paramInt3, 0, 0, 0, false, false);
        }

        public Event(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
            this(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, true, false);
        }

        public Event(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2) {
            this.title = paramString1;
            this.description = paramString2;
            this.Y = paramInt1;
            this.M = paramInt2;
            this.D = paramInt3;
            this.h = paramInt4;
            this.m = paramInt5;
            this.s = paramInt6;
            this.hasTime = paramBoolean1;
            this.allDay = paramBoolean2;
            this.bg = this.colors[((paramInt1 + paramInt2 + paramInt3 + paramInt4 + paramInt5 + paramInt6) % this.colors.length)];
            this.fg = new Color(this.bg.getRed() / 2, this.bg.getGreen() / 2, this.bg.getBlue() / 2);
            this.border = this.fg;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean isAllDay() {
            return this.allDay;
        }

        public boolean hasTime() {
            return this.hasTime;
        }

        public int getYear() {
            return this.Y;
        }

        public int getMonth() {
            return this.M;
        }

        public int getDayOfMonth() {
            return this.D;
        }

        public int getHour() {
            return this.h;
        }

        public int getMinute() {
            return this.m;
        }

        public int getSecond() {
            return this.s;
        }

        public boolean hasDuration() {
            return false;
        }

        public String getLocation() {
            return null;
        }

        public int getDurationSeconds() {
            return 0;
        }

        public Color getForegroundColor() {
            return this.fg;
        }

        public Color getBackgroundColor() {
            return this.bg;
        }

        public Color getBorderColor() {
            return this.border;
        }

        public int compareTo(Object paramObject) {
            EventInstance localEventInstance = (EventInstance) paramObject;
            if (getYear() < localEventInstance.getYear()) {
                return -1;
            }
            if (getYear() > localEventInstance.getYear()) {
                return 1;
            }
            if (getMonth() < localEventInstance.getMonth()) {
                return -1;
            }
            if (getMonth() > localEventInstance.getMonth()) {
                return 1;
            }
            if (getDayOfMonth() < localEventInstance.getDayOfMonth()) {
                return -1;
            }
            if (getDayOfMonth() > localEventInstance.getDayOfMonth()) {
                return 1;
            }
            if ((!this.hasTime) && (localEventInstance.hasTime())) {
                return -1;
            }
            if ((hasTime()) && (!localEventInstance.hasTime())) {
                return 1;
            }
            if ((!this.hasTime) && (!localEventInstance.hasTime())) {
                return 0;
            }
            if ((isAllDay()) && (!localEventInstance.isAllDay())) {
                return -1;
            }
            if ((!isAllDay()) && (localEventInstance.isAllDay())) {
                return 1;
            }
            if ((isAllDay()) && (localEventInstance.isAllDay())) {
                return 0;
            }
            if (getHour() < localEventInstance.getHour()) {
                return -1;
            }
            if (getHour() > localEventInstance.getHour()) {
                return 1;
            }
            if (getMinute() < localEventInstance.getMinute()) {
                return -1;
            }
            if (getMinute() > localEventInstance.getMinute()) {
                return 1;
            }
            if (getSecond() < localEventInstance.getSecond()) {
                return -1;
            }
            if (getSecond() > localEventInstance.getSecond()) {
                return 1;
            }
            return 0;
        }
    }
}
