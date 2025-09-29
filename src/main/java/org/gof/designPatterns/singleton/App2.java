package org.gof.designPatterns.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 싱글톤을 깨뜨리는 방법
 * 1) reflection -> 대응x -> class를 enum 타입으로 수정 후, 인스턴스 변수를 호출하면 relection으로 생성할 수 없음.
 * 2) 직렬화 & 역직렬화 사용하기 -> 대응가능
 */
public class App2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, NoSuchFieldException {
        Settings settings = Settings.getInstance();
        Settings settings2 = null;
        //1) reflection
        Constructor<?>[] declaredConstructors = Settings.class.getDeclaredConstructors();
        for(Constructor<?> constructor : declaredConstructors) {
            constructor.setAccessible(true);
            settings2 = (Settings) constructor.newInstance();
        }
        System.out.println(settings2 == settings);
        //2 - 1) 직렬화
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("settings1.obj"))) {
            objectOutputStream.writeObject(settings2);
        }

        //2 - 2) 역직렬화
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("settings1.obj"))) {
            settings2  =(Settings) objectInputStream.readObject();
        }
        //System.out.println(settings2 == settings);
    }
}
