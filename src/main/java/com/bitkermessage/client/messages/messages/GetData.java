package com.bitkermessage.client.messages.messages;

import java.util.List;

/**
 * Created by Matteo on 07/10/2016.
 */
public class GetData extends Inventory {


    public GetData(){
        super();
    }

    public GetData(List<InventoryVector> iv){
		super(iv);
	}
    
    @Override
    public String getCommand() {
        return "getdata";
    }

}
