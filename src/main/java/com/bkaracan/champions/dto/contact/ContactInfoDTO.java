package com.bkaracan.champions.dto.contact;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties()
public record ContactInfoDTO(String message, Map<String, String> contactDetails,
                             List<String> onCallSupport) {
}
