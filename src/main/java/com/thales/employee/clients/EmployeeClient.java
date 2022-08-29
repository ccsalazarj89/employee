package com.thales.employee.clients;

import com.thales.employee.model.Employee;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.thales.employee.commons.APIEndPoints.DUMMY_RESTAPI_EXAMPLE;
import static com.thales.employee.commons.APIEndPoints.DUMMY_RESTAPI_EXAMPLE_BY_ID;

@Component
public class EmployeeClient {


    @Autowired
    RestTemplate restTemplate;
    public List getAllEmployees(){

        Map<String,String> map = new HashMap<>();
        map.put("state","success");

            HttpEntity request =
                    new HttpEntity<>(map,null);
            String employeeURL = DUMMY_RESTAPI_EXAMPLE;
            ResponseEntity<JSONObject> response =
                    restTemplate.exchange(employeeURL, HttpMethod.GET,request, JSONObject.class);

        return (List) response.getBody().get("data");

    }

    public Map getEmployeeById(int id){

        Map<String,String> map = new HashMap<>();
        map.put("state","success");

        HttpEntity request =
                new HttpEntity<>(map,null);
        String employeeURL = DUMMY_RESTAPI_EXAMPLE_BY_ID+"/"+id;
        ResponseEntity<JSONObject> response =
                restTemplate.exchange(employeeURL, HttpMethod.GET,request, JSONObject.class);

       Map data = (Map) response.getBody().get("data");


        return (Map)response.getBody().get("data");

    }

}
