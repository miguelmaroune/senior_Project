package army.calendar;

import java.util.Vector;

public class Utils {

    public static Vector wrapLines(String paramString, int paramInt) {
        Vector localVector1 = new Vector();
        String[] arrayOfString = paramString.split("[\r\n]+");
        for (int i = 0; i < arrayOfString.length; i++) {
            Vector localVector2 = wrapLine(arrayOfString[i], paramInt);
            localVector1.addAll(localVector2);
        }
        return localVector1;
    }

    public static Vector wrapLine(String paramString, int paramInt) {
        Vector localVector = new Vector();
        if (paramString.length() <= paramInt) {
            localVector.addElement(paramString);
            return localVector;
        }
        String[] arrayOfString = paramString.split("[ \t]+");
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < arrayOfString.length; i++) {
            if (localStringBuffer.length() + 1 + arrayOfString[i].length() >= paramInt) {
                if (localStringBuffer.length() > 0) {
                    localVector.addElement(localStringBuffer.toString());
                }
                localStringBuffer.setLength(0);
                localStringBuffer.append(arrayOfString[i]);
            } else {
                if (localStringBuffer.length() > 0) {
                    localStringBuffer.append(' ');
                }
                localStringBuffer.append(arrayOfString[i]);
            }
        }
        if (localStringBuffer.length() > 0) {
            localVector.addElement(localStringBuffer.toString());
        }
        return localVector;
    }
}
