package com.finki.AdventureTravel.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryBuilder {

    public String addCountries(List<String> countries) {
        StringBuilder sb = new StringBuilder();
        if (countries != null && countries.size() > 0) {
            sb.append("country in ('");
            for (int i = 0; i < countries.size(); i++) {
                sb.append(countries.get(i));
                if (i != countries.size() - 1) {
                    sb.append("', '");
                }
            }
            sb.append("' )");
        }
        return sb.toString();
    }

    public String addCategories(List<String> categories) {
        StringBuilder sb = new StringBuilder();
        if (categories != null && categories.size() > 0) {
            sb.append("category in ('");
            for (int i=0; i<categories.size(); i++) {
                sb.append(categories.get(i));
                if (i != categories.size()-1) {
                    sb.append("', '");
                }
            }
            sb.append("' )");
        }
        return sb.toString();
    }
}
