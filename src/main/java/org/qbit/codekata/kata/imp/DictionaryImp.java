package org.qbit.codekata.kata.imp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qbit.codekata.kata.Dictionary;
import org.qbit.codekata.kata.exception.AppException;
import org.qbit.codekata.kata.exception.ErrorCode;
import org.qbit.codekata.kata.exception.TechnicalException;

import java.io.*;
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

    public DictionaryImp(String filePath) throws AppException {

        dictionary = new HashSet<String>();

        try (FileInputStream fis = new FileInputStream(filePath)) {

            loadDictionary(fis);
        } catch (FileNotFoundException e) {
            TechnicalException tex = new TechnicalException(ErrorCode.ErrorCode_2001, ErrorCode.ErrorCode_2001.getMessage() + ": " + filePath, e);
            logger.error(tex);
            throw tex;
        } catch (IOException e) {
            TechnicalException tex = new TechnicalException(e);
            logger.error(tex);
            throw tex;
        }
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
