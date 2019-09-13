package com.nik.thymeleaf.template;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.time.LocalDateTime;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TemplateEngine templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML); // HTML5 option was deprecated in 3.0.0
        templateEngine.setTemplateResolver(resolver);
        Context ct = new Context();
        ct.setVariable("name", "Prashant");
        ct.setVariable("date", LocalDateTime.now().toString());
        System.out.println(templateEngine.process("greeting.html", ct));
	}

}
