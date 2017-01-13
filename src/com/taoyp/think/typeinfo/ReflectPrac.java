package com.taoyp.think.typeinfo;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class ReflectPrac {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, 
	ClassNotFoundException,InvocationTargetException,NoSuchMethodException,NoSuchFieldException{
		
		Class<?> s1 = null,s2=null,s3=null;
		s1 = Class.forName("com.taoyp.think.typeinfo.User");
		s2 = new User().getClass();
		s3 = User.class;
		
		System.out.println("s1's name is:" + s1.getName());
		System.out.println("s2's name is:" + s2.getName());
		System.out.println("s3's name is:" + s3.getName());
		
		Class<?> p1 = s1.getSuperclass();
		System.out.println("p1's name is:" + p1.getName());
		Class<?> i1[] = s1.getInterfaces();//此方法不能取到父类的接口
		System.out.print("ths interface I can use is:");
		for(int i=0;i<i1.length;i++){
			System.out.println(i1[i].getName());
		}
		
		User user = (User)s1.newInstance();
		user.setName("Evin");
		user.setAge(20);
		user.setDept(5);
		System.out.println(user);
		
		Constructor<?> cons[] = s1.getDeclaredConstructors();//只能取到public的构造函数
		System.out.println("The constructor I can user are:");
		for(int i=0;i<cons.length;i++){
			int modifier = cons[i].getModifiers();
			String priv = Modifier.toString(modifier);
			System.out.print((priv.equals("")?"":priv + " ") + cons[i].getName()+"(");
			Class<?> pType[] = cons[i].getParameterTypes();
			for(int j=0;j<pType.length;j++){
				System.out.print((j==0?"":",")+pType[j].getName());
			}
			System.out.println(")");
		}
		
		user = (User)cons[0].newInstance();
		System.out.println(user);
		user = (User)cons[1].newInstance("Evin",20);
		System.out.println(user);
		user = (User)cons[2].newInstance("Evin");
		System.out.println(user);
		user = (User)cons[3].newInstance("Evin",20,5);
		System.out.println(user);
		
		//本类的属性
		Field[] fields = s1.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			int modifier = fields[i].getModifiers();
			String priv = Modifier.toString(modifier);
			Class<?> type = fields[i].getType();
			System.out.println("fields::::Priv:"+priv+":"+type.getName()+":"+fields[i].getName());
		}
		//所有public的属性
		Field[] fielda = s1.getFields();
		for(int i=0;i<fielda.length;i++){
			int modifier = fielda[i].getModifiers();
			String priv = Modifier.toString(modifier);
			Class<?> type = fielda[i].getType();
			System.out.println(""+priv+":"+type.getName()+":"+fielda[i].getName());
		}
		
		Method methods[] = s1.getMethods();
		for(int i=0;i<methods.length;i++){
			Class<?> returnType = methods[i].getReturnType();
			Class<?> paras[] = methods[i].getParameterTypes();
			int mo = methods[i].getModifiers();
			String priv = Modifier.toString(mo);
			System.out.print(priv+" "+returnType+" "+methods[i].getName());
			System.out.print("(");
			for(int j=0;j<paras.length;j++){
				System.out.print((j==0?"":",")+paras[j].getName());
			}
			System.out.print(")");
			Class<?> exce[] = methods[i].getExceptionTypes();
			for(int j=0;j<exce.length;j++){
				System.out.print((j==0?"throws ":",")+exce[j].getName());
			}
			System.out.println();
		}
		
		//通过反射机制调用类的方法
		Class<?> rf = Class.forName("com.taoyp.think.typeinfo.ReflectMe");
		Method methodNoPara = rf.getMethod("methodNoPara");
		methodNoPara.invoke(rf.newInstance());
		Method methodWithPara = rf.getMethod("methodWithPara", String.class, int.class);
		methodWithPara.invoke(rf.newInstance(),"Evin",20);
		
		//通过反射机制操作类的属性
		Object obj = rf.newInstance();
		Field field = rf.getDeclaredField("field");
		field.setAccessible(true);
		field.set(obj, 234);
		System.out.println(field.get(obj));
		
		//反射机制的动态代理
		MyInvocationHandler mych = new MyInvocationHandler();
		Subject sub = (Subject)mych.bind(new RealSubject());
		String infos = sub.say("Evin", 20);
		System.out.println(infos);
		
		//在Interger的ArrayList中放一个String
		ArrayList<Integer> aint = new ArrayList<Integer>();
		Method method = aint.getClass().getMethod("add", Object.class);
		method.invoke(aint, "add a string");
		System.out.println(aint.get(0));
		
		//修改数组信息
		int[] ai = {1, 2, 3, 4, 5};
		Class<?> aclass = ai.getClass().getComponentType();
		System.out.println("arrays type : " + aclass.getName());
		System.out.println("arrays length : " + Array.getLength(ai));
		System.out.println("the first data of arrays : " + ai[0]);
		Array.set(ai, 0, 100);
		System.out.println("after chg, the first data of arrays : " + ai[0]);
		
		int[] aiN = (int[])arrayC(ai, 10);
		printArray(aiN);
		
		String[] str1 = {"a", "b", "c"};
		String[] str2 = (String[])arrayC(str1, 10);
		printArray(str2);
		
		Fruit fruit = Factory.getInstance("com.taoyp.think.typeinfo.Apple");
		fruit.eat();
	}

	public static Object arrayC(Object obj, int length){
		Class<?> arr = obj.getClass().getComponentType();
		Object newArr = Array.newInstance(arr, length);
		int alength = Array.getLength(obj);
		System.arraycopy(obj, 0, newArr, 0, alength);
		return newArr;
	}
	public static void printArray(Object obj){
		Class<?> c = obj.getClass();
		if(!c.isArray())
			return;
		int length = Array.getLength(obj);
		System.out.println("the length is : " + length);
		for(int i=0;i<length;i++){
			System.out.print(Array.get(obj, i) + " ");
		}
		System.out.println();
	}
}

interface IUser{}

interface IPuser{}

class PUser implements IPuser{
	private String pName;
	protected int pAge;
	public int pDept;
}

class User extends PUser implements IUser{
	private String name;
	protected int age;
	public int dept;
	
	public User(){}
	public User(String name){
		this.name = name;
	}
	User(String name, int age){
		this.name = name;
		this.age = age;
	}
	public User(String name, int age, int dept){
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setDept(int dept){
		this.dept = dept;
	}
	public int getDept(){
		return this.dept;
	}
	
	public String toString(){
		return "name:" + this.name + ", age:" + this.age + ", dept:"+this.dept;
	}
}

class ReflectMe{
	public void methodNoPara(){
		System.out.println("I'm a method of ReflectMe!!");
	}
	public void methodWithPara(String name,int age){
		System.out.println("I'm the second method of ReflectMe!! My name is "+name+", My age is "+age);
	}
	
	public int field;
}

interface Subject{
	public String say(String name, int age);
}
class RealSubject implements Subject{
	public String say(String name, int age){
		return "My name is " + name + " and my age is " + age;
	}
}
class MyInvocationHandler implements InvocationHandler {
	public Object obj = null;
	
	public Object bind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable{
		Object temp = method.invoke(this.obj, args);
		return temp;
	}
}

interface Fruit{
	public void eat();
}
class Apple implements Fruit{
	public void eat(){
		System.out.println("apple apple!!");
	}
}
class Orange implements Fruit{
	public void eat(){
		System.out.println("orange orange!!");
	}
}
class Factory{
	public static Fruit getInstance(String className){
		Fruit fruit = null;
		try{
			fruit = (Fruit)Class.forName(className).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return fruit;
	}
}
