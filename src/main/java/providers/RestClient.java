package providers;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import config.ApplicationProperties;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jackson.JacksonEncoder;


public class RestClient {

    public ApplicationEndpoints createClient() {
        ObjectMapper mapper = createObjectMapper();

        Feign.Builder feignBuilder = Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new JacksonEncoder(mapper));

        return feignBuilder
                .target(ApplicationEndpoints.class, ApplicationProperties.getString(ApplicationProperties.ApplicationProperty.SERVICE_URL));
    }

    private ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

}
