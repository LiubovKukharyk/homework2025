
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    static Connections connections;
    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        setupLogger();
        connections = new Connections();
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            for (int r = 0; r < 3; r++) {
                exec.submit(Main::runnableTask);
            }
            for (int f = 0; f < 3; f++) {
                Future<Void> future = exec.submit(Main::callableTask);
                future.get();
            }
            for (int t = 0; t < 3; t++) {
                Thread thread = new Thread(Main::threadTask);
                thread.start();
                thread.join();
            }
            for (int g = 0; g < 2; g++) {
            	exec.submit(Main::runnableTask);
            }
        }

        exec.shutdown();
        logger.info("All tasks completed");
    }

    static void runnableTask() {
        try {
            Connection c = connections.getConnection();
            runSQL(c);
            connections.releaseConnection(c);
            logger.info("Runnable task completed");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Runnable task error", e);
        }
    }

    static Void callableTask() {
        try {
            Connection c = connections.getConnection();
            runSQL(c);
            connections.releaseConnection(c);
            logger.info("Callable task completed");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Callable task error", e);
        }
        return null;
    }

    static void threadTask() {
        try {
            Connection c = connections.getConnection();
            runSQL(c);
            connections.releaseConnection(c);
            logger.info("Thread task completed");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Thread task error", e);
        }
    }

    static void runSQL(Connection c) throws SQLException, InterruptedException {
        try (PreparedStatement s = c.prepareStatement("SELECT CURRENT_DATE")) {
            s.executeQuery();
        }
        Thread.sleep(100);
    }


    private static void setupLogger() throws Exception {
        FileHandler fileHandler = new FileHandler("log.txt", true);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.INFO);
    }
}
