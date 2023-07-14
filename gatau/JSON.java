package gatau;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSON {
    public static void main(String[] args) {
        String json = "{\"Menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateteNewDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Close\",\"onclick\":\"CloseDoc()\"}]}}}";

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject menuObject = jsonObject.getJSONObject("Menu");
            JSONObject popupObject = menuObject.getJSONObject("popup");
            JSONArray menuitemArray = popupObject.getJSONArray("menuitem");

            // Iterate over menuitem entities
            for (int i = 0; i < menuitemArray.length(); i++) {
                JSONObject menuitem = menuitemArray.getJSONObject(i);
                String value = menuitem.getString("value");
                String onclick = menuitem.getString("onclick");

                System.out.println("Value: " + value);
                System.out.println("Onclick: " + onclick);
                System.out.println("---------------------");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}