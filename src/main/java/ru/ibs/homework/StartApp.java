package ru.ibs.homework;

import ru.ibs.homework.entity.Root;
import ru.ibs.homework.parser.JsonParserJackson;

public class StartApp {
    public static void main(String[] args) {
        JsonParserJackson parser = new JsonParserJackson();
        Root root = parser.parse();

        parser.showCompanyName(root);
        System.out.println();

        parser.showAllSecurities(root);
        System.out.println();

//        parser.showDateOfFoundationCompany(root);
//        System.out.println();

//        parser.showIdCompaniesAndSecurityCodes(root);
//        System.out.println();
    }
}
