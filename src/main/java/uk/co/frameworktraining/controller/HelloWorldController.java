package uk.co.frameworktraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class HelloWorldController {
	@RequestMapping(value = "/", produces = "text/plain")
	@ResponseBody
	String home() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/banner.txt"), "UTF-8"))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
                sb.append("\n");
			}
		} catch (IOException e) {
            e.printStackTrace();
        }
		return sb.toString();
	}
}
