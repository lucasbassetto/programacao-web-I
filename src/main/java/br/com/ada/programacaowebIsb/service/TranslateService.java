package br.com.ada.programacaowebIsb.service;

import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    public String getMessage(String language) {
        String result = "";
        switch (language) {
            case "fr" : result = "Bonjour"; break;
            case "dr" : result = "Willkomen"; break;
            case "en" : result = "Good Morning"; break;
        }
        return result;
    }
}
