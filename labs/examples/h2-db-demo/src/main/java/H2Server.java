import java.sql.SQLException;

import org.h2.tools.Server;

public class H2Server {

    public static void main(String[] args) throws SQLException {
        System.out.println("Starting H2 Server...");
        Server server = Server.createTcpServer(args).start();
        System.out.println("H2 Server Running...");
    }
}
