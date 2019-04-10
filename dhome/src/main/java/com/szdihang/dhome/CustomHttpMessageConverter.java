package com.szdihang.dhome;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import springfox.documentation.spring.web.json.Json;

/**
 * @author glory
 * @version V1.0
 * @Title: WebConfigurer
 * @Package: com.szdihang.dhome
 * @Description: TODO
 * @date 2019/4/7 14:56
 **/
@Configuration
public class CustomHttpMessageConverter {
    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson());
        return converter;
    }

    private Gson gson() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Json.class, new SwaggerJsonSerialize());
        return builder.create();
    }
}
