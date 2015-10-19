/**
 * @author Girdhari
 * Main class for annotation assignment
 */
package assignment3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		
		AnnotationRunner annotationRunner = new AnnotationRunner();
		Method methods[] = annotationRunner.getClass().getMethods();
		
		for(Method method : methods) {
			CanRun annotation = method.getAnnotation(CanRun.class);
			
			if(annotation != null) {
				try {
					method.invoke(annotationRunner);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
}
