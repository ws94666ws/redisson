/**
 * Copyright (c) 2013-2024 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.spring.cache;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.redisson.api.map.event.MapEntryListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

/**
 * 
 * @author Nikita Koksharov
 *
 */
public class CacheConfigSupport {

    ObjectMapper jsonMapper = createMapper(null);
    ObjectMapper yamlMapper = createMapper(new YAMLFactory());
    
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
    public static class ClassMixIn {
    }
    
    private ObjectMapper createMapper(JsonFactory mapping) {
        ObjectMapper mapper = new ObjectMapper(mapping);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.addMixIn(MapEntryListener.class, ClassMixIn.class);
        return mapper;
    }
    
    public Map<String, CacheConfig> fromJSON(String content) throws IOException {
        return jsonMapper.readValue(content, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromJSON(File file) throws IOException {
        return jsonMapper.readValue(file, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromJSON(URL url) throws IOException {
        return jsonMapper.readValue(url, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromJSON(Reader reader) throws IOException {
        return jsonMapper.readValue(reader, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromJSON(InputStream inputStream) throws IOException {
        return jsonMapper.readValue(inputStream, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public String toJSON(Map<String, ? extends CacheConfig> configs) throws IOException {
        return jsonMapper.writeValueAsString(configs);
    }

    public Map<String, CacheConfig> fromYAML(String content) throws IOException {
        return yamlMapper.readValue(content, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromYAML(File file) throws IOException {
        return yamlMapper.readValue(file, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromYAML(URL url) throws IOException {
        return yamlMapper.readValue(url, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromYAML(Reader reader) throws IOException {
        return yamlMapper.readValue(reader, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public Map<String, CacheConfig> fromYAML(InputStream inputStream) throws IOException {
        return yamlMapper.readValue(inputStream, new TypeReference<Map<String, CacheConfig>>() {});
    }

    public String toYAML(Map<String, ? extends CacheConfig> configs) throws IOException {
        return yamlMapper.writeValueAsString(configs);
    }


}
