package com.salesart.billingmigration.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = 7208220849220984767L;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Integer pageNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Integer pageSize;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private transient Long totalElements;
    private transient ResponseMessage message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private transient int responseStatus;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private transient T data;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private transient String errorMessageKey;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private transient String errorMessage;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private transient String stackTrace;

}
