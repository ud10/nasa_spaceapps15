/*
 * Copyright 2014 IBM Corp. All Rights Reserved
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cardboard.photosphere;
import android.util.Log;


public class Item {
	public String id;
    public String url;
    public String title;
	
	public Item(String itemId, String itemURL, String itemTitle) {
        id = itemId;
        url = itemURL;
        title = itemTitle;
	}
	
	/**
	 * Gets the name of the Item.
	 * @return String itemName
	 */
	public String getTitle() {
		return title;
	}

    public String getURL() { return url;}

	/**
	 * Sets the name of a list item, as well as calls setCreationTime().
	 * //@param String itemName
	 */
//	public void setName(String itemName) {
//		name = itemName;
//	}
	
	/**
	 * When calling toString() for an item, we'd really only want the name.
	 * @return String theItemName
	 */
//	public String toString() {
//		String theItemName = "";
//		theItemName = getName();
//		return theItemName;
//	}
}
