package com.example.demo.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Encripta {
    public static void main(String[] args) throws IOException {
        String keyFilePath = "C:\\Users\\wesle\\Desktop\\Habib-N3\\demo\\src\\main\\java\\com\\example\\demo\\program\\public.key";
        String inputFilePath = "C:\\Users\\wesle\\Desktop\\Habib-N3\\demo\\src\\main\\java\\com\\example\\demo\\program\\texto.txt";
        String outputFilePath = "C:\\Users\\wesle\\Desktop\\Habib-N3\\demo\\src\\main\\java\\com\\example\\demo\\program\\encrypted.txt";

        List<BigInteger> key = readKeyFromFile(keyFilePath);
        BigInteger modulus = key.get(0);
        BigInteger exponent = key.get(1);


        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter pw = new PrintWriter(outputFilePath)) {
            String text = "";
            String textTemp = "";
            String line;
            while ((line = br.readLine()) != null) {
                text = text + line + System.lineSeparator();
            }

            final byte[] authBytes = text.getBytes(StandardCharsets.UTF_8);
            String encoded = Base64.getEncoder().encodeToString(authBytes);

            while (encoded != "") {
                BigInteger n = BigInteger.valueOf(0);
                BigInteger nTemp;
                int i = 0;
                int cont = 0;
                while (n.compareTo(modulus) == -1) {
                    if (n.intValue() != 0) {
                        i++;

                        textTemp = encoded.substring(0, i);
                        TextChunk textChunk = new TextChunk(textTemp);
                        nTemp = textChunk.bigIntValue();
                        if (nTemp.compareTo(modulus) == 1) {
                            break;
                        } else {
                            n = textChunk.bigIntValue();
                            cont++;
//                            System.out.println("(" + encoded.length() + ")" + " - " + textChunk.toString().length());
                            if (textChunk.toString().length() == encoded.length()) {
                                break;
                            }
                        }
                    } else {
                        i++;
                        textTemp = encoded.substring(0, i);
                        TextChunk textChunk = new TextChunk(textTemp);
                        nTemp = textChunk.bigIntValue();
                        if (nTemp.compareTo(modulus) == 1) {
                            break;
                        } else {
                            n = textChunk.bigIntValue();
                            cont++;
//                            System.out.println("(" + encoded.length() + ")" + " - " + textChunk.toString().length());
                            if (textChunk.toString().length() == encoded.length()) {
                                break;
                            }
                        }
                    }
                }
                BigInteger encryptedBigIntTemp = n.modPow(exponent, modulus);
                BigInteger encryptedBigInt = encryptedBigIntTemp;
                pw.println(encryptedBigInt);

                StringBuffer sbf = new StringBuffer(encoded);

                int j = 0;
                while (j != cont) {
                    sbf.deleteCharAt(0);
                    j++;
                }
                encoded = String.valueOf(sbf);
                if (n.intValue() == 0) {
                    break;
                }
            }
        }
    }

    private static List<BigInteger> readKeyFromFile(String keyFilePath) throws IOException {
        List<BigInteger> key = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(keyFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                key.add(new BigInteger(line));
            }
        }
        return key;
    }
}
