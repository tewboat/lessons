package com.example.httpexample.repository.jsonplaceholder;

import com.example.httpexample.domain.user.Address;
import com.example.httpexample.domain.user.Company;
import com.example.httpexample.domain.user.Geo;
import com.example.httpexample.domain.user.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class JsonPlaceholderParser {
    JsonPlaceholderRepository repository = new JsonPlaceholderRepository();

    public User getUser(int index) throws IOException, JSONException {
        String rawUserJson = repository.getRawJson("/users/" + index);
        JSONObject userRootJson = new JSONObject(rawUserJson);
        JSONObject addressJson = userRootJson.getJSONObject("address");
        JSONObject geoJson = addressJson.getJSONObject("geo");
        JSONObject companyJson = userRootJson.getJSONObject("company");

        int id = userRootJson.getInt("id");
        String name = userRootJson.getString("name");
        String userName = userRootJson.getString("username");
        String email = userRootJson.getString("email");
        String phone = userRootJson.getString("phone");
        String website = userRootJson.getString("website");

        String addressStreet = addressJson.getString("street");
        String addressSuite = addressJson.getString("suite");
        String addressCity = addressJson.getString("city");
        String addressZipcode = addressJson.getString("zipcode");

        double geoLat = geoJson.getDouble("lat");
        double geoLng = geoJson.getDouble("lng");

        String companyName = companyJson.getString("name");
        String companyCatchPhrase = companyJson.getString("catchPhrase");
        String companyBs = companyJson.getString("bs");

        Geo geo = new Geo(geoLat, geoLng);
        Address address = new Address(addressStreet, addressSuite, addressCity, addressZipcode, geo);
        Company company = new Company(companyName, companyCatchPhrase, companyBs);

        return new User(id, name, userName, email, address, phone, website, company);
    }

}
