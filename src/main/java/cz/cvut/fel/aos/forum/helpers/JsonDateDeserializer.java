package cz.cvut.fel.aos.forum.helpers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

class JsonDateDeserializer {

}

//class JsonDateDeserializer extends JsonDeserializer<Date> {
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
//
//    @Override
//    Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//        String timestamp = jp.getText().trim();
//        // dateFormat.
//
//        return new Date(Long.valueOf(timestamp));
//    }
//}