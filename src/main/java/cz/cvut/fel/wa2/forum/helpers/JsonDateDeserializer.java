package cz.cvut.fel.wa2.forum.helpers;

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