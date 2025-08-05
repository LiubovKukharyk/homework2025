package com.solvd.wordsstat;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;

public class WordsStat {

    public static Map<String, Integer> countWords(File file) throws IOException {
        String content = FileUtils.readFileToString(file, "UTF-8");
        String normalized = content.replaceAll("[^\\p{L}\\p{Nd}]+", " ").toLowerCase(Locale.ROOT);
        String[] words = StringUtils.split(normalized);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}
