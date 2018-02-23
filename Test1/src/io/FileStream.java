package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStream {
	public static void main(String[] args) throws Exception {
		writeFile("11,22,33","D:"+File.separator+"123.txt");
		System.out.println(readFile("D:"+File.separator+"123.txt"));
		copyFile("D:"+File.separator+"123.csv", "E:"+File.separator+"123.csv");
	}
	public static String readFile(String path) throws Exception{
		//创建文件输入流
		byte[] bytes=null;
		try(FileInputStream fis=new FileInputStream(new File(path));){
		//返回字节数组长度
		int size=fis.available();
		//创建自己数组
		bytes=new byte[size];
		//将数据读取到自己数组中
		fis.read(bytes);
		}
		//利用String构造将字节数组转换为String
		return new String(bytes);
	}
	public static void writeFile(String content,String path) throws Exception{
		//创建文件输出流
		try(FileOutputStream fos=new FileOutputStream(new File(path));){
		//将内容转换为字节数组
		byte[] bytes=content.getBytes();
		//输出内容到文件
		fos.write(bytes);
		}
	}
	public static void copyFile(String oldFile,String newFile) throws Exception{
		//创建文件输入流
		try(FileInputStream fis=new FileInputStream(new File(oldFile));){//FileInputStream没有找到文件会抛FileNotFoundException
		//创建字节数组
		byte[] bytes=new byte[fis.available()];
		//将数据读取到字节数组中
		fis.read(bytes);
		//创建文件输出流并将字节数组传到输出流输出数据,完成文件的拷贝(FileOutputStream的write方法没有找到路径对应文件时会创建新的文件,进行输出操作,不会抛异常)
		FileOutputStream fos = new FileOutputStream(new File(newFile));
		fos.write(bytes);
		}
	}
}
