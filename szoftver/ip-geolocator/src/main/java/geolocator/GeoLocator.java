package geolocator;

import feign.Feign;
import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;
import feign.slf4j.Slf4jLogger;

/**
 * inforaciok ip cimekrol es host evekrol
 * használatával <a href="https://reallyfreegeoip.org">really free gro ip api</a>
 * a {@link #newInstance()}
 */
public interface GeoLocator {

    /**
     * visszaad geolocation információkat a jvm futasarol
     *
     * @return geolocation információkat a a jvm futasarol
     * @throws feign.FeignException ha bármi hia tortenik a http hivasnal
     */
    @RequestLine("GET")
    GeoLocation getGeoLocation();

    /**
     * viszaad geolocation információkat a megadott ip vagy host cimrol futasarol
     *
     * @param ipOrHostName ip vagy host cim
     * @return geolocation információkat a megadott ip vagy host cimrol futasarol
     * @throws feign.FeignException ha bármi hia tortenik a http hivasnal
     */
    @RequestLine("GET /{ipOrHostName}")
    GeoLocation getGeoLocation(@Param("ipOrHostName") String ipOrHostName);

    /**
     * epit egy olyan objektumot amit implemetálja a {@code GeoLocation} interfacet
     *
     * @return objektum ami implemetálja a geolocation interfacet
     */
    static GeoLocator newInstance() {
        return Feign.builder()
                .decoder(new GsonDecoder(new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .target(GeoLocator.class, "https://reallyfreegeoip.org/json/");
    }

}
