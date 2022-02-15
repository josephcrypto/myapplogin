package cn.coding.com.myapplogin.exception;

import lombok.Getter;
import lombok.Setter;

/**@Author JosephCrypto
 *@Create 2022-47-2/15/22 9:47 PM
 */
@Getter
@Setter
public class CustomErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public CustomErrorResponse(){
        super();
    }

    public CustomErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
