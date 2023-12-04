package com.h3c;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.WordDictionary;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JiebaDemo2 {

    public static String CHINESE = "，。！？；：“”【】《》（）、";
    public static String ENGLISH = ",.!?;:\"[]<>()\\";
    public static void main(String[] args) throws Exception {

        String sentence = "我是一只小鸟。我是一个中国人，你是哪人？ where are you come from?";
        testDemo(sentence);

        // 定义正则表达式
//        String regex = "\\b[\\w']+(-[\\w']+\\b)?'\\b";
        String regex = "\\b[a-zA-Z]+('\\b|-\\b[a-zA-Z]+')?\\b";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        // 创建 Matcher 对象
        Matcher matcher = pattern.matcher(sentence);
        // 统计匹配到的单词数量
        int wordCount = 0;
        while (matcher.find()) {
            wordCount++;
        }

        System.out.println("原句子: " + sentence);
        System.out.println("包含英文单词的数量: " + wordCount);

         regex = "[\\u4e00-\\u9fff]";

        // 编译正则表达式
         pattern = Pattern.compile(regex);
        // 创建 Matcher 对象
         matcher = pattern.matcher(sentence);
        // 统计匹配到的单词数量
         wordCount = 0;
        while (matcher.find()) {
            wordCount++;
        }
        System.out.println("包含中文的数量: " + wordCount);

    }

    public static String testDemo(String sentence) throws Exception {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String resultStr = segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString();

        System.out.println("-------------------切到的词");
        System.out.println(resultStr);
        System.out.println("1111111111111111111111111111111111111111111111");

        List<SegToken> aiTokens = segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH);
        List<String> aiContentList = aiTokens.stream()
                .filter(o-> {
                    return !(CHINESE.contains(o.word)||ENGLISH.contains(o.word));
                }).map(token -> token.word).collect(Collectors.toList());
        System.out.println(aiContentList.size());

       /* // 词典路径为Resource/dicts/jieba.dict
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        File file = resourceLoader.getResource("classpath:dicts" +
                "/dict-h3c.txt").getFile();
        String absolutePath = file.getAbsolutePath();
//        String absolutePath = new File(JiebaDemo2.class.getClassLoader().getResource("dict-h3c.txt").getPath()).getAbsolutePath();
        Path path = Paths.get(URLDecoder.decode(absolutePath, "UTF-8"));
        //加载自定义的词典进词库
        WordDictionary.getInstance().loadUserDict(path);
        //重新分词
        segmenter = new JiebaSegmenter();

        System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
*/
        return resultStr;
    }
}
