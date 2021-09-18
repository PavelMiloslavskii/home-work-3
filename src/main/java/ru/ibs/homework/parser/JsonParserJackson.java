package ru.ibs.homework.parser;

import ru.ibs.homework.helper.DateHelper;
import ru.ibs.homework.entity.Root;
import ru.ibs.homework.entity.Company;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ibs.homework.entity.Security;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class JsonParserJackson {

    public Root parse() {
        ObjectMapper mapper = new ObjectMapper();
        Root root = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("testJson.json"))) {
            root = mapper.readValue(reader, Root.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return root;
    }


    public void showCompanyName(Root root) {
        root.getCompaniesList()
                .forEach(company -> System.out.println("Компания: " + company.getName() + ", дата основания: "
                        + LocalDate.ofInstant(company.getFounded().toInstant(), ZoneId.systemDefault())));
    }


    public void showAllSecurities(Root root) {
        Date givenDate = new Date();
        List<Company> companiesList = root.getCompaniesList();
        LocalDate currentDate = LocalDate.ofInstant(givenDate.toInstant(), ZoneId.systemDefault());
        List<Security> securityList;
        Instant instant;
        ZoneId zoneId;
        int count = 0;

        for (Company company : companiesList) {
            securityList = company.getSecuritiesList();

            for (int i = 0; i < securityList.size(); i++) {
                instant = company.getSecuritiesList().get(i).getDate().toInstant();
                zoneId = ZoneId.systemDefault();

                if (LocalDate.ofInstant(instant, zoneId).isAfter(currentDate)) {
                    System.out.println("Код ц/б " + company.getSecuritiesList().get(i).getCode() + ", дата истечения "
                            + LocalDate.ofInstant(instant, zoneId) + ", компания "
                            + company.getName());
                    count++;
                }
            }
        }
        System.out.println("Суммарное число ц/б = " + count + " шт.");
    }


    public void showDateOfFoundationCompany(Root root) {
        List<Company> companiesList = root.getCompaniesList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите дату основания компании:");
            String line = reader.readLine();
            String formattedString = DateHelper.showingAndVerifyEntryDate(line);
            LocalDate localDate = LocalDate.parse(formattedString, formatter);

            companiesList.stream()
                    .filter(company -> LocalDate.ofInstant(
                            company.getFounded().toInstant(),
                            ZoneId.systemDefault()).isAfter(localDate)
                    )
                    .forEach(company -> System.out.println(
                            "Компания: " + company.getName() + ", дата основания: " + LocalDate.ofInstant(
                                    company.getFounded().toInstant(), ZoneId.systemDefault()))
                    );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showIdCompaniesAndSecurityCodes(Root root) {
        List<Company> companies = root.getCompaniesList();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите код валюты:");
            String line = reader.readLine();
            List<Security> securityList;
            List<String> currencyList;

            for (Company company : companies) {
                securityList = company.getSecuritiesList();

                for (Security security : securityList) {
                    currencyList = security.getCurrencyList();

                    for (String s : currencyList) {
                        if (s.equals(line)) {
                            System.out.println("Код ц/б " + security.getCode() +
                                    ", id-компании = " + company.getId());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
