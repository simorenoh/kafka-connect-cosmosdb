package com.azure.cosmos.kafka.connect.sink.id.strategy;

import org.apache.kafka.common.config.ConfigDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ProvidedInConfig extends AbstractIdStrategyConfig {
    private static final Logger logger = LoggerFactory.getLogger(ProvidedInConfig.class);
    public static final String JSON_PATH_CONFIG = "jsonPath";
    public static final String JSON_PATH_CONFIG_DEFAULT = "$.id";
    public static final String JSON_PATH_CONFIG_DOC = "A JsonPath expression to select the desired component to use as ``id``";
    public static final String JSON_PATH_CONFIG_DISPLAY = "JSON Path";
    private final String jsonPath;

    public ProvidedInConfig(Map<String, ?> props) {
        this(getConfig(), props);
    }

    public ProvidedInConfig(ConfigDef definition, Map<String, ?> originals) {
        super(definition, originals);

        this.jsonPath = getString(JSON_PATH_CONFIG);
    }


    public static ConfigDef getConfig() {
        ConfigDef result = new ConfigDef();

        final String groupName = "JsonPath Parameters";
        int groupOrder = 0;

        result.define(
            JSON_PATH_CONFIG,
            ConfigDef.Type.STRING,
            JSON_PATH_CONFIG_DEFAULT,
            ConfigDef.Importance.MEDIUM,
            JSON_PATH_CONFIG_DOC,
            groupName,
            groupOrder++,
            ConfigDef.Width.MEDIUM,
            JSON_PATH_CONFIG_DISPLAY
        );

        return result;
    }

    public String jsonPath() {
        return jsonPath;
    }
}
