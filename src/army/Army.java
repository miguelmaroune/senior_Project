package army;

import army.controller.DbManager;
import army.views.LoginPage;
import static army.views.LoginPage.changecolor;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Army {

    static Logger logger = Logger.getLogger(Army.class);

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        logger.info("main started");
//        Process process = Runtime.getRuntime().exec("C:\\xampp\\xampp_start.exe");
        Process process = Runtime.getRuntime().exec("C:\\wamp\\bin\\mysql\\mysql5.7.21\\bin\\mysqld.exe");

        new LoginPage().setVisible(true);
        changecolor();

//        stop wampp 
//        Process process_end = Runtime.getRuntime().exec("C:\\xampp\\mysql_stop.bat");
    }

//    public void close() {
//        
//        WindowEvent windowClose = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
//        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClose);
//        
//    }
}
