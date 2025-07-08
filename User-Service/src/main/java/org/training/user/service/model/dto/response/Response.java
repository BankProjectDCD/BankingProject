package org.training.user.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Response {

    private String responseCode;

    private String responseMessage;
    
    
    // Static builder method
    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    // Builder class
    public static class ResponseBuilder {
        private String responseCode;
        private String responseMessage;

        public ResponseBuilder responseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public ResponseBuilder responseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }

        public Response build() {
            Response response = new Response();
            response.setResponseCode(responseCode);
            response.setResponseMessage(responseMessage);
            return response;
        }
    }
    
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
    
    
}
