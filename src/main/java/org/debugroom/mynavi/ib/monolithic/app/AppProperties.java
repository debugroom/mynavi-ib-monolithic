package org.debugroom.mynavi.ib.monolithic.app;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="app")
public class AppProperties {

    private final String credentialSecondaryPasswordLogicalName;

}
