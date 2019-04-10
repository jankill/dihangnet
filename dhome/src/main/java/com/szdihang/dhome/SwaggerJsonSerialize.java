package com.szdihang.dhome;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;

/**
 * @author glory
 * @version V1.0
 * @Title: SwaggerJsonSerialize
 * @Package: com.szdihang.dhome
 * @Description: TODO
 * @date 2019/4/7 15:01
 **/
public class SwaggerJsonSerialize implements JsonSerializer<Json> {
    @Override
    public JsonElement serialize(Json json, Type type, JsonSerializationContext context) {
        final JsonParser parser = new JsonParser();
        return parser.parse(json.value());
    }
}
