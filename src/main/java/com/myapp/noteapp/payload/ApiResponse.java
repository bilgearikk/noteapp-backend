package com.myapp.noteapp.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private Boolean success;

    public ApiResponse(String message,Boolean success) {
        this.message = message;
        this.success = success;
    }

    // toString method
    @Override
    public String toString() {
        return "ApiResponse [message= " + message + ", success=" + success +"]";
    }
}
