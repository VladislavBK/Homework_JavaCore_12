package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceMock;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceMock;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    @org.testng.annotations.Test
    public void messageSender_RussianSuccess () {
        String expected = "Добро пожаловать";
        GeoService geoService = new GeoServiceMock();
        LocalizationService localizationService = new LocalizationServiceMock();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();

        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String argument = messageSender.send(headers);
        Assertions.assertEquals(expected, argument);
    }

    @Test
    public void messageSender_OtherSuccess () {
        String expected = "Welcome";
        GeoService geoService = new GeoServiceMock();
        LocalizationServiceMock localizationService = new LocalizationServiceMock();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();

        localizationService.setText("Welcome");
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String argument = messageSender.send(headers);
        Assertions.assertEquals(expected, argument);
    }
}
