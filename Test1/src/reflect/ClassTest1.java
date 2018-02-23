package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import reflect.bean.Student;

public class ClassTest1 {
	public static void main(String[] args) throws Exception {
		Class stuCls=Class.forName("reflect.bean.Student");
		Field[] fieldArray=stuCls.getDeclaredFields();//获取类所有成员变量
		String method=null;
		String methodStu=null;
		Object obj=null;
		for (Field field : fieldArray) {
			method=field.toString();
			obj=stuCls.getConstructor().newInstance();//获取类的实例
			methodStu=upperCaseFirstLatter(method.substring(method.lastIndexOf(".")+1,method.length()));
			Method metset=stuCls.getMethod("set"+methodStu, String.class);//获取方法(方法名,参数类型)
			metset.invoke(obj, "帅哥");//调用方法(实例,方法内参数)
			Method metget=stuCls.getMethod("get"+methodStu);
			System.out.println(metget.invoke(obj));
		}
	}
	public static String upperCaseFirstLatter(String str){  
	    char[] strChar=str.toCharArray();  
	    strChar[0]-=32;  
	    return String.valueOf(strChar);  
	}  
}
