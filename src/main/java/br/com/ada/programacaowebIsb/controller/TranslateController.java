package br.com.ada.programacaowebIsb.controller;
import br.com.ada.programacaowebIsb.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("/{language}")
    public String getTranslate(@PathVariable("language") String language) {
        return translateService.getMessage(language);
    }
}
