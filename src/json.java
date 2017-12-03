import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Formation;
import model.Utilisateur;

public class json {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		  
		
		List<Formation> abc = new ArrayList(); 
		abc.add(new Formation( 1,"A" ));
		abc.add(new Formation( 2,"B" ));
		
		obj.put(1, ((Formation)abc.get(0)).toJson() );
		
		obj.put(2, ((Formation)abc.get(1)).toJson() );
		
		System.out.println(obj.toJSONString());
		
		
		JSONArray resultArray = new JSONArray();
		
		resultArray.add(obj);
		
		JSONObject main = new JSONObject();
		main.put("first",resultArray);
		
		System.out.println(main.toJSONString());
		

	}

}
