package pl.company.app;

import pl.company.services.ConnectionService;
import pl.company.services.JsonParseService;
import ru.sms_activate.error.base.SMSActivateBaseException;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws SMSActivateBaseException, IOException {
        ConnectionService connectionService = new ConnectionService();
        System.out.println(connectionService.connect());
    }

}
