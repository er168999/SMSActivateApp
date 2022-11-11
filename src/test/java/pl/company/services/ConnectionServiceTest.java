package pl.company.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import ru.sms_activate.error.base.SMSActivateBaseException;
import ru.sms_activate.error.wrong_parameter.SMSActivateWrongParameterException;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConnectionServiceTest {


    ConnectionService connectionService;
    String authKey;


    @Before
    public void init(){
        connectionService = new ConnectionService();
        authKey = "B8d8fe6f99B0726B0edc45687fBe660d";
    }

    @Test
    public void ShouldThrowSMSActivateWrongParameterExpection()
    {
        //given
        String testKey = "123";

        //when
        Exception e = assertThrows(SMSActivateWrongParameterException.class, () -> connectionService.connect(testKey));

        //then
        assertEquals(SMSActivateWrongParameterException.class, e.getClass());
    }
    @Test
    public void ShouldThrowNullPointerException()
    {
        //given
        String testKey = null;

        //when
        Exception e = assertThrows(NullPointerException.class, () -> connectionService.connect(testKey));

        //then
        assertEquals(NullPointerException.class, e.getClass());
    }
    @Test
    public void ShouldReturnConnectedAndBalance() throws SMSActivateBaseException, IOException {
        //given
        String testKey = authKey;

        //when
        String result = connectionService.connect(testKey);

        //then
        assertTrue(result.equals("Connected, actual balance:  " + connectionService.balance));
    }

}