package io.github.kanedafromparis.ose.fakedatagen;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.payment.CreditCard;
import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;
import org.apache.commons.lang3.RandomUtils;

import org.json.simple.JSONObject;

import java.text.MessageFormat;
import java.util.Calendar;
import org.json.simple.JSONArray;

public class FakeDataGenerator {

    public String generateFakeData() {
        return this.generateFakeData(10);
    }

    public String generateFakeData(Integer deep) {
        StringBuilder sb = new StringBuilder();
        Fairy fairy = Fairy.create();
        Calendar start = Calendar.getInstance();

        JSONObject jsoReq = new JSONObject();
        JSONArray jsoCompanies = new JSONArray();
        jsoReq.put("companies", jsoCompanies);
        while (deep > 0) {
            deep = deep - 1;
            Integer nbPersonnes = RandomUtils.nextInt(0, 5);
            Integer nbPersonnesComp = nbPersonnes;
            System.out.println(MessageFormat.format("Creating {0} user", nbPersonnesComp));

            Company company = fairy.company();
            JSONObject jsoCompany = new JSONObject();
            jsoCompanies.add(jsoCompany);
            String annotation = fairy.textProducer().sentence(RandomUtils.nextInt(5, 25));
            jsoCompany.put("companyName", company.name());
            jsoCompany.put("annotation", annotation);

            JSONArray jsoPersons = new JSONArray();
            jsoCompany.put("persons", jsoPersons);
            while (nbPersonnes > 0) {
                nbPersonnes = nbPersonnes - 1;
                Person person = fairy.person();
                JSONObject jsoPerson = new JSONObject();
                String firstname = person.firstName();
                String lastname = person.lastName();
                jsoPerson.put("firstname", firstname);
                jsoPerson.put("lastname", lastname);

                CreditCard card = fairy.creditCard();
                String cardVendor = card.vendor();

                jsoPerson.put("cardVendor", cardVendor);

                Address adress = person.getAddress();

                String stnum = adress.streetNumber();
                String street = adress.street();
                String postalCode = adress.getPostalCode();
                String city = adress.getCity();

                jsoPerson.put("stnum", stnum);
                jsoPerson.put("street", street);
                jsoPerson.put("postalCode", postalCode);
                jsoPerson.put("city", city);
                jsoPersons.add(jsoPerson);
            }

        }

        Calendar end = Calendar.getInstance();
        long delta = end.getTimeInMillis() - start.getTimeInMillis();
        System.out.println(MessageFormat.format("Process took {0} Milliseconds", delta));
        return jsoReq.toJSONString();

    }

}
