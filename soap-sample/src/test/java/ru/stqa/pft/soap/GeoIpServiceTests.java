package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("79.165.124.228");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }

  @Test
  public void testInvalidIp1() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("79.165.124.xxx");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }

}
