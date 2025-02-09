package com.opf.project.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponse (Integer number, Boolean is_prime,
                           Boolean is_perfect, List<String> properties,
                           Integer digit_sum, String fun_fact) {
}