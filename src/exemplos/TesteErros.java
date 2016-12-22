package exemplos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteErros {

	public static void main(String[] args) throws Exception {

		TesteErros obj = new TesteErros();
		Usuario usuario = new Usuario();
		Class<?> klass = obj.getClass();
		
		try {
			Method method = klass.getDeclaredMethod("metodo", String.class);
			method.invoke(obj, 1);
		} catch (InvocationTargetException ex) {
			ex.getTargetException().printStackTrace();
		}
		
	}
	
	public void metodo(String s) {
		throw new RuntimeException();
	}
}
