import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class Connections {
    private static final int POOL_SIZE = 10;
    private final BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(POOL_SIZE);
    private static final Logger logger = Logger.getLogger(Connections.class.getName());

    public Connections() throws SQLException {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.offer(DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", ""));
        }
    }

    public Connection getConnection() throws InterruptedException, SQLException {
        if (pool.isEmpty()) {
            Main.logger.info("Waiting for a free connection...");
        }
        Connection c = pool.take(); 
        return c;
    }

    public void releaseConnection(Connection c) throws InterruptedException {
        Thread.sleep(100);
        pool.offer(c);
    }

	public static Logger getLogger() {
		return logger;
	}
}
