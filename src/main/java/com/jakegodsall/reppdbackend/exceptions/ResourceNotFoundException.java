package com.jakegodsall.reppdbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(
            String resourceName,
            String fieldName,
            Long fieldValue
    ) {
        super(String.format(
                "%s: %s not found for resource %s.\n",
                fieldName, fieldValue, resourceName
        ));
    }
}
