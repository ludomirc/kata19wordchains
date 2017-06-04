package com.codekata.kata.imp;

import com.codekata.kata.Dictionary;
import com.codekata.kata.exception.AppException;
import com.codekata.kata.exception.ErrorCode;
import com.codekata.kata.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by Benek on 18.05.2017.
 */
public class DictionaryImp implements Dictionary {

    private static Logger logger = LogManager.getLogger(DictionaryImp.class.getName());

    private HashSet<String> dictionary;

    public DictionaryImp() {
        dictionary = new HashSet<String>();
    }

    public DictionaryImp(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }

    protected void loadDictionary(InputStream dictionaryStream) throws AppException {

        logger.info("dictionary load...");
        if (dictionaryStream == null) {
            throw new TechnicalException(ErrorCode.ErrorCode_2001, ErrorCode.ErrorCode_2001.getMessage());
        } else {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(dictionaryStream))) {
                StringBuilder sb = new StringBuilder();
                String word = "";
                while ((word = br.readLine()) != null) {
                    word.trim();
                    dictionary.add(word.trim());
                }

            } catch (IOException e) {
                TechnicalException tex = new TechnicalException(e);
                logger.error(tex);
                throw tex;
            }

        }
        logger.info("dictionary loaded");

    }

    public int size() {
        return dictionary.size();
    }

    @Override
    public Boolean contains(CharSequence word) {
        return dictionary.contains(word);
    }
}
