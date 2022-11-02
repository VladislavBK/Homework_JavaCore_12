package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @org.testng.annotations.Test
    public void byIp_Moscow_Success () {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        String ip = "172.0.32.11";
        Location argument = geoService.byIp(ip);
        Assertions.assertEquals(expected, argument);
    }

    @org.testng.annotations.Test
    public void byIp_NewYork_Success () {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        String ip = "96.44.183.149";
        Location argument = geoService.byIp(ip);
        Assertions.assertEquals(expected, argument);
    }

    @org.testng.annotations.Test
    public void byIp_StartWithMoscow_Success () {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        String ip = "172.11.42.14";
        Location argument = geoService.byIp(ip);
        Assertions.assertEquals(expected, argument);
    }

    @org.testng.annotations.Test
    public void byIp_StartWithNewYork_Success () {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        String ip = "96.60.83.119";
        Location argument = geoService.byIp(ip);
        Assertions.assertEquals(expected, argument);
    }

    @Test
    public void byIp_LocalHost_Success () {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location expected = new Location(null, null, null, 0);
        String ip = "127.0.0.1";
        Location argument = geoService.byIp(ip);
        Assertions.assertEquals(expected, argument);
    }
}
