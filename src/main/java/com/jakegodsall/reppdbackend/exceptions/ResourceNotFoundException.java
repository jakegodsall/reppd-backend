package com.jakegodsall.reppdbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private String fieldStringValue;
    private Long fieldLongValue;

    public ResourceNotFoundException(
            String resourceName,
            String fieldName,
            Long fieldLongValue
    ) {
        super(String.format(
                "%s: %s not found for resource %s.\n",
                fieldName, fieldLongValue, resourceName
        ));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldLongValue = fieldLongValue;
    }

    public ResourceNotFoundException(
            String resourceName,
            String fieldName,
            String fieldStringValue
    ) {
        super(String.format(
                "%s: %s not found for resource %s.\n",
                fieldName, fieldStringValue, resourceName
        ));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldStringValue = fieldStringValue;
    }
}
