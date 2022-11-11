package pl.company.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.company.models.Authorization;
import ru.sms_activate.SMSActivateApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sms_activate.error.base.SMSActivateBaseException;
import ru.sms_activate.error.wrong_parameter.SMSActivateWrongParameterException;

import java.io.IOException;
import java.math.BigDecimal;

public class ConnectionService {
    JsonParseService jsonParseService = new JsonParseService();


    public String connect() throws SMSActivateBaseException, IOException {
        SMSActivateApi smsActivateApi = new SMSActivateApi(jsonParseService.getAuthKey());
        BigDecimal balance = smsActivateApi.getBalance();
        return "Connected, actual balance:  " + balance;
    }

}
