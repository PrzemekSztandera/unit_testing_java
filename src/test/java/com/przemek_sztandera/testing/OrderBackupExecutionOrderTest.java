package com.przemek_sztandera.testing;

import com.przemek_sztandera.testing.order.Order;
import com.przemek_sztandera.testing.order.OrderBackup;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingFileFirstShouldThrowException() throws IOException {
        // given
        OrderBackup orderBackup = new OrderBackup();

        // then
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}
