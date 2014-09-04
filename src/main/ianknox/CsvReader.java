package ianknox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private String file;

    public CsvReader(String file) {
        this.file = file;
    }

    public List getLineItems() {
        List cartItems = new ArrayList();
        try {
            BufferedReader br = readFile();
            String line;
            while ((line = br.readLine()) != null) {
                createLineItem(line, cartItems);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return cartItems;
    }

    private BufferedReader readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.file));
        skipHeader(br);
        return br;
    }

    private void createLineItem(String line, List cartItems) {
        String[] entry = line.split(",");
        LineItem item = new LineItem(entry[1], entry[2], Integer.parseInt(entry[0]), Double.parseDouble(entry[3]));
        cartItems.add(item);
    }

    private void skipHeader(BufferedReader br) throws IOException {
        String headerLine = br.readLine();
    }
}
