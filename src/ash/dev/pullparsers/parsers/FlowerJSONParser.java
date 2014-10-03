package ash.dev.pullparsers.parsers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ash.dev.pullparsers.model.Flower;

public class FlowerJSONParser {

	public static List<Flower> parseFeed(String content) {

		try {
			JSONArray ar = new JSONArray(content);
			List<Flower> flowerlist = new ArrayList<>();
			
			for (int i = 0; i < ar.length(); i++) {
				JSONObject obj = ar.getJSONObject(i);
				Flower flower = new Flower();
				
				flower.setProductId(obj.getInt("productId"));
				flower.setName(obj.getString("name"));
				flower.setCategory(obj.getString("category"));
				flower.setInstructions(obj.getString("instructions"));
				flower.setPhoto(obj.getString("photo"));
				flower.setPrice(obj.getDouble("price"));
				
				flowerlist.add(flower);
			}
			return flowerlist;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
