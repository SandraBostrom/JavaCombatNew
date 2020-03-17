package org.example.JunitTests;
import org.example.DB.MySqlConnection;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class MySqlConnectionTest {

    @Test
    public void testGetConnection() throws SQLException {
        Connection con = MySqlConnection.getConnection();
        Assert.assertNotNull(con);
    }
}
