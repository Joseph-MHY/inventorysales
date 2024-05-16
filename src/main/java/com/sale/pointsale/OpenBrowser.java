package com.sale.pointsale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class OpenBrowser implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:8080/login";
        openBrowser(url);
    }

    private void openBrowser(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
