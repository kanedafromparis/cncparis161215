package io.github.kanedafromparis.ose.fakedatagen;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.payment.CreditCard;
import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;
import org.apache.commons.lang3.RandomUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FakeDataGenerator {

    public List<FDGCompany> generateFakeData() {
        return this.generateFakeData(10,5);
    }

    public List<FDGCompany> generateFakeData(Integer deepCompany, Integer topRangePersons) {
        Fairy fairy = Fairy.create(Locale.FRANCE);
        
        Calendar start = Calendar.getInstance();

        List<FDGCompany> lstCompany = new ArrayList();
        while (deepCompany > 0) {
            deepCompany = deepCompany - 1;
            Integer nbPersonnes = RandomUtils.nextInt(1, topRangePersons);
            Integer nbPersonnesComp = nbPersonnes;
            System.out.println(MessageFormat.format("Creating {0} user", nbPersonnesComp));

            Company company = fairy.company();
            FDGCompany oCompany = new FDGCompany();
            lstCompany.add(oCompany);

            String annotation = fairy.textProducer().sentence(RandomUtils.nextInt(5, 25));
            oCompany.setName(company.name());
            oCompany.setNote(annotation);

            List<FDGPersonne> t = new ArrayList();
            oCompany.setFKPersonneLst(t);
            while (nbPersonnes > 0) {
                nbPersonnes = nbPersonnes - 1;
                FDGPersonne oPerson = new FDGPersonne();
                t.add(oPerson);

                Person person = fairy.person();

                String firstname = person.firstName();
                String lastname = person.lastName();
                oPerson.setFirstname(firstname);
                oPerson.setLastname(lastname);

                CreditCard card = fairy.creditCard();
                String cardVendor = card.vendor();
                oPerson.setCardVendor(cardVendor);

                Address adress = person.getAddress();

                String stnum = adress.streetNumber();
                String street = adress.street();
                String postalCode = adress.getPostalCode();
                String city = adress.getCity();

                oPerson.setStnum(stnum);
                oPerson.setStreet(street);
                oPerson.setPostalCode(postalCode);
                oPerson.setCity(city);

            }

        }

        Calendar end = Calendar.getInstance();
        long delta = end.getTimeInMillis() - start.getTimeInMillis();
        System.out.println(MessageFormat.format("Process took {0} Milliseconds", delta));
        fairy = null;
        return lstCompany;

    }

    String toJSon(List<FDGCompany> compLst) {
        JSONArray jsoCompanies = new JSONArray();
        Iterator<FDGCompany> iterator = compLst.iterator();
        while (iterator.hasNext()) {
            FDGCompany next = iterator.next();
            JSONObject jsoCompany = new JSONObject();
            jsoCompanies.add(jsoCompany);
            jsoCompany.put("companyName", next.getName());
            jsoCompany.put("annotation", next.getNote());

            JSONArray jsoPersons = new JSONArray();
            jsoCompany.put("persons", jsoPersons);

            Iterator<FDGPersonne> iterator1 = next.getFKPersonneLst().iterator();
            while (iterator1.hasNext()) {
                FDGPersonne person = iterator1.next();
                JSONObject jsoPerson = new JSONObject();
                jsoPersons.add(jsoPerson);
                jsoPerson.put("firstname", person.getFirstname());
                jsoPerson.put("lastname", person.getLastname());
                jsoPerson.put("cardVendor", person.getCardVendor());
                jsoPerson.put("stnum", person.getStnum());
                jsoPerson.put("street", person.getStreet());
                jsoPerson.put("postalCode", person.getPostalCode());
                jsoPerson.put("city", person.getCity());
                jsoPersons.add(jsoPerson);

            }

        }
        return jsoCompanies.toJSONString();
    }
}
