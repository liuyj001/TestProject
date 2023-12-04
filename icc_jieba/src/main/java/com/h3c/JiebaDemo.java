package com.h3c;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.sun.rowset.internal.Row;
import javafx.scene.control.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JiebaDemo {
    public static void main(String[] args) {
        String content="大多数情况下。";
        JiebaSegmenter segmenter2 = new JiebaSegmenter();
        List<String> list1 = segmenter2.sentenceProcess(content);
        for (String item:
                list1) {
            System.out.println(item);
        }
        System.out.println("-------------INDEX模式------------------");
        List<SegToken> process = segmenter2.process(content, JiebaSegmenter.SegMode.INDEX);
        List<String> list = process.stream().map(item -> item.word).collect(Collectors.toList());
        for (String item:
                list) {
            System.out.println(item);
        }

        System.out.println("-------------SEARCH模式------------------");
        List<SegToken> process2 = segmenter2.process(content, JiebaSegmenter.SegMode.SEARCH);
        List<String> list2 = process2.stream().map(item -> item.word).collect(Collectors.toList());
        for (String item:
                list2) {
            System.out.println(item);
        }
    }

    public static void main11(String[] args) {

        List<String> st1=new ArrayList<String>();
        st1.add("1");
        st1.add("2");
        st1.add("1");
        st1.add("3");
//        st1.add("1");
        List<String> st2=new ArrayList<String>();
        st2.add("1");
        st2.add("5");
        st2.add("2");
        st2.add("1");
        st2.add("3");
        st2.add("1");
        int longestCommonSubsequence = getLongestCommonSubsequence(st1, st2);
        System.out.println(longestCommonSubsequence);

        // 创建分词器
        JiebaSegmenter segmenter = new JiebaSegmenter();

        // 要分词的文本（AI生成文本）
        String text1= "结巴分词是一款中文分词工具，它能将中文文本分割成词语";
        // 对文本进行分词
        List<SegToken> tokens = segmenter.process(text1, JiebaSegmenter.SegMode.SEARCH);
        // 输出分词结果
        for (SegToken token : tokens) {
            System.out.println(token.word);
        }
        System.out.println("--------");
        // 要分词的文本（AI生成文本）
        String text2= "结巴分词是一款开源的中文分词工具，它能够将中文文本分割成一个一个的词语";
        // 对文本进行分词
        List<SegToken> tokens2 = segmenter.process(text2, JiebaSegmenter.SegMode.SEARCH);
        // 输出分词结果
        for (SegToken token : tokens) {
            System.out.println(token.word);
        }
        List<String> str1=tokens.stream().map(token->token.word).collect(Collectors.toList());
        List<String> str2=tokens2.stream().map(token->token.word).collect(Collectors.toList());
        int commonSubsequence = getLongestCommonSubsequence(str1, str2);
        System.out.println("公共子序列数量："+commonSubsequence);
        double pScoreL = (double) commonSubsequence / str1.size();
        double rScoreL = (double) commonSubsequence / str2.size();

        // Set the values in the Excel sheet
        //采纳率就是AI生成了5个词，我用了4个词，做除法
        System.out.println("采纳率："+pScoreL);
        //补全率就是AI帮我的工作，占用了总词数的百分比
        System.out.println("补全率："+rScoreL);
    }



       /* public static void main2(String[] args) throws IOException {
            XSSFWorkbook workbook = new XSSFWorkbook("采纳率及补全率统计.xlsx");
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cellA = row.getCell(0);
                Cell cellB = row.getCell(1);

                if (cellA != null && cellB != null) {
                    String fileA = cellA.getStringCellValue();
                    String fileB = cellB.getStringCellValue();

                    if (fileA != null && fileB != null) {
                        XWPFDocument docA = new XWPFDocument(new FileInputStream(fileA));
                        XWPFDocument docB = new XWPFDocument(new FileInputStream(fileB));
                        int wordCountA = countWords(docA);
                        int wordCountB = countWords(docB);

                        List<String> tokenizeA = tokenizeDoc(docA);
                        List<String> tokenizeB = tokenizeDoc(docB);

                        int length = getLongestCommonSubsequence(tokenizeA, tokenizeB);
                        double page = (double) wordCountB / 300;

                        double pScoreL = (double) length / tokenizeA.size();
                        double rScoreL = (double) length / tokenizeB.size();
                        double aiPageL = rScoreL * page;

                        // Set the values in the Excel sheet
                        row.createCell(2).setCellValue(pScoreL);
                        row.createCell(3).setCellValue(rScoreL);
                        row.createCell(4).setCellValue(aiPageL);
                    }
                }
            }

            // Save the updated workbook
            try (FileOutputStream fos = new FileOutputStream("采纳率及补全率统计.xlsx")) {
                workbook.write(fos);
            }
        }

        public static int countWords(XWPFDocument doc) {
            int chineseCount = 0;
            int englishCount = 0;
            int punctuationCount = 0;

            for (XWPFParagraph paragraph : doc.getParagraphs()) {
                String text = paragraph.getText();
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
                        chineseCount++;
                    } else if (Character.isLetter(c)) {
                        englishCount++;
                    } else if (Character.getType(c) == Character.DASH_PUNCTUATION || Character.getType(c) == Character.START_PUNCTUATION || Character.getType(c) == Character.END_PUNCTUATION || Character.getType(c) == Character.CONNECTOR_PUNCTUATION || Character.getType(c) == Character.OTHER_PUNCTUATION) {
                        punctuationCount++;
                    }
                }
            }

            return chineseCount + englishCount + punctuationCount;
        }

        public static List<String> tokenizeDoc(XWPFDocument doc) {
            List<String> wordList = new ArrayList<>();
            for (XWPFParagraph paragraph : doc.getParagraphs()) {
                String text = paragraph.getText();
                text = cleanText(text);
                String[] words = text.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordList.add(word);
                    }
                }
            }
            return wordList;
        }

        public static String cleanText(String text) {
            Pattern pattern = Pattern.compile("[^\\p{IsAlphabetic}\\p{IsIdeographic} ]");
            Matcher matcher = pattern.matcher(text);
            String cleanedText = matcher.replaceAll("").toLowerCase();

            pattern = Pattern.compile("([\\p{IsAlphabetic}])([\\p{IsIdeographic}])");
            matcher = pattern.matcher(cleanedText);
            cleanedText = matcher.replaceAll("$1 $2");

            pattern = Pattern.compile("([\\p{IsIdeographic}])([\\p{IsAlphabetic}])");
            matcher = pattern.matcher(cleanedText);
            cleanedText = matcher.replaceAll("$1 $2");

            return cleanedText;
        }
*/
        public static int getLongestCommonSubsequence1(List<String> str1, List<String> str2) {
            int m = str1.size();
            int n = str2.size();

            int[][] dp = new int[m + 1][n + 1];

            for (int x = 1; x <= m; x++) {
                for (int y = 1; y <= n; y++) {
                    if (str1.get(x - 1).equals(str2.get(y - 1))) {
                        dp[x][y] = dp[x - 1][y - 1] + 1;
                    } else {
                        dp[x][y] = Math.max(dp[x - 1][y], dp[x][y - 1]);
                    }
                }
            }
            return dp[m][n];
        }

    public static int getLongestCommonSubsequence(List<String> str1, List<String> str2) {
        int m = str1.size();
        int n = str2.size();

        int[] dp = new int[n + 1];

        for (int x = 1; x <= m; x++) {
            int prev = 0; // 保存前一行的值
            for (int y = 1; y <= n; y++) {
                int temp = dp[y]; // 保存当前行的值
                if (str1.get(x - 1).equals(str2.get(y - 1))) {
                    dp[y] = prev + 1;
                } else {
                    dp[y] = Math.max(dp[y - 1], dp[y]);
                }
                prev = temp; // 更新前一行的值
            }
        }

        return dp[n];
    }


//
//    public static void main(String[] args) throws IOException {
//        // 读取自定义词典文件并将词汇存储在HashSet中
//        HashSet<String> customDictionary = loadCustomDictionary("custom_dict.txt");
//
//        // 要分词的文本
//        String text = "我喜欢使用自定义词典进行分词。";
//
//        // 使用自定义词典进行分词
//        StringTokenizer tokenizer = new StringTokenizer(text, " ");
//        while (tokenizer.hasMoreTokens()) {
//            String token = tokenizer.nextToken();
//            if (customDictionary.contains(token)) {
//                System.out.println(token);
//            }
//        }
//    }
//
//    private static HashSet<String> loadCustomDictionary(String dictionaryFile) throws IOException {
//        HashSet<String> dictionary = new HashSet<>();
//        BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            dictionary.add(line);
//        }
//        reader.close();
//        return dictionary;
//    }
}
