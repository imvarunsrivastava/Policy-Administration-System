package com.cts.authorization.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class ValidatingDTO {

	 @JsonProperty
	 private boolean validStatus;
}
