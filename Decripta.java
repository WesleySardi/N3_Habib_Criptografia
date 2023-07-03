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

public class Decripta {
    public static void main(String[] args) throws IOException {
        String keyFilePath = "C:\\Users\\wesle\\Desktop\\Habib-N3\\demo\\src\\main\\java\\com\\example\\demo\\program\\private.key";
        String inputFilePath = "C:\\Users\\wesle\\Desktop\\Habib-N3\\demo\\src\\main\\java\\com\\example\\demo\\program\\encrypted.txt";
        String outputFilePath = "C:\\Users\\wesle\\Desktop\\Habib-N3\\demo\\src\\main\\java\\com\\example\\demo\\program\\texto-decryptado.txt";

        List<BigInteger> key = readKeyFromFile(keyFilePath);
        BigInteger modulus = key.get(0);
        BigInteger exponent = key.get(1);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter pw = new PrintWriter(outputFilePath)) {
            String line;
            String text = "";

            while ((line = br.readLine()) != null) {
                BigInteger encryptedBigInt = new BigInteger(line);
                BigInteger decryptedBigInt = encryptedBigInt.modPow(exponent, modulus);
                TextChunk textChunk = new TextChunk(decryptedBigInt);
                text = text + textChunk;
            }
            final byte[] decodedBytes = Base64.getDecoder().decode(text);
            String decodedString = new String(decodedBytes);
            pw.println(decodedString);
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