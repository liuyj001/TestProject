package com.h3c;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JiebaDemo2 {
    public static void main(String[] args) throws Exception {
        testDemo("我是一只小鸟。我是一个中国人，你是哪人？");
    }

    public static String testDemo(String sentence) throws Exception {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String resultStr = segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString();

        System.out.println("-------------------切到的词");
        System.out.println(resultStr);

        // 词典路径为Resource/dicts/jieba.dict
        String absolutePath = new File(JiebaDemo2.class.getClassLoader().getResource("dict-h3c.txt").getPath()).getAbsolutePath();
        Path path = Paths.get(URLDecoder.decode(absolutePath, "UTF-8"));
        //加载自定义的词典进词库
        WordDictionary.getInstance().loadUserDict(path);
        //重新分词
        segmenter = new JiebaSegmenter();

        System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());

        return resultStr;
    }
}
