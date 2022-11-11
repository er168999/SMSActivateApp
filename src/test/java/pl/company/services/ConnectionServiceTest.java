package pl.company.services;

import org.junit.Before;
import org.junit.Test;
import ru.sms_activate.error.wrong_parameter.SMSActivateWrongParameterException;

import static org.junit.Assert.*;

public class ConnectionServiceTest {


    ConnectionService connectionService;
    String authKey;


    @Before
    public void init(){
        connectionService = new ConnectionService();
        authKey = "123aa";
    }

    @Test
    public void ShouldThrowSMSActivateWrongParameterExpection()
    {
        //given
        String testKey = authKey;

        //when
        Exception e = assertThrows(SMSActivateWrongParameterException.class, () -> connectionService.connect(authKey));

        //then
        assertEquals(SMSActivateWrongParameterException.class, e.getClass());
    }


}