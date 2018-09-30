package com.bitkermessage.client.messages.messages;

import java.util.List;

/**
 * Created by Matteo on 07/10/2016.
 */
public class GetHeaders extends GetBlocks {

    public GetHeaders(){
        super();
    }

    public GetHeaders(List<byte []> h){
        super(h);
    }
    
    @Override
    public String getCommand() {
        return "getheaders";
    }
}
