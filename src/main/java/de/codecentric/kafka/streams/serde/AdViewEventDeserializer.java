package de.codecentric.kafka.streams.serde;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.codecentric.kafka.streams.model.AdClickEvent;
import de.codecentric.kafka.streams.model.AdViewEvent;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ftr on 03/02/2017.
 */
public class AdViewEventDeserializer implements Deserializer<AdViewEvent>{
    private ObjectMapper mapper = new ObjectMapper();

    public void configure(Map<String, ?> map, boolean b) {

    }

    public AdViewEvent deserialize(String s, byte[] bytes) {

        try {
            if(bytes == null || bytes.length == 0){
                return null;
            }
            return mapper.readValue(bytes, AdViewEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {

    }
}
