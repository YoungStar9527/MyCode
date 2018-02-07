package jdkt7;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import streamjdk8.zxp1.interfacefun.BufferedReaderProcessor;

public class Test {
	/**这些资源必须实现AutoCloseable或者Closeable接口，实现这两个接口就必须实现close()方法*/
	public static void main(String[] args) throws IOException {//try-with-resources
        try (
        // 声明、初始化两个可关闭的资源
         BufferedReader br = new BufferedReader(new FileReader("E:/123.txt"));
         PrintStream ps = new PrintStream(new FileOutputStream("E:/123.txt"))
        ){
         // 使用两个资源
         System.out.println(br.readLine());
         ps.println("test");
        }
        // 自动关闭资源的try语句相当于包含了隐式的finally块，用于关闭资源。
	}
	
	
}
