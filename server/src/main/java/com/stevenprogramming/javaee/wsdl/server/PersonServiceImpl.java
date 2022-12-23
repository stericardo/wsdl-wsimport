package com.stevenprogramming.javaee.wsdl.server;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "com.stevenprogramming.javaee.wsdl.server.PersonService")
public class PersonServiceImpl implements PersonService{

    private Map<String, Person> map;

    public PersonServiceImpl(){
        map = new HashMap<>();
        Person person = new Person();
        person.setName("Steven");
        person.setAddress("Steven-Address");
        map.put("Steven", person);
        person = new Person();
        person.setAddress("Ladonna-Address");
        map.put("Ladonna", person);
    }

    @Override
    public Person findByName(String name) {
        return map.get(name);
    }

}
